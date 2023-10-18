public class Car {
    /*
     * Properties aka Instance Variables
     * Note - all private
     */
    private String color = "silver";
    private double engineSizeMetersSquared;
    private Integer numberOfDoors;
    private double speedMph = 75;

    /*
     * Constructors
     * Note - no return type
     *      - name is the same name as the class
     */
    Car(double engineSize, Integer numberOfDoors){
        this.engineSizeMetersSquared = engineSize;
        this.numberOfDoors = numberOfDoors;
    }

    Car(){
        System.out.println("Calling the 'no-args' constructor, Car()");
    }

    /*
     * Methods
     *  -Getters
     *  -Setters
     *  -Behaviors
     */
    public String getColor() {
        return color;
    }

    public void drive(){
        double speedMph = 65;

        // code

        System.out.println("Car is driving at " + this.speedMph + " mph");
    }

    /*
     * Override the implementation of this object's
     * representation as a String
     */
    @Override
    public String toString(){
        return "color is: " + this.color + "\n" +
                "engine size is: " + this.engineSizeMetersSquared + "\n" +
                "number of doors: " + this.numberOfDoors;
    }
}
