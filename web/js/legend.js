/**
 * Created with IntelliJ IDEA.
 * User: pipo
 * Date: 11.3.2014
 * Time: 14:30
 * To change this template use File | Settings | File Templates.
 */

function legend() {
	var dataset = [
		{x: 1},
		{x: 2},
		{x: 3},
		{x: 4},
		{x: 5}
	];

	var colors = {
		0: ["Created file", "#1dd300"],
		1: ["Changed file", "#ffa500"],
		2: ["Deleted file", "#aaaaaa"],
		3: ["File or package", "#428bca"],
		4: ["Best developer for package", "#ff0000"]
	}

	var svg = d3.select("#legend")
		.append("svg")
		.attr("width", 800)
		.attr("height", 40);

	var legend = svg.append("g")
		.attr("class", "legend")
		.attr("x", 0)
		.attr("y", 0)
		.attr("height", 100)
		.attr("width", 800);

	legend.selectAll('g').data(dataset)
		.enter()
		.append('g')
		.each(function (d, i) {
			var g = d3.select(this);

			g.append("circle")
				.attr("r", 5)
				.attr("cx", i * 120 + 10)
				.attr("cy", 25)
				.attr("width", 10)
				.attr("height", 10)
				.style("fill", colors[i][1]);

			g.append("text")
				.attr("x", i * 120 + 20)
				.attr("y", 30)
				.attr("height", 20)
				.attr("width", 110)
				.style("fill", colors[i][1])
				.text(colors[String(i)][0]);
		});
}