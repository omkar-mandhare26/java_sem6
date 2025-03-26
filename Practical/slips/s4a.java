import java.sql.*;

// Command to run : java -cp ~name.jar filename.java
public class s4a {
    public static void main(String[] args) {
        try {
            String url = "jdbc:mysql://localhost:3306/testing?useSSL=false&allowPublicKeyRetrieval=true";
            String user = "root";
            String password = "edmfreak";
            String query = "DELETE FROM student WHERE name LIKE 'S%'";

            Connection conn = DriverManager.getConnection(url, user, password);
            System.out.println("Connected to MySQL successfully!");
            Statement stmt = conn.createStatement();

            int rowsAffected = stmt.executeUpdate(query);
            System.out.println(rowsAffected + " student(s) deleted.");

            stmt.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}