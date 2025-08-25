import java.util.Scanner;

public class Cars extends Showroom implements utility{
    String car_name;
    String car_color;
    int car_price;
    String car_type;
    boolean car_powertrain; // ICE or EV
    String car_transmission;
    String chassis_number;
    ICE engine;
    EV electric_powertrain;

    @Override
    public void get_details(){
        System.out.println("NAME: " + car_name);
        System.out.println("COLOR: " + car_color);
        System.out.println("PRICE: " + car_price);
        System.out.println("CAR TYPE: " + car_type);
        System.out.println("TRANSMISSION: " + car_transmission);
        if(car_powertrain)
            engine.get_engine_details();
        else
            electric_powertrain.get_details();
    }

    @Override
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
            if(car_price < 400000)
                throw new IllegalArgumentException("Price cannot be negative.");
            sc.nextLine();
            System.out.print("CAR TYPE(SEDAN/SUV/HATCHBACK): ");
            car_type = sc.nextLine();
            if(car_type.isEmpty())
                throw new IllegalArgumentException("Car type field cannot be empty.");
            System.out.print("CAR TYPE BY POWERTRAIN(ICE/EV): ");
            car_powertrain = (sc.nextLine() == "ICE"); // true for ICE, false for EV
            System.out.print("CHASSIS NUMBER: ");
            chassis_number = sc.nextLine();
            if(chassis_number.isEmpty())
                throw new IllegalArgumentException("Chassis number field cannot be empty.");
            System.out.print("TRANSMISSION TYPE(AUTOMATIC/MANUAL): ");
            car_transmission = sc.nextLine();
            if(car_transmission.isEmpty())
                throw new IllegalArgumentException("Transmission type field cannot be empty.");
            if(car_powertrain) {
                System.out.print("ENGINE CONFIGURATION: ");
                String configuration = sc.nextLine();
                if(configuration.isEmpty())
                    throw new IllegalArgumentException("Engine configuration field cannot be empty.");
                System.out.print("ENGINE NUMBER: ");
                String engine_number = sc.nextLine();
                if(engine_number.isEmpty())
                    throw new IllegalArgumentException("Engine number field cannot be empty.");
                System.out.print("POWER(in HP): ");
                int power = sc.nextInt();
                if(power < 50)
                    throw new IllegalArgumentException("Power cannot be negative.");
                System.out.print("TORQUE(in Nm): ");
                int torque = sc.nextInt();
                if(torque < 50)
                    throw new IllegalArgumentException("Torque cannot be negative.");
                sc.nextLine(); // Consume newline
                System.out.print("ENGINE NUMBER: ");
                System.out.print("FUEL TYPE(PETROL/DIESEL): ");
                boolean fuel_type = (sc.nextLine() == "PETROL"); // true for petrol, false for diesel
                engine = new ICE(configuration, power, torque, engine_number, fuel_type);
            }
            else {
                System.out.print("BATTERY CAPACITY (in kWh): ");
                int battery_capacity = sc.nextInt();
                System.out.print("RANGE(in km): ");
                int range = sc.nextInt();
                if(range < 50)
                    throw new IllegalArgumentException("Range cannot be negative.");
                sc.nextLine(); // Consume newline
                System.out.print("MOTOR TYPE: ");
                String motor_type = sc.nextLine();
                if(motor_type.isEmpty())
                    throw new IllegalArgumentException("Motor type field cannot be empty.");
                System.out.print("POWER(in HP): ");
                int power = sc.nextInt();
                if(power < 50)
                    throw new IllegalArgumentException("Power cannot be negative.");
                sc.nextLine(); // Consume newline
                System.out.print("TORQUE(in Nm): ");
                int torque = sc.nextInt();
                if(torque < 50)
                    throw new IllegalArgumentException("Torque cannot be negative.");
                electric_powertrain = new EV(battery_capacity, range, motor_type, power, torque);
            }
            total_cars_in_stock++;
        }
        catch(Exception e) {
            System.out.println("An error occurred while setting car details: " + e.getMessage());
        }
    }

    public String toString() {
        return "Car Name: " + car_name + ", Color: " + car_color + ", Price: " + car_price +
               ", Type: " + car_type + ", Transmission: " + car_transmission +
               ", Powertrain: " + (car_powertrain ? engine.toString() : electric_powertrain.toString() ) +
               ", Chassis Number: " + chassis_number;
    }
}

class ICE {
    String configuration;
    int power;
    int torque;
    String engine_number;
    boolean fuel_type; // true for petrol, false for diesel

    ICE(String configuration, int power, int torque, String engine_number, boolean fuel_type) {
        this.configuration = configuration;
        this.power = power;
        this.torque = torque;
        this.engine_number = engine_number;
        this.fuel_type = fuel_type;
    }

    public void get_engine_details() {
        System.out.println("ENGINE CONFIGURATION: " + configuration);
        System.out.println("POWER: " + power + " HP");
        System.out.println("TORQUE: " + torque + " Nm");
        System.out.println("ENGINE NUMBER: " + engine_number);
        System.out.println("FUEL TYPE: " + (fuel_type ? "PETROL" : "DIESEL"));
        System.out.println("ENGINE NUMBER: " + engine_number);
    }

    public String toString() {
        return "Configuration: " + configuration + ", Power: " + power + " HP, Torque: " + torque +
               " Nm, Engine Number: " + engine_number + ", Fuel Type: " + (fuel_type ? "PETROL" : "DIESEL");
    }
}

class EV extends Cars {
    int battery_capacity;
    int range;
    String motor_type;
    int power;
    int torque;

    EV(int battery_capacity, int range, String motor_type, int power, int torque) {
        this.battery_capacity = battery_capacity;
        this.range = range;
        this.motor_type = motor_type;
        this.power = power;
        this.torque = torque;
    }

    @Override
    public void get_details() {
        super.get_details();
        System.out.println("BATTERY CAPACITY: " + battery_capacity + " kWh");
        System.out.println("RANGE: " + range + " km");
        System.out.println("MOTOR TYPE: " + motor_type);
        System.out.println("POWER: " + power + " HP");
        System.out.println("TORQUE: " + torque + " Nm");
    }

    public String toString() {
        return "Battery Capacity: " + battery_capacity + " kWh, Range: " + range + " km, Motor Type: " +
               motor_type + ", Power: " + power + " HP, Torque: " + torque + " Nm";
    }
}