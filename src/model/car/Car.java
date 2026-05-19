package model.car;

import java.util.Objects;

public class Car {
    private final String id;
    private String chassisNumber;
    private String name;
    private String color;
    private int price;
    private CarType type;
    private String transmission;
    private Powertrain powertrain;
    private CarStatus status;

    public Car(String id,
               String chassisNumber,
               String name,
               String color,
               int price,
               CarType type,
               String transmission,
               Powertrain powertrain,
               CarStatus status) {
        this.id = Objects.requireNonNull(id, "id");
        this.chassisNumber = chassisNumber;
        this.name = name;
        this.color = color;
        this.price = price;
        this.type = type;
        this.transmission = transmission;
        this.powertrain = powertrain;
        this.status = status;
    }

    public String getId() {
        return id;
    }

    public String getChassisNumber() {
        return chassisNumber;
    }

    public void setChassisNumber(String chassisNumber) {
        this.chassisNumber = chassisNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public CarType getType() {
        return type;
    }

    public void setType(CarType type) {
        this.type = type;
    }

    public String getTransmission() {
        return transmission;
    }

    public void setTransmission(String transmission) {
        this.transmission = transmission;
    }

    public Powertrain getPowertrain() {
        return powertrain;
    }

    public void setPowertrain(Powertrain powertrain) {
        this.powertrain = powertrain;
    }

    public CarStatus getStatus() {
        return status;
    }

    public void setStatus(CarStatus status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Car{" +
                "id='" + id + '\'' +
                ", chassisNumber='" + chassisNumber + '\'' +
                ", name='" + name + '\'' +
                ", color='" + color + '\'' +
                ", price=" + price +
                ", type=" + type +
                ", transmission='" + transmission + '\'' +
                ", powertrain=" + powertrain +
                ", status=" + status +
                '}';
    }
}
