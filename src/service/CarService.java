package service;

import exception.CarNotFoundException;
import model.car.Car;
import model.car.CarStatus;
import repository.CarRepository;

import java.util.List;

public class CarService {
    private final CarRepository carRepository;

    public CarService(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    public Car addCar(Car car) {
        return carRepository.save(car);
    }

    public boolean removeCar(String id) {
        if(!carRepository.deleteById(id)) {
            throw new CarNotFoundException(id);
        }
        return true;
    }

    public Car getById(String id) {
        return carRepository.findById(id).orElseThrow(() -> new CarNotFoundException(id));
    }

    public List<Car> getAll() {
        return carRepository.findAll();
    }

    public List<Car> searchByName(String namePart) {
        String q = namePart == null ? "" : namePart.toLowerCase();
        return carRepository.findAll().stream()
                .filter(c -> c.getName() != null && c.getName().toLowerCase().contains(q))
                .toList();
    }

    public Car updateCarStatus(String id, CarStatus status) {
        Car car = getById(id);
        car.setStatus(status);
        return carRepository.save(car);
    }
}
