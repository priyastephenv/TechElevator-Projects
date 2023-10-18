package com.techelevator.farm;

public class FarmAnimal implements Singable {
	private String name;

	public FarmAnimal(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	@Override
	public String getSound() {
		return "BARGAHHH";
	}

}
