/**
 * Created with IntelliJ IDEA.
 * User: pipo
 * Date: 11.3.2014
 * Time: 14:30
 * To change this template use File | Settings | File Templates.
 */
var valMap=[],
    maxi,
    mini;

$(function() {


    $.getJSON( "ajaxGetAllChangesets", {
        tags: "changesets",
        tagmode: "any",
        format: "json"
    })
        .done(function( data ) {
            valMap = data.slice();
            $("#slider-range").slider('option','max', valMap.length -1);
        });


    $("#slider-range").slider({
        min: 1,
        max: 1,
        slide: function(event, ui) {
            $("#amount").val(valMap[ui.value]);
        }
    });
});