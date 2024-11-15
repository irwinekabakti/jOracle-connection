import dto.EmployeesDTO;
import entity.Employees;
import services.*;

import java.util.*;

/*
public class Main {
    public static void main(String[] args) {
        ReadStatement readOp = new ReadStatement();
        InsertStatement insertOp = new InsertStatement();
        UpdateStatement updateOp = new UpdateStatement();
        DeleteStatement deleteOp = new DeleteStatement();

//        // Test Insert
//        System.out.println("\nTesting INSERT:");
////        insertOp.createEmployee("Mudryk", 30, "Ukraine", 9999);
//        insertOp.createEmployee("Test name", null, null, null);
////        insertOp.createEmployee("Wissa", 31, "Brent", 99999.0);


//        // Create a list of employees
//        List<Employees> employees = new ArrayList<>();
//        employees.add(new Employees("John Doe", 30, "Norway", 3400));
//        employees.add(new Employees("Jane Smith", 25, "Wales", 4600));
//        employees.add(new Employees("Bob Johnson", 35, "Scotland", 1200));
//
//
        // Test Read
        System.out.println("\nTesting READ:");
        readOp.getAllEmployees();
//        readOp.getEmployeeById(2);

//
//        // Test Update
//        EmployeesDTO updateEmployee = new EmployeesDTO(27, "Fernandes", 31, "Lisbon", null);
//        updateOp.updateEmployee(updateEmployee);
//
//        // Verify the update
//        readOp.getEmployeeById(27);
//
//        // Test Delete
//        System.out.println("\nTesting DELETE:");
//        deleteOp.deleteEmployee(2);
//        readOp.getAllEmployees();
    }
}
*/

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