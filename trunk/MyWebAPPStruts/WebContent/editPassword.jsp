<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://struts.apache.org/tags-html" prefix="h"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Edit Password</title>
</head>
<body>
	Edit Password
	<hr>
	<h:errors />
	<h:form action="editPassword">
		<table>
			<tr>
				<td>Old password:</td>
				<td><h:password property="oldPassword" /></td>
			</tr>
			<tr>
				<td>New password:</td>
				<td><h:password property="newPassword" /></td>
			</tr>
			<tr>
				<td>Confirm new password:</td>
				<td><h:password property="newPasswordConfirm" /></td>
			</tr>
		</table>
		<input type="submit" value="Edit">
	</h:form>
	<h:link page="/operations.jsp">Cancel</h:link>
</body>
</html>
