public class Main {

    public static void main(String[] args) {
        Car myCar = new Car(35.0, 4);
        myCar.drive();
        System.out.println(myCar);

        System.out.println();

        Car mySecondCar = new Car();
        mySecondCar.drive();
        System.out.println(mySecondCar);
    }
}
