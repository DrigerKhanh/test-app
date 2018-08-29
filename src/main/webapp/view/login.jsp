<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
</head>
<body>
	<h1>Login</h1>
	<form action="loginServlet" method="post">
	<table>
		<c:if test="${thongbao!= null }">
			<p class="thongbao"><c:out value="${thongbao }"></c:out>
			</c:if>
		
		<tr>
			<td>Username
			<td><input type="text" name="txtusername">
		</tr>
		<tr>
			<td>Password
			<td><input type="password" name="txtpassword"></td>
		</tr>
	</table>
		<input type="submit" value="submit">
	</form>
</body>
</html>