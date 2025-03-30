import java.sql.*;
import java.util.*;

class EmpTable {
    Connection conn;
    PreparedStatement pstmt;

    EmpTable() {
        String connString = "jdbc:mysql://localhost:3306/testing";
        String username = "root";
        String password = "edmfreak";

        try {
            conn = DriverManager.getConnection(connString, username, password);
            System.out.println("Connected to Database!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    void insertData(Scanner sc) {
        try {
            System.out.print("Enter EMP No: ");
            int empNo = sc.nextInt();
            sc.nextLine();

            System.out.print("Enter EMP Name: ");
            String empName = sc.nextLine();

            System.out.print("Enter EMP Salary: ");
            int empSalary = sc.nextInt();
            sc.nextLine();

            System.out.print("Enter EMP Designation: ");
            String empDesg = sc.nextLine();

            String insertQuery = "INSERT INTO emp (eno, ename, sal, desg) VALUES (?, ?, ?, ?)";
            pstmt = conn.prepareStatement(insertQuery);
            pstmt.setInt(1, empNo);
            pstmt.setString(2, empName);
            pstmt.setInt(3, empSalary);
            pstmt.setString(4, empDesg);

            int rows = pstmt.executeUpdate();
            System.out.println(rows + " row(s) inserted successfully!");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    void updateData(Scanner sc) {
        try {
            System.out.print("Enter EMP No: ");
            int empNo = sc.nextInt();
            sc.nextLine();

            System.out.print("Enter new Salary: ");
            int newSal = sc.nextInt();
            sc.nextLine();

            String updateQuery = "UPDATE emp SET sal = ? WHERE eno = ?";
            pstmt = conn.prepareStatement(updateQuery);
            pstmt.setInt(1, newSal);
            pstmt.setInt(2, empNo);
            pstmt.executeUpdate();
            System.out.println("Updated");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    void deleteData(Scanner sc) {
        try {
            System.out.print("Enter EMP No to delete: ");
            int empNo = sc.nextInt();
            sc.nextLine();

            String deleteQuery = "DELETE FROM emp WHERE eno = ?";
            pstmt = conn.prepareStatement(deleteQuery);
            pstmt.setInt(1, empNo);
            pstmt.executeUpdate();
            System.out.println("Deleted");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    void searchData(Scanner sc) {
        try {
            System.out.print("Enter EMP No to search: ");
            int empNo = sc.nextInt();
            sc.nextLine();

            String selectQuery = "SELECT * FROM emp WHERE eno = ?;";
            pstmt = conn.prepareStatement(selectQuery);
            pstmt.setInt(1, empNo);
            ResultSet rs = pstmt.executeQuery();

            System.out.println("ENO | ENAME | SALARY| DESG");
            System.out.println("--------------------------");

            while (rs.next()) {
                int eno = rs.getInt("eno");
                String ename = rs.getString("ename");
                int sal = rs.getInt("sal");
                String desg = rs.getString("desg");

                System.out.println(eno + " | " + ename + " | " + sal + " | " + desg);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    void displayData() {
        try {
            String selectQuery = "SELECT * FROM emp WHERE eno;";
            pstmt = conn.prepareStatement(selectQuery);
            ResultSet rs = pstmt.executeQuery();

            System.out.println("ENO | ENAME | SALARY| DESG");
            System.out.println("--------------------------");

            while (rs.next()) {
                int eno = rs.getInt("eno");
                String ename = rs.getString("ename");
                int sal = rs.getInt("sal");
                String desg = rs.getString("desg");

                System.out.println(eno + " | " + ename + " | " + sal + " | " + desg);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

public class s24b {
    public static void main(String[] args) {
        EmpTable emp = new EmpTable();
        Scanner sc = new Scanner(System.in);
        int choice;
        do {
            System.out.println("\n\n1. Insert\n2. Update\n3. Delete\n4. Search\n5. Display\n6. Exit");
            System.out.print("Enter Your Choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    emp.insertData(sc);
                    break;
                case 2:
                    emp.updateData(sc);
                    break;
                case 3:
                    emp.deleteData(sc);
                    break;
                case 4:
                    emp.searchData(sc);
                    break;
                case 5:
                    emp.displayData();
                    break;
                case 6:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid Choice");
                    break;
            }
        } while (choice != 6);
        sc.close();
    }
}
