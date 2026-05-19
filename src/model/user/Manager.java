package model.user;

public class Manager extends Employee {
    public Manager(String id,
                   String name,
                   String phoneNumber,
                   String email,
                   int age,
                   double salary,
                   String designation) {
        super(id, name, phoneNumber, email, age, salary, designation);
    }

    @Override
    public Role getRole() {
        return Role.MANAGER;
    }
}
