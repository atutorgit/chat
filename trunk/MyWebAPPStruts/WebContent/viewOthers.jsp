<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://struts.apache.org/tags-html" prefix="h"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>View Others</title>
</head>
<body>
	Other users
	<hr>
	<h:errors />
	<form action="editPassword">
		<table>
			<tr>
				<th>Login</th>
				<th>Admin</th>
			</tr>
			<c:forEach var="current" items="${users }">
				<tr>
					<td><c:out value="${current.login }"></c:out></td>
					<td><input type="checkbox"
						<c:if test="${current.admin}">checked</c:if> disabled="disabled" /></td>
				</tr>
			</c:forEach>
		</table>
		<input type="submit" value="Edit" />
	</form>
	<h:link page="/operations.jsp">Cancel</h:link>
</body>
</html>
