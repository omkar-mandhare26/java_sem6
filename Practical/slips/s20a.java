import java.sql.*;
import java.util.Scanner;

public class s20a {
    public static void main(String[] args) {
        String connString = "jdbc:mysql://localhost:3306/testing";
        String username = "root";
        String password = "edmfreak";

        try (Connection conn = DriverManager.getConnection(connString, username, password);
                Statement stmt = conn.createStatement();
                Scanner sc = new Scanner(System.in);) {
            System.out.print("Enter emp id to delete row: ");
            int empId = sc.nextInt();

            String deleteQuery = "delete from emp where eno = " + empId + ";";
            int rs = stmt.executeUpdate(deleteQuery);

            System.out.println(rs + " row(s) got affected");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
