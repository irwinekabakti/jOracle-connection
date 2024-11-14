package services;
import java.sql.*;


public class EmployeeProcedureService {
    private static final String DB_URL = "jdbc:oracle:thin:system/lEAfs1967@localhost:1521:orcl1";

    public void getPlayersByLocation(String location) {
        String callStatement = "{call get_employees_by_address(?, ?)}";

        try (Connection connection = DriverManager.getConnection(DB_URL);
             CallableStatement stmt = connection.prepareCall(callStatement)) {

            // Set input parameter
            stmt.setString(1, location);

            // Register output parameter
            stmt.registerOutParameter(2, Types.INTEGER);

            // Execute the procedure
            stmt.execute();

            // Get the result
            int playerCount = stmt.getInt(2);
            System.out.println("Number of players in " + location + ": " + playerCount);

        } catch (SQLException e) {
            System.out.println("Error getting players by location!");
            e.printStackTrace();
        }
    }

    public void getSalaryStatsByAgeGroup(int minAge, int maxAge) {
        String callStatement = "{call get_salary_stats_by_age(?, ?, ?, ?, ?)}";

        try (Connection connection = DriverManager.getConnection(DB_URL);
             CallableStatement stmt = connection.prepareCall(callStatement)) {

            // Set input parameters
            stmt.setInt(1, minAge);
            stmt.setInt(2, maxAge);

            // Register output parameters
            stmt.registerOutParameter(3, Types.DOUBLE);  // avg salary
            stmt.registerOutParameter(4, Types.DOUBLE);  // max salary
            stmt.registerOutParameter(5, Types.INTEGER); // player count

            // Execute the procedure
            stmt.execute();

            // Get the results
            double avgSalary = stmt.getDouble(3);
            double maxSalary = stmt.getDouble(4);
            int playerCount = stmt.getInt(5);

            System.out.println("\nSalary Statistics for Age Group " + minAge + "-" + maxAge + ":");
            System.out.println("Number of Players: " + playerCount);
            System.out.println("Average Salary: $" + String.format("%.2f", avgSalary));
            System.out.println("Maximum Salary: $" + String.format("%.2f", maxSalary));

        } catch (SQLException e) {
            System.out.println("Error getting salary statistics!");
            e.printStackTrace();
        }
    }

    public double getLocationWages(String location) {
        String callStatement = "{? = call calculate_location_wages(?)}";

        try (Connection connection = DriverManager.getConnection(DB_URL);
             CallableStatement stmt = connection.prepareCall(callStatement)) {

            // Register return parameter
            stmt.registerOutParameter(1, Types.DOUBLE);

            // Set input parameter
            stmt.setString(2, location);

            // Execute the function
            stmt.execute();

            // Get the result
            return stmt.getDouble(1);

        } catch (SQLException e) {
            System.out.println("Error calculating location wages!");
            e.printStackTrace();
            return 0.0;
        }
    }
}
