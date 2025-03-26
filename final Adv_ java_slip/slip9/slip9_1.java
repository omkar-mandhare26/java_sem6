import java.sql.*;

class slip9_1{
	public static void main(String args[]){
		try{
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");

			Connection con = DriverManager.getConnection(
			"jdbc:odbc:TYBBA-CA","","");

			Statement s = con.createStatement();

			s.execute("create table Emp(Eno integer primary key, Ename varchar(30), sal float))");

			PreparedStatement ps = con.prepareStatement("insert into Emp values(?,?,?,?)");

			ps.setInt(1,"A111");
			ps.setString(2,"Micromax");
			ps.setFloat(3,10000);
			

			ps.executeUpdate();
			con.close();
		}
		catch(Exception e){
			System.out.println(e);
		}
	}
}