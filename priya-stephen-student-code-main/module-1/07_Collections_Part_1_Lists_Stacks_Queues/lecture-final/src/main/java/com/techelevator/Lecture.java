package com.techelevator;

import java.util.*;

public class Lecture {

	public static void main(String[] args) {

		System.out.println("####################");
		System.out.println("       LISTS");
		System.out.println("####################");

		System.out.println(zipZap("abcppp"));

		// Use List to make the students variable more
		// flexible to hold other types of lists in the future
		List<String> students = new ArrayList<>();
		students = new LinkedList<String>();

		List<Integer> intList = new ArrayList<>();
		int listSize = intList.size();
		System.out.println("List size is: " + listSize);
		System.out.println("Adding 3 integers...");
		intList.add(11);
		intList.add(12);
		intList.add(-100);
		System.out.println("List size is: " + intList.size());

		// Add numbers 0 to 4, all the values of the loop variable
		for(int i = 0; i < 5; i++){
			intList.add(i);
		}

		System.out.println("####################");
		System.out.println("Lists are ordered");
		System.out.println("####################");


		System.out.println("####################");
		System.out.println("Lists allow duplicates");
		System.out.println("####################");


		System.out.println("####################");
		System.out.println("Lists allow elements to be inserted in the middle");
		System.out.println("####################");
		System.out.println(intList);
		intList.add(1, 55555555);
		System.out.println(intList);

		System.out.println("####################");
		System.out.println("Lists allow elements to be removed by index");
		System.out.println("####################");
		System.out.println("Removing index 1 ...");
		intList.remove(1);
		System.out.println(intList);

		System.out.println("####################");
		System.out.println("Find out if something is already in the List");
		System.out.println("####################");

		boolean isZeroInList = intList.contains(0);
		System.out.println("Is zero inside of this list: " + isZeroInList);

		System.out.println("####################");
		System.out.println("Find index of item in List");
		System.out.println("####################");
		intList.indexOf(0);

		System.out.println("####################");
		System.out.println("Lists can be turned into an array");
		System.out.println("####################");
		int[] intArr = new int[intList.size()];
		for(int i = 0; i < intArr.length; i++){
			intArr[i] = intList.get(i);
		}
		System.out.println("list contains : " + intList);
		System.out.println("array contains: " + Arrays.toString(intArr));

		System.out.println("####################");
		System.out.println("Lists can be sorted");
		System.out.println("####################");
		Collections.sort(intList);
		System.out.println("after sorting, list contains : " + intList);

		Arrays.sort(new int[]{5,4,3,2,1});

		System.out.println("####################");
		System.out.println("Lists can be reversed too");
		System.out.println("####################");
		Collections.reverse(intList);
		System.out.println("after reversing, list contains : " + intList);


		System.out.println("####################");
		System.out.println("       FOREACH");
		System.out.println("####################");
		System.out.println();

		for(Integer eachIntValue : intList){

			System.out.println(eachIntValue);

			if(eachIntValue == 0) {
				System.out.println("0 found!!!!");
				break;
			}
		}
		System.out.println("After for-each loop");

	}


	//	Look for patterns like "zip" and "zap" in the string -- length-3, starting with 'z' and ending with 'p'. Return a string where for all such words, the middle letter is gone, so "zipXzap" yields "zpXzp".
	//
	//
	//	zipZap("zipXzap") → "zpXzp"
	//	zipZap("zopzop") → "zpzp"
	//	zipZap("zzzopzop") → "zzzpzp"
	public static String zipZap(String str) {

		/*
		 * PLAN OF ATTACK!
		 *
		 * I. How to go through each 3-letter combination of the string
		 * II. check each 3-letter combination with the z*p pattern
		 * III. Replace each found instance of the pattern with zp
		 */

		//   str.substring(4,    7)
		//                 |     |
		// indexes 0 1 2 3 4 5 6 7
		//         z i p X z a p    - 7 characters long, so str.length() -> 7
		//         "zp"
		//         "zp" + "X"
		//         "zp" + "X" + "zp"

		// indexes 0 1 2 3 4 5 6 7
		// 		   z z z o p z o p  - 8 characters long, so str.length() -> 8
		//
		//         "z"
		//         "z" + "z"
		//         "z" + "z" + "zp"
		//         "z" + "z" + "zp" + "zp"

		// Failing Test Case:
		//           str      expected   actual
		// zipZap("abcppp") → "abcppp"	"abcp"
		//
		// indexes 0 1 2 3 4 5
		// 		   a b c p p p


		// The magic 1-liner using regular expression :)
		//return str.replaceAll("(z.p)", "zp");

		// Since strings less than 3 characters can't have a substring with a
		// pattern "z*p", the code can return the original string and exit ASAP
		if(str.length() < 3){
			return str;
		}

		// Need to create a new string because the original string can't be modified
		String returnString = "";

		for( int i = 0; i < str.length(); i++){

			// Need to only check for a 3-letter combination if
			// we're at a valid index

			if( i <= str.length() - 3){
				// There is a valid 3-letter substring to get
				String threeLetterCombination = str.substring(i, i + 3);

				if(threeLetterCombination.charAt(0) == 'z' && threeLetterCombination.charAt(2) == 'p'){
					// There is a match for the pattern z*p

					returnString += "zp";
					i += 2;

				} else {
					// There is NO match for the pattern z*p

					returnString += str.charAt(i);
				}
			} else {
				// There is no valid 3-letter substring
				// at the end of the string

				returnString += str.charAt(i);
			}
		}

		return returnString;
	}

}
