<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="styles.css">
    <title>Registration Successful</title>
</head>
<body>
    <div class="container">
        <h2>Registration Successful</h2>
        <p>Thank you for registering,<%=request.getParameter("username")%></p>
    </div>
</body>
</html>
