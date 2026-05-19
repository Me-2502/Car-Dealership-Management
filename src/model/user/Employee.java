package model.user;

public class Employee extends Person {
    private int age;
    private double salary;
    private String designation;

    public Employee(String id,
                    String name,
                    String phoneNumber,
                    String email,
                    int age,
                    double salary,
                    String designation) {
        super(id, name, phoneNumber, email);
        this.age = age;
        this.salary = salary;
        this.designation = designation;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    @Override
    public Role getRole() {
        return Role.EMPLOYEE;
    }
}
