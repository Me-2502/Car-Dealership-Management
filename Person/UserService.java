import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UserController {
    private final List<Employee> employees = new ArrayList<>();
    private final List<Customer> customers = new ArrayList<>();
    private final List<Person> others = new ArrayList<>();

    public Person addUser(String type) {
        Scanner sc = new Scanner(System.in);
        String name;
        String phoneNumber;
        String mail_id;
        try {
            System.out.print("Enter name: ");
            name = sc.nextLine();
            if(name == null || name.trim().isEmpty())
                throw new IllegalArgumentException("Name cannot be empty.");
            System.out.print("Enter phone number: ");
            phoneNumber = sc.nextLine();
            if(phoneNumber == null || phoneNumber.trim().isEmpty())
                throw new IllegalArgumentException("Phone number cannot be empty.");
            System.out.print("Enter mail ID: ");
            mail_id = sc.nextLine();
            if(mail_id == null || mail_id.trim().isEmpty())
                throw new IllegalArgumentException("Mail ID cannot be empty.");
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
            return null;
        }
        switch (type.toLowerCase()) {
            case "employee":
                try {
                    System.out.print("Enter age: ");
                    int age = sc.nextInt();
                    if(age < 18 || age > 65)
                        throw new IllegalArgumentException("Age must be between 18 and 65.");
                    System.out.print("Enter salary: ");
                    double salary = sc.nextDouble();
                    if(salary < 0)
                        throw new IllegalArgumentException("Salary cannot be negative.");
                    sc.nextLine();
                    System.out.print("Enter employee type (e.g. Manager, Salesperson): ");
                    String empTypeStr = sc.nextLine();
                    EmployeeType empType = EmployeeType.valueOf(empTypeStr.toUpperCase());
                    System.out.print("Enter designation: ");
                    String empdesigStr = sc.nextLine();
                    Designation designation = Designation.valueOf(empdesigStr.toUpperCase());
                    Employee emp = new Employee(name, age, salary, empType, designation, phoneNumber, mail_id);
                    employees.add(emp);
                    return emp;
                } catch (IllegalArgumentException e) {
                    System.out.println("Error: " + e.getMessage());
                    return null;
                }
            case "customer":
                Customer cust = new Customer(name, phoneNumber, mail_id, new ArrayList<>());
                customers.add(cust);
                return cust;
            default:
                // Keep legacy behavior: store as generic person-like record.
                PersonRecord per = new PersonRecord(name, phoneNumber, mail_id);
                others.add(per);
                return per;
        }
    }

    public void getUserDetails(String userId) {
        Person user = getUser(userId);
        if(user == null) {
            System.out.println("User with ID " + userId + " not found.");
            return;
        }
        System.out.println(user);
    }

    public Person getUser(String userId) {
        for(Employee user : employees) {
            if(user.id.equals(userId)) return user;
        }
        for(Customer user : customers) {
            if(user.id.equals(userId)) return user;
        }
        for(Person user : others) {
            if(user.id.equals(userId)) return user;
        }
        return null;
    }
}

// Minimal concrete type for legacy "others" list.
class PersonRecord extends Person {
    public PersonRecord(String name, String phoneNumber, String mail_id) {
        super(name, phoneNumber, mail_id);
    }
}