<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<title>Home Page</title>
</head>
<body>
	<%
		session.invalidate();
		response.sendRedirect("./");
	%>
</body>
</html>