<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://struts.apache.org/tags-html" prefix="h"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>User Info</title>
</head>
<body>
	User Info
	<hr>
	<h:errors />
	<h:form>
		<!-- Needed to use property attributes -->
		<table>
			<tr>
				<td>Login:</td>
				<td><h:text property="user.login" /></td>
			</tr>
			<tr>
				<td><h:checkbox property="user.admin" disabled="true" /></td>
				<td>Admin</td>
			</tr>
		</table>
	</h:form>
	<form action="logout.do">
		<h:submit value="Logout" />
	</form>
</body>
</html>
