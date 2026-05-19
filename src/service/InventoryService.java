package service;

import exception.InventoryFullException;
import model.car.Car;
import model.showroom.Showroom;

public class InventoryService {
    public void addStock(Showroom showroom, Car car) {
        if(!showroom.hasCapacityForMoreCars()) {
            throw new InventoryFullException("Showroom capacity reached");
        }
        showroom.addCar(car);
    }

    public void removeStock(Showroom showroom, Car car) {
        showroom.removeCar(car);
    }

    public boolean checkAvailability(Showroom showroom) {
        return showroom.hasCapacityForMoreCars();
    }
}
