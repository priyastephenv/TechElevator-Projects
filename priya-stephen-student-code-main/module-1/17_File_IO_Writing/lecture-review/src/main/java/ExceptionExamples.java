import exceptions.CarMaintenanceException;
import exceptions.OilChangeException;
import exceptions.OutOfFuelException;
import exceptions.TireRotationException;
import vehicle.Car;
import vehicle.CarNoException;

import java.util.Random;

public class ExceptionExamples {

    public static void main(String[] args) {
        ExceptionExamples examples = new ExceptionExamples();

        examples.carWithoutExceptions();
        //examples.carWithExceptions();
    }

    public void carWithoutExceptions(){
        CarNoException car = new CarNoException();

        for (int i = 0; i < 300; i++) {

            int randomDistance = getRandomInt(50, 200);
            System.out.println("Driving " + randomDistance + " miles, total: " + car.getOdometer());
            int errorCode = car.drive(randomDistance);

            if(errorCode == CarNoException.REQUIRES_OIL_CHANGE){
                System.out.println("========== Changing oil ==========");
            } else if( errorCode == CarNoException.REQUIRES_MAINTENANCE){
                System.out.println("========== Performing car maintenance ==========");
            } else if( errorCode == CarNoException.REQUIRES_TIRE_ROTATION){
                System.out.println("========== Performing tire rotation ==========");
            } else if( errorCode == CarNoException.REQUIRES_FUEL){
                System.out.println("========== Getting more fuel ==========");
            }
        }
    }

    public void carWithExceptions() {
        Car car = new Car();

        for (int i = 0; i < 300; i++) {
            try {

                int randomDistance = getRandomInt(50, 200);
                System.out.println("Driving " + randomDistance + " miles, total: " + car.getOdometer());
                car.drive(randomDistance);

            } catch (OilChangeException e) {
                System.out.println("========== Changing oil ==========");
            } catch (CarMaintenanceException e) {
                System.out.println("========== Performing car maintenance ==========");
            } catch (TireRotationException e) {
                System.out.println("========== Performing tire rotation ==========");
            } catch (OutOfFuelException e) {
                System.out.println("========== Getting more fuel ==========");
            }
        }
    }

    public static int getRandomInt(int min, int max){
        return new Random().nextInt(max - min) + min;
    }
}