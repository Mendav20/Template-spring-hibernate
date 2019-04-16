<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    
<div class="authbar">
    <span>Dear <strong>${loggedinuser}</strong>, Welcome to treage.</span> <span class="floatRight"><a href="<c:url value="/logout" />">Logout</a></span>
</div>