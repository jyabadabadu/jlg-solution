<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Alta Usuario</title>
</head>
<body>
	
	<h1>Alta de usuario</h1>
    
    <form:form method="post" action="addUser" commandName="user">
  
    <table>
    <tr>
        <td><form:label path="name">Nombre:</form:label></td>
        <td><form:input path="name" /></td>
    </tr>
    <tr>
        <td><form:label path="lastname">Apellido:</form:label></td>
        <td><form:input path="lastname" /></td>
    </tr>
    <tr>
        <td><form:label path="enable" >Estado:</form:label></td>
        <td><form:checkbox path="enable" /></td>
    </tr>
    <tr>
        <td><form:label path="email" >Email:</form:label></td>
        <td><form:input path="email" /></td>
    </tr>
    <tr>
        <td colspan="2">
            <input type="submit" value="Añadir" />
        </td>
    </tr>
</table> 
</form:form>
    
    
</body>
</html>