import java.sql.*;
import java.io.*;
import java.lang.*;
class slip25_2
{
	public static void main(String args[]) throws IOException
	{
		try
		{
		
			int ch;
			BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			Connection conn=DriverManager.getConnection("jdbc:odbc:TY","","");
			Statement stmt=conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
			ResultSet rs=stmt.executeQuery("select * from Emp");
			do
			{		
				System.out.println("1.Move Next Record");
				System.out.println("2.Move First Record");
				System.out.println("3.Move Previous Record");
				System.out.println("4.Move Last Record");
				System.out.println("5.Exit");
				System.out.println("Enter your choice: ");
				ch=Integer.parseInt(br.readLine());
				switch(ch)
				{
					case 1:
						System.out.println("Display Next Record");
						rs.next();
						System.out.println("Eno: "+rs.getInt(1));
						System.out.println("Ename: "+rs.getString(2)); 
						System.out.println("Eno: "+rs.getFloat(3));
						break;
					case 2:
						System.out.println("Display Next Record");
						rs.first();
						System.out.println("Eno: "+rs.getInt(1));
						System.out.println("Ename: "+rs.getString(2)); 
						System.out.println("Eno: "+rs.getFloat(3));
						break;
					case 3:
						System.out.println("Display Next Record");
						rs.previous();
						System.out.println("Eno: "+rs.getInt(1));
						System.out.println("Ename: "+rs.getString(2)); 
						System.out.println("Eno: "+rs.getFloat(3));
						break;
					case 4:
						System.out.println("Display Next Record");
						rs.last();
						System.out.println("Eno: "+rs.getInt(1));
						System.out.println("Ename: "+rs.getString(2)); 
						System.out.println("Eno: "+rs.getFloat(3));
						break;
					case 5:System.exit(0);
						break;
				}
			}while(ch!=5);
		}
		catch(SQLException e)
		{
			System.out.println(e);
		}
		catch(ClassNotFoundException e)
		{
			System.out.println(e1)
		}

	}
}
		
		
		
