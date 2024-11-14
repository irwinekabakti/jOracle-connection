import java.sql.*;

public class Main {
    public static void main(String[] args) {
        String dbURL = "jdbc:oracle:thin:system/lEAfs1967@localhost:1521:orcl1";

        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        PreparedStatement preparedStatement = null;

        String deleteSQL = "DELETE FROM employees WHERE id = ?";


        try {
            // Connect to database
            connection = DriverManager.getConnection(dbURL);
            preparedStatement = connection.prepareStatement(deleteSQL);

            // Define the ID you want to delete
            int idToDelete = 1;  // Change this ID as needed

            // Set the parameter for PreparedStatement
            preparedStatement.setInt(1, idToDelete);

            // Execute the delete
            int rowsAffected = preparedStatement.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("\nSuccessfully deleted employee with ID: " + idToDelete);
            } else {
                System.out.println("\nNo employee found with ID: " + idToDelete);
            }

        } catch (SQLException e) {
            System.out.println("Error in DELETE operation!");
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