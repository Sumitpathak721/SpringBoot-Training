

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;


/**
 * Servlet implementation class ServletDB1
 */
public class ServletDB1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Connection con = null;
	Statement stmt = null;
	ResultSet rs = null;

    /**
     * Default constructor. 
     */
    public ServletDB1() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out = response.getWriter();
		response.setContentType("text/html"); 
		 		try
				{  
		 			Class.forName("com.mysql.cj.jdbc.Driver");
		   			out.println("Driver is Loaded");
					out.println("<br><br>"); 
		   	        con = DriverManager.getConnection("jdbc:mysql://localhost:3306/db1","root","root");  
		   	        out.println( "Connection is Available");
		   			stmt=con.createStatement();  
		   	        rs=stmt.executeQuery("select * from users"); 
		   			while(rs.next())
					{ 
		 			int id=rs.getInt(1);
					String name=rs.getString(2);
					String email=rs.getString(3);
					String password=rs.getString(4);
					out.println("<br><br>"); 
					out.println("The Employee Id is"+" "+id); 
					out.println("<br><br>");
					out.println("The Employee Name is"+" "+name);
					out.println("<br><br>");
					out.println("The Employee Email no."+" "+email); 
					out.println("<br><br>");
					out.println("The Employee Password"+" "+"nahi btaunga");
					out.println("<br><br>");
					
	
					 
		  			 }  
		  
				}
				catch(Exception e){out.println(e);}
	}

}
