package uk.ncl.ac.CarRental;

import static org.junit.Assert.assertEquals;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import org.junit.Test;

public class DriversLicenseTesting {
	@Test
	public void DrivingLicence() {
		Person grovolis = new Person("Georgios", "Rovolis"); //driver name
		Calendar dateOfBirth = new GregorianCalendar(1992, 11, 31); //date of Birth
		Calendar dateOfIssue = new GregorianCalendar(2011, 1, 25); //License Date of Issue
		
		DriversLicense drivLicense = new DriversLicense(grovolis, dateOfBirth.getTime(), dateOfIssue.getTime(), true);
		
		
		Person testingDrName = new Person("Georgios", "Rovolis"); //testing name
		assertEquals("Testing Driver's Name: ", drivLicense.getDrName().getClass(), testingDrName.getClass());

		Date testingDateOfBirth = new Date(); //testing date of birth
		assertEquals("Testing Driver's Date of Birth: ", drivLicense.getDrDoB().getClass(), testingDateOfBirth.getClass());

		Date testingDateOfIssue = new Date();
		assertEquals("Testing Driver's License Date of Issue: ", drivLicense.getDoI().getClass(), testingDateOfIssue.getClass());

		LicenceNumber testingLicenseNo = LicenceNumber.getInstance(grovolis, dateOfBirth.getTime());
		assertEquals("Testing Driver's License Number: ", drivLicense.getLicNumb().getClass(), testingLicenseNo.getClass());

		boolean fullTank = true;
		assertEquals("Testing full Tank boolean: ", fullTank, drivLicense.getLicenseStatus());

		drivLicense.setRentalStatus(true); 
		assertEquals("Testing Driver's Current Rental Status: ", true, drivLicense.getCurrentlyRenting());
		
		System.out.println(drivLicense);
	}
}
