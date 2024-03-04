<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Index</title>
<link rel="stylesheet" type="text/css" href="Index.css">
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
    	// Check if both cookies exist
    if (username != null && email != null){%>
    <div id="app">
      <header class='navbar'>
        <div class='navtitle'>
          PerfectCV
        </div>
        <div class='navlinks'>
          <div class='navlinks-div1'>
            Hi,👋 <%=username %>
          </div>
          <div class='navlinks-div2'>
          	About
          </div>
        </div>
      </header>
    </div>
    <section>
        <h1 style='color:green'>You have logged In :)</h1>
    </section>
<%}else{
    response.sendRedirect("auth.jsp");
}%>

</body>
</html>