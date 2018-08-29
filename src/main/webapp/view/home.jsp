<%@page import="utils.utils"%>
<%@page import="model.contactModel"%>
<%@page import="java.util.ArrayList"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="resources/css/app.css">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<style>
	table,th,td {
		border: 1px solid black;
	}
</style>

<title>Customer Service</title>
</head>
<body>
<h1>Customer Information</h1>
	<div class="action">
		<button type="button" onclick="window.location.href='<%= utils.getUrl(request, "/view/contact-detail.jsp") %>'" >Add</button>
		
	</div>
<table>
	<tr>
		<th>Contact ID</th>
		<th>Full name</th>
		<th>Image</th>
		<th>Date of Birth</TH>
		<th>Sex</th>
		<th>Address</th>
		<th>Phone</th>
		<th>Email</th>
	</tr>
	<% contactModel cont =new contactModel(); %>
	
	<c:forEach var="p" items="<%=cont.getList() %>">
	<tr>
		<td>${p.contactid }</td>
		<td>${p.fullname }</td>
		<td><img src="view/images/${p.image}" width="120px" height="150px"/></td>
		<td>${p.dateofBirth }</td>
		<td>${p.sex }</td>
		<td>${p.address }</td>
		<td>
			<a href="phoneServlet?contactId=${p.contactid }">Phone Number</a></td>
		<td>
			<a href="emailServlet?contactId=${p.contactid}">Email</a></td>
	</tr>
	
	
	</c:forEach>
</table>

</body>
</html>