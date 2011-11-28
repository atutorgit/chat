<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://struts.apache.org/tags-html" prefix="h"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>User Login</title>
</head>
<body>
	Login
	<hr>
	<h:errors />
	<h:form action="loginUser.do">
		<table>
			<tr>
				<td>Login:</td>
				<td><h:text property="user.login" /></td>
			</tr>
			<tr>
				<td>Password:</td>
				<td><h:password property="user.password" /></td>
			</tr>
		</table>
		<input type="submit" value="Login">
	</h:form>
	<h:link page="/createUser.jsp">Create an account</h:link>
</body>
</html>
