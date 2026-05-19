package ui.input;

import model.showroom.Showroom;
import model.user.Manager;
import model.user.Person;
import util.IdGenerator;

public class ShowroomInputHandler {
    private final ConsoleInput in;

    public ShowroomInputHandler(ConsoleInput in) {
        this.in = in;
    }

    public Showroom readShowroom(Person owner, Manager manager) {
        String name = in.readLine("Showroom name: ").trim();
        String address = in.readLine("Address: ").trim();
        int capacity = in.readInt("Car capacity: ");
        return new Showroom(IdGenerator.newId(), name, address, owner, manager, capacity);
    }
}
