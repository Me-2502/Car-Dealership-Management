package repository;

import model.user.Person;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

public class UserRepository {
    private final List<Person> users = new ArrayList<>();

    public Person save(Person user) {
        deleteById(user.getId());
        users.add(user);
        return user;
    }

    public boolean deleteById(String id) {
        return users.removeIf(u -> u.getId().equals(id));
    }

    public Optional<Person> findById(String id) {
        return users.stream().filter(u -> u.getId().equals(id)).findFirst();
    }

    public List<Person> findAll() {
        return Collections.unmodifiableList(users);
    }
}
