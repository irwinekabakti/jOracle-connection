package services;

import java.sql.*;

public class ReadStatement {
    private static final String DB_URL = "jdbc:oracle:thin:system/lEAfs1967@localhost:1521:orcl1";

    public void getAllEmployees() {
        String selectSQL = "SELECT * FROM employees";

        try (Connection connection = DriverManager.getConnection(DB_URL);
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(selectSQL)) {

            System.out.println("\nCurrent Employees:");
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                int age = resultSet.getInt("age");
                String address = resultSet.getString("address");
                double salary = resultSet.getDouble("salary");
                System.out.println("Employee ID: " + id +
                        ", Name: " + name +
                        ", Age: " + age +
                        ", Address: " + address +
                        ", Salary: $" + salary);
            }
        } catch (SQLException e) {
            System.out.println("Error in READ operation!");
            e.printStackTrace();
        }
    }

    public void getEmployeeById(int id) {
        String selectSQL = "SELECT * FROM employees WHERE id = ?";

        try (Connection connection = DriverManager.getConnection(DB_URL);
             PreparedStatement preparedStatement = connection.prepareStatement(selectSQL)) {

            preparedStatement.setInt(1, id);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    String name = resultSet.getString("name");
                    int age = resultSet.getInt("age");
                    String address = resultSet.getString("address");
                    double salary = resultSet.getDouble("salary");
                    System.out.println("Employee ID: " + id +
                            ", Name: " + name +
                            ", Age: " + age +
                            ", Address: " + address +
                            ", Salary: $" + salary);
                } else {
                    System.out.println("No employee found with ID: " + id);
                }
            }

        } catch (SQLException e) {
            System.out.println("Error in READ operation!");
            e.printStackTrace();
        }
    }
};
