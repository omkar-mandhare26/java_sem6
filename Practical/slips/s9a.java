// A) Write a Java Program to create a Emp (ENo, EName, Sal) table and insert record into it. (Use PreparedStatement Interface)

import java.sql.*;

public class s9a {
    public static void main(String[] args) {
        String connString = "jdbc:mysql://localhost:3306/testing";
        String username = "root";
        String password = "edmfreak";

        try (Connection conn = DriverManager.getConnection(connString, username, password)) {
            String createQuery = "create table emp(eno int, ename varchar(50), sal int);";
            String insertQuery = "insert into emp(eno,ename,sal) values(?,?,?);";
            Object[][] records = { { 1, "Omkar", 99000 }, { 2, "Om", 89000 }, { 3, "Martin", 79000 } };

            PreparedStatement create_pstmt = conn.prepareStatement(createQuery);
            create_pstmt.executeUpdate();

            PreparedStatement insert_pstmt = conn.prepareStatement(insertQuery);
            for (int i = 0; i < 3; i++) {
                insert_pstmt.setInt(1, (int) records[i][0]);
                insert_pstmt.setString(2, (String) records[i][1]);
                insert_pstmt.setInt(3, (int) records[i][2]);
                insert_pstmt.executeUpdate();
            }
            System.out.println("Done");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
