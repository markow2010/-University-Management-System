import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Manager {

    public static void main(String[] args) {
        Connection conn = null;
        try {
            // Load the MySQL JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Prompt the user for their username and password
            Scanner scanner = new Scanner(System.in);
            System.out.println("Please provide username: ");
            String username = scanner.nextLine();
            System.out.println("Please provide password: ");
            String password = scanner.nextLine();
            scanner.close();

            conn = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/university?serverTimezone=UTC", username, password);

            // Retrieve all info about departments, without info about their budgets
            System.out.println("Departments:");
            PreparedStatement deptStmt = conn.prepareStatement(
                    "SELECT dept_name, building FROM department ORDER BY dept_name");
            ResultSet deptResult = deptStmt.executeQuery();
            while (deptResult.next()) {
                System.out.println(
                        deptResult.getString("dept_name") + ", " + deptResult.getString("building"));
            }
            deptStmt.close();
            deptResult.close();

            // Add a course
            Scanner inputScanner = new Scanner(System.in);
            System.out.println("Enter course ID:");
            String courseId = inputScanner.nextLine();
            System.out.println("Enter course title:");
            String courseTitle = inputScanner.nextLine();
            System.out.println("Enter department name:");
            String deptName = inputScanner.nextLine();
            System.out.println("Enter number of credits:");
            int credits = 0;
            try {
                while (credits == 0) {
                    try {
                        credits = Integer.parseInt(inputScanner.nextLine());
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid input. Please enter a number:");
                    }
                }
            } finally {
                inputScanner.close();
            }

            // Insert the new course into the database
            PreparedStatement addCourseStmt = conn.prepareStatement(
                    "INSERT INTO course (course_id, title, dept_name, credits) VALUES (?, ?, ?, ?)");
            addCourseStmt.setString(1, courseId);
            addCourseStmt.setString(2, courseTitle);
            addCourseStmt.setString(3, deptName);
            addCourseStmt.setInt(4, credits);
            addCourseStmt.executeUpdate();
            addCourseStmt.close();

            // Retrieve all info about courses
            System.out.println("Courses:");
            PreparedStatement courseStmt = conn.prepareStatement(
                    "SELECT course_id, title, dept_name, credits FROM course ORDER BY course_id");
            ResultSet courseResult = courseStmt.executeQuery();
            while (courseResult.next()) {
                System.out.println(courseResult.getString("course_id") + ", " + courseResult.getString("title")
                        + ", " + courseResult.getString("dept_name") + ", " + courseResult.getInt("credits"));
            }
            courseStmt.close();
            courseResult.close();

            // Delete a course
            Scanner deleteScanner = new Scanner(System.in);
            try {
                System.out.println("Enter course ID to delete:");
                String deleteCourseId = deleteScanner.nextLine();
                PreparedStatement deleteCourseStmt = conn.prepareStatement("DELETE FROM course WHERE course_id = ?");
                deleteCourseStmt.setString(1, deleteCourseId);
                int deleteCount = deleteCourseStmt.executeUpdate();
                deleteCourseStmt.close();
            } finally {
                deleteScanner.close();
            }
        }
        
    }
}