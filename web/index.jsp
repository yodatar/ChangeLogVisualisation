<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html lang="en">
<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<meta name="description" content="">
	<meta name="author" content="Michalek">
	<link rel="shortcut icon" href="">

	<title>Bakalaris</title>

	<link href="css/bootstrap.min.css" rel="stylesheet">
	<link href="css/dashboard.css" rel="stylesheet">
	<link rel="stylesheet" href="//code.jquery.com/ui/1.10.4/themes/smoothness/jquery-ui.css">
	<link rel="stylesheet" href="css/graph.css">
	<link rel="stylesheet" type="text/css" href="css/jScrollbar.jquery.css" media="screen"/>


	<!--[if lt IE 9]>
	<script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
	<script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
	<![endif]-->

	<script src="js/jquery21.min.js"></script>
	<script src="js/jquery-ui-1.10.4.min.js"></script>
	<script src="js/bootstrap.min.js"></script>
	<script src="js/docs.min.js"></script>
	<script src="js/d3.v3.min.js"></script>
	<script src="js/slider.js"></script>
	<script src="js/visualisation3.js"></script>
	<script src="js/graph.js"></script>
	<%--	<script src="js/jquery-mousewheel.js"></script>
		<script src="js/jScrollbar.jquery.min.js"></script>--%>


</head>
<body>

<div class="navbar navbar-inverse navbar-fixed-top" role="navigation">
	<div class="container-fluid">
		<div class="navbar-header">
			<button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
				<span class="sr-only">Toggle navigation</span>
				<span class="icon-bar"></span>
				<span class="icon-bar"></span>
				<span class="icon-bar"></span>
			</button>
			<a class="navbar-brand" href="#">Interactive visualisation of developing source code over time</a>
		</div>
		<div class="navbar-collapse collapse">
			<ul class="nav navbar-nav navbar-right">
				<li><a href="#">Dashboard</a></li>
				<li><a href="#">Settings</a></li>
				<li><a href="#">ABOUT</a></li>
				<li class="dropdown">
					<a href="#" class="dropdown-toggle" data-toggle="dropdown">Dropdown <b class="caret"></b></a>
					<ul class="dropdown-menu">
						<li><a href="#">Action</a></li>
						<li><a href="#">Another action</a></li>
						<li><a href="#">Something else here</a></li>
						<li class="divider"></li>
						<li class="dropdown-header">Nav header</li>
						<li><a href="#">Separated link</a></li>
						<li><a href="#">One more separated link</a></li>
					</ul>
				</li>
			</ul>
			<form class="navbar-form navbar-right">
				<input type="text" class="form-control" placeholder="Search...">
			</form>
		</div>
	</div>
</div>

<div class="container-fluid">
	<div class="row">
		<div class="col-sm-3 col-md-2 sidebar" style="width:250px;">
			<ul class="nav nav-sidebar">

				<%--<li class="active"><a href="#">Filter</a></li>--%>

				<li style="margin:10px">
					<form action="index" method="GET">
						Project
						<select class="form-control" name="projectSelect" id="projectSelect"
						        onchange="clearPageProjectSelected()">
							<c:forEach var="projects" items="${allProjects}">
								<option value="${projects.id}"
								        <c:if test="${projectSelect == projects.id}">selected</c:if> >
										${projects.name}
								</option>
							</c:forEach>
						</select>
						<br>
						From:
						<div class="well well-sm" id="changesetFromDate"
						     style="display:inline-block;width:140px;"></div>
						<br>
						To:&nbsp;&nbsp;&nbsp;
						<div class="well well-sm" id="changesetToDate" style="display:inline-block;width:140px;"></div>

						<div id="slider">
							<div id="slider-range"></div>
						</div>
						<br>

						<input hidden id="changesetFromId" name="changesetFrom" value="${changesetFromId}"/>
						<input hidden id="changesetToId" name="changesetTo" value="${changesetToId}"/>
						<input type="submit" value="Display!" class="btn btn-primary btn-sm btn-block"/>
					</form>

					<div id="chart-container-wrapper" class="jScrollbar">
						<div id="chart-container" class="jScrollbar_mask"></div>
						<%--
												<div class="jScrollbar_draggable">    <!-- slider --> <a href="#" class="draggable"></a></div>
						--%>
					</div>
					<%--
										<div class="clr"></div>
					--%>

					<div id="developers-loading"></div>

				</li>
			</ul>
		</div>
		<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
			<div id="breadcrubms"></div>
			<div id="canvas"></div>
		</div>
	</div>
</div>

<script src="js/pageHandling.js"></script>

</body>
</html>