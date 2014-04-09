/**
 * Created with IntelliJ IDEA.
 * User: pipo
 * Date: 7.12.2013
 * Time: 4:08
 */

var diameter = 500,
	format = d3.format(",d"),
	color = d3.scale.category20c();

var bubble = d3.layout.pack()
	.sort(null)
	.size([diameter, diameter])
	.padding(1.5);

var svg = d3.select("#vis").append("svg")
	.attr("width", diameter)
	.attr("height", diameter)
	.attr("class", "bubble");

//d3.json("flare.json", function (error, root) {
d3.json("ajaxGetAllUsers", function (error, root) {

	var node = svg.selectAll(".node")
		.data(bubble.nodes(classes(root))
			.filter(function (d) {
				return !d.children;
			}))
		.enter().append("g")
		.attr("class", "node")
		.attr("transform", function (d) {
			return "translate(" + d.x + "," + d.y + ")";
		});

	node.append("title")
		.text(function (d) {
			return d.className + ": " + format(d.value);
		});

	node.append("circle")
		.attr("r", 5)
		.transition()
		.ease(Math.sqrt)
		.attr("r", function (d) {
			return d.r;
		})
		.style("fill", function (d) {
			return color(d.packageName);
		})
	;

	node.append("text")
		.attr("dy", ".3em")
		.style("text-anchor", "middle")
		.text(function (d) {
			return d.className.substring(0, d.r / 3);
		});
});

function classes(root) {
	var classes = [];

	function recurse(name, node) {
		if (node.children) node.children.forEach(function (child) {
			recurse(node.name, child);
		});
		else classes.push({packageName: name, className: node.name, value: node.size});
	}

	recurse(null, root);
	return {children: classes};


}

d3.select(self.frameElement).style("height", diameter + "px");
