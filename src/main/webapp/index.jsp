<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Search</title>
</head>
<body>
	<h1>Search User</h1>
	
	<form action="${pageContext.request.contextPath}/fetchUser" method="post">
		<label for="id">Id:</label>
        <input type="number" id="id" name="id" required>
        <input type="submit" value="Search">
	</form>
</body>
</html>