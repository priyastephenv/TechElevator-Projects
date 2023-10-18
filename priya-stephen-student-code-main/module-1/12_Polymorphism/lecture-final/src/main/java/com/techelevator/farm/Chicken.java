package com.techelevator.farm;

public class Chicken extends FarmAnimal {

	public Chicken() {
		super("Chicken");
	}

	@Override
	public String getSound(){
		return "cluck!";
	}

	public void layEgg() {
		System.out.println("Chicken laid an egg!");
	}

}
