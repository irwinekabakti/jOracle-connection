package dto;

public class EmployeesDTO {
    private Integer id;
    private String name;
    private Integer age;
    private String address;
    private Double salary;

    public EmployeesDTO(Integer id, String name, Integer age, String address, Double salary) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.address = address;
        this.salary = salary;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Integer getAge() {
        return age;
    }

    public String getAddress() {
        return address;
    }

    public Double getSalary() {
        return salary;
    }
}