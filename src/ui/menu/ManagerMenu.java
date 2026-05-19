package ui.menu;

import exception.InvalidInputException;
import exception.NotFoundException;
import model.car.Car;
import model.car.CarStatus;
import model.showroom.Showroom;
import model.user.Employee;
import model.user.Manager;
import model.user.Customer;
import model.user.Person;
import repository.CarRepository;
import repository.ShowroomRepository;
import repository.UserRepository;
import service.CarService;
import service.InventoryService;
import service.ShowroomService;
import service.UserService;
import ui.display.CarPrinter;
import ui.display.ShowroomPrinter;
import ui.display.UserPrinter;
import ui.input.CarInputHandler;
import ui.input.ConsoleInput;
import ui.input.ShowroomInputHandler;
import ui.input.UserInputHandler;
import util.LogReader;

import java.util.List;

public class ManagerMenu {
    private final ConsoleInput in;

    private final CarService carService;
    private final UserService userService;
    private final ShowroomService showroomService;

    private final CarInputHandler carInput;
    private final UserInputHandler userInput;
    private final ShowroomInputHandler showroomInput;

    private final CarPrinter carPrinter = new CarPrinter();
    private final UserPrinter userPrinter = new UserPrinter();
    private final ShowroomPrinter showroomPrinter = new ShowroomPrinter();

    public ManagerMenu(ConsoleInput in,
                       CarService carService,
                       UserService userService,
                       ShowroomService showroomService) {
        this.in = in;
        this.carService = carService;
        this.userService = userService;
        this.showroomService = showroomService;

        this.carInput = new CarInputHandler(in);
        this.userInput = new UserInputHandler(in);
        this.showroomInput = new ShowroomInputHandler(in);
    }

    public static ManagerMenu defaultWiring(ConsoleInput in) {
        // Simple wiring without DI framework
        CarRepository carRepo = new CarRepository();
        UserRepository userRepo = new UserRepository();
        ShowroomRepository showroomRepo = new ShowroomRepository();

        InventoryService inventoryService = new InventoryService();
        CarService carService = new CarService(carRepo);
        UserService userService = new UserService(userRepo);
        ShowroomService showroomService = new ShowroomService(showroomRepo, inventoryService);

        return new ManagerMenu(in, carService, userService, showroomService);
    }

    public void run() {
        while(true) {
            printMenu();
            int choice = in.readInt("Choice: ");
            try {
                switch(choice) {
                    case 0:
                        System.out.println("Bye.");
                        return;

                    case 98:
                        viewLogs();
                        break;

                    // Showrooms
                    case 1:
                        createShowroom();
                        break;
                    case 2:
                        showroomPrinter.printList(showroomService.getAll());
                        break;

                    // Users/Employees
                    case 3:
                        addEmployee();
                        break;
                    case 4:
                        userPrinter.printList(userService.findAll());
                        break;
                    case 5:
                        assignManagerToShowroom();
                        break;

                    // Cars
                    case 6:
                        addCar();
                        break;
                    case 7:
                        carPrinter.printList(carService.getAll());
                        break;
                    case 8:
                        searchCarsByName();
                        break;
                    case 9:
                        updateCarStatus();
                        break;

                    // Inventory / Sales
                    case 10:
                        addCarToShowroomStock();
                        break;
                    case 11:
                        listCarsInShowroom();
                        break;
                    case 12:
                        sellCarFromShowroom();
                        break;
                    case 13:
                        removeCarFromShowroom();
                        break;
                    case 14:
                        removeCarFromCatalog();
                        break;
                    case 15:
                        removeEmployeeFromShowroom();
                        break;

                    default:
                        System.out.println("Invalid choice.");
                }
            } catch(InvalidInputException | NotFoundException e) {
                System.out.println("Error: " + e.getMessage());
            } catch(Exception e) {
                System.out.println("Unexpected error: " + e.getMessage());
            }
            System.out.println();
        }
    }

    private void printMenu() {
        System.out.println("=== Manager Console ===");
        System.out.println("0) Exit");
        System.out.println("98) View logs");
        System.out.println();

        System.out.println("-- Showrooms --");
        System.out.println("1) Create showroom");
        System.out.println("2) List showrooms");

        System.out.println("-- Employees / Users --");
        System.out.println("3) Add employee");
        System.out.println("4) List users");
        System.out.println("5) Assign manager to showroom");

        System.out.println("-- Cars --");
        System.out.println("6) Add car (catalog)");
        System.out.println("7) List cars (catalog)");
        System.out.println("8) Search cars by name");
        System.out.println("9) Update car status");

        System.out.println("-- Inventory / Sales --");
        System.out.println("10) Add car to showroom stock");
        System.out.println("11) List cars in a showroom");
        System.out.println("12) Sell car from showroom");
        System.out.println("13) Remove car from showroom stock");
        System.out.println("14) Remove car from catalog");
        System.out.println("15) Remove employee from showroom");
    }

    private void viewLogs() {
        int n = in.readInt("How many recent log lines? ");
        for(String line : LogReader.tail("dealership.log", n)) {
            System.out.println(line);
        }
    }

    private void createShowroom() {
        System.out.println("(Creating owner as a customer record for now)");
        Person owner = userInput.readCustomer();
        userService.addUser(owner);

        System.out.println("Create manager for this showroom");
        Manager manager = userInput.readManager();
        userService.addUser(manager);

        Showroom showroom = showroomInput.readShowroom(owner, manager);
        showroomService.addShowroom(showroom);
        System.out.println("Created showroom: " + showroom.getId());
    }

    private void addEmployee() {
        Employee emp = userInput.readEmployee();
        userService.addUser(emp);
        System.out.println("Added employee: " + emp.getId());

        String assign = in.readLine("Assign to a showroom now? (y/n): ").trim().toLowerCase();
        if(assign.equals("y")) {
            String showroomId = in.readLine("Showroom id: ").trim();
            showroomService.addEmployee(showroomId, emp);
            System.out.println("Assigned employee to showroom.");
        }
    }

    private void assignManagerToShowroom() {
        String showroomId = in.readLine("Showroom id: ").trim();
        Manager manager = userInput.readManager();
        userService.addUser(manager);
        showroomService.assignManager(showroomId, manager);
        System.out.println("Manager assigned.");
    }

    private void addCar() {
        Car car = carInput.readCar();
        carService.addCar(car);
        System.out.println("Added car: " + car.getId());
    }

    private void searchCarsByName() {
        String name = in.readLine("Search name contains: ");
        List<Car> results = carService.searchByName(name);
        carPrinter.printList(results);
    }

    private void updateCarStatus() {
        String carId = in.readLine("Car id: ").trim();
        CarStatus status = in.readEnum("New status (IN_STOCK/RESERVED/SOLD): ", CarStatus.class);
        carService.updateCarStatus(carId, status);
        System.out.println("Updated.");
    }

    private void addCarToShowroomStock() {
        String showroomId = in.readLine("Showroom id: ").trim();
        String carId = in.readLine("Car id (from catalog): ").trim();
        Car car = carService.getById(carId);
        showroomService.addCarToShowroom(showroomId, car);
        System.out.println("Added to showroom stock.");
    }

    private void listCarsInShowroom() {
        String showroomId = in.readLine("Showroom id: ").trim();
        Showroom showroom = showroomService.getById(showroomId);
        carPrinter.printList(showroom.getCarsInStock());
    }

    private void sellCarFromShowroom() {
        String showroomId = in.readLine("Showroom id: ").trim();
        String carId = in.readLine("Car id: ").trim();

        Customer buyer = chooseOrCreateCustomer();
        userService.addUser(buyer);

        showroomService.sellCarToCustomer(showroomId, carId, buyer);
        carService.updateCarStatus(carId, CarStatus.SOLD);
        System.out.println("Sold car.");
    }

    private Customer chooseOrCreateCustomer() {
        String mode = in.readLine("Buyer: (1) existing customer by id, (2) create new : ").trim();
        if("1".equals(mode)) {
            String id = in.readLine("Customer id: ").trim();
            Person existing = userService.findUserByIdOrNull(id);
            if(existing instanceof Customer) {
                return (Customer) existing;
            }
            System.out.println("Customer not found. Creating new.");
        }
        return userInput.readCustomer();
    }

    private void removeCarFromShowroom() {
        String showroomId = in.readLine("Showroom id: ").trim();
        String carId = in.readLine("Car id: ").trim();
        showroomService.removeCarFromShowroom(showroomId, carId);
        System.out.println("Removed from showroom stock.");
    }

    private void removeCarFromCatalog() {
        String carId = in.readLine("Car id: ").trim();
        carService.removeCar(carId);
        System.out.println("Removed from catalog.");
    }

    private void removeEmployeeFromShowroom() {
        String showroomId = in.readLine("Showroom id: ").trim();
        String employeeId = in.readLine("Employee id: ").trim();
        showroomService.removeEmployee(showroomId, employeeId);
        System.out.println("Removed employee from showroom.");
    }
}
