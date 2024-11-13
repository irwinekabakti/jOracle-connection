import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {
//        String dbURL = "jdbc:oracle:thin://localhost:1521/orcl1";
        String dbURL = "jdbc:oracle:thin:system/lEAfs1967@localhost:1521:orcl1";

//        String dbURL = "jdbc:oracle:oci@localhost:1521:orcl1";
//        String username = "system";
//        String password = "lEAfs1967";

        try {
            Connection connection = DriverManager.getConnection(dbURL);
//            Connection connection = DriverManager.getConnection(dbURL, username, password);
            System.out.println("Connected to Oracle database server !");

        } catch (SQLException e) {
            System.out.println("Ups, something went wrong !");
            e.printStackTrace();
        }
    }
}