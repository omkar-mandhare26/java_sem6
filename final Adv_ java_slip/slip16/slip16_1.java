import java.sql.*;
import java.io.*;

class slip16_1
{
	public static void main(String args[])
	{
	try
	{
		Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");

		Connection con = DriverManager.getConnection("jdbc:odbc:TYBCA","","");

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		PreparedStatement ps = con.prepareStatement("insert into customer values(?,?,?,?)");

		String ch="";
		
		do
		{
			System.out.print("Enter CID:");
			int cid = Integer.parseInt(br.readLine());
			System.out.print("Enter CName:");
			String name = br.readLine();
			System.out.print("Enter Address:");
			String addr = br.readLine();
			System.out.print("Enter Phone No:");
			String phno = br.readLine();

			ps.setInt(1,cid);
			ps.setString(2,name);
			ps.setString(3,addr);
			ps.setString(4,phno);

			ps.executeUpdate();
			
			System.out.print("Continue y/n?");
			ch = br.readLine();
		}while(ch.equals("y"));
		System.out.println("Records inserted successfully");
		con.close();
	}
	catch(Exception e)
	{
		System.out.println(e);
	}
	}
}