<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<jsp:include page="common.jsp"/>
<link href="<%=request.getContextPath()%>/pages/css/table.css" rel="stylesheet" type="text/css"/>
<html>
<head>
	<meta charset="UTF-8">
	<meta http-equiv="X-UA-Compatible" content="IE=9, IE=8, chrome=1">
	<style>
		table.gridtable {
			font-family: verdana,arial,sans-serif;
			font-size:11px;
			color:#333333;
			border-width: 1px;
			border-color: #666666;
			border-collapse: collapse;
		}
		table.gridtable th {
			border-width: 1px;
			padding: 8px;
			border-style: solid;
			border-color: #666666;
			background-color: #dedede;
		}
		table.gridtable td {
			border-width: 1px;
			padding: 8px;
			border-style: solid;
			border-color: #666666;
			background-color: #ffffff;
		}

	</style>

</head>
<body>
	<h1>${message}</h1>
	<table class="gridtable">
		<tr>
			<td>id</td>
			<td>用户名</td>
			<td>密  码</td>
		</tr>
		<c:forEach var="user" items="${userList}" varStatus="status">
			<tr>
				<td>${user.id}</td>
				<td>${user.username}</td>
				<td>${user.password}</td>
			</tr>
		</c:forEach>

	</table>

</body>
</html>