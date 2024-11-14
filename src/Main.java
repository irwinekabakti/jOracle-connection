import dto.EmployeesDTO;
import entity.Employees;
import services.DeleteStatement;
import services.InsertStatement;
import services.ReadStatement;
import services.UpdateStatement;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        ReadStatement readOp = new ReadStatement();
        InsertStatement insertOp = new InsertStatement();
        UpdateStatement updateOp = new UpdateStatement();
        DeleteStatement deleteOp = new DeleteStatement();

        // Test Insert
        System.out.println("\nTesting INSERT:");
        insertOp.createEmployee("Mudryk", 30, "Ukraine", 9999);

        // Create a list of employees
        List<Employees> employees = new ArrayList<>();
        employees.add(new Employees("John Doe", 30, "Norway", 3400));
        employees.add(new Employees("Jane Smith", 25, "Wales", 4600));
        employees.add(new Employees("Bob Johnson", 35, "Scotland", 1200));


        // Test Read
        System.out.println("\nTesting READ:");
        readOp.getAllEmployees();
        readOp.getEmployeeById(2);

        // Test Update - Only updating name and age
        EmployeesDTO updateEmployee = new EmployeesDTO(2, "Test Updated", 31, null, null);
        updateOp.updateEmployee(updateEmployee);

        // Verify the update
        readOp.getEmployeeById(2);

        // Test Delete
        System.out.println("\nTesting DELETE:");
        deleteOp.deleteEmployee(2);
        readOp.getAllEmployees();
    }
}