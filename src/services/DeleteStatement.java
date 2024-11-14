package services;

import java.sql.*;

public class DeleteStatement {
    private static final String DB_URL = "jdbc:oracle:thin:system/lEAfs1967@localhost:1521:orcl1";

    public boolean deleteEmployee(int id) {
        String deleteSQL = "DELETE FROM employees WHERE id = ?";

        try (Connection connection = DriverManager.getConnection(DB_URL);
             PreparedStatement preparedStatement = connection.prepareStatement(deleteSQL)) {

            preparedStatement.setInt(1, id);

            int rowsAffected = preparedStatement.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Successfully deleted employee with ID: " + id);
                return true;
            } else {
                System.out.println("No employee found with ID: " + id);
                return false;
            }

        } catch (SQLException e) {
            System.out.println("Error in DELETE operation!");
            e.printStackTrace();
            return false;
        }
    }

    public boolean deleteEmployeesByAge(int age) {
        String deleteSQL = "DELETE FROM employees WHERE age = ?";

        try (Connection connection = DriverManager.getConnection(DB_URL);
             PreparedStatement preparedStatement = connection.prepareStatement(deleteSQL)) {

            preparedStatement.setInt(1, age);

            int rowsAffected = preparedStatement.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Successfully deleted " + rowsAffected + " employees with age: " + age);
                return true;
            } else {
                System.out.println("No employees found with age: " + age);
                return false;
            }

        } catch (SQLException e) {
            System.out.println("Error in DELETE operation!");
            e.printStackTrace();
            return false;
        }
    }
}
