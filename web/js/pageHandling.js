/**
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

	$("#chart-container-wrapper").css("max-height", ($(window).height() - 340) + 'px');
});

function clearPageProjectSelected() {
	try {
		sliderDestroy();
	} catch (e) {
	}

	abortDevelopers();

	$("#slider")
		.progressbar({ value: false})
		.find(".ui-progressbar-value").css({"background": '#428bca'});

	slider();

	d3.select(".svg").remove();
	d3.select(".canvas").remove();
	d3.select("#trail").remove();
	d3.select("#legend").remove();

	$(".btn-primary").addClass("disabled").prop('disabled', true);
}

function clearPageSliderMoved() {
	$(".btn-primary").removeClass("disabled").prop('disabled', false);

	d3.select(".svg").remove();
	d3.select(".canvas").remove();
	d3.select("#trail").remove();
	d3.select("#legend").remove();
	abortDevelopers();
}

$.xhrPool = [];
$.xhrPool.abortAll = function () {
	$(this).each(function (idx, jqXHR) {
		jqXHR.abort();
	});
	$.xhrPool = [];
};

function abortDevelopers() {
	try {
		$("#developers-loading").progressbar("destroy");
		$(".close").remove();
	} catch (err) {
		document.getElementById("developers-loading").innerHTML = "";
	}

	try {
		$.xhrPool.abortAll();
	} catch (e) {
	}

	abortAjax = true;
}

