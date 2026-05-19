package ui.input;

import model.car.*;
import util.IdGenerator;

public class CarInputHandler {
    private final ConsoleInput in;

    public CarInputHandler(ConsoleInput in) {
        this.in = in;
    }

    public Car readCar() {
        String name = in.readLine("Car name: ").trim();
        String color = in.readLine("Color: ").trim();
        int price = in.readInt("Price: ");
        CarType type = in.readEnum("Type (SEDAN/SUV/...): ", CarType.class);
        String transmission = in.readLine("Transmission (AUTOMATIC/MANUAL): ").trim();
        String chassis = in.readLine("Chassis number: ").trim();

        Powertrain powertrain = readPowertrain();

        return new Car(
                IdGenerator.newId(),
                chassis,
                name,
                color,
                price,
                type,
                transmission,
                powertrain,
                CarStatus.IN_STOCK
        );
    }

    private Powertrain readPowertrain() {
        String kind = in.readLine("Powertrain (EV/ICE): ").trim().toUpperCase();
        if("EV".equals(kind)) {
            int battery = in.readInt("Battery capacity (kWh): ");
            int range = in.readInt("Range (km): ");
            String motor = in.readLine("Motor type: ").trim();
            int power = in.readInt("Power (hp): ");
            int torque = in.readInt("Torque (Nm): ");
            return new EV(battery, range, motor, power, torque);
        }
        if("ICE".equals(kind)) {
            String config = in.readLine("Engine configuration: ").trim();
            int power = in.readInt("Power (hp): ");
            int torque = in.readInt("Torque (Nm): ");
            String engineNo = in.readLine("Engine number: ").trim();
            FuelType fuel = in.readEnum("Fuel type (PETROL/DIESEL): ", FuelType.class);
            return new ICE(config, power, torque, engineNo, fuel);
        }
        System.out.println("Unknown powertrain. Defaulting to ICE.");
        return new ICE("", 0, 0, "", FuelType.PETROL);
    }
}
