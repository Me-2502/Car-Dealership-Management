package exception;

public class CarNotFoundException extends NotFoundException {
    public CarNotFoundException(String id) {
        super("Car with id '" + id + "' not found");
    }
}
