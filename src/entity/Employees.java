package entity;

public class Employees {
    private String name;
    private int age;
    private String address;
    private double salary;


    public Employees(String name, int age, String address, int salary) {
        this.name = name;
        this.age = age;
        this.address = address;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public void setName () {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge () {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress () {
        this.name = name;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
}
