import java.util.UUID;
import java.util.List;

public class Customer extends Person {
    private List<Car> customerCars;

    public Customer(String name, String phone_number, String mail_id, List<Car> customerCars) {
        // try {
        //     if(customerCars == null)
        //         throw new IllegalArgumentException("Customer cars list cannot be null.");
        // } catch (IllegalArgumentException e) {
        //     System.out.println(e.getMessage());
        //     return;
        // }
        super(name, phone_number, mail_id);
        this.customerCars = customerCars;
    }

    public List<Car> getCustCars() {
        return customerCars;
    }

    public void setCustCars(List<Car> customerCars) {
        this.customerCars = customerCars;
    }

    public void addCar(Car car) {
        customerCars.add(car);
    }

    public void removeCar(Car car) {
        customerCars.remove(car);
    }

    public String toString() {
        return "Customer ID: " + id + ", Name: " + name + ", Age: " + cust_age +
        ", Phone Number: " + phoneNumber;
    }
}