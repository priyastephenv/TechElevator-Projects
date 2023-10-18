package com.techelevator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Exercises {

    /*
    The method average takes in an array of doubles called values.
    Complete the method so that it returns the average (mean) of all
    the numbers in values:

    average([5.0,6.0,7.0]) --> 6.0
    average([2.0,2.0]) --> 2.0
     */
    public double average(double[] values) {

        double sum = 0;
        double average;

        for (int i =0; i< values.length; i++) {

            double variable1 = values[i];

            sum = sum + variable1;


        }

        average = sum / (values.length);

        return average;
    }

    /*
    The method specificGreeting has one String input parameter called name.
    If the method is called with the String "Alice", the method should return
    a String containing "Hello Alice!".

    There is only one exception! If the method is called with the String "Bob",
    the method should return "Hello Robert!".
    This is the only exception to the rule.

    greeting("Alice") --> "Hello Alice!"
    greeting("Bob") --> "Hello Robert!"
    greeting("Carly") --> "Hello Carly!"
     */
    public String specificGreeting(String name) {

        if (name.equals("Bob")) {

            return "Hello Robert!";

        }
        return "Hello " + name + "!";
    }

    /*
    The method getEmployeeNames takes in an array containing employee data that looks like this:
    ["001", "Alice", "1234 Somewhere St.", "002", "Bob", "3214 Nowhere Lane", "003", "Carly", "211 Deer Haven Lane"]

    As you can see, the data for each employee is organized in clusters of three cells:
    - index 0 is the employee ID
    - index 1 is employee name
    - index 2 is employee address
    ... and we start off with another employee ID at index 3

    The method should return a List containing only the employee names:
                       0        1          2               3       4       5
    getEmployeeName(["001", "Alice", "1234 Somewhere St.", "002", "Bob", "3214 Nowhere Lane"]) --> {"Alice", "Bob"}
     */

    public List<String> getEmployeeNames(String [] data) {

        List <String> onlyEmployeeNames = new ArrayList<>();

            for (int i = 1; i < data.length ; i += 3) {

                onlyEmployeeNames.add(data[i]);

            }




        return onlyEmployeeNames;
    }


}
