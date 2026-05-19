package model.user;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Customer extends Person {
    private final List<String> ownedCarIds = new ArrayList<>();

    public Customer(String id, String name, String phoneNumber, String email) {
        super(id, name, phoneNumber, email);
    }

    public List<String> getOwnedCarIds() {
        return Collections.unmodifiableList(ownedCarIds);
    }

    public void addOwnedCarId(String carId) {
        ownedCarIds.add(carId);
    }

    public void removeOwnedCarId(String carId) {
        ownedCarIds.remove(carId);
    }

    @Override
    public Role getRole() {
        return Role.CUSTOMER;
    }
}
