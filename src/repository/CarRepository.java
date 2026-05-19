package repository;

import model.car.Car;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

public class CarRepository {
    private final List<Car> cars = new ArrayList<>();

    public Car save(Car car) {
        // Replace if same id already exists
        deleteById(car.getId());
        cars.add(car);
        return car;
    }

    public boolean deleteById(String id) {
        return cars.removeIf(c -> c.getId().equals(id));
    }

    public Optional<Car> findById(String id) {
        return cars.stream().filter(c -> c.getId().equals(id)).findFirst();
    }

    public List<Car> findAll() {
        return Collections.unmodifiableList(cars);
    }
}
