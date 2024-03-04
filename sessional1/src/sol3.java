

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * Servlet implementation class sol3
 */
public class sol3 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public sol3() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection(
				"jdbc:mysql://localhost:3306/db1","root","root");
			
			Statement stmt=con.createStatement();
			ResultSet rs = stmt.executeQuery("select * from employee2");
//			response.getWriter().writer("<>");
//			response.getWriter().write(rs);
			response.getWriter().write("<h1>All Entries</h1>");
			response.getWriter().write("<div>");
			int counter = 1;
			while(rs.next()) {
				response.getWriter().write("<div><div>Dataset "+counter+"</div><pre>");
				response.getWriter().write("<div>Name: "+rs.getString(2)+"</div>");
				response.getWriter().write("<div>City: "+rs.getString(3)+"</div>");
				response.getWriter().write("<div>Phone No. :"+rs.getString(4)+"</div>");
				response.getWriter().write("</pre></div>");
				counter++;
			}
			response.getWriter().write("</div>");
			
//			System.out.println(rs.getString(1)+" "+rs.getString(2)+" "+rs.getString(3)+" "+rs.getString(4));
			con.close();
		}
		catch(Exception e) {
			System.out.print(e);
		}
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
			response.sendRedirect("/sessional1/success.jsp");
		}
		catch(Exception e) {
			System.out.print(e);
		}
	}

}
