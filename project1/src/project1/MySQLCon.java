package project1;
import java.sql.*;
public class MySQLCon {
	public static void main(String args[]) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection(
				"jdbc:mysql://localhost:3306/db1","root","root");
			
			Statement stmt=con.createStatement();
			ResultSet rs = stmt.executeQuery("select * from employee");
			while(rs.next()) 
			System.out.println(rs.getString(1)+" "+rs.getString(2)+" "+rs.getString(3)+" "+rs.getString(4));
			con.close();
		}
		catch(Exception e) {
			System.out.print(e);
		}
	}
}

/*
 * import java.sql.*;  
public class MySQLConnect {

	public static void main(String[] args) {
		try{  Class.forName("com.mysql.cj.jdbc.Driver");
		System.out.println("Driver is Loaded");
		 Connection con=DriverManager.getConnection(  
		"jdbc:mysql://localhost:3306/khaliddb1","root","root");  
		System.out.println("Connection is available");
		Statement stmt=con.createStatement();  
		ResultSet rs=stmt.executeQuery("select * from employee");  
		while(rs.next())  
		System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getString(3)+"  "+rs.getString(4));  
		con.close();  
		}catch(Exception e){ System.out.println(e);}  

	}

}*/
 