package service;

import exception.NotFoundException;
import model.car.Car;
import model.showroom.Showroom;
import model.user.Employee;
import model.user.Manager;
import model.user.Customer;
import model.user.Person;
import repository.ShowroomRepository;

import java.util.List;

public class ShowroomService {
    private final ShowroomRepository showroomRepository;
    private final InventoryService inventoryService;

    public ShowroomService(ShowroomRepository showroomRepository, InventoryService inventoryService) {
        this.showroomRepository = showroomRepository;
        this.inventoryService = inventoryService;
    }

    public Showroom addShowroom(Showroom showroom) {
        return showroomRepository.save(showroom);
    }

    public List<Showroom> getAll() {
        return showroomRepository.findAll();
    }

    public Showroom getById(String id) {
        return showroomRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Showroom with id '" + id + "' not found"));
    }

    public void addEmployee(String showroomId, Employee employee) {
        Showroom s = getById(showroomId);
        s.addEmployee(employee);
        showroomRepository.save(s);
    }

    public void removeEmployee(String showroomId, String employeeId) {
        Showroom s = getById(showroomId);
        Employee emp = s.getEmployees().stream().filter(e -> e.getId().equals(employeeId)).findFirst()
                .orElseThrow(() -> new NotFoundException("Employee with id '" + employeeId + "' not found in showroom"));
        s.removeEmployee(emp);
        showroomRepository.save(s);
    }

    public void assignManager(String showroomId, Manager manager) {
        Showroom s = getById(showroomId);
        s.setManager(manager);
        showroomRepository.save(s);
    }

    public void sellCar(String showroomId, String carId, Person customerOrBuyer) {
        // Keep it simple: remove car from stock.
        Showroom s = getById(showroomId);
        Car car = s.getCarsInStock().stream().filter(c -> c.getId().equals(carId)).findFirst()
                .orElseThrow(() -> new NotFoundException("Car with id '" + carId + "' not found in showroom"));
        inventoryService.removeStock(s, car);
        showroomRepository.save(s);
    }

    public void sellCarToCustomer(String showroomId, String carId, Customer customer) {
        sellCar(showroomId, carId, customer);
        customer.addOwnedCarId(carId);
    }

    public void addCarToShowroom(String showroomId, Car car) {
        Showroom s = getById(showroomId);
        inventoryService.addStock(s, car);
        showroomRepository.save(s);
    }

    public void removeCarFromShowroom(String showroomId, String carId) {
        Showroom s = getById(showroomId);
        Car car = s.getCarsInStock().stream().filter(c -> c.getId().equals(carId)).findFirst()
                .orElseThrow(() -> new NotFoundException("Car with id '" + carId + "' not found in showroom"));
        inventoryService.removeStock(s, car);
        showroomRepository.save(s);
    }
}
