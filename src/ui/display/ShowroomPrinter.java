package ui.display;

import model.showroom.Showroom;

import java.util.List;

public class ShowroomPrinter {
    public void print(Showroom showroom) {
        System.out.println(showroom);
    }

    public void printList(List<Showroom> showrooms) {
        if(showrooms.isEmpty()) {
            System.out.println("(no showrooms)");
            return;
        }
        for(Showroom s : showrooms) {
            System.out.println(s);
        }
    }
}
