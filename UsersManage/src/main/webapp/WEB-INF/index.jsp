<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Usuarios</title>
</head>
<body>
    <h1>Lista de usuarios</h1>
    <table>
    	<tr>
    		<th>Nombre</th>
	        <th>Apellido</th>
	        <th>Estado</th>
	        <th>e-Mail</th>
	        <th>Eliminar</th>
    	</tr>
        <c:forEach var="user" items="${users}">
        	<tr>
           		<td>${user.name}</td>
           		<td>${user.lastname}</td>
           		<td>${user.enable}</td>
           		<td>${user.email}</td>
           		<td><form:form method="delete" action="delete" commandName="user">
           				<form:hidden path="id" value="${user.id}" />
    					<form:hidden path="name" value="${user.name}" />
    					<form:hidden path="lastname" value="${user.lastname}" />
    					<form:hidden path="enable" value="${user.enable}" />
    					<form:hidden path="email" value="${user.email}" />
    					<input type="submit" value="Eliminar"/>
					</form:form>
				</td>
				<td><form:form method="get" action="update" commandName="user">
           				<form:hidden path="id" value="${user.id}" />
    					<form:hidden path="name" value="${user.name}" />
    					<form:hidden path="lastname" value="${user.lastname}" />
    					<form:hidden path="enable" value="${user.enable}" />
    					<form:hidden path="email" value="${user.email}" />
    					<input type="submit" value="Modificar"/>
					</form:form>
				</td>
            <tr>
        </c:forEach>
    </table>
    
    <form:form method="get" action="add">
    
    	<input type="submit" value="Nuevo Usuario"/>
 
	</form:form>
    
    
</body>
</html>