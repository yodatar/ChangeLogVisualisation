<%@ page import="sk.GetAllUsersServlet" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <script src="d3.v3.js" charset="UTF-8"></script>

    <style>
        text {
            font: 10px sans-serif;
        }
    </style>
    <title>Pali</title>
</head>

<body>
<h2>Ahoj, svet!</h2>

<%
    GetAllUsersServlet getIt = new GetAllUsersServlet();
    getIt.doGet(request,response);
%>


<div id="vis"><script src="visualisation.js"></script></div>


</body>
</html>