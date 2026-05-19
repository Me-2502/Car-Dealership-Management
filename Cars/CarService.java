import java.util.Scanner;
import java.util.UUID;
import java.util.ArrayList;
import java.util.List;

public class CarService {
    private final List<Car> cars = new ArrayList<>();

    public Car addCar() {
        Scanner sc = new Scanner(System.in);
        String carName, color, chassis_number, transmission;
        int price;
        CarType car_type;
        try {
            System.out.print("Enter car name: ");
            carName = sc.nextLine();
            System.out.print(("Enter car color: "));
            color = sc.nextLine();
            System.out.print("Enter car price: ");
            price = sc.nextInt();
            if(price < 0)
                throw new IllegalArgumentException("Price cannot be negative.");
            sc.nextLine();
            System.out.print("Enter car type (SEDAN/SUV/HATCHBACK): ");
            String car_type_input = sc.nextLine();
            switch(car_type_input.toUpperCase()) {
                case "SEDAN":
                    car_type = CarType.SEDAN;
                    break;
                case "SUV":
                    car_type = CarType.SUV;
                    break;
                case "HATCHBACK":
                    car_type = CarType.HATCHBACK;
                    break;
                default:
                    throw new IllegalArgumentException("Invalid car type. Please enter SEDAN, SUV, or HATCHBACK.");
            }
            System.out.print("Enter chassis number: ");
            chassis_number = sc.nextLine();
            if(chassis_number.isEmpty())
                throw new IllegalArgumentException("Chassis number field cannot be empty.");
            System.out.print("Enter transmission type (AUTOMATIC/MANUAL): ");
            transmission = sc.nextLine();
            if(transmission.isEmpty())
                throw new IllegalArgumentException("Transmission type field cannot be empty.");
            // Legacy: keep UUID generation if needed later
            String car_id = UUID.randomUUID().toString();
            System.out.println("Enter powertrain type:");
            String powertrain_type = sc.nextLine();
            Powertrain powertrain;
            switch(powertrain_type.toUpperCase()) {
                case "ICE":
                    powertrain = new ICE();
                    break;
                case "EV":
                    powertrain = new EV();
                    break;
                default:
                    throw new IllegalArgumentException("Invalid powertrain type. Please enter ICE or EV.");
            }
            Car car = new Car(carName, color, price, car_type, transmission, chassis_number, powertrain);
            cars.add(car);
            return car;
        }
        catch(Exception e) {
            System.out.println("An error occurred while setting car details: " + e.getMessage());
            return null;
        }
    }
}