import java.sql.*;
import java.io.*;
import java.lang.*;
class connect2
{
	public static void main(String[] args)throws Exception
	{	
			int rno;
			String name;
			Double per;
			Connection con;
			PreparedStatement pstmt;
		try
		{	
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			con=DriverManager.getConnection("jdbc:odbc:studdemo","","");
			BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
			int ch;
		
			do  
			{
				System.out.println("\n1.Insert\n2.Update\n3.Delete\n4.Search\n5.Alter\n6.view all\n7.Count \n8.Exit");
				System.out.println("Enter Your Choice");
				ch=Integer.parseInt(br.readLine());
								
				switch(ch)
				{
				case 1:	if(con!=null)
					{
					System.out.println("Enter Roll_no");	
			          	rno=Integer.parseInt(br.readLine());	
					System.out.println("Enter the Name");
					name=br.readLine();
					System.out.println("Enter the percentage");
					per=Double.parseDouble(br.readLine());
					pstmt=con.prepareStatement("INSERT INTO student VALUES(?,?,?)");
					pstmt.setInt(1,rno);
					pstmt.setString(2,name);
					pstmt.setDouble(3,per);
					pstmt.executeUpdate();
					System.out.println("Record Inserted Successfully......");
					}
					break;
			
				case 2:if(con!=null)
					{

					try
					{
					System.out.println("Enter the  roll_no to be updated");
		        		rno=Integer.parseInt(br.readLine());
					System.out.println("Enter the  updated  name");
					name=br.readLine();
					System.out.println("Enter the updated  percentage");
					per=Double.parseDouble(br.readLine());
					con.setAutoCommit(false);
					pstmt=con.prepareStatement("UPDATE stud SET Per=?,Sname=? where Rno=?");


					Savepoint sp=con.setSavepoint("Savepoint");
						
					
					
					pstmt.setDouble(1,per);
					pstmt.setString(2,name);
					pstmt.setInt(3,rno);
					
					con.releaseSavepoint(sp);			
					
					
					if (per>100)
					{
					System.out.println("plsss update per less than 100");
					}
					else
					pstmt.executeUpdate();
					con.commit();
					System.out.println("Record Updated Successfully......");
					
					}
					catch(Exception e)
					{
						
						con.rollback();
					}


					}
					
					break;


				case 3: if(con!=null)
					{
					System.out.println("Enter the  roll_no of the student to be deleted");
					rno=Integer.parseInt(br.readLine());
					pstmt=con.prepareStatement("DELETE FROM stud where Rno=?");
					pstmt.setInt(1,rno);
					pstmt.executeUpdate();
					System.out.println("Record Deleted Successfully......"  +rno);
					}
					break;
			
				case 4:
					if(con!=null)
					{
					Statement st2=con.createStatement();
					System.out.println("Enter the Roll No to search Record:");
					rno=Integer.parseInt(br.readLine());
					ResultSet rs2 = st2.executeQuery("select * from stud where Rno = "+rno);
					
					
		   			if(rs2.next())
		    	 		{
						System.out.println("Roll No\t Name\tPercentage\n");
						System.out.println("-----------------------------------------------");
						System.out.println(rs2.getInt(1)+"\t"+rs2.getString(2)+"\t"+rs2.getDouble(3));	
					}
					else
					System.out.println("Record Not Found");
					}

					break;
				case 5:
					try
					{

					if(con!=null)
					{
					Statement st2=con.createStatement();
					
					System.out.println("Enter the column name:");
					String cname=br.readLine();
					String sql=("alter table stud ADD"+cname+"char(10)");
					st2.execute(sql);
					System.out.println("Alter table successfully");	

					}
					}
					catch(Exception e)
					{
						System.out.println("error in alter table");
					}
					break;
	

				case 6:	Statement st=con.createStatement();
					ResultSet rs=st.executeQuery("select * from stud order by Rno asc");
					System.out.println("Roll_no\tName\t Percentage");
					System.out.println("------------------------------------");
					while(rs.next())
					{
						System.out.println(rs.getInt(1)+"\t"+rs.getString(2)+"\t"+rs.getDouble(3)+"\t");
					}
					break;
					
				case 7:
					if(con!=null)
					{
					Statement st2=con.createStatement();
					
					String sql=("select count(*) AS Rowcount from stud");
					ResultSet rs2=st2.executeQuery(sql);
					rs2.next();
					int cnt;
					cnt=rs2.getInt("Rowcount");
					
					System.out.println("Total Students: " +cnt);
					}
					break;

					
 					case 8:	con.close(); 
					System.exit(0);		
				}//switch
			}while(true);	
		}//try
		catch(SQLException se)
		{
			System.out.println("Connection Failed: "+se);
			System.exit(0);
		}			
	
	}	
}
				