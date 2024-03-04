	

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * Servlet implementation class solution13
 */
public class solution13 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public solution13() {
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
			ResultSet rs = stmt.executeQuery("select * from employee where salary<25000");
//			response.getWriter().writer("<>");
//			response.getWriter().write(rs);
			response.getWriter().write("<h1>All Entries whos Salary less then 25000:</h1>");
			response.getWriter().write("<div>");
			int counter = 1;
			while(rs.next()) {
				response.getWriter().write("<div><div>Dataset "+counter+"</div><pre>");
				response.getWriter().write("<div>Name: "+rs.getString(2)+"</div>");
				response.getWriter().write("<div>City: "+rs.getString(3)+"</div>");
				response.getWriter().write("<div>Phone No. :"+rs.getString(4)+"</div>");
				response.getWriter().write("<div>Salary. :"+rs.getString(5)+"</div>");
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

}
