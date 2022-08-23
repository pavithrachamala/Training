<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form:form action="transfer" modelAttribute="accountBean">
<table>
<tr><td>Enter the account number(from where money is to withdraw)</td><td><form:input path="from"/></td></tr>
<tr><td>Enter the account number(from where money is to deposit)</td><td><form:input path="to"/></td></tr>
<tr><td>Enter the amount</td><td><form:input path="amount"/></td></tr>
<tr><td><input type="submit"></td></tr>
</table>

</form:form>
</body>
</html>