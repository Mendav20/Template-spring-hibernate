<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page isELIgnored="false" %>
	<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html>
 
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>User Registration Form</title>
    
    
    <link href="<c:url value='https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" 
    		integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous'/>" rel="stylesheet"></link>
    
    
</head>
 
<body>
    <div class="generic-container">
        <%@include file="authheader.jsp" %>
 		
 		<form method="POST">
        <div class="well lead">User Registration Form</div>
        
        <form:form  method="POST" modelAttribute="user" class="form-horizontal">
            <form:input type="hidden" path="idUsuario" id="idUsuario"/>
             
            <div class="row">
                <div class="form-group col-md-12">
                    <label class="col-md-3 control-lable" for="username">UserName</label>
                    <div class="col-md-7">
                    		<form:input type="text" path="username" id="username" class="form-control input-sm"/>                  		
                    		<div class="has-error">
                            	<form:errors path="username" class="help-inline"/>
                        	</div>               
                    </div>
                </div>
            </div>
            
     
     
            <div class="row">
                <div class="form-group col-md-12">
                    <label class="col-md-3 control-lable" for="email">Email</label>
                    <div class="col-md-7">
                        <c:choose>
                            <c:when test="${edit}">
                                <form:input type="text" path="email" id="email" class="form-control input-sm" disable="true"/>
                            </c:when>
                            <c:otherwise>
                                <form:input type="text" path="email" id="email" class="form-control input-sm" />
                                <div class="has-error">
                                    <form:errors path="email" class="help-inline"/>
                                </div>
                            </c:otherwise>
                        </c:choose>
                    </div>
                </div>
            </div>
     
            <div class="row">
                <div class="form-group col-md-12">
                    <label class="col-md-3 control-lable" for="password">Password</label>
                    <div class="col-md-7">
                        <form:input type="password" path="password" id="password" class="form-control input-sm" />
                        <div class="has-error">
                            <form:errors path="password" class="help-inline"/>
                        </div>
                    </div>
                </div>
            </div>
            
            <div class="row">
                <div class="form-group col-md-12 dropdown">
                    <label class="col-md-3 control-lable" for="rolesUs">Roles</label>
                    <div class="col-md-7">                    
                        <form:select path="rolesUs" items="${roles}" itemValue="idRolUsuario" itemLabel="NombreRol" class="form-control input-sm" />
                        <div class="has-error">
                            <form:errors path="rolesUs" class="help-inline"/>
                        </div>
                    </div>
                </div>
            </div>
     
            <div class="row">
                <div class="form-actions floatRight">
                    <c:choose>
                        <c:when test="${edit}">
                            <input type="submit" value="Update" class="btn btn-primary btn-sm"/> or <a href="<c:url value='/list' />">Cancel</a>
                        </c:when>
                        <c:otherwise>
                            <input type="submit" value="Register" class="btn btn-primary btn-sm"/> or <a href="<c:url value='/list' />">Cancel</a>
                        </c:otherwise>
                    </c:choose>
                </div>
            </div>
        </form:form>
        </form>
    </div>
    
</body>
</html>