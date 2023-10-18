package com.techelevator.farm;

public class OldMacdonald {
	public static void main(String[] args) {

		FarmAnimal bessy = new Cow();
		FarmAnimal foghorn = new Chicken();
		Tractor tracky = new Tractor();

		// Q: Want to add the tractor object so it can sing,
		// but the array can only hold FarmAnimal objects
		// What to do???
		//
		// A: Make an interface so singable things can be grouped together
		// Can't make tractor extend FarmAnimal b/c there is not is-a relationship

		Singable[] singableObjects = new Singable[] { bessy, foghorn, tracky };

		for (Singable eachSingableObject : singableObjects) {
			String name = eachSingableObject.getName();
			String sound = eachSingableObject.getSound();

			String song = "Old MacDonald had a farm, ee, ay, ee, ay, oh!" + "\n" +
			"And on his farm he had a " + name + ", ee, ay, ee, ay, oh!" + "\n" +
			"With a " + sound + " " + sound + " here" + "\n" +
			"And a " + sound + " " + sound + " there" + "\n" +
			"Here a " + sound + " there a " + sound + " everywhere a " + sound + " " + sound + "\n" +
			"\n";

			System.out.println(song);

			//speak(song);
		}
	}





























	public static void speak(String words) {
		if (System.getProperty("os.name").contains("Windows")) {
			String cmd = "PowerShell -Command \"Add-Type -AssemblyName System.Speech; (New-Object System.Speech.Synthesis.SpeechSynthesizer).Speak('"
					+ words + "');\"";
			try {
				Runtime.getRuntime().exec(cmd).waitFor();
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else {
			try {
				Runtime.getRuntime().exec("say " + words).waitFor();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
