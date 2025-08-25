import java.util.Scanner;
import java.util.UUID;

public class Employees extends Showroom implements utility {
    private String emp_id;
    private String emp_name;
    private int emp_age;
    private int salary;
    private String emp_designation;
    private String mail_id = "Not Provided";
    private String phone_number;
    private String emp_department;

    @Override
    public void get_details() {
        System.out.println("ID: " + emp_id);
        System.out.println("Name: " + emp_name);
        System.out.println("Age: " + emp_age);
        System.out.println("Salary: " + salary);
        System.out.println("Designation: " + emp_designation);
        if(mail_id != "Not Provided")
            System.out.println("Mail ID: " + mail_id);
        System.out.println("Phone Number: " + phone_number);
        if(emp_department == null || emp_department.isEmpty())
            System.out.println("Department: Not Assigned");
        else
            System.out.println("Department: " + emp_department);
        System.out.println("Department: " + emp_department);
    }

    @Override
    public void set_details( Scanner sc){
        try {
            UUID uuid = UUID.randomUUID();
            emp_id = String.valueOf(uuid);
            System.out.println("======================= *** ENTER EMPLOYEE DETAILS *** =======================");
            System.out.println();
            System.out.print("EMPLOYEE NAME: ");
            emp_name = sc.nextLine();
            if(emp_name.isEmpty())
                throw new IllegalArgumentException("Name field cannot be empty.");
            System.out.print(("EMPLOYEE AGE: "));
            emp_age = sc.nextInt();
            if(emp_age < 18 || emp_age > 65)
                throw new IllegalArgumentException("Age must be between 18 and 65.");
            sc.nextLine();
            System.out.print("EMPLOYEE DEPARTMENT: ");
            emp_department = sc.nextLine();
            if(emp_department.isEmpty())
                throw new IllegalArgumentException("Department field cannot be empty.");
            System.out.print("EMPLOYEE DESIGNATION: ");
            emp_designation = sc.nextLine();
            System.out.print("EMPLOYEE SALARY: ");
            salary = sc.nextInt();
            if(salary < 0)
                throw new IllegalArgumentException("Salary cannot be negative.");
            sc.nextLine();
            System.out.print("EMPLOYEE PHONE NUMBER: ");
            phone_number = sc.nextLine();
            if(phone_number.isEmpty())
                throw new IllegalArgumentException("Phone number field cannot be empty.");
            else if(!phone_number.matches("\\d{10}"))
                throw new IllegalArgumentException("Invalid phone number format. Please enter a 10-digit number.");
            else if(phone_number.length() != 10)
                throw new IllegalArgumentException("Phone number must be exactly 10 digits long.");
            System.out.print("EMPLOYEE MAIL ID (optional, press enter to skip): ");
            String input = sc.nextLine();
            if(!input.isEmpty()) {
                if(input.contains("@") && input.contains("."))
                    mail_id = input;
                else
                    throw new IllegalArgumentException("Invalid email format.");
            }
            else
                mail_id = "Not Provided";
        }
        catch(Exception e) {
            System.out.println("An error occurred while setting employee details: " + e.getMessage());
        }
    }

    @Override
    public String toString() {
        return "Employee ID: " + emp_id + ", Name: " + emp_name + ", Age: " + emp_age +
               ", Salary: " + salary + ", Designation: " + emp_designation +
               ", Phone Number: " + phone_number + ", Department: " + emp_department;
    }
}