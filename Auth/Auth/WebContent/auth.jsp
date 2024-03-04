<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Check user authentication</title>
<link rel="stylesheet" type="text/css" href="auth.css">
</head>
<body>
	<%
		String username = null;
    	String email = null;

	    // Get cookies
    	Cookie[] cookies = request.getCookies();
    	if (cookies != null) {
        	for (Cookie cookie : cookies) {
            	if (cookie.getName().equals("username")) {
                	username = cookie.getValue();
            	} else if (cookie.getName().equals("email")) {
                	email = cookie.getValue();
            	}
        	}
    	}
    %>
    <%
    	if (username != null && email != null) {response.sendRedirect("index.jsp");}else{;
    %>
    <div class="container">
        <h2>Registration Form</h2>
        <form action="authApi" method="post">
            <label for="username">Username:</label>
            <input type="text" id="username" name="username" required>

            <label for="email">Email:</label>
            <input type="email" id="email" name="email" required>

            <label for="password">Password:</label>
            <input type="password" id="password" name="password" required>

            <button type="submit">Register</button>
        </form>
    </div>
    <%}%>
</body>
</html>