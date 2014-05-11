var commiterNum = 0;
var commitersList;
var abortAjax = false;
var windowWidth = $(window).width() - 70;

function developersStats() {
	$("#developers-loading")
		.progressbar({ value: false})
		.find(".ui-progressbar-value")
		.css({"background": '#428bca', "width": "90%"});

	d3.json("ajaxGetDevelepers", function (error, data) {
		commitersList = data.commiters;

		createChart(data);
		for (var i = 0; i < data.commiters.length; i++) {
			d3.json("ajaxUsersCodeActivities", createChart)
				.on("beforesend", function (request) {
					$.xhrPool.push(request);
				})
				.header("Content-Type", "application/x-www-form-urlencoded")
				.send("POST", "user=" + data.commiters[i].name);
		}
	});
}

function createChart(data) {

	if (commitersList.length == commiterNum) {
		try {
			$("#developers-loading").progressbar("destroy");
			$(".close").remove();
		} catch (err) {
			document.getElementById("developers-loading").innerHTML = "";
		}
	}
	commiterNum++;

	if (data == null || abortAjax) return;

	var margin = {top: 10, right: 20, bottom: 30, left: 200},
		width,
		height;

	var name = [], ids = [],
		charts = [],
		maxDataPoint = 0;

	for (var index in data.commiters) {
		name.push(data.commiters[index].name);
		ids.push(data.commiters[index].id)
	}

	width = windowWidth - margin.left - margin.right;
	height = name.length * 40;

	d3.select(".svg").remove();

	var svg = d3.select("#chart-container")
		.append("svg")
		.attr("width", width + margin.left + margin.right)
		.attr("height", (height + margin.top + margin.bottom))
		.attr("class", "svg");

	data.intervals.forEach(function (d) {
		for (var prop in d) {
			if (d.hasOwnProperty(prop) && prop != "0") {
				d[prop] = parseInt(d[prop]);

				if (d[prop] > maxDataPoint) {
					maxDataPoint = d[prop];
				}
			}
		}

		d.date = new Date(d[0]);
	});


	for (var i = 0; i < commitersList.length; i++) {
		charts.push(new Chart({
			data: data.intervals.slice(),
			id: i,
			name: name[i],
			ids: ids[i],
			width: width,
			height: height * (1 / name.length),
			maxDataPoint: maxDataPoint,
			svg: svg,
			margin: margin,
			showBottomAxis: (i == name.length - 1)
		}));
	}
}


function Chart(options) {
	var chartData = options.data;
	var width = options.width;
	var height = options.height;
	var maxDataPoint = options.maxDataPoint;
	var svg = options.svg;
	var id = options.id;
	var name = options.name;
	var ids = options.ids;
	var margin = options.margin;
	var showBottomAxis = options.showBottomAxis;

	if (chartData == null) return;

	var xScale = d3.time.scale()
		.range([0, width])
		.domain(d3.extent(chartData.map(function (d) {
			return d.date;
		})));

	var yScale = d3.scale.linear()
		.range([height, 0])
		.domain([0, maxDataPoint]);

	var xS = xScale;
	var yS = yScale;

	var tip = d3.tip()
		.attr('class', 'd3-tip')
		.offset([-5, 0])
		.html(function (d) {
			return "characters: " +
				"<span style='color:#3276b1'>" + d[ids] + "</span>";
		});

	var chartContainer = svg.append("g")
		.attr("transform", "translate(" + margin.left + "," + (margin.top + (height * id) + (3 * id)) + ")");

	svg.call(tip);

	var bars = chartContainer.append('g')
		.attr('class', 'bars');

	bars.selectAll('rect')
		.data(chartData)
		.enter()
		.append('rect')
		.attr('x', function (d, i) {
			return xS(d.date) - .5;
		})
		.attr('y', function (d) {
			if (yS(d[ids]) < height && yS(d[ids]) > (height - 2))
				return height - 2;
			return yS(d[ids]);
		})
		.attr('width', width / (chartData.length + 1))
		.attr('height', function (d) {
			if ((height - yS(d[ids])) != 0 && (height - yS(d[ids])) < 2)
				return 2;
			return height - yS(d[ids]);
		})
		.on('mouseover', tip.show)
		.on('mouseout', tip.hide)
		.append('g');


	var xAxisTop = d3.svg.axis().scale(xScale).orient("bottom");
	var xAxisBottom = d3.svg.axis().scale(xScale).orient("top");

	if (id == 0) {
		chartContainer.append("g")
			.attr("class", "x axis top")
			.attr("transform", "translate(0,0)")
			.call(xAxisTop);
	}

	if (showBottomAxis) {
		chartContainer.append("g")
			.attr("class", "x axis bottom")
			.attr("transform", "translate(0," + height + ")")
			.call(xAxisBottom);
	}

	var yAxis = d3.svg.axis().scale(yScale).orient("left").ticks(2);

	chartContainer.append("g")
		.attr("class", "y axis")
		.attr("transform", "translate(" + width + ",0)")
		.call(yAxis);


	chartContainer.append("line")
		.attr("x1", -50)
		.attr("x2", width)
		.attr("y1", height - .5)
		.attr("y2", height - .5)
		.style("stroke", "#ddd");

	chartContainer.append("text")
		.attr("class", "name-title name-title" + ids)
		.attr("transform", "translate(-170,25)")
		.text(name)
		.on("click", userSelection);

	d3.select("#chart-container-mouseover")
		.on("mouseover", function () {
			if (svg.attr("width") > 250) {
				svg.transition()
					.attr("width", windowWidth)
					.duration(1000)
					.ease("elastic");
				d3.select("#chart-container").transition()
					.attr("width", windowWidth)
					.duration(1000)
					.ease("elastic");
			}
		})
		.on("mouseleave", function () {
			d3.select("#chart-container-mouseover").transition()
				.style("opacity", 0)
				.duration(200);
		});


	d3.select("#chart-container")
		.on("mouseover", function () {
			if (svg.attr("width") == 230) {
				svg.transition()
					.attr("width", 260)
					.duration(300);
				d3.select("#chart-container").transition()
					.attr("width", 260)
					.duration(300);
				d3.select("#chart-container-mouseover").transition()
					.style("opacity", 0.2)
					.duration(300);
			}
		})
		.on("mouseleave", function () {
			svg.transition()
				.attr("width", 230)
				.duration(500);
			d3.select("#chart-container").transition()
				.attr("width", 230)
				.duration(500);
			d3.select("#chart-container-mouseover").transition()
				.style("opacity", 0)
				.duration(500);
		});


	svg.attr("width", 230);
	d3.select("#chart-container").attr("width", 230);
}

function userSelection(d) {
	var currentUser = this;
	var opacity = parseFloat(d3.select(this).style('opacity'));

	if (opacity.toPrecision(2) == 0.99) {
		d3.selectAll('.name-title')
			.transition()
			.style('opacity', 1);


		d3.selectAll(".child")
			.transition()
			.style("fill", function (d) {
				return d.color;
			});
	} else {
		d3.selectAll('.name-title')
			.transition()
			.style('opacity', function () {
				return (this === currentUser) ? 0.99 : 0.3;
			});

		var index = 0, userIndex;
		for (var i = 0; i < currentUser.parentNode.parentNode.childNodes.length; i++) {
			if (currentUser.parentNode.parentNode.childNodes[i].lastChild === currentUser) {
				userIndex = index;
				break;
			}
			index++;
		}
		var selectedUserId = commitersList[userIndex].id;

		var files = d3.selectAll(".child")[0];

		for (var i = 0; i < files.length; i++) {
			var isCommiter = false;

			if (!(typeof files[i].__data__.commiters === "undefined")) {
				files[i].__data__.commiters.forEach(function (commiter) {
					if (commiter.id == selectedUserId) {
						isCommiter = true;
					}
				});
			}

			if (isCommiter) {
				d3.select(files[i])
					.transition()
					.style("fill", function (d) {
						return d.color;
					});
			} else {
				d3.select(files[i])
					.transition()
					.style("fill", function (d) {
						return d.parent.color;
					});
			}
		}
	}
}
