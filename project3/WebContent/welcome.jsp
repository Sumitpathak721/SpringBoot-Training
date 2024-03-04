<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Welcome</title>
</head>
<body>
<% String name = request.getParameter("uname");
out.print("<h1>Sir, "+name+"</h1>");
%>

</body>
</html>