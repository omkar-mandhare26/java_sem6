import java.sql.*;

public class s12a {
    public static void main(String[] args) {
        String connString = "jdbc:mysql://localhost:3306/testing";
        String username = "root";
        String password = "edmfreak";

        try (Connection conn = DriverManager.getConnection(connString, username, password)) {
            String selectQuery = "select * from emp;";

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(selectQuery);

            int count = 0;
            while (rs.next())
                count++;

            System.out.println("No of Rows: " + count);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
