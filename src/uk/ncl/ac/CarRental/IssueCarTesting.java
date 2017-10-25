package uk.ncl.ac.CarRental;

import static org.junit.Assert.assertEquals;

import java.util.Calendar;
import java.util.GregorianCalendar;

import org.junit.Test;

public class IssueCarTesting {
	@Test
	public void TestRentalAgency() {
		IssueCar carGen = new IssueCar();
		
		assertEquals("Testing List Size: ", 30, carGen.returnListofCars().size());
		assertEquals("Small Car Number", 20, carGen.availableCars(true));
		assertEquals("Large Car Number", 10, carGen.availableCars(false));
		System.out.println("Prints Small Cars: " +carGen.availableCars(true));
		System.out.println("Prints Large Cars: " +carGen.availableCars(false));

		Person grovolis = new Person("Georgios", "Rovolis");
		Calendar dateofIssue = new GregorianCalendar(2011, 1, 25);
		Calendar dateofBirth = new GregorianCalendar(1992, 11, 31);
		DriversLicense drivLicense = new DriversLicense(grovolis, dateofBirth.getTime(), dateofIssue.getTime(), true);

		carGen.issueCar(drivLicense, true);
		System.out.println("Number of Large Cars available after issueing one: " +carGen.availableCars(true));

		carGen.terminateRental(drivLicense);
		System.out.println("Number of Large Cars available after termination: " +carGen.availableCars(true));
		
	}
}
