/**
 * Created with IntelliJ IDEA.
 * User: pipo
 * Date: 13.3.2014
 * Time: 23:59
 */


$(document).ready(function () {
	$("#slider")
		.progressbar({ value: false})
		.find(".ui-progressbar-value").css({"background": '#428bca'});
	slider();
	visualisation();
	developersStats();

	/*	$('.jScrollbar').jScrollbar({
	 scrollStep: 25,
	 position: 'left',
	 showOnHover: true
	 });*/
});

function clearPageProjectSelected() {
	sliderDestroy();

	$("#slider")
		.progressbar({ value: false})
		.find(".ui-progressbar-value").css({"background": '#428bca'});

	slider();

	d3.select(".svg").remove();
	d3.select(".canvas").remove();
	d3.select("#trail").remove();
}

function clearPageSliderMoved() {
	d3.select(".svg").remove();
	d3.select(".canvas").remove();
	d3.select("#trail").remove();
};
