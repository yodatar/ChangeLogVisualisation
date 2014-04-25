/**
 * User: pipo
 * Date: 5.3.2014
 * Time: 21:08
 */

// TODO: klikanie aj na list stromu, a priblizenie k parentovi

// TODO: precistit


var w = 1000;
var h = 480;
var x = d3.scale.linear().range([ 0, w ]);
var y = d3.scale.linear().range([ 0, h ]);
var b = {
	w: 100, h: 30, s: 3, t: 10
};

function visualisation() {
	$("#breadcrubms")
		.progressbar({ value: false})
		.find(".ui-progressbar-value").css({"background": '#428bca'});

	var vis = d3.select("#canvas")
		.append("div")
		.attr("class", "chart")
		.style("width", w + "px")
		.style("height", h + "px")
		.attr("class", "canvas")
		.append("svg:svg")
		.attr("width", w)
		.attr("height", h)
		.attr("id", "container");

	var partition = d3.layout
		.partition()
		.value(function (d) {
			return d.size;
		})
		.sort(function (a, b) {
			return a.name.toLowerCase().localeCompare(b.name.toLowerCase());
		});

	d3.json("ajaxGetProjectTree", function (error, root) {

		initializeBreadcrumbTrail();

		g = vis.selectAll("g")
			.data(partition.nodes(root))
			.enter()
			.append("svg:g")
			.attr("transform", function (d) {
				return "translate(" + x(d.y) + "," + y(d.x) + ")";
			})
			.on("click", click)
			.on("mouseover", mouseover);


		kx = w / root.dx;
		ky = h;

		g.append("svg:rect")
			.attr("width", root.dy * kx)
			.attr("height", function (d) {
				return d.dx * ky;
			})
			.attr("class", function (d) {
				return d.children ? "parent" : "child";
			})
			.style("fill", function (d) {
				return d.color;
			})
			.style("stroke", "white")
			.style("stroke-width", "0");

		g.append("svg:text")
			.attr("transform", transform)
			.attr("dy", ".50em")
			.style("opacity", function (d) {
				return d.dx * ky / 2 > 12 ? 1 : 0;
			})

			.append("tspan")
			.attr("x", "0")
			.attr("y", "0")
			.text(function (d) {
				return d.name;
			});

		click(root);

		d3.select("#container").on("mouseleave", mouseleave);
		d3.select("#page-header").on("click", click(root));

		$("#breadcrubms").progressbar("destroy");
	});


	function click(d) {
		if (!d.children) {
			selectDevelopers(d);
			return;
		}

		var kx = (d.y ? w - 40 : w) / (1 - d.y);
		var ky = h / d.dx;

		x.domain([ d.y, 1 ]).range([ d.y ? 40 : 0, w ]);
		y.domain([ d.x, d.x + d.dx ]);

		var t = g.transition()
			//.duration(d3.event.altKey ? 7500 : 750)
			.duration(750)
			.attr("transform", function (d) {
				return "translate(" + x(d.y) + "," + y(d.x) + ")";
			});

		t.select("rect")
			.attr("width", d.dy * kx)
			.attr("height", function (d) {
				return d.dx * ky;
			})
			.style("display", function (d) {
				if (d.depth > 2) return "";
			});

		t.select("text")
			.attr("transform", transform)
			.style("opacity", function (d) {
				return d.dx * ky > 12 ? 1 : 0;
			});

		//d3.event.stopPropagation();
	}

	function transform(d) {
		return "translate(8," + d.dx * ky / 2 + ")";
	}

////////////////////////////////////// breadcrumbs

	function mouseover(d) {

		d3.select("#explanation")
			.style("visibility", "");

		var sequenceArray = getAncestors(d);
		updateBreadcrumbs(sequenceArray);
		// Fade all the segments.
		d3.selectAll("g")
			.style("opacity", 0.9);

		// Then highlight only those that are an ancestor of the current segment.
		vis.selectAll("g")
			.filter(function (node) {
				return (sequenceArray.indexOf(node) >= 0);
			})
			.style("opacity", 1);

		// TODO: osetrit ak "d" je z vizualizacie developers graph
		if (!d.children) updateDevelopers(d);

	}

// Restore everything to full opacity when moving off the visualization.
	function mouseleave(d) {

		// Deactivate all segments during transition.
		d3.selectAll("g").on("mouseover", null);

		// Transition each segment to full opacity and then reactivate it.
		d3.selectAll("g")
			.transition()
			.duration(250)
			.style("opacity", 1)
			.each("end", function () {
				d3.select(this).on("mouseover", mouseover);
			});
	}

// Given a node in a partition layout, return an array of all of its ancestor
// nodes, highest first, but excluding the root.
	function getAncestors(node) {
		var path = [];
		var current = node;
		while (current) {
			path.unshift(current);
			current = current.parent;
		}
		return path;
	}

	function initializeBreadcrumbTrail() {
		// Add the svg area.
		var trail = d3.select("#breadcrubms").append("svg:svg")
			.attr("width", w)
			.attr("height", 50)
			.attr("id", "trail");

		// Add the label at the end, for the percentage.
		trail.append("svg:text")
			.attr("id", "endlabel")
			.style("fill", "#000");
	}

// Generate a string that describes the points of a breadcrumb polygon.
	function breadcrumbPoints(d, i) {
		var points = [];
		points.push("0,0");
		// TODO: osetrit chybajuce "d"

		points.push(d.name.length * 8 + ",0");
		points.push(d.name.length * 8 + b.t + "," + (b.h / 2));
		points.push(d.name.length * 8 + "," + b.h);
		points.push("0," + b.h);
		if (i > 0) { // Leftmost breadcrumb; don't include 6th vertex.
			points.push(b.t + "," + (b.h / 2));
		}
		return points.join(" ");
	}

// Update the breadcrumb trail to show the current sequence and percentage.
	function updateBreadcrumbs(nodeArray) {

		// Data join; key function combines name and depth (= position in sequence).
		var g = d3.select("#trail")
			.selectAll("g")
			.data(nodeArray, function (d) {
				return d.name + d.depth;
			})
			.on("click", click)
			.on("mouseover", mouseover);

		// Add breadcrumb and label for entering nodes.
		var entering = g.enter().append("svg:g");

		entering.append("svg:polygon")
			.attr("points", breadcrumbPoints)
			.style("fill", function (d) {
				return d.color;
			});

		entering.append("svg:text")
			.attr("x", 12)
			.attr("y", b.h / 2)
			.attr("dy", "0.35em")
			.style("font-size", "12px")
			.text(function (d) {
				return d.name;
			});

		// Set position for entering and updating nodes.
		g.attr("transform", function (d) {
			var sum = 0;
			var sequenceArray = getAncestors(d.parent);
			sequenceArray.forEach(function (entry) {
				sum += entry.name.length * 8 + b.s;
			});
			return "translate(" + sum + ", 0)";
		});

		// Remove exiting nodes.
		g.exit().remove();

		// Make the breadcrumb trail visible, if it's hidden.
		d3.select("#trail")
			.style("visibility", "");
	}

	function updateDevelopers(data) {
		d3.selectAll(".graph")
			.style("color", "#68a3d4")

		if (data.commiters) {
			var selection = [];
			for (var i in data.commiters) {
				selection.push(".graph" + data.commiters[i].id)
			}
			var ids = selection.join();
			d3.selectAll(ids)
				.style("color", data.color)
		}
	}

	//TODO: prehodnotit tuto funkciu
	function selectDevelopers(data) {
		if (data.commiters) {
			var selection = [];
			for (var i in data.commiters) {
				selection.push(".graph" + data.commiters[i].id)
			}
			var ids = selection.join();
			d3.selectAll(ids)
				.style("fill", data.color)
		}
	}
};