package com.techelevator;

import java.util.Locale;

public class Exercises {

	/*
	 Given a string name, e.g. "Bob", return a greeting of the form "Hello Bob!".
	 helloName("Bob") → "Hello Bob!"
	 helloName("Alice") → "Hello Alice!"
	 helloName("X") → "Hello X!"
	 */
	public String helloName(String name) {
		return "Hello " + name + "!";
	}

	/*
	 Given two strings, a and b, return the result of putting them together in the order abba,
	 e.g. "Hi" and "Bye" returns "HiByeByeHi".
	 makeAbba("Hi", "Bye") → "HiByeByeHi"
	 makeAbba("Yo", "Alice") → "YoAliceAliceYo"
	 makeAbba("What", "Up") → "WhatUpUpWhat"
	 */
	public String makeAbba(String a, String b) {

		String puttingVariablesTogether = a + b + b + a;

		return puttingVariablesTogether;
	}

	/*
	 The web is built with HTML strings like "<i>Yay</i>" which draws Yay as italic text. In this example,
	 the "i" tag makes <i> and </i> which surround the word "Yay". Given tag and word strings, create the
	 HTML string with tags around the word, e.g. "<i>Yay</i>".
	 makeTags("i", "Yay") → "<i>Yay</i>"
	 makeTags("i", "Hello") → "<i>Hello</i>"
	 makeTags("cite", "Yay") → "<cite>Yay</cite>"
	 */
	public String makeTags(String tag, String word) {

		String tag1 = "<" + tag + ">";
		String tag2 = "</" + tag + ">";
		String htmlString = tag1 + word + tag2;

		return htmlString;
	}

	/*
	 Given an "out" string length 4, such as "<<>>", and a word, return a new string where the word is in the
	 middle of the out string, e.g. "<<word>>". Note: use str.substring(i, j) to extract the String starting
	 at index i and going up to but not including index j.
	 makeOutWord("<<>>", "Yay") → "<<Yay>>"
	 makeOutWord("<<>>", "WooHoo") → "<<WooHoo>>"
	 makeOutWord("[[]]", "word") → "[[word]]"
	 */
	public String makeOutWord(String out, String word) {
		String beginningOfNewString = out.substring(0,2);
		String endingOfNewString = out.substring(2);
		String newString = beginningOfNewString + word + endingOfNewString;
		return newString;
	}

	/*
	 Given a string, return a new string made of 3 copies of the last 2 chars of the original string. The string
	 length will be at least 2.
	 extraEnd("Hello") → "lololo"
	 extraEnd("ab") → "ababab"
	 extraEnd("Hi") → "HiHiHi"
	 */
	public String extraEnd(String str) {

		String lastTwoCharacters = str.substring((str.length()-2) );

		String threeCopies = lastTwoCharacters + lastTwoCharacters + lastTwoCharacters;
		return threeCopies;
	}

	/*
	 Given a string, return the string made of its first two chars, so the String "Hello" yields "He". If the
	 string is shorter than length 2, return whatever there is, so "X" yields "X", and the empty string ""
	 yields the empty string "". Note that str.length() returns the length of a string.
	 firstTwo("Hello") → "He"
	 firstTwo("abcdefg") → "ab"
	 firstTwo("ab") → "ab"
	 */
	public String firstTwo(String str) {

		if (str.length() < 1 ) {
			return str;
		} else if (str.length() <2) {

			return str.substring(0);
		} else {

			return str.substring(0,2);
		}

	}

	/*
	 Given a string of even length, return the first half. So the string "WooHoo" yields "Woo".
	 firstHalf("WooHoo") → "Woo"
	 firstHalf("HelloThere") → "Hello"
	 firstHalf("abcdef") → "abc"
	 */
	public String firstHalf(String str) {
		int lastIndexNumber = str.length()/2;

		return str.substring(0,lastIndexNumber);
	}

	/*
	 Given a string, return a version without the first and last char, so "Hello" yields "ell".
	 The string length will be at least 2.
	 withoutEnd("Hello") → "ell"
	 withoutEnd("java") → "av"
	 withoutEnd("coding") → "odin"
	 */
	public String withoutEnd(String str) {
		return str.substring(1, str.length()-1);
	}

	/*
	 Given 2 strings, a and b, return a string of the form short+long+short, with the shorter string
	 on the outside and the longer string on the inside. The strings will not be the same length, but
	 they may be empty (length 0).
	 comboString("Hello", "hi") → "hiHellohi"
	 comboString("hi", "Hello") → "hiHellohi"
	 comboString("aaa", "b") → "baaab"
	 */
	public String comboString(String a, String b) {

		String shortWord;
		String longWord ;
		String shortLongShort;


		if (a.length() < b.length()) {

			shortWord = a;
			longWord = b;

			shortLongShort = shortWord + longWord + shortWord;


			return shortLongShort;

		} else {

			shortWord = b;
			longWord = a;

			shortLongShort = shortWord + longWord + shortWord;


			return	shortLongShort;

		}

	}

	/*
	 Given 2 strings, return their concatenation, except omit the first char of each. The strings will
	 be at least length 1.
	 nonStart("Hello", "There") → "ellohere"
	 nonStart("java", "code") → "avaode"
	 nonStart("shotl", "java") → "hotlava"
	 */
	public String nonStart(String a, String b) {

		String newStringA = a.substring(1);
		String newStringB = b.substring(1);
		return newStringA + newStringB;
	}

	/*
	 Given a string, return a "rotated left 2" version where the first 2 chars are moved to the end.
	 The string length will be at least 2.
	 left2("Hello") → "lloHe"
	 left2("java") → "vaja"
	 left2("Hi") → "Hi"
	 */
	public String left2(String str) {

		if (str.length() <3) {

			return str;

		} else {

			String rotatedString = str.substring(2) + str.substring(0,2);

			return rotatedString;
		}

	}

	/*
	 Given a string, return a "rotated right 2" version where the last 2 chars are moved to the start.
	 The string length will be at least 2.
	 right2("Hello") → "loHel"
	 right2("java") → "vaja"
	 right2("Hi") → "Hi"
	 */
	public String right2(String str) {

		if (str.length() <3) {

			return str;

		} else {

			String rotatedString =  str.substring(str.length()-2) + str.substring(0,str.length()-2);

			return rotatedString;
		}

	}

	/*
	 Given a string, return a string length 1 from its front, unless front is false, in which case
	 return a string length 1 from its back. The string will be non-empty.
	 theEnd("Hello", true) → "H"
	 theEnd("Hello", false) → "o"
	 theEnd("oh", true) → "o"
	 */
	public String theEnd(String str, boolean front) {

		if (front ==true) {

			return str.substring(0,1);
		} else {

			return str.substring(str.length()-1);

		}


	}

	/*
	 Given a string, return a version without both the first and last char of the string. The string
	 may be any length, including 0.
	 withoutEnd2("Hello") → "ell"
	 withoutEnd2("abc") → "b"
	 withoutEnd2("ab") → ""
	 */
	public String withoutEnd2(String str) {

		if (str.length() <1) {

			return str;

		} else if (str.length() < 3) {
			String emptyString = "";

			return emptyString;

		} else {


			String middle = str.substring(1,str.length()-1);

			return middle;
		}


	}

	/*
	 Given a string of even length, return a string made of the middle two chars, so the string "string"
	 yields "ri". The string length will be at least 2.
	 middleTwo("string") → "ri"
	 middleTwo("code") → "od"
	 middleTwo("Practice") → "ct"
	 */
	public String middleTwo(String str) {

		int lastIndex = ((str.length() / 2) + 1 );
		int firstIndex = ((str.length() / 2) - 1 );

		String middleChars = str.substring(firstIndex,lastIndex);

		return middleChars;
	}

	/*
	 Given a string, return true if it ends in "ly".
	 endsLy("oddly") → true
	 endsLy("y") → false
	 endsLy("oddy") → false
	 */
	public boolean endsLy(String str) {

		if ( str.length() < 2) {

			return false;

		}  else {

			String newString = str.substring(str.length()-2);

			if (newString.equalsIgnoreCase("ly")){

				return true;
			}


		}


		return false;
	}

	/*
	 Given a string and an int n, return a string made of the first and last n chars from the string. The
	 string length will be at least n.

	         0 1 2 3 4
	 nTwice("H e l l o", 2) → "Helo"

	          0 1 2 3 4 5 6 7 8
	 nTwice(" C h o c o l a t e ", 3) → "Choate"
	 nTwice("Chocolate", 1) → "Ce"
	 */
	public String nTwice(String str, int n) {

		String firstPartOfString = str.substring(0,n);
		String lastPartOfString = str.substring(str.length()-n);

		String weirdString = firstPartOfString + lastPartOfString;
		return weirdString;
	}

	/*
	 Given a string and an int n, return a string that starts at n and has a length of 2. Note that n may or may not be a valid
	 location in the string. If n is too low or too high to define a string of length 2, return the string's first 2 characters.
	 The string length will be at least 2.
	 twoChar("java", 0) → "ja"
	 twoChar("java", 2) → "va"
	 twoChar("java", 3) → "ja"
	 */
	public String twoChar(String str, int n) {

		if (str.length() < 3) {

			return str;


		} else if (n <= 0 || n >= str.length() - 1) {

			return str.substring(0, 2);

		} else  {


			if (n + 2 == str.length() - 1) {

				String StartFromSecondToLast = str.substring(n);

				return StartFromSecondToLast;


			} else {

				String StartFromAnyOtherIndex = str.substring(n, n + 2);

				return StartFromAnyOtherIndex;


			}

		}


	}

	/*
	 Given a string of odd length, return the string length 3 from its middle, so "Candy" yields "and".
	 The string length will be at least 3.
	 middleThree("Candy") → "and"
	 middleThree("and") → "and"
	 middleThree("solving") → "lvi"
	 */
	public String middleThree(String str) {

		if (str.length() < 4) {

			return str;

		} else {

			String newString = str.substring( ((str.length()/2) - 1), (  (str.length()/2) +2) );
			return newString;
		}
	}

	/*
	 Given a string, return true if "bad" appears starting at index 0 or 1 in the string, such as with
	 "badxxx" or "xbadxx" but not "xxbadxx". The string may be any length, including 0. Note: use .equals()
	 to compare 2 strings.
	 hasBad("badxx") → true
	 hasBad("xbadxx") → true
	 hasBad("xxbadxx") → false
	 */
	public boolean hasBad(String str) {

		boolean	isItBad = str.contains ("bad");

		if (isItBad) {

			int numberOfStartingIndex = str.indexOf("bad");


			if (numberOfStartingIndex == 0 || numberOfStartingIndex ==1){

				return true;

			} else {

				return false;
			}

		} else {

			return false;
		}


	}

	/*
	 Given a string and a non-negative int n, return a larger string that is n copies of the original string.
	 stringTimes("Hi", 2) → "HiHi"
	 stringTimes("Hi", 3) → "HiHiHi"
	 stringTimes("Hi", 1) → "Hi"
	 */
	public String stringTimes(String str, int n) {

		String originalString = str;

		if ( n <1 ) {

			return "";


		} else if (n <2) {

			return originalString;

		} else {

			for (int i = 2; i <= n; i++) {
				str = str + originalString;

			}

			return str;

		}

	}

	/*
	 Given a string and a non-negative int n, we'll say that the front of the string is the first 3 chars, or
	 whatever is there if the string is less than length 3. Return n copies of the front;
	 frontTimes("Chocolate", 2) → "ChoCho"
	 frontTimes("Chocolate", 3) → "ChoChoCho"
	 frontTimes("Abc", 3) → "AbcAbcAbc"
	 */
	public String frontTimes(String str, int n) {

		String front;

		if (n < 0) {

			return " ";

		} else if (str.length() <= 3 && n >0) {

			front = str;

			for (int i = 1; i < n; i++) {

				front = front + str;

			}

			return front;
		} else {

			front = str.substring(0, 3);

			String originalFront = front;

			if (n < 1) {

				return "";

			} else if (n < 2) {

				return front;

			} else {

				for (int i = 2; i <= n; i++) {

					front = front + originalFront;
				}


			}

  			return front;
		}
	}

	/*
	 Count the number of "xx" in the given string. We'll say that overlapping is allowed, so "xxx" contains 2 "xx".
	 countXX("abcxx") → 1
	 countXX("xxx") → 2
	 countXX("xxxx") →
	 */
	public int countXX(String str) {
			// first does it even have an xx

		boolean doesItHaveXX = str.contains("xx");

			// well if it does then

		if (doesItHaveXX && str.length() <3) {
			// this already counts for strings that have at least two characters and if it's two characters there's
			// only one possibility

			return  1;


		} else if (doesItHaveXX) {
		// in any other situation the string will have a length of at least three characters and it COULD have
		// overlapping x's
		// want to find the index of the first xx

			int firstIndexOfXX = str.indexOf("xx");

			// if the first instance of an x is second from the last, then the number of xx is just 1
			if (firstIndexOfXX == str.length()-2) {

				return 1;

				// if the first Index is between 0 and less than 2 away from the end, the number could be greater than 1
				// we have to keep finding the next index number and stop at index -2. we start at the first index
				// and increase by 1. we check to see if there's an instance of xx. if there is, we add 1. if not, we
				//keep going

			} else  {

				int sumOfXX = 1;


				for ( int i = 0; i < str.length()-1; i++) {

					String stringOfTwoLetters = str.substring(i, i+2);
					
					if (stringOfTwoLetters.equals("xx")) {

						sumOfXX +=1;

						return sumOfXX;
						
					}

				}
				return 0;

			}






		}


		return 0;
	}

	/*
	 Given a string, return true if the first instance of "x" in the string is immediately followed by another "x".
	 doubleX("axxbb") → true
	 doubleX("axaxax") → false
	 doubleX("xxxxx") → true
	 */
	public boolean doubleX(String str) {


		int firstIndex = str.indexOf("x");

		if (firstIndex == str.length()-1) {
			return false;

		} else if (firstIndex < str.length()-1) {

			String nextLetter = str.substring(firstIndex+1, firstIndex +2);
			 if (nextLetter.equals ("x")) {

				 return true;
			 }



		}

		return false;
	}

	/*
	 Given a string, return a new string made of every other char starting with the first, so "Hello" yields "Hlo".
	 stringBits("Hello") → "Hlo"
	 stringBits("Hi") → "H"
	 stringBits("Heeololeo") → "Hello"
	 */
	public String stringBits(String str) {
		String variable1 ="";

		for (int i =0; i <str.length(); i+=2) {

			variable1 = variable1+ String.valueOf(str.charAt(i));
		}

		return variable1;
	}

	/*
	 Given a non-empty string like "Code" return a string like "CCoCodCode".
	 stringSplosion("Code") → "CCoCodCode"
	 stringSplosion("abc") → "aababc"
	 stringSplosion("ab") → "aab"
	 */
	public String stringSplosion(String str) {


		return null;
	}

	/*
	 Given a string, return the count of the number of times that a substring length 2 appears in the string and
	 also as the last 2 chars of the string, so "hixxxhi" yields 1 (we won't count the end substring).
	 last2("hixxhi") → 1
	 last2("xaxxaxaxx") → 1
	 last2("axxxaaxx") → 2
	 */
	public int last2(String str) {

		String last2Letters = str.substring(str.length()-2, str.length()-1);
		

		return 0;
	}

	/*
	 Given a string, return a version where all the "x" have been removed. Except an "x" at the very start or end
	 should not be removed.
	 stringX("xxHxix") → "xHix"
	 stringX("abxxxcd") → "abcd"
	 stringX("xabxxxcdx") → "xabcdx"
	 */
	public String stringX(String str) {

		if (str.length() < 3) {
			return str;

		} else {

		String StringWithTooManyX = str.substring(1,str.length()-2);

		String noX = StringWithTooManyX.replace("x", "");
		String beginning = str.substring(0,1);
		String ending = str.substring(str.length()-2);

		return beginning + noX + ending; }


	}

	/*
	 Given a string, return a string made of the chars at indexes 0,1, 4,5, 8,9 ... so "kittens" yields "kien".
	            0 1 2 3 4 5 = length = 6
	 altPairs(" k i t t e n") → "kien"
                  length = 9
	            0   1  2 3  4  5  6  7  8
	 altPairs(" C  h  o  c  o  l  a  t  e") → "Chole"
	 altPairs("CodingHorror") → "Congrr"
	 */
	public String altPairs(String str) {

		String stringReplaced = "";

		if (str.length() % 2 ==0){
			for (int i =0; i < str.length()-1; i+=4) {

			String partThatWillBePrinted = str.substring(i , i + 2);
			stringReplaced+=partThatWillBePrinted;

		}
			return stringReplaced;

		} else {
			for (int i =0; i < str.length()-1; i+=4) {

				String partThatWillBePrinted = str.substring(i , i + 2);
				stringReplaced+=partThatWillBePrinted;

				if (str.length()<4) {

					return stringReplaced;
				}



		}


			return stringReplaced + str.charAt(str.length()-1);



	}

	}

	/*
	 Suppose the string "yak" is unlucky. Given a string, return a version where all the "yak" are removed.
	 The "yak" strings will not overlap.
	 stringYak("yakpak") → "pak"
	 stringYak("pakyak") → "pak"
	 stringYak("yak123ya") → "123ya"
	 */
	public String stringYak(String str) {

		str=str.replace ("yak","" );


		return str;
	}

}
