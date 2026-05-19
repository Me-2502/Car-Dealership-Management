import java.util.ArrayList;
import java.util.List;

public class ShowroomController {
    private final List<Showroom> showrooms = new ArrayList<>();
    private final UserController userService = new UserController();
    private final CarService carService = new CarService();

    public void addShowroom(String name, String address, Person owner, Employee manager, int capacity) {
        Showroom showroom = new Showroom(name, address, owner, manager, capacity);
        showrooms.add(showroom);
    }

    public void getShowroomDetails(String showroomId) {
        for(Showroom showroom : showrooms) {
            if(showroom.getId().equals(showroomId)) {
                System.out.println(showroom);
                return;
            }
        }
        System.out.println("Showroom with ID " + showroomId + " not found.");
    }

    public void addEmployeeToShowroom(String showroomId) {
        Person created = userService.addUser("employee");
        if(!(created instanceof Employee)) {
            System.out.println("Failed to create employee.");
            return;
        }
        Employee emp = (Employee) created;
        for(Showroom showroom : showrooms) {
            if(showroom.getId().equals(showroomId)) {
                showroom.addEmployee(emp);
                return;
            }
        }
        System.out.println("Showroom with ID " + showroomId + " not found.");
    }

    public void removeEmployeeFromShowroom(String showroomId, Employee employee) {
        for(Showroom showroom : showrooms) {
            if(showroom.getId().equals(showroomId)) {
                showroom.removeEmployee(employee);
                return;
            }
        }
        System.out.println("Showroom with ID " + showroomId + " not found.");
    }

    public void addCarToShowroom(String showroomId, Car car) {
        for(Showroom showroom : showrooms) {
            if(showroom.getId().equals(showroomId)) {
                showroom.addCar(car);
                return;
            }
        }
        System.out.println("Showroom with ID " + showroomId + " not found.");
    }

    public void removeCarFromShowroom(String showroomId, Car car) {
        for(Showroom showroom : showrooms) {
            if(showroom.getId().equals(showroomId)) {
                showroom.removeCar(car);
                return;
            }
        }
        System.out.println("Showroom with ID " + showroomId + " not found.");
    }
}