<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page isELIgnored="false" %>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
   
    <link href="<c:url value='https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" 
    		integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous'/>" rel="stylesheet"></link>
    
    <title>AccessDenied page</title>
</head>
<body>
    <div class="generic-container">
        <div class="authbar">
            <span>Dear <strong>${loggedinuser}</strong>, You are not authorized to access this page.</span> <span class="floatRight"><a href="<c:url value="/logout" />">Logout</a></span>
        </div>
    </div>
</body>
</html>