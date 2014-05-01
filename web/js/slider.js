/**
 * Created with IntelliJ IDEA.
 * User: pipo
 * Date: 11.3.2014
 * Time: 14:30
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
			try {
				$("#slider").progressbar("destroy");
			} catch (err) {
				document.getElementById("slider").innerHTML = "";
			}

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
						document.getElementById("changesetFromDate").innerHTML = "From: " + dateArray[ui.values[0]];
						document.getElementById("changesetToDate").innerHTML = "To: &nbsp;&nbsp;&nbsp;&nbsp;" + dateArray[ui.values[1]];

						$("#changesetFromId").val(idArray[ui.values[0]]);
						$("#changesetToId").val(idArray[ui.values[1]]);
					},
					start: function (event, ui) {
						clearPageSliderMoved();
					}
				});

			document.getElementById("changesetFromDate").innerHTML = "From: " + dateArray[idArray.indexOf(Number(changesetFromId))];
			document.getElementById("changesetToDate").innerHTML = "To: &nbsp;&nbsp;&nbsp;&nbsp;" + dateArray[idArray.indexOf(Number(changesetToId))];
		});

}

function sliderDestroy() {
	$("#slider-range").slider("destroy");
};