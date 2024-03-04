package project1;

import java.sql.*;
import java.io.*;
public class InsertData {

	public static void main(String[] args) {
		try
        {

			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Driver is loaded");
 
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/db1","root","root");  

			PreparedStatement pst=con.prepareStatement("insert into employee2 values(?,?,?,?)");  

			BufferedReader br=new BufferedReader(new InputStreamReader(System.in));  

			do{  
				System.out.println("Enter EmpId:");  
				int id=Integer.parseInt(br.readLine());  
				System.out.println("Enter EmpName:");  
				String name=br.readLine();  
				System.out.println("Enter EmpPhone:");  
				String phone=br.readLine();  
				System.out.println("Enter EmpDept:");  
				String dept =br.readLine();  

				pst.setInt(1,id);  
				pst.setString(2,name);  
				pst.setString(3,phone);
				pst.setString(4,dept);
   
				int i=pst.executeUpdate();  
				System.out.println(i+" records inserted");  

				System.out.println("Do you want to continue: y/n");  
				String s=br.readLine();  
				if(s.startsWith("n"))
				{  
					break;  
				}  
			}while(true);  
			con.close(); 
		}catch(Exception e){ 
			System.out.println(e);
		} 
	}

}