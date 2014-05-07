/**
 * User: pipo
 * Date: 5.11.2013
 * Time: 21:08
 */


var w = $(window).width() - 300;
var h = $(window).height() - 180;
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
			.style("opacity", function (d) {
				return d.dx * ky / 2 > 12 ? 1 : 0;
			})
			.attr("alignment-baseline", "auto")
			.text(function (d) {
				return d.name;
			});

		click(root);

		d3.select("#container").on("mouseleave", mouseleave);
		d3.select("#page-header").on("click", click(root));

		try {
			$("#breadcrubms").progressbar("destroy");
		} catch (err) {
			document.getElementById("breadcrubms").innerHTML = "";
		}

		initializeBreadcrumbTrail();
		legend();
	});


	function click(d) {
		if (!d.children) {
			d = d.parent;
		}

		var kx = (d.y ? w - 40 : w) / (1 - d.y);
		var ky = h / d.dx;

		x.domain([ d.y, 1 ]).range([ d.y ? 40 : 0, w ]);
		y.domain([ d.x, d.x + d.dx ]);

		var t = g.transition()
			.duration(750)
			.attr("transform", function (d) {
				return "translate(" + x(d.y) + "," + y(d.x) + ")";
			});

		t.select("rect")
			.attr("width", d.dy * kx)
			.attr("height", function (d) {
				return d.dx * ky;
			});

		t.select("text")
			.attr("transform", transform)
			.attr("alignment-baseline", function (d) {
				if (d.depth > 2)
					return "baseline";
				return "auto";
			})
			/*.style("font-size",function (d) {
			 return (13 - d.depth)+"px";
			 })*/
			.style("opacity", function (d) {
				return d.dx * ky > 12 ? 1 : 0;
			});
	}

	function transform(d) {
		return "translate(8," + d.dx * ky / 2 + ")";
	}

	function mouseover(d) {
		d3.select("#explanation")
			.style("visibility", "");

		var sequenceArray = getAncestors(d);
		updateBreadcrumbs(sequenceArray);
		d3.selectAll(".child, .parent")
			.style("opacity", 0.9);

		vis.selectAll(".child, .parent")
			.filter(function (node) {
				return (sequenceArray.indexOf(node) >= 0);
			})
			.style("opacity", 1);

		updateDevelopers(d);
	}

	function mouseleave(d) {

		d3.selectAll(".child, .parent").on("mouseover", null);

		d3.selectAll(".child, .parent")
			.transition()
			.duration(250)
			.style("opacity", 1)
			.each("end", function () {
				d3.select(this)
					.on("mouseover", mouseover);
			});
	}

	function getAncestors(node) {
		var path = [];
		var current = node;
		while (current) {
			path.unshift(current);
			current = current.parent;
		}
		return path;
	}

	var childrenList = [];
	var lastColor;

	function getChildren(node) {

		if (!(typeof node.commiters === "undefined")) {
			lastColor = node.color;
			node.commiters.forEach(function (entry) {
				childrenList.push(".name-title" + entry.id)
			});
		}

		if (node.children) {
			for (var i = 0; i < node.children.length; i++) {
				getChildren(node.children[i]);
			}
		}
	}

	function initializeBreadcrumbTrail() {
		var trail = d3.select("#breadcrubms")
			.append("svg:svg")
			.attr("width", w)
			.attr("height", 50)
			.attr("id", "trail");

		trail.append("svg:text")
			.attr("id", "endlabel")
			.style("fill", "#000");
	}

	function breadcrumbPoints(d, i) {
		var points = [];
		points.push("0,0");
		points.push(d.name.length * 8 + ",0");
		points.push(d.name.length * 8 + b.t + "," + (b.h / 2));
		points.push(d.name.length * 8 + "," + b.h);
		points.push("0," + b.h);

		if (i > 0) {
			points.push(b.t + "," + (b.h / 2));
		}
		return points.join(" ");
	}

	function updateBreadcrumbs(nodeArray) {
		var group = d3.select("#trail")
			.selectAll("g")
			.data(nodeArray, function (d) {
				return d.name + d.depth;
			})
			.on("click", click)
			.on("mouseover", mouseover);

		var entering = group.enter().append("svg:g");

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

		group.attr("transform", function (d) {
			var sum = 0;
			var sequenceArray = getAncestors(d.parent);
			sequenceArray.forEach(function (entry) {
				sum += entry.name.length * 8 + b.s;
			});
			return "translate(" + sum + ", 0)";
		});

		group.exit().remove();

		d3.select("#trail")
			.style("visibility", "");
	}

	function updateDevelopers(data) {
		d3.selectAll(".name-title")
			.transition()
			.style("fill", "#000000")
			.duration(100);

		Array.prototype.uniqueCommiter = function () {
			var o = {}, i,
				l = this.length,
				r = [];
			for (i = 0; i < l; i += 1)
				o[this[i]] = this[i];
			for (i in o)
				r.push(o[i]);
			return r;
		};

		childrenList = [];
		lastColor = data.color;
		getChildren(data);
		var bestCommiter = modus(childrenList);
		var selections = childrenList.uniqueCommiter().join();

		if (selections != "") {
			d3.selectAll(selections)
				.transition()
				.style("fill", function () {
					if (data.color != "#1dd300" && data.color != "#ffa500")
						return lastColor;
					return data.color;
				})
				.duration(100);

		}
		if (typeof data.commiters === "undefined") {
			d3.select(bestCommiter)
				.transition()
				.style("fill", "#ff0000")
				.duration(100);
		}
	}

	function modus(array) {
		if (array.length == 0)
			return null;

		var modeMap = {},
			max = array[0],
			maxCount = 1;

		for (var i = 0; i < array.length; i++) {
			var value = array[i];
			if (modeMap[value] == null)
				modeMap[value] = 1;
			else
				modeMap[value]++;
			if (modeMap[value] > maxCount) {
				max = value;
				maxCount = modeMap[value];
			}
		}
		return max;
	}
};