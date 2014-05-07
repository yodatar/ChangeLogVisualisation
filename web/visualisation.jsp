<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<div class="col-sm-3 col-md-2 sidebar" style="width:250px;">
	<ul class="nav nav-sidebar">

		<li style="margin:10px">
			<form action="vis" method="GET">
				<label for="projectSelect">Project</label>
				<select class="form-control" name="projectSelect" id="projectSelect"
				        onchange="clearPageProjectSelected()">
					<c:forEach var="projects" items="${allProjects}">
						<option value="${projects.id}"
						        <c:if test="${projectSelect == projects.id}">selected</c:if> >
								${projects.name}
						</option>
					</c:forEach>
				</select>

				<div class="well well-sm" style="margin-top:5px;margin-bottom: 2px;"
				     id="changesetFromDate"></div>
				<div class="well well-sm" style="margin-bottom: 10px;" id="changesetToDate"></div>

				<div id="slider" style="margin-bottom:10px;height: 17px;">
					<div id="slider-range"></div>
				</div>

				<input hidden id="changesetFromId" name="changesetFrom" value="${changesetFromId}"/>
				<input hidden id="changesetToId" name="changesetTo" value="${changesetToId}"/>
				<input type="submit" value="Display!" class="btn btn-primary btn-sm btn-block"
				       onclick="abortDevelopers()"/>
			</form>

			<div style="float: left;width: 100px;"><label for="chart-container-wrapper">Developers</label></div>
			<div style="float: right;width: 125px;" id="developers-loading">
				<button type="button" class="close" aria-hidden="true" onclick="abortDevelopers()">&times;</button>
			</div>
			<div id="chart-container-wrapper">
				<div id="chart-container-mouseover"></div>
				<div id="chart-container"></div>
			</div>
		</li>

	</ul>
</div>
<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">

	<div id="breadcrubms"></div>
	<div id="canvas"></div>
	<div id="legend"></div>

</div>


