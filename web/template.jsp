<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html lang="en">
<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<meta name="description" content="Interactive visualisation of developing source code over time">
	<meta name="author" content="Pavol Michalek">
	<link rel="shortcut icon" href="img/blue_dot.png">

	<title>CodeMaster</title>

	<link href="css/bootstrap.min.css" rel="stylesheet">
	<link rel="stylesheet" href="//code.jquery.com/ui/1.10.4/themes/smoothness/jquery-ui.css">
	<link href="css/dashboard.css" rel="stylesheet">

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
	<script src="js/d3-tip.js"></script>
	<script src="js/pageHandling.js"></script>


</head>
<body>

<div class="navbar navbar-inverse navbar-fixed-top" role="navigation">
	<div class="container-fluid">
		<div class="navbar-header">
			<button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
				<span class="sr-only"></span>
				<span class="icon-bar"></span>
			</button>
			<a class="navbar-brand" href="/visualisation/index">
				CodeMaster
				<small style="padding-left: 20px;">Interactive visualisation of developing source code over time</small>
			</a>
		</div>
	</div>
</div>

<div class="container-fluid">
	<div class="row">

		<c:if test="${from == 'home'}">
			<jsp:include page="index.jsp"/>
		</c:if>
		<c:if test="${from == 'vis'}">
			<jsp:include page="visualisation.jsp"/>
		</c:if>

	</div>
</div>


</body>
</html>