<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://struts.apache.org/tags-html" prefix="h"%>
<%@taglib uri="http://struts.apache.org/tags-bean" prefix="b"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>User Operations</title>
</head>
<body>
	Welcome
	<b:write name="userActionForm" property="user.login" />
	<hr>
	<h:errors />

	<h:link page="/editPassword.jsp">Edit password</h:link>
	<br>
	<h:link page="/viewOthers.do">View others</h:link>
	<br>
	<h:link page="/removeAccount.do">Remove account</h:link>
	<br>
	<h:link page="/chat.jsp">Enter to the chat!</h:link>

	<form action="logout.do">
		<h:submit value="Logout" />
	</form>
</body>
</html>
