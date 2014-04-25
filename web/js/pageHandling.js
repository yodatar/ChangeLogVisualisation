/**
 * Created with IntelliJ IDEA.
 * User: pipo
 * Date: 13.3.2014
 * Time: 23:59
 */

// TODO: sem vsetky funkcie pre riadenie dokumentu

$(document).ready(function () {
	$("#slider")
		.progressbar({ value: false})
		.find(".ui-progressbar-value").css({"background": '#428bca'});
	slider();
	visualisation();
	developersStats();
});

function clearPage() {
	sliderDestroy();

	$("#slider")
		.progressbar({ value: false})
		.find(".ui-progressbar-value").css({"background": '#428bca'});

	slider();

	d3.select(".svg").remove();
	d3.select(".canvas").remove();
}