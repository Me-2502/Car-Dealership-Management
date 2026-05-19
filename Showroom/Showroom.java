import java.util.UUID;
import java.util.ArrayList;
import java.util.List;

public class Showroom {
    String id;
    String name;
    String address;
    Person owner;
    int capacity;
    int totalEmployees;
    int totalCarsInStock;
    Employee manager;
    List<Employee> employees;
    List<Car> carsInStock;

    public Showroom(String name, String address, Person owner, Employee manager, int capacity) {
        this.id = UUID.randomUUID().toString();
        this.name = name;
        this.address = address;
        this.owner = owner;
        this.manager = manager;
        this.capacity = capacity;
        this.totalEmployees = 1;
        this.totalCarsInStock = 0;
        employees = new ArrayList<>();
        employees.add(manager);
        carsInStock = new ArrayList<>();
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Person getOwner() {
        return owner;
    }

    public Employee getManager() {
        return manager;
    }

    public String getAddress() {
        return address;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setName(String name) {
        try {
            if(name == null || name.trim().isEmpty())
                throw new IllegalArgumentException("Showroom name cannot be empty.");
            this.name = name;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return;
        }
    }

    public void setAddress(String address) {
        try {
            if(address == null || address.trim().isEmpty())
                throw new IllegalArgumentException("Showroom address cannot be empty.");
            this.address = address;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return;
        }
    }

    public void setOwner(Person owner) {
        try {
            if(owner == null)
                throw new IllegalArgumentException("Owner cannot be null.");
            this.owner = owner;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return;
        }
    }

    public void setManager(Employee manager) {
        try {
            if(manager.getType() != EmployeeType.MANAGER)
                throw new IllegalArgumentException("Employee is not a manager. Cannot assign as showroom manager.");
            this.manager = manager;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return;
        }
    }

    public void setCapacity(int capacity) {
        try {
            if(capacity <= 0)
                throw new IllegalArgumentException("Capacity must be a positive integer.");
            this.capacity = capacity;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return;
        }
    }

    public void addEmployee(Employee employee) {
        employees.add(employee);
        totalEmployees++;
    }

    public void removeEmployee(Employee employee) {
        if(employees.remove(employee))
            totalEmployees--;
        else
            System.out.println("Employee not found in showroom.");
    }

    public void getEmployees() {
        System.out.println("Employees in " + name + ":");
        for(Employee emp : employees) {
            System.out.println(emp.toString());
        }
    }

    public void addCar(Car car) {
        if(totalCarsInStock < capacity) {
            carsInStock.add(car);
            totalCarsInStock++;
        } else {
            System.out.println("Cannot add car. Showroom capacity reached.");
            return;
        }
    }

    public void getCarsInStock() {
        System.out.println("Cars in stock at " + name + ":");
        for(Car car : carsInStock) {
            System.out.println(car.toString());
        }
    }

    public void removeCar(Car car) {
        if(carsInStock.remove(car))
            totalCarsInStock--;
        else
            System.out.println("Car not found in showroom stock.");
    }

    public String toString() {
        return "Showroom ID: " + id + ", Name: " + name + ", Address: " + address +
               ", Owner: " + owner.getName() + ", Manager: " + manager.getName() + ", Employees: " + totalEmployees +
               ", Cars in Stock: " + totalCarsInStock;
    }
}
