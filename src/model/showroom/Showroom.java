package model.showroom;

import model.car.Car;
import model.user.Employee;
import model.user.Manager;
import model.user.Person;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class Showroom {
    private final String id;
    private String name;
    private String address;
    private Person owner;
    private int capacity;
    private Manager manager;

    private final List<Employee> employees = new ArrayList<>();
    private final List<Car> carsInStock = new ArrayList<>();

    public Showroom(String id, String name, String address, Person owner, Manager manager, int capacity) {
        this.id = Objects.requireNonNull(id, "id");
        this.name = name;
        this.address = address;
        this.owner = owner;
        this.manager = manager;
        this.capacity = capacity;
        if(manager != null) {
            this.employees.add(manager);
        }
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Person getOwner() {
        return owner;
    }

    public void setOwner(Person owner) {
        this.owner = owner;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public Manager getManager() {
        return manager;
    }

    public void setManager(Manager manager) {
        this.manager = manager;
        if(manager != null && !employees.contains(manager)) {
            employees.add(manager);
        }
    }

    public List<Employee> getEmployees() {
        return Collections.unmodifiableList(employees);
    }

    public List<Car> getCarsInStock() {
        return Collections.unmodifiableList(carsInStock);
    }

    // Domain helpers (no printing)
    public boolean hasCapacityForMoreCars() {
        return carsInStock.size() < capacity;
    }

    public void addEmployee(Employee employee) {
        employees.add(employee);
    }

    public void removeEmployee(Employee employee) {
        employees.remove(employee);
    }

    public void addCar(Car car) {
        carsInStock.add(car);
    }

    public void removeCar(Car car) {
        carsInStock.remove(car);
    }

    @Override
    public String toString() {
        return "Showroom{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", owner=" + (owner != null ? owner.getName() : null) +
                ", manager=" + (manager != null ? manager.getName() : null) +
                ", capacity=" + capacity +
                ", employees=" + employees.size() +
                ", carsInStock=" + carsInStock.size() +
                '}';
    }
}
