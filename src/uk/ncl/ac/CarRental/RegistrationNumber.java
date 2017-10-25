package uk.ncl.ac.CarRental;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;


public final class RegistrationNumber {
	
	private static final Map<String, RegistrationNumber> CarRegNumb = new HashMap<String, RegistrationNumber>();
	
	private final char letter; // 1st letter
	private final char letter1; //2nd letter
	private final int digits; // 2 numbers
	private final char letter2; //last three letters
	private final char letter3;
	private final char letter4;
	private final String fullLicenseNumber; // letters + number + letters, e.g. AB12CDE

	private RegistrationNumber(char letter, char letter1, int numbers, char letter2, char letter3, char letter4)
	{
		this.letter = letter;
		this.letter1 = letter1;
		this.digits = numbers;
		this.letter2 = letter2;
		this.letter3 = letter3;
		this.letter4 = letter4;
		this.fullLicenseNumber = String.format("%s%s%02d%s%s%s", letter, letter1, numbers, letter2, letter3, letter4);
		// makes sure you always get the correct format of the license number
	}

	public static RegistrationNumber getInstance() {
		Random random = new Random();
		// Using the random class instead of math.random as it is a static
		// method
		final Character letter = (char) (random.nextInt(26) + 'A');
		final Character letter1 = (char) (random.nextInt(26) + 'A');
		final int numbers = random.nextInt(90) + 10;
		final Character letter2 = (char) (random.nextInt(26) + 'A');
		final Character letter3 = (char) (random.nextInt(26) + 'A');
		final Character letter4 = (char) (random.nextInt(26) + 'A');
		final String fullLicense = letter + letter1 + numbers + letter2 + letter3 + letter4 + "";

		if (!CarRegNumb.containsKey(fullLicense)) {
			CarRegNumb.put(fullLicense, new RegistrationNumber(letter, letter1, numbers, letter2, letter3, letter4));
		}
		// If the registration plate created is unique, create a new object
		else if (CarRegNumb.containsKey(fullLicense)) {
			return getInstance();
		}
		// if the registration plate is a duplicate call get instance again

		return CarRegNumb.get(fullLicense);
	}

	public char getLetter() {
		return letter;
	}
	
	public char getLetter1() {
		return letter1;
	}

	public int getNumbers() {
		return digits;
	}
	
	public char getLetter2() {
		return letter2;
	}
	
	public char getLetter3() {
		return letter3;
	}
	
	public char getLetter4() {
		return letter4;
	}
	
	public String getFullLicenseNumber() {
		return fullLicenseNumber;
	}

	public String toString() {
		return "RegistrationNumber [letter:" + letter + ", letter1 : " + letter1 + " , digits :" + digits + ", letter2 : " + letter2 + ", letter3 : " + letter3 + ", letter4 : " + letter4 + ", Full License Number: " + fullLicenseNumber + "]";
	}
}
