package ui.display;

import model.car.Car;

import java.util.List;

public class CarPrinter {
    public void print(Car car) {
        System.out.println(car);
    }

    public void printList(List<Car> cars) {
        if(cars.isEmpty()) {
            System.out.println("(no cars)");
            return;
        }
        for(Car c : cars) {
            System.out.println(c);
        }
    }
}
