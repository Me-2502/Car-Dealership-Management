import java.util.Scanner;

public class ShowroomController {
    private List<Showroom> showrooms;
    private UserService userService;

    public addShowroom(String name, String address, Person owner, Employee manager, int capacity) {
        Showroom showroom = new Showroom(name, address, owner, manager, capacity);
        showrooms.add(showroom);
    }

    public getShoroomDetails(String showroomId) {
        for(Showroom showroom : showrooms) {
            if(showroom.getId().equals(showroomId)) {
                System.out.println(showroom);
                return;
            }
        }
        System.out.println("Showroom with ID " + showroomId + " not found.");
    }

    public void addEmployeeToShowroom(String showroomId) {
        for(Showroom showroom : showrooms) {
            if(showroom.getId().equals(showroomId)) {
                showroom.addEmployee(employee);
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

    public void 
}