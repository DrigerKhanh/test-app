<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Customer Registration</h1>

<form enctype="multipart/form-data" action="../contactServlet?action=insert" method="post">
<table>
	<tr>
		<td>ContactID
		<td><input type="text" name="txtid">
	</tr>
	<tr>
		<td>Name
		<td><input type="text" name="txtname">
	</tr>
	<tr>
		<td>Image
		<td><input type="file" name="file">
	</tr>
	<tr>
		<td>DateofBirth
		<td><input type="text" name="txtdate">
	</tr>
	<tr>
		<td>Sex
		<td><input type="text" name="txtsex">
	</tr>
	<tr>
		<td>Address
		<td><input type="text" name="txtaddress">
	</tr>
	<tr>
		<td>Phone Number
		<td><input type="text" name="txtphone">
	</tr>
	<tr>
		<td>Email
		<td><input type="text" name="txtemail">
	</tr>
	
		
	
</table>
<input type="submit" value="Submit">
</form>
	
</table>
</body>
</html>