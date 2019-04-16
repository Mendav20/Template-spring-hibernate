<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>

    
<!DOCTYPE html>
<html>
 
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Users List</title>
   
    <link href="<c:url value='https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" 
    		integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous'/>" rel="stylesheet"></link>
    
</head>
 
<body>
    <div class="generic-container">
        <%@include file="authheader.jsp" %>   
        <div class="panel panel-default">
              <!-- Default panel contents -->
            <div class="panel-heading"><span class="lead">List of Users </span></div>
            <table class="table table-hover">
                <thead>
                    <tr>
                        <th>UserName</th>
                        <th>Email</th>
                        <sec:authorize access="hasRole('ADMIN') or hasRole('MASTER')">
                            <th width="100"></th>
                        </sec:authorize>
                        <sec:authorize access="hasRole('ADMIN')">
                            <th width="100"></th>
                        </sec:authorize>
                         
                    </tr>
                </thead>
                <tbody>
                <c:forEach items="${users}" var="user">
                    <tr>
                        <td>${user.username}</td>
                        <th>${user.email }</th>
                        <sec:authorize access="hasRole('ADMIN') or hasRole('MASTER')">
                            <td><a href="<c:url value='/edit-user-${user.idUsuario}' />" class="btn btn-success custom-width">Edit</a></td>
                        </sec:authorize>
                        <sec:authorize access="hasRole('ADMIN') or hasRole('MASTER')">
                            <td><a href="<c:url value='/delete-user-${user.idUsuario}' />" class="btn btn-danger custom-width">Delete</a></td>
                        </sec:authorize>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
        <sec:authorize access="hasRole('ADMIN') or hasRole('MASTER')">
            <div class="well">
            	
                <a href="<c:url value='/newuser' />" <button type="button" class="btn btn-info" </button>>Add New User</a>
                <a href="<c:url value='/report'/>" <button type="button" class="btn btn-success"</button>>Generar Reporte </a>
            </div>
        </sec:authorize>
    </div>
</body>
</html>