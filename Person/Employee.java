import java.util.UUID;

enum EmployeeType {
    MANAGER, SALES_EXECUTIVE, MECHANIC, FINANCE_OFFICER
}

enum Designation {
    JUNIOR, SENIOR, LEAD, HEAD
}

public class Employee extends Person {
    private int age;
    private double salary;
    private EmployeeType type;
    private Designation designation;

    public Employee(String name, int age, double salary, EmployeeType type, Designation designation, String phone_number, String mail_id) {
        // try {
        //     if(age < 18 || age > 65)
        //         throw new IllegalArgumentException("Age must be between 18 and 65.");
        //     if(salary < 0)
        //         throw new IllegalArgumentException("Salary cannot be negative.");
        // } catch (IllegalArgumentException e) {
        //     System.out.println(e.getMessage());
        //     return;
        // }
        super(name, phone_number, mail_id);
        this.age = age;
        this.salary = salary;
        this.type = type;
        this.designation = designation;
    }

    public int getAge() {
        return age;
    }

    public double getSalary() {
        return salary;
    }

    public EmployeeType getType() {
        return type;
    }

    public String getDesignation() {
        return designation;
    }

    public void setAge(int age) {
        try {
            if(age < 18 || age > 65)
                throw new IllegalArgumentException("Age must be between 18 and 65.");
            this.age = age;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return;
        }
    }

    public void setSalary(double salary) {
        try {
            if(salary < 0)
                throw new IllegalArgumentException("Salary cannot be negative.");
            this.salary = salary;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return;
        }
    }

    public void setDesignation(Designation designation) {
        this.designation = designation;
    }

    public void setType(EmployeeType type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Employee ID: " + id + ", Name: " + name + ", Age: " + age +
               ", Salary: " + salary + ", Designation: " + designation +
               ", Type: " + type + ", Phone Number: " + phoneNumber;
    }
}