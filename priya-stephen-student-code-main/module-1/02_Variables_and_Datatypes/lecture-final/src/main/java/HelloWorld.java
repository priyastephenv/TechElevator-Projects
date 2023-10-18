public class HelloWorld {

    public static void main(String[] args) {
        System.out.println("hello from orange class");
        System.out.println("Hello, how are you?");

        // Variable declaration
        int numberOfStudents;

        // Variable declaration and assignment
        // '=' usage in java is not the same as in math 2x = 5
        int i = 5;

        /*
         * ===========LITERALS=============
         */
        //   var name      int literal
        numberOfStudents = 42;

        // var name   long literal
        long num =     42L;

        //    var name     float literal
        float decimalNum = 12.2f;

        //    var name     double literal
        double decimalNum2 = 12.2;

        //    var name   char literal
        char character = 'f';

        //           var name       boolean literal
        boolean isJumpWorldRecord = false;

        /*
         * =========== PARENTHESIS USE () =============
         */
        int product = ( (numberOfStudents - 5) * 11 ) / 2;

        System.out.println();
        System.out.println("===========COST CHANGE WORD PROBLEM=============");
        double costOfDeckOfCardsInDollars = 8.50;
        double paymentDollars = 10;
        double expectedChangeInDollars = paymentDollars - costOfDeckOfCardsInDollars;

        double temperatureFarenheit = 98.6;

        double temperatureCelsius = (temperatureFarenheit - 32) * (5.0/9);
        System.out.println("The temperature in Celsius is: " + temperatureCelsius);

        //              string literal
        String text = "The temperature in Celsius is: ";

        // 1 character char vs. 1 character String
        // char is more memory efficient
        String character2 = "a";
        char character3 = 'a';

        int fraction = 9999 / 10000;
        System.out.println("the int fraction (9999 / 10000) is: " + fraction);

        System.out.println();
        System.out.println("===========CAST=============");
        // range heirarchy
        // double > float > long > int
        double mathCalculation = 42 * 3.14f;

        //                     int * double -> result is a double
        //                      42 * 11.2 -> this results in a double
        //    assign floatCalculation to a double
        //              ERROR! double can hold more values than a float,
        //                      so possible data loss.
        int floatCalculation = (int)(42 - 11.2);    // (int)30.8
        System.out.println("float calculation #1 (int)(42 - 11.2): " + floatCalculation);

        floatCalculation = 42 - (int)11.2;          // 42 - 11
        System.out.println("float calculation #2 (int)11.2: " + floatCalculation);

        System.out.println("this is an example of a string => " + true + " <= this is the end of a string");

        System.out.println();
        System.out.println("==========LARGEST INT VALUE==============");
        System.out.println("This is the largest int : " + Integer.MAX_VALUE);
        System.out.println("This is the largest long: " + Long.MAX_VALUE);

        // This literal needs to be stored in a long
        long newIntValue = 2147483648L;
    }

}



