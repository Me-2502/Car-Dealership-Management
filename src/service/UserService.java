package service;

import exception.UserNotFoundException;
import model.user.Person;
import repository.UserRepository;

import java.util.List;

public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Person addUser(Person user) {
        return userRepository.save(user);
    }

    public boolean removeUser(String id) {
        if(!userRepository.deleteById(id)) {
            throw new UserNotFoundException(id);
        }
        return true;
    }

    public Person findUserById(String id) {
        return userRepository.findById(id).orElseThrow(() -> new UserNotFoundException(id));
    }

    public Person findUserByIdOrNull(String id) {
        return userRepository.findById(id).orElse(null);
    }

    public List<Person> findAll() {
        return userRepository.findAll();
    }
}
