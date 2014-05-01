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

	<title>Bakalárka - Michálek</title>

	<link href="css/bootstrap.min.css" rel="stylesheet">
	<link href="css/dashboard.css" rel="stylesheet">
	<link rel="stylesheet" href="//code.jquery.com/ui/1.10.4/themes/smoothness/jquery-ui.css">
	<link rel="stylesheet" href="css/graph.css">

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
	<script src="js/legend.js"></script>


</head>
<body>

<div class="navbar navbar-inverse navbar-fixed-top" role="navigation">
	<div class="container-fluid">
		<div class="navbar-header">
			<button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
				<span class="sr-only">Toggle navigation</span>
				<span class="icon-bar"></span>
			</button>
			<a class="navbar-brand" href="/visualisation/index">Interactive visualisation of developing source code over
				time</a>
		</div>
	</div>
</div>

<div class="container-fluid">
	<div class="row">
		<div class="col-sm-3 col-md-2 sidebar" style="width:250px;">
			<ul class="nav nav-sidebar">


				<c:if test="${from == 'home'}">
					<li class="active"><a href="#">Home</a></li>
					<br>
					<li><a href="/visualisation/vis">Visualisation</a></li>
				</c:if>

				<c:if test="${from == 'vis'}">
					<jsp:include page="sidebar.jsp"/>
				</c:if>

			</ul>
		</div>
		<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">

			<c:if test="${from == 'home'}">
				<jsp:include page="index.jsp"/>
			</c:if>

			<c:if test="${from == 'vis'}">
				<div id="breadcrubms"></div>
				<div id="canvas"></div>
				<div id="legend"></div>
			</c:if>

		</div>
	</div>
</div>

<script src="js/pageHandling.js"></script>

</body>
</html>