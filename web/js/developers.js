/**
 * Created with IntelliJ IDEA.
 * User: pipo
 * Date: 13.3.2014
 * Time: 23:59
 */

// TODO: To delete...

var options = {};

$("#developersList")
	.mouseenter(function () {
		$("#developersStats").show("slide", options, 300);
	});
$("#developersStats")
	.mouseleave(function () {
		$("#developersStats").hide("slide", options, 300);
	})
	.hide();