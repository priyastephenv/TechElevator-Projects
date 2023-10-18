package com.techelevator;

public class Lecture {

	public static void main(String[] args) {

		System.out.println("************************************");
		System.out.println("****** MAKING A STRING OBJECT ******");
		System.out.println("************************************");

		/* The String class gets special treatment in the Java language.  One
		 * example of this is that there is a literal representation of a
		 * String (i.e. characters appearing between two double quotes.  This
		 * is not the case for most classes */

		/* create an new instance of String using a literal */

		
		System.out.println();
		System.out.println("******************************");
		System.out.println("****** MEMBER METHODS ******");
		System.out.println("******************************");
		System.out.println();

		String name = "Tech Elevator";
		//name = name.toUpperCase();

		//System.out.println("The upper case string is ??? : " + name);

		System.out.println("test if name includes 'vator': " + name.contains("vator") );

		System.out.println("get index of 'e': " + name.indexOf("e", 2) );

		System.out.println("get index of 'Q': " + name.indexOf("Q") );

		System.out.println("replace 'at' with 'z': " + name.replace("at", "z"));

		System.out.println("replace 'e' with 'Q': " + name.replace("e", "Q"));

		System.out.println("replace all letters besides 'e' and 'E' with 'Q': " + name.replaceAll("[^eE]", "Q"));

		System.out.println("first 5 characters are: " + name.substring(0, 5));

		System.out.println("==========================");
		System.out.println("At the end, name is still: " + name);

		/* Other commonly used methods:
		 *
		 * endsWith
		 * startsWith
		 * indexOf
		 * lastIndexOf
		 * length
		 * substring
		 * toLowerCase
		 * toUpperCase
		 * trim
		 */

		System.out.println();
		System.out.println("**********************");
		System.out.println("****** EQUALITY ******");
		System.out.println("**********************");
		System.out.println();

//        char[] helloArray = new char[] { 'H', 'e', 'l', 'l', 'o' };
//        String hello1 = new String(helloArray);
//        String hello2 = new String(helloArray);
//
//		/* Double equals will compare to see if the two variables, hello1 and
//		 * hello2 point to the same object in memory. Are they the same object? */
//		if (hello1 == hello2) {
//			System.out.println("They are equal!");
//		} else {
//			System.out.println(hello1 + " is not equal to " + hello2);
//		}
//
//		String hello3 = hello1;
//		if (hello1 == hello3) {
//			System.out.println("hello1 is the same reference as hello3");
//		}
//
//		/* So, to compare the values of two objects, we need to use the equals method.
//		 * Every object type has an equals method */
//		if (hello1.equals(hello2)) {
//			System.out.println("They are equal!");
//		} else {
//			System.out.println(hello1 + " is not equal to " + hello2);
//		}

	}


//	A sandwich is two pieces of bread with something in between.
//	Return the string that is between the first and last
//	appearance of "bread" in the given string,
//	or return the empty string "" if there are not two pieces of bread.

//  indexes      0 1 2 3 4 5 6 7 8 9 10 11 12
//	getSandwich("b r e a d j a m b r e  a  d") → "jam"
//	getSandwich("xxbreadjambreadyy") → "jam"
//	getSandwich("xxbreadyy") → ""
	public String getSandwich(String str) {
		String middle = "";

		// 1. Check if "bread" is in the string
		int indexOfFirstBread = str.indexOf("bread");

		// 2. If "bread" was found
		if(indexOfFirstBread != -1) {

			// 3. Check if bread was also at the end of the string
			int indexOfLastBread = str.lastIndexOf("bread");

			// 4. If found at the end, get the string in between both
			// pieces of bread
			//   if this found index is not -1 OR the index is greater than the
			//   first index bread of was found
			if(indexOfLastBread != -1 && indexOfLastBread > indexOfFirstBread){

				// 5. Get the text between both pieces of bread
				int startIndex = indexOfFirstBread + "bread".length();
				int lastIndex = indexOfLastBread;
				middle = str.substring(startIndex, lastIndex);
			}
		}

		// return the found string in between both pieces of bread

		return middle;
	}

}
