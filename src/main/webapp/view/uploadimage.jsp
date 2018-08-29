<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form enctype="multipart/form-data" action="../contactServlet?action=upload" method="post">
	<input type="file" name="file">
	<input type="submit">
</form>

</body>
</html>