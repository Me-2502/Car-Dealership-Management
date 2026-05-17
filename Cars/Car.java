import java.util.Scanner;

enum CarType {
    SEDAN, SUV, HATCHBACK, WAGON, CONVERTIBLE, COUPE, MINIVAN
}

public class Car extends Showroom implements utility{
    String car_name;
    String car_color;
    int car_price;
    CarType car_type;
    String car_transmission;
    String chassis_number;
    Powertrain powertrain;

    public void get_details(){
        System.out.println("NAME: " + car_name);
        System.out.println("COLOR: " + car_color);
        System.out.println("PRICE: " + car_price);
        System.out.println("CAR TYPE: " + car_type);
        System.out.println("TRANSMISSION: " + car_transmission);
        powertrain.get_details();
    }

    public void set_details(Scanner sc) {
        try {
            System.out.println("======================= *** ENTER CAR DETAILS *** =======================");
            System.out.println();
            System.out.print("CAR NAME: ");
            car_name = sc.nextLine();
            System.out.print(("CAR COLOR: "));
            car_color = sc.nextLine();
            System.out.print("CAR PRICE: ");
            car_price = sc.nextInt();
            if(car_price < 0)
                throw new IllegalArgumentException("Price cannot be negative.");
            sc.nextLine();
            System.out.print("CAR TYPE(SEDAN/SUV/HATCHBACK): ");
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
            System.out.print("CHASSIS NUMBER: ");
            chassis_number = sc.nextLine();
            if(chassis_number.isEmpty())
                throw new IllegalArgumentException("Chassis number field cannot be empty.");
            System.out.print("TRANSMISSION TYPE(AUTOMATIC/MANUAL): ");
            car_transmission = sc.nextLine();
            if(car_transmission.isEmpty())
                throw new IllegalArgumentException("Transmission type field cannot be empty.");
            powertrain.set_details(sc);
            total_cars_in_stock++;
        }
        catch(Exception e) {
            System.out.println("An error occurred while setting car details: " + e.getMessage());
        }
    }

    public String toString() {
        return "Car Name: " + car_name + ", Color: " + car_color + ", Price: " + car_price +
               ", Type: " + car_type + ", Transmission: " + car_transmission +
               ", Powertrain: " + powertrain.toString() +
               ", Chassis Number: " + chassis_number;
    }
}
