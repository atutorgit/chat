<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Chat area</title>
</head>
<body>
	Chat
	<hr>
	<form action="goChat.do">
		<textarea name="chat" rows="30" cols="50" disabled="disabled">
			<c:out value="${chat.messages }" />
		</textarea>
		<br> <input name="message" type="text" size="50"
			value="Say something..." /> <input type="submit" value="Go" />
	</form>
	<a href="operations.jsp">Back</a>
</body>
</html>
