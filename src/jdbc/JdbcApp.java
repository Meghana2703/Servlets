package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class JdbcApp {
	public static void main(String[]args)
	{
		try
		{
			//Load driver
			Class.forName("com.mysql.cj.jdbc.Driver");
			//connection with database
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc", "root", "Meh@2703");
			Statement st = con.createStatement();
			//String qry = "Create Table Product(pid int,pname char(10), price double)";
			//taking Dynamic input 
			Scanner sc = new Scanner(System.in);
			int id = sc.nextInt();
			String  name = sc.next();
			double price = sc.nextDouble();
			//String qry2 ="insert into product values(123,'Mobile',40000)";
			String qry2="insert into product values("+id+",'"+name+"',"+price+")";
			int x = st.executeUpdate(qry2);
			//get the result
			System.out.println(x);
			System.out.println("Row Created");
			ResultSet rs = st.executeQuery("select * from "+sc.next());
			System.out.println("Rows Retrived");
			System.out.println("===================================");
			while(rs.next())
			{
				System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getDouble(3));
			}
			st.close();
			con.close();
			//rs.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

}
