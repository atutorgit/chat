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
	<%
		String adminOrNot = "disabled=\"disabled\"";
	%>
	<c:if test="${userActionForm.user.admin}">
		<%
			adminOrNot = "";
		%>
	</c:if>
	<table>
		<tr>
			<th>Login</th>
			<th>Admin</th>
			<th>Edit password</th>
			<th>Remove account</th>
		</tr>
		<c:forEach var="current" items="${users }">
			<tr>
				<td><c:out value="${current.login }"></c:out></td>
				<form action="editPassword.do">
					<td><input type="checkbox" <%=adminOrNot%>
						<c:if test="${current.admin}">checked="checked"</c:if>
						name="userAdmin" /></td>
					<td><input type="password" name="newPassword" <%=adminOrNot%>
						value="${current.password }" /> <input type="hidden"
						name="oldPassword" value="${current.password }" /> <input
						type="hidden" name="userLogin" value="${current.login }" /> <input
						type="submit" <%=adminOrNot%> value="Save" /></td>
				</form>
				<td><form action="removeAccount.do">
						<input type="hidden" name="userLogin" value="${current.login }" />
						<input type="submit" <%=adminOrNot%> value="Remove" />
					</form></td>
			</tr>
		</c:forEach>
	</table>
	<h:link page="/operations.jsp">Back</h:link>
</body>
</html>
