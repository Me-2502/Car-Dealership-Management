import java.util.Scanner;

public class UserController {
    private List<Employee> employees;
    private List<Customer> customers;
    private List<Person> others;

    public Person addUser(String type) {
        Scanner sc = new Scanner(System.in);
        try {
            System.out.print("Enter name: ");
            String name = sc.nextLine();
            if(name == null || name.trim().isEmpty())
                throw new IllegalArgumentException("Name cannot be empty.");
            System.out.print("Enter phone number: ");
            String phoneNumber = sc.nextLine();
            if(phoneNumber == null || phoneNumber.trim().isEmpty())
                throw new IllegalArgumentException("Phone number cannot be empty.");
            System.out.print("Enter mail ID: ");
            String mail_id = sc.nextLine();
            if(mail_id == null || mail_id.trim().isEmpty())
                throw new IllegalArgumentException("Mail ID cannot be empty.");
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
            return null;
        }
        switch type.toLowerCase() {
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
        }
        Person per = new Person(name, phoneNumber, mail_id);
        others.add(per);
        return per;
    }

    public void getUserDetails(String userId) {
        for(Person user : users) {
            if(user.getId().equals(userId)) {
                System.out.println(user);
                return;
            }
        }
        System.out.println("User with ID " + userId + " not found.");
    }

    public Person getUser(String userId) {
        for(Person user : users) {
            if(user.getId().equals(userId))
                return user;
        }
        return null;
    }
}