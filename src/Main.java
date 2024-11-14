import java.sql.*;

public class Main {
    public static void main(String[] args) {

        String dbURL = "jdbc:oracle:thin:system/lEAfs1967@localhost:1521:orcl1";

        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;

        try {
            // Connect to Oracle Database
            connection = DriverManager.getConnection(dbURL);
            System.out.println("Connected to Oracle database server!");

            // Create a SQL SELECT query
            String sql = "SELECT * FROM employees";

            // Create a Statement object to execute the query
            statement = connection.createStatement();

            // Execute the query and get the ResultSet
            resultSet = statement.executeQuery(sql);

            // Process the ResultSet to retrieve data
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                int age = resultSet.getInt("age");

                // Print the data
                System.out.println("Employee ID: " + id + ", Name: " + name + " " + age);
            }
        } catch (SQLException e) {
            System.out.println("Ups, something went wrong!");
            e.printStackTrace();
        } finally {
            // Close resources to prevent memory leaks
            try {
                if (resultSet != null) resultSet.close();
                if (statement != null) statement.close();
                if (connection != null) connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
   }
}