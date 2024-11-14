package services;

import entity.Employees;
import java.sql.*;
import java.util.List;

public class InsertStatement {
    private static final String DB_URL = "jdbc:oracle:thin:system/lEAfs1967@localhost:1521:orcl1";

    public boolean createEmployee(String name, Integer age, String address, Double salary) {
        String insertSQL = "INSERT INTO employees (name, age, address, salary) VALUES (?, ?, ?, ?)";

        try (Connection connection = DriverManager.getConnection(DB_URL);
             PreparedStatement preparedStatement = connection.prepareStatement(insertSQL)) {

            // Set the 'name' parameter
            preparedStatement.setString(1, name);

            // Set the 'age' parameter, check if age is null and handle it
            if (age != null) {
                preparedStatement.setInt(2, age);
            } else {
                preparedStatement.setNull(2, Types.INTEGER);
            }

            // Set the 'address' parameter, check if address is null and handle it
            if (address != null) {
                preparedStatement.setString(3, address);
            } else {
                preparedStatement.setNull(3, Types.VARCHAR);
            }

            // Set the 'salary' parameter, check if salary is null and handle it
            if (salary != null) {
                preparedStatement.setDouble(4, salary);
            } else {
                preparedStatement.setNull(4, Types.DOUBLE);
            }

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
                // Set the 'name' parameter
                preparedStatement.setString(1, emp.getName());

                // Set the 'age' parameter, check if age is null and handle it
                if (emp.getAge() != null) {
                    preparedStatement.setInt(2, emp.getAge());
                } else {
                    preparedStatement.setNull(2, Types.INTEGER);
                }

                // Set the 'address' parameter, check if address is null and handle it
                if (emp.getAddress() != null) {
                    preparedStatement.setString(3, emp.getAddress());
                } else {
                    preparedStatement.setNull(3, Types.VARCHAR);
                }

                // Set the 'salary' parameter, check if salary is null and handle it
                if (emp.getSalary() != null) {
                    preparedStatement.setDouble(4, emp.getSalary());
                } else {
                    preparedStatement.setNull(4, Types.DOUBLE);
                }

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