<%@page import="utils.utils"%>
<%@page import="model.phoneModel"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<style>
	table,th,td {
		border: 1px solid black;	
	}
</style>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>Update</h1>
	
	<table>
	<tr>
		<td>Contactid
		<td><input type="text" name="txtid" value="<%=request.getParameter("contactId") %>" readonly="readonly" >
	</tr>
	<tr>
		<td>Phone number</td>
		<td>	<%=request.getAttribute("phoneList") %></td>
	</tr>
	</table>
	</form>
	<div class="action">
		<button type="button" onclick="window.location.href='<%= utils.getUrl(request, "/view/homecontact.jsp") %>'" >Return</button>
	</div>
</body>
</html>