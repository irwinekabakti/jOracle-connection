package services;

import dto.EmployeesDTO;
import java.sql.*;

public class UpdateStatement {
    private static final String DB_URL = "jdbc:oracle:thin:system/lEAfs1967@localhost:1521:orcl1";

    public boolean updateEmployee(EmployeesDTO employee) {
        StringBuilder updateSQL = new StringBuilder("UPDATE employees SET ");

        boolean firstField = true;

        if (employee.getName() != null) {
            updateSQL.append("name = ?");
            firstField = false;
        }
        if (employee.getAge() != null) {
            if (!firstField) updateSQL.append(", ");
            updateSQL.append("age = ?");
            firstField = false;
        }
        if (employee.getAddress() != null) {
            if (!firstField) updateSQL.append(", ");
            updateSQL.append("address = ?");
            firstField = false;
        }
        if (employee.getSalary() != null) {
            if (!firstField) updateSQL.append(", ");
            updateSQL.append("salary = ?");
        }

        updateSQL.append(" WHERE id = ?");

        try (Connection connection = DriverManager.getConnection(DB_URL);
             PreparedStatement preparedStatement = connection.prepareStatement(updateSQL.toString())) {

            int parameterIndex = 1;
            if (employee.getName() != null) {
                preparedStatement.setString(parameterIndex++, employee.getName());
            }
            if (employee.getAge() != null) {
                preparedStatement.setInt(parameterIndex++, employee.getAge());
            }
            if (employee.getAddress() != null) {
                preparedStatement.setString(parameterIndex++, employee.getAddress());
            }
            if (employee.getSalary() != null) {
                preparedStatement.setDouble(parameterIndex++, employee.getSalary());
            }
            preparedStatement.setInt(parameterIndex, employee.getId());

            int rowsAffected = preparedStatement.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Successfully updated employee with ID: " + employee.getId());
                return true;
            } else {
                System.out.println("No employee found with ID: " + employee.getId());
                return false;
            }

        } catch (SQLException e) {
            System.out.println("Error in UPDATE operation!");
            e.printStackTrace();
            return false;
        }
    }
}