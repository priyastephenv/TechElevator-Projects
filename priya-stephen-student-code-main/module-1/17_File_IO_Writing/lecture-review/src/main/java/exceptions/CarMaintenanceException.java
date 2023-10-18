package exceptions;

public class CarMaintenanceException extends Exception {

    public CarMaintenanceException(){
        super("Car maintenance at 100,000 miles");
    }
}
