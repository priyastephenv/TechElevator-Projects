package vehicle;

import exceptions.*;

import java.util.Random;

public class Car {
    private int odometer;
    private int mileageLastOilCheck;
    private int mileageLastTireRotation;
    private int mileageLastMaintenance;

    public Car(){
        this.odometer = 0;
        this.mileageLastOilCheck = 0;
        this.mileageLastTireRotation = 0;
        this.mileageLastMaintenance = 0;
    }

    public int getOdometer() {
        return odometer;
    }

    public void drive(int distanceMiles) throws OilChangeException, CarMaintenanceException, TireRotationException, OutOfFuelException {

        this.odometer += distanceMiles;

        if(distanceMiles > 200){

            throw new OutOfFuelException("out of fuel!");

        } else if(this.odometer - this.mileageLastMaintenance >= 60000){

            this.mileageLastMaintenance = this.odometer;
            throw new CarMaintenanceException();

        } else if(this.odometer - this.mileageLastTireRotation >= 15000 ){

            this.mileageLastTireRotation = this.odometer;
            throw new TireRotationException();

        } else if( this.odometer - this.mileageLastOilCheck > 3000 ){

            this.mileageLastOilCheck = this.odometer;
            throw new OilChangeException();

        }
    }

    /*
     * Exception benefits
     * 1. Code looks neater (subjective :D)
     * 2. Additional error info from exception object
     * 3. Program can be forced to handle an error (checked exception)
     *    and stop code execution to prevent further problems
     */
    public boolean fullInspection() {
        boolean inspectionPassed = false;

        try {

            checkLights();
            checkSmog();
            checkSuspension();
            checkRadiator();

            inspectionPassed = true;

        } catch (LightsFailureException e){
            System.out.println("Handling lights failure exception");
        } catch(SmogFailureException e) {
            System.out.println("Handling smog failure exception");
        } catch(SuspensionFailureException e) {
            System.out.println("Handling suspension failure exception");
        } catch(RadiatorFailureException e) {
            System.out.println("Handling radiator failure exception");
        }

        return inspectionPassed;
    }

    /*
     * Methods throw exceptions
     */
    private void checkLights() throws LightsFailureException {
        if( new Random().nextBoolean() ){ throw new LightsFailureException(); }
    }
    private void checkSmog() throws SmogFailureException {
        if( new Random().nextBoolean() ){ throw new SmogFailureException(); }
    }
    private void checkSuspension() throws SuspensionFailureException {
        if( new Random().nextBoolean() ){ throw new SuspensionFailureException(); }
    }
    private void checkRadiator() throws RadiatorFailureException {
        if( new Random().nextBoolean() ){ throw new RadiatorFailureException(); }
    }
}
