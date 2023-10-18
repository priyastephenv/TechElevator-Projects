package vehicle;

import java.util.Random;

public class CarNoException {
    public static final int NO_ERROR = 0;
    public static final int REQUIRES_FUEL = 1;
    public static final int REQUIRES_MAINTENANCE = 2;
    public static final int REQUIRES_TIRE_ROTATION = 3;
    public static final int REQUIRES_OIL_CHANGE = 4;

    private int odometer;
    private int mileageLastOilCheck;
    private int mileageLastTireRotation;
    private int mileageLastMaintenance;

    public CarNoException(){
        this.odometer = 0;
        this.mileageLastOilCheck = 0;
        this.mileageLastTireRotation = 0;
        this.mileageLastMaintenance = 0;
    }

    public int getOdometer() {
        return odometer;
    }

    public int drive(int distanceMiles) {

        /*
         * Error code to convey what error occurred
         */
        int errorCode = 0;

        this.odometer += distanceMiles;

        if(distanceMiles > 200){

            errorCode = REQUIRES_FUEL;

        } else if(this.odometer - this.mileageLastMaintenance >= 60000){

            this.mileageLastMaintenance = this.odometer;
            errorCode = REQUIRES_MAINTENANCE;

        } else if(this.odometer - this.mileageLastTireRotation >= 15000 ){

            this.mileageLastTireRotation = this.odometer;
            errorCode = REQUIRES_TIRE_ROTATION;

        } else if( this.odometer - this.mileageLastOilCheck > 3000 ){

            this.mileageLastOilCheck = this.odometer;
            errorCode = REQUIRES_OIL_CHANGE;
        }

        /*
         * Must return error code information back to the caller
         */
        return errorCode;
    }

    /*
     * Returned-Error-Code paradigm problems
     * 1. Lots of if-else checks; increased code complexity
     * 2. Return status taken by returned error code
     * 3. No way to force calling code to handle error;
     *    code can still run in an error state
     */
    public boolean fullInspection(){
        int errorCode = NO_ERROR;

        if( !checkLights() ) {
            return false;
        }

        if( checkSmog() != NO_ERROR ) {
            return false;
        }

        errorCode = checkSuspension();

        if(errorCode == 0 || errorCode == 1) {
            errorCode = checkRadiator();
        } else {
            return false;
        }

        return errorCode == NO_ERROR;
    }

    /*
     * Methods return error codes
     */
    private boolean checkLights(){ return new Random().nextBoolean(); }
    private int checkSmog(){ return new Random().nextInt(); }
    private int checkSuspension(){ return new Random().nextInt(3); }
    private int checkRadiator(){ return new Random().nextInt(3); }
}
