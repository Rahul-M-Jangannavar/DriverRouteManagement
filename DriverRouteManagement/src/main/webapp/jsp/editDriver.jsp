<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
    
    <%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<form:form action="update" modelAttribute="emp">

 <form:hidden path="eno"/>
FirstName : <form:input path="firstName"/><br><br>

LastName  : <form:input path="lastName"/><br><br>

LicenceNo     : <form:input path="lno"/> <br><br>


<input type="submit" value="EditDriver">



</form:form>


<a href="viewAll">ViewAllDrivers </a>

</body>
</html>