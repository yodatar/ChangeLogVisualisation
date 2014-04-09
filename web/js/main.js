$(document).ready(function () {

	var margin = {top: 10, right: 20, bottom: 10, left: 20},
		width = 1200 - margin.left - margin.right,
		height = 200 - margin.top - margin.bottom;

	var svg = d3.select("#chart-container")
		.append("svg")
		.attr("width", width + margin.left + margin.right)
		.attr("height", (height + margin.top + margin.bottom));

	d3.json('data.json', createChart);

	function createChart(data) {
		var countries = [],
			charts = [],
			maxDataPoint = 0;

		for (var prop in data[0]) {
			if (data[0].hasOwnProperty(prop)) {
				if (prop != 'Year') {
					countries.push(prop);
				}
			}
		}
		;

		var countriesCount = countries.length,
			startYear = data[0].Year,
			endYear = data[data.length - 1].Year,
			chartHeight = height * (1 / countriesCount);

		data.forEach(function (d) {
			for (var prop in d) {
				if (d.hasOwnProperty(prop)) {
					d[prop] = parseInt(d[prop]);

					if (d[prop] > maxDataPoint) {
						maxDataPoint = d[prop];
					}
				}
			}

			// D3 needs a date object, let's convert it just one time
			d.Year = new Date(d.Year, 0, 1);
		});

		for (var i = 0; i < countriesCount; i++) {
			charts.push(new Chart({
				data: data.slice(), // copy the array
				id: i,
				name: countries[i],
				width: width,
				height: height * (1 / countriesCount),
				maxDataPoint: maxDataPoint,
				svg: svg,
				margin: margin,
				showBottomAxis: (i == countries.length - 1)
			}));
		}
	}


	function Chart(options) {
		this.chartData = options.data;
		this.width = options.width;
		this.height = options.height;
		//this.maxDataPoint = options.maxDataPoint;
		this.maxDataPoint = 10;
		this.svg = options.svg;
		this.id = options.id;
		this.name = options.name;
		this.margin = options.margin;
		this.showBottomAxis = options.showBottomAxis;

		var localName = this.name;

		/* XScale is time based */
		this.xScale = d3.time.scale()
			.range([0, this.width])
			.domain(d3.extent(this.chartData.map(function (d) {
				return d.Year;
			})));

		/* YScale is linear based on the maxData Point we found earlier*/
		this.yScale = d3.scale.linear()
			.range([this.height, 0])
			.domain([0, this.maxDataPoint]);

		var xS = this.xScale;
		var yS = this.yScale;

		this.area = d3.svg.area()
			.interpolate("basis")
			.x(function (d) {
				return xS(d.Year);
			})
			.y0(this.height)
			.y1(function (d) {
				return yS(d[localName]);
			});

		this.svg.append("defs").append("clipPath")
			.attr("id", "clip-" + this.id)
			.append("rect")
			.attr("width", this.width)
			.attr("height", this.height);

		this.chartContainer = svg.append("g")
			.attr('class', this.name.toLowerCase())
			.attr("transform", "translate(" + this.margin.left + "," + (this.margin.top + (this.height * this.id) + (3 * this.id)) + ")");

		/* We've created everything, let's actually add it to the page */

		this.chartContainer.append("path")
			.data([this.chartData])
			.attr("class", "chart")
			.attr("clip-path", "url(#clip-" + this.id + ")")
			.attr("d", this.area);

		this.xAxisTop = d3.svg.axis().scale(this.xScale).orient("bottom");
		this.xAxisBottom = d3.svg.axis().scale(this.xScale).orient("top");

		/* We only want a top axis if it's the first country */

		if (this.id == 0) {
			this.chartContainer.append("g")
				.attr("class", "x axis top")
				.attr("transform", "translate(0,0)")
				.call(this.xAxisTop);
		}

		/* Only want a bottom axis on the last country */

		if (this.showBottomAxis) {
			this.chartContainer.append("g")
				.attr("class", "x axis bottom")
				.attr("transform", "translate(0," + this.height + ")")
				.call(this.xAxisBottom);
		}

		/*this.yAxis = d3.svg.axis().scale(this.yScale).orient("left").ticks(5);

		 this.chartContainer.append("g")
		 .attr("class", "y axis")
		 .attr("transform", "translate(-15,0)")
		 .call(this.yAxis);
		 */

		this.chartContainer.append("text")
			.attr("class", "country-title")
			.attr("transform", "translate(15,40)")
			.text(this.name);

		this.svg
			.on("mouseover", function () {
				svg.transition()
					.attr("width", 1200)
					.duration(1000)
					.ease("elastic");
				d3.select("#chart-container").transition()
					.attr("width", 1200)
					.duration(1000)
					.ease("elastic");
			})
			.on("mouseleave", function () {
				svg.transition()
					.attr("width", 220)
					.duration(500);
				d3.select("#chart-container").transition()
					.attr("width", 220)
					.duration(500);
			});

		svg
			.attr("width", 220);
		d3.select("#chart-container")
			.attr("width", 220);

	}
});