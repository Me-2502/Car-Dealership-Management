import java.util.Scanner;

class EV extends Powertrain {
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

    @Override
    public void set_details(Scanner sc) {
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

    public String toString() {
        return "Battery Capacity: " + battery_capacity + " kWh, Range: " + range + " km, Motor Type: " +
               motor_type + ", Power: " + power + " HP, Torque: " + torque + " Nm";
    }
}