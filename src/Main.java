import dto.EmployeesDTO;
import entity.Employees;
import services.*;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        EmployeeProcedureService service = new EmployeeProcedureService();

        // Test getting players by location
        System.out.println("\n--- Players by Location ---");
        service.getPlayersByLocation("Ukraine");
        service.getPlayersByLocation("London");

        // Test getting salary statistics for different age groups
        System.out.println("\n--- Salary Statistics by Age Group ---");
        service.getSalaryStatsByAgeGroup(18, 25); // Young players
        service.getSalaryStatsByAgeGroup(26, 35); // Experienced players

        // Test calculating total wages by location
        System.out.println("\n--- Total Wages by Location ---");
        double ukraineWages = service.getLocationWages("Ukraine");
        System.out.println("Total wages in Ukraine: $" + String.format("%.2f", ukraineWages));

        double londonWages = service.getLocationWages("London");
        System.out.println("Total wages in London: $" + String.format("%.2f", londonWages));
    }
}