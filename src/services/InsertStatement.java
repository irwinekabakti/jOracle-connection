package services;

import entity.Employees;
import java.sql.*;
import java.util.List;

public class InsertStatement {
    private static final String DB_URL = "jdbc:oracle:thin:system/lEAfs1967@localhost:1521:orcl1";

    public boolean createEmployee(String name, int age, String address, double salary) {
        String insertSQL = "INSERT INTO employees (name, age, address, salary) VALUES (?, ?, ?, ?)";

        try (Connection connection = DriverManager.getConnection(DB_URL);
             PreparedStatement preparedStatement = connection.prepareStatement(insertSQL)) {

            preparedStatement.setString(1, name);
            preparedStatement.setInt(2, age);
            preparedStatement.setString(3, address);
            preparedStatement.setDouble(4, salary);

            int rowsAffected = preparedStatement.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Successfully created new employee");
                return true;
            } else {
                System.out.println("Failed to create employee");
                return false;
            }

        } catch (SQLException e) {
            System.out.println("Error in CREATE operation!");
            e.printStackTrace();
            return false;
        }
    }

    public boolean createMultipleEmployees(List<Employees> employees) {
        String insertSQL = "INSERT INTO employees (name, age, address, salary) VALUES (?, ?, ?, ?)";

        try (Connection connection = DriverManager.getConnection(DB_URL);
             PreparedStatement preparedStatement = connection.prepareStatement(insertSQL)) {

            connection.setAutoCommit(false);

            for (Employees emp : employees) {
                preparedStatement.setString(1, emp.getName());
                preparedStatement.setInt(2, emp.getAge());
                preparedStatement.setString(3, emp.getAddress());
                preparedStatement.setDouble(4, emp.getSalary());

                preparedStatement.addBatch();
            }

            int[] results = preparedStatement.executeBatch();
            connection.commit();

            System.out.println("Successfully created " + results.length + " employees");
            return true;

        } catch (SQLException e) {
            System.out.println("Error in batch CREATE operation!");
            e.printStackTrace();
            return false;
        }
    }
}