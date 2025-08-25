import java.util.*;
import java.io.*;

public class Main {

    static void main_menu(){
        System.out.println();
        System.out.println("======================= *** WELCOME TO SHOWROOM MANAGEMENT SYSTEM *** =======================");
        System.out.println();
        System.out.println("=============================== *** ENTER YOUR CHOICE *** ===============================");
        System.out.println();
        System.out.println("1].ADD SHOWROOMS \t\t\t 2].ADD EMPLOYEES \t\t\t 3].ADD CARS");
        System.out.println();
        System.out.println("4].GET SHOWROOMS \t\t\t 5].GET EMPLOYEES \t\t\t 6].GET CARS");
        System.out.println();
        System.out.println("=============================== *** ENTER 0 TO EXIT *** ===============================");
        System.out.println();

    }

    public static void main(String[] args) throws IOException {
        try(Scanner sc = new Scanner(System.in)) {
            Showroom showroom[] = new Showroom[5];
            Employees employee[] = new Employees[5];
            Cars car[] = new Cars[5];
            int car_counter = 0;
            int showroom_counter = 0;
            int employees_counter = 0;
            int choice = 100;

            FileWriter writer = new FileWriter(new File("showroomLogs.txt"), true);
            PrintWriter printWriter = new PrintWriter(writer);
            main_menu();
            choice = sc.nextInt();
            sc.nextLine(); // Consume newline
            while(choice != 0){
                switch(choice) {
                    case 1:
                        showroom[showroom_counter] = new Showroom();
                        showroom[showroom_counter].set_details(sc);
                        showroom_counter++;
                        printWriter.println("NEW SHOWROOM ADDED: " + showroom[showroom_counter - 1].toString());
                        break;
                    case 2:
                        employee[employees_counter] = new Employees();
                        employee[employees_counter].set_details(sc);
                        employees_counter++;
                        printWriter.println("NEW EMPLOYEE ADDED: " + employee[employees_counter - 1].toString());
                        break;
                    case 3:
                        car[car_counter] = new Cars();
                        car[car_counter].set_details(sc);
                        car_counter++;
                        printWriter.println("NEW CAR ADDED: " + car[car_counter - 1].toString());
                        break;
                    case 4:
                        for(int i = 0; i < showroom_counter; i++) {
                            showroom[i].get_details();
                            System.out.println();
                        }
                        break;
                    case 5:
                        for(int i = 0; i < employees_counter; i++) {
                            employee[i].get_details();
                            System.out.println();
                        }
                        break;
                    case 6:
                        for(int i = 0; i < car_counter; i++) {
                            car[i].get_details();
                            System.out.println();
                        }
                        break;
                    default:
                        System.out.println("ENTER VALID CHOICE: ");
                        break;
                }
                main_menu();
                System.out.print("ENTER YOUR CHOICE: ");
                choice = sc.nextInt();
                sc.nextLine(); // Consume newline
            }
            System.out.println("THANK YOU FOR USING SHOWROOM MANAGEMENT SYSTEM");
            printWriter.close();
            writer.close();
        }
        catch(Exception e) {
            System.out.println("AN ERROR OCCURRED: " + e.getMessage());
        }
    }
}