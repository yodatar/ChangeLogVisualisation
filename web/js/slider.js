/**
 * Created with IntelliJ IDEA.
 * User: pipo
 * Date: 11.3.2014
 * Time: 14:30
 * To change this template use File | Settings | File Templates.
 */

function slider() {
	var idArray, dateArray;

	var e = document.getElementById("projectSelect");
	var projectId = e.options[e.selectedIndex].value;


	$.getJSON("ajaxGetAllChangesets", {
		dataType: 'JSON',
		data: projectId
	})
		.done(function (data) {
			$("#slider").progressbar("destroy");

			var i = 0;
			idArray = new Array();
			dateArray = new Array();

			$.each(data, function () {
				idArray[i] = this['id'];
				dateArray[i] = this['date'];
				i++
			});

			var changesetFromId = document.getElementById("changesetFromId").value;
			var changesetToId = document.getElementById("changesetToId").value;

			$("#slider-range")
				.slider({
					range: true,
					values: [idArray.indexOf(Number(changesetFromId)), idArray.indexOf(Number(changesetToId))],
					min: 0,
					max: idArray.length - 1,
					slide: function (event, ui) {
						document.getElementById("changesetFromDate").innerHTML = dateArray[ui.values[0]];
						document.getElementById("changesetToDate").innerHTML = dateArray[ui.values[1]];

						$("#changesetFromId").val(idArray[ui.values[0]]);
						$("#changesetToId").val(idArray[ui.values[1]]);
					}
				});

			document.getElementById("changesetFromDate").innerHTML = dateArray[idArray.indexOf(Number(changesetFromId))];
			document.getElementById("changesetToDate").innerHTML = dateArray[idArray.indexOf(Number(changesetToId))];
		});

}

function sliderDestroy() {
	$("#slider-range").slider("destroy");
};