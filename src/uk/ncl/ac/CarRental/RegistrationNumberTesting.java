package uk.ncl.ac.CarRental;

import org.junit.Test;

public class RegistrationNumberTesting {
	@Test
	public void TestRegistrationNumber() {
		RegistrationNumber regNumberTest = RegistrationNumber.getInstance();
		System.out.println("Car Registration Number eg. (2Chars + 2 Digits + 3 Chars): " + regNumberTest.getFullLicenseNumber());
	}
}
