package ui.display;

import model.user.Person;

import java.util.List;

public class UserPrinter {
    public void print(Person user) {
        System.out.println(user);
    }

    public void printList(List<Person> users) {
        if(users.isEmpty()) {
            System.out.println("(no users)");
            return;
        }
        for(Person u : users) {
            System.out.println(u);
        }
    }
}
