import ui.input.ConsoleInput;
import ui.menu.ManagerMenu;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try(Scanner scanner = new Scanner(System.in)) {
            ConsoleInput in = new ConsoleInput(scanner);
            ManagerMenu menu = ManagerMenu.defaultWiring(in);
            menu.run();
        }
    }
}
