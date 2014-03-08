/**
 * Created with IntelliJ IDEA.
 * User: pipo
 * Date: 5.3.2014
 * Time: 21:08
 * To change this template use File | Settings | File Templates.
 */

var w = 1000;
var h = 650;
var x = d3.scale.linear().range([ 0, w ]);
var y = d3.scale.linear().range([ 0, h ]);

var vis = d3.select("#canvas")
    .append("div")
    .attr("class", "chart")
    .style("width", w + "px")
    .style("height", h + "px")
    .append("svg:svg")
    .attr("width", w)
    .attr("height", h);

var partition = d3.layout
    .partition()
    .value(function (d) {
        return d.size;})
    .sort(function (a, b) {
        return a.name.toLowerCase().localeCompare(b.name.toLowerCase());});

d3.json("ajaxGetProjectTree", function (error, root) {

    var color = d3.scale.category20c();

    g = vis.selectAll("g")
        .data(partition.nodes(root))
        .enter()
        .append("svg:g")
        .attr("transform", function (d) {
            return "translate(" + x(d.y) + "," + y(d.x) + ")";})
        .on("click", click);

    kx = w / root.dx;
    ky = h / 1;

    g.append("svg:rect")
        .attr("width", root.dy * kx)
        .attr("height",function (d) {
            return d.dx * ky;})
        .attr("class",function (d) {
            return d.children ? "parent" : "child";})
        .style("fill", function (d, i) {
            return color(i);});

    g.append("svg:text")
        .attr("transform", transform)
        .attr("dy", ".20em")
        .style("opacity",function (d) {
            return d.dx * ky / 2 > 12 ? 1 : 0;})

        .append("tspan")
        .attr("x", "0")
        .attr("y", "5")
        .text(function (d) {
            return d.name;})

        .append("tspan")
        .attr("x", "0")
        .attr("y", "25")
        .text(function (d) {
            return (d.budget / 1e6).toFixed(2) + " M";});

    d3.select("window")
        .on("click", function () {
            click(root);});
});

function click(d) {
    if (!d.children) return;

    var kx = (d.y ? w - 40 : w) / (1 - d.y);
    var ky = h / d.dx;

    x.domain([ d.y, 1 ]).range([ d.y ? 40 : 0, w ]);
    y.domain([ d.x, d.x + d.dx ]);

    var t = g.transition()
        .duration(d3.event.altKey ? 7500 : 750)
        .attr("transform", function (d) {
            return "translate(" + x(d.y) + "," + y(d.x) + ")";});

    t.select("rect")
        .attr("width", d.dy * kx)
        .attr("height", function (d) {
            return d.dx * ky;})
        .style("display", function (d) {
            if (d.depth > 2) return "";});

    t.select("text")
        .attr("transform", transform)
        .style("opacity", function (d) {
            return d.dx * ky > 12 ? 1 : 0;});

    d3.event.stopPropagation();
}

function transform(d) {
    return "translate(8," + d.dx * ky / 2 + ")";
}
