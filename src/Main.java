import java.sql.*;

public class Main {
    public static void main(String[] args) {
        String dbURL = "jdbc:oracle:thin:system/lEAfs1967@localhost:1521:orcl1";

        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;

        try {
            connection = DriverManager.getConnection(dbURL);

            String sql = "INSERT INTO EMPLOYEES (name, age, address, salary) " + "VALUES ('Garnacho', 19, 'Manchester', 2000)";
            statement = connection.createStatement();
            int rows = statement.executeUpdate(sql);

            if(rows > 0) {
                System.out.println("A row has been inserted !");
            }

            connection.close();

        } catch (SQLException e) {
            System.out.println("Ups, something went wrong !");
            e.printStackTrace();
        }
    }
}