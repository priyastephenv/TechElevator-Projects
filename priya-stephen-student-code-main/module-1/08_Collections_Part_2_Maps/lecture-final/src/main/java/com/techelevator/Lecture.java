package com.techelevator;


import java.util.*;

public class Lecture {

	public static void main(String[] args) {

		System.out.println("####################");
		System.out.println("        SETS");
		System.out.println("####################");
		System.out.println();

		List<Integer> intList = new ArrayList<>();
		intList.add(5);
		intList.add(5);
		intList.add(5);
		System.out.println(intList);

		Set<Integer> intSet = new HashSet<>();
		intSet.add(5);
		intSet.add(5);
		intSet.add(5);
		intSet.add(-255);
		intSet.add(42);
		System.out.println(intSet);

		// Can't do a 'classic' for loop, because the set is unordered
//		for(int i = 0; i < intSet.size(); i++){
//			intSet.get(i);
//		}
		for(int eachInt : intSet){
			System.out.println(eachInt);
		}

		if( intSet.contains(5) ){
			System.out.println("5 is contained in this set");
		}

		System.out.println("####################");
		System.out.println("        MAPS");
		System.out.println("####################");
		System.out.println();

		Map<Integer, String> zipCodes;
		Map<String, String> phoneBook;

		// Student enrollment status
		// "Connor F" -> true
		// "Jane Doe" -> false
		// "Seth A" -> true
		Map<String, Boolean> studentEnrollmentStatus = new HashMap<>();
		studentEnrollmentStatus.put("Seth A", true);
		studentEnrollmentStatus.put("Connor F", true);
		studentEnrollmentStatus.put("Donnie Dark", true);
		studentEnrollmentStatus.put("Jessica A", true);
		System.out.println("Initial roster: " + studentEnrollmentStatus);

		// Put => add if doesn't exist,
		//        update if does exist
		studentEnrollmentStatus.put("Seth A", false);
		System.out.println("Seth dropped: " + studentEnrollmentStatus);

		boolean sethsEnrollmentStatus = studentEnrollmentStatus.get("Seth A");

		if(sethsEnrollmentStatus){
			System.out.println("Seth is enrolled!");
		} else {
			System.out.println("Seth has dropped :(");

			Boolean previousStatus = studentEnrollmentStatus.remove("seth A");
			System.out.println(previousStatus);
		}

		Boolean isMattEnrolled = studentEnrollmentStatus.get("Matthew C");

		if(isMattEnrolled == null){
			System.out.println("Matt isn't enrolled");
		} else {
			System.out.println("Matt is enrolled :) ");
		}

		for( String eachStudent : studentEnrollmentStatus.keySet() ){
			Boolean enrollmentStatus = studentEnrollmentStatus.get(eachStudent);

			System.out.println(eachStudent + " enrollment status: " + enrollmentStatus);
		}

		/*
		 * Create a map that contains each class and the
		 * count how many students are enrolled in each class
		 */
		List<String> orange = new ArrayList<>(Arrays.asList("Seth", "Connor", "Priya", "Maryam"));
		List<String> blue = new ArrayList<>(Arrays.asList("John", "Stacy", "Serina"));
		List<String> purple = new ArrayList<>(Arrays.asList("Mary", "Gizem", "Joe"));
		List<String> green = new ArrayList<>(Arrays.asList("Pat", "Vu"));
		Map<String, Integer> classCount = new HashMap<>();

		classCount.put("orange", orange.size());
		classCount.put("purple", purple.size());
		classCount.put("blue", blue.size());
		classCount.put("green", green.size());

		/*
		 * How to update the count for the number of students in orange
		 * to indicate 1 new student
		 */
		String input = "Orange";

		int currentNumberOfOrangeStudents = classCount.get("ORANGE");
		classCount.put("orange", currentNumberOfOrangeStudents - 1);

		classCount.get(input.toUpperCase());

		if( ! classCount.containsKey("yellow")){
			classCount.put("yellow", 0);
		} else {
			classCount.put("yellow", classCount.get("yellow") + 1);
		}

	}





	void djsMethod() {
		Integer integer1 = Integer.valueOf(5);
		Integer integer2 = Integer.valueOf(5);

		if (integer1 == integer2) {
			System.out.println("equal");
		} else {
			System.out.println("not equal");
		}

		integer1 = new Integer(5);
		integer2 = new Integer(5);

		if (integer1 == integer2) {
			System.out.println("equal");
		} else {
			System.out.println("not equal");
		}

		integer1 = 5;
		integer2 = 5;

		if (integer1 == integer2) {
			System.out.println("equal");
		} else {
			System.out.println("not equal");
		}
	}
}


