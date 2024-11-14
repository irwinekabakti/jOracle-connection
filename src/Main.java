import java.sql.*;

public class Main {
    public static void main(String[] args) {
        String dbURL = "jdbc:oracle:thin:system/lEAfs1967@localhost:1521:orcl1";

        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        PreparedStatement preparedStatement = null;

        String updateSQL = "UPDATE employees SET name = ?, age = ? WHERE id = ?";

        try {
            // Connect to database
            connection = DriverManager.getConnection(dbURL);
            preparedStatement = connection.prepareStatement(updateSQL);

            // Define the ID you want to update
            int idToUpdate = 1;  // Now id is defined

            // Set the parameters for PreparedStatement
            preparedStatement.setString(1, "test update");
            preparedStatement.setInt(2, 55);
            preparedStatement.setInt(3, idToUpdate);

            // Execute the update
            int rowsAffected = preparedStatement.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("\nSuccessfully updated employee with ID: " + idToUpdate);
            } else {
                System.out.println("\nNo employee found with ID: " + idToUpdate);
            }

        } catch (SQLException e) {
            System.out.println("Error in UPDATE operation!");
            e.printStackTrace();
        } finally {
            // Close resources
            try {
                if (preparedStatement != null) preparedStatement.close();
                if (connection != null) connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}