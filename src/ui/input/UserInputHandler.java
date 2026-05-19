package ui.input;

import model.user.Customer;
import model.user.Employee;
import model.user.Manager;
import model.user.Person;
import util.IdGenerator;

public class UserInputHandler {
    private final ConsoleInput in;

    public UserInputHandler(ConsoleInput in) {
        this.in = in;
    }

    public Employee readEmployee() {
        String name = in.readLine("Employee name: ").trim();
        String phone = in.readLine("Phone number: ").trim();
        String email = in.readLine("Email: ").trim();
        int age = in.readInt("Age: ");
        double salary = in.readDouble("Salary: ");
        String designation = in.readLine("Designation: ").trim();
        return new Employee(IdGenerator.newId(), name, phone, email, age, salary, designation);
    }

    public Manager readManager() {
        String name = in.readLine("Manager name: ").trim();
        String phone = in.readLine("Phone number: ").trim();
        String email = in.readLine("Email: ").trim();
        int age = in.readInt("Age: ");
        double salary = in.readDouble("Salary: ");
        String designation = in.readLine("Designation: ").trim();
        return new Manager(IdGenerator.newId(), name, phone, email, age, salary, designation);
    }

    public Customer readCustomer() {
        String name = in.readLine("Customer name: ").trim();
        String phone = in.readLine("Phone number: ").trim();
        String email = in.readLine("Email: ").trim();
        return new Customer(IdGenerator.newId(), name, phone, email);
    }

    public Person readBuyer() {
        // Keep it simple: buyer is a customer
        return readCustomer();
    }
}
