

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.*;
import jakarta.servlet.http.Cookie;

/**
 * Servlet implementation class authApi
 */
public class authApi extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public authApi() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			String username = request.getParameter("username");
	        String email = request.getParameter("email");
	        String pass = request.getParameter("password");
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection(
				"jdbc:mysql://localhost:3306/db1","root","root");
			
			Statement stmt=con.createStatement();
			PreparedStatement pst=con.prepareStatement("INSERT INTO users (username, email, password) VALUES (?, ?,?);");
			
			pst.setString(1,username);  
			pst.setString(2,email);
			pst.setString(3,pass);
			pst.executeUpdate();    
			con.close();
			Cookie usernameCookie = new Cookie("username", username);
	        usernameCookie.setMaxAge(60*2); // Set cookie to expire in a week
	        Cookie emailCookie = new Cookie("email", email);
	        emailCookie.setMaxAge(60*2); // Set cookie to expire in a week
	        // Add cookies to response
	        response.addCookie(usernameCookie);
	        response.addCookie(emailCookie);
			response.sendRedirect("/Auth/index.jsp");
		}
		catch(Exception e) {
			System.out.print(e);
		}
		
		
	}

}
