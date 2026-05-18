import java.util.Scanner;

enum CarType {
    SEDAN, SUV, HATCHBACK, WAGON, CONVERTIBLE, COUPE, MINIVAN
}

public class Car{
    String chassis_number;
    String car_name;
    String car_color;
    int car_price;
    CarType car_type;
    String car_transmission;
    Powertrain powertrain;

    public Car(String name, String color, int price, CarType type, String transmission, String chassisNumber, Powertrain powertrain) {
        this.chassis_number = chassisNumber;
        this.car_name = name;
        this.car_color = color;
        this.car_price = price;
        this.car_type = type;
        this.car_transmission = transmission;
        this.powertrain = powertrain;
    }

    public void get_details(){
        System.out.println("NAME: " + car_name);
        System.out.println("COLOR: " + car_color);
        System.out.println("PRICE: " + car_price);
        System.out.println("CAR TYPE: " + car_type);
        System.out.println("TRANSMISSION: " + car_transmission);
        powertrain.get_details();
    }

    public void setName(String name) {
        this.car_name = name;
    }

    public void setColor(String color) {
        this.car_color = color;
    }

    public void setPrice(int price) {
        this.car_price = price;
    }

    public void setType(CarType type) {
        this.car_type = type;
    }

    public void setTransmission(String transmission) {
        this.car_transmission = transmission;
    }

    public void setChassisNumber(String chassisNumber) {
        this.chassis_number = chassisNumber;
    }

    public void setPowertrain(Powertrain powertrain) {
        this.powertrain = powertrain;
    }

    public String toString() {
        return "Car Name: " + car_name + ", Color: " + car_color + ", Price: " + car_price +
               ", Type: " + car_type + ", Transmission: " + car_transmission +
               ", Powertrain: " + powertrain.toString() +
               ", Chassis Number: " + chassis_number;
    }
}
