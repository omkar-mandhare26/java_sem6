import java.sql.*;
import java.io.*;

public class slip4_1 {
	public static void main(String args[]) throws IOException,ClassNotFoundException
  	{
    		Connection conn;
    		Statement stmt;
    		ResultSet rs;
    		
		try
		{
	    		Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
    			conn=DriverManager.getConnection("jdbc:odbc:emp_dsn"," ", " ");
    		
			stmt=conn.createStatement();
			
			System.out.println("Before deleting records are");
		        rs=stmt.executeQuery("select * from Emp");
			
			System.out.println("\nEno\Ename\t\tSal");
               		while(rs.next())
               		{
                  			System.out.print("\n"+rs.getInt(1));
                  			System.out.print("\t"+rs.getString(2));
					
                  			System.out.print("\t"+rs.getFloat(3));
			}
			
			stmt.executeUpdate("delete from student where name like 'S%'");
			
			System.out.println("After deleting records are");
		        rs=stmt.executeQuery("select * from Emp");
			
			System.out.println("\nEno\Ename\t\tSal");
               		while(rs.next())
               		{
                  			System.out.print("\n"+rs.getInt(1));
                  			System.out.print("\t"+rs.getString(2));
					
                  			System.out.print("\t"+rs.getFloat(3));
			}
			



		}
		catch(SQLException e)
		{
			System.out.println(e);
		}
	}
}