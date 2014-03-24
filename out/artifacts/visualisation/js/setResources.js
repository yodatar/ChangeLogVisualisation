/**
 * Created with IntelliJ IDEA.
 * User: pipo
 * Date: 13.3.2014
 * Time: 23:59
 */

function setResources() {
    var e = document.getElementById("projectSelect");
    var projectId = e.options[e.selectedIndex].value;
    var changesetId = 0;

    $.get( "setResouerces", { projectId: projectId} )
        .done(function( data ) {
            document.getElementById('canvas').innerHTML = '<div id="loading"><img alt="loading" src="img/loading.jpg"/></div>';
            visualisation();
        });
}