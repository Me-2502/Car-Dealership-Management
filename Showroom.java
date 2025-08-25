import java.util.Scanner;

public class Showroom implements utility {  //utility is an interface 
    String showroom_name;
    String showroom_address;
    int total_employees;
    int total_cars_in_stock = 0;
    String manager_name;

    @Override
    public void get_details() {
        System.out.println("Showroom Name: " + showroom_name);
        System.out.println("Showroom Address: " + showroom_address);
        System.out.println("Manager Name: " + manager_name);
        System.out.println("Total Employees: " + total_employees);
        System.out.println("Total Cars In Stock: " + total_cars_in_stock);
    }

    @Override
    public void set_details(Scanner sc) {
        try {
            System.out.println("======================= *** ENTER SHOWROOM DETAILS *** =======================");
            System.out.println();
            System.out.print("SHOWROOM NAME: ");
            showroom_name = sc.nextLine();
            System.out.print(("SHOWROOM ADDRESS: "));
            showroom_address = sc.nextLine();
            System.out.print("MANAGER NAME: ");
            manager_name = sc.nextLine();
            System.out.print("TOTAL NO OF EMPLOYEES: ");
            total_employees = sc.nextInt();
            sc.nextLine(); // Consume newline
            if(total_employees < 0)
                throw new IllegalArgumentException("Total employees cannot be negative.");
            System.out.print("TOTAL CARS IN STOCK: ");
            total_cars_in_stock = sc.nextInt();
            if(total_cars_in_stock < 0)
                throw new IllegalArgumentException("Total cars in stock cannot be negative.");
            sc.nextLine(); // Consume newline
        }
        catch(Exception e) {
            System.out.println("An error occurred while setting showroom details: " + e.getMessage());
        }
    }

    public String toString() {
        return "Showroom Name: " + showroom_name + ", Address: " + showroom_address +
               ", Manager: " + manager_name + ", Employees: " + total_employees +
               ", Cars in Stock: " + total_cars_in_stock;
    }
}

interface utility{  //Interface have two methods
    public void get_details();
    public void set_details(Scanner sc);
}