<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Details</title>
</head>
<body>
	<c:if test="${not empty user}">
        <h3>User Details:</h3>
        <form action="${pageContext.request.contextPath}/updateUser" method="post" 
        	style="width: 300px; display: flex; flex-direction: column; gap: 1rem;">
        	
        	<input type="hidden" name="id" value="${user.id}" />
        	
        	<div style="width: 100%;">
	        	<label for="name">Name: </label>
	        	<input type="text" name="name" id="name" value="${user.name}" required />
        	</div>
        	
        	<div style="width: 100%;">
	        	<label for="email">Email: </label>
	        	<input type="email" name="email" id="email" value="${user.email}" required />
        	</div>
        	
        	<div style="width: 100%;">
	        	<label for="phone">Phone: </label>
	        	<input type="text" name="phone" id="phone" value="${user.phone}" required />
        	</div>
        	
        	<input type="submit" value="Submit" />
        </form>
    </c:if>
    
    <c:if test="${not empty success}">
    	<b style="font-size: 20px; color: green;">${success}</b>
    </c:if>
    
</body>
</html>