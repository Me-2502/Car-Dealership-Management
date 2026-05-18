import java.util.Scanner;

class ICE extends Powertrain {
    String configuration;
    int power;
    int torque;
    String engine_number;
    boolean fuel_type;

    ICE(String configuration, int power, int torque, String engine_number, boolean fuel_type) {
        this.configuration = configuration;
        this.power = power;
        this.torque = torque;
        this.engine_number = engine_number;
        this.fuel_type = fuel_type;
    }

    @Override
    public void get_details() {
        System.out.println("ENGINE CONFIGURATION: " + configuration);
        System.out.println("POWER: " + power + " HP");
        System.out.println("TORQUE: " + torque + " Nm");
        System.out.println("ENGINE NUMBER: " + engine_number);
        System.out.println("FUEL TYPE: " + (fuel_type ? "PETROL" : "DIESEL"));
        System.out.println("ENGINE NUMBER: " + engine_number);
    }

    @Override
    public void set_details(Scanner sc) {
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
        if(power < 0)
            throw new IllegalArgumentException("Power cannot be negative.");
        System.out.print("TORQUE(in Nm): ");
        int torque = sc.nextInt();
        if(torque < 0)
            throw new IllegalArgumentException("Torque cannot be negative.");
        sc.nextLine(); // Consume newline
        System.out.print("ENGINE NUMBER: ");
        System.out.print("FUEL TYPE(PETROL/DIESEL): ");
        boolean fuel_type = (sc.nextLine() == "PETROL"); // true for petrol, false for diesel
        engine = new ICE(configuration, power, torque, engine_number, fuel_type);
    }

    public String toString() {
        return "Configuration: " + configuration + ", Power: " + power + " HP, Torque: " + torque +
               " Nm, Engine Number: " + engine_number + ", Fuel Type: " + (fuel_type ? "PETROL" : "DIESEL");
    }
}