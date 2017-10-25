package uk.ncl.ac.CarRental;

import static org.junit.Assert.assertEquals;

import java.util.Calendar;
import java.util.GregorianCalendar;

import org.junit.Test;

public class LicenseNumberTesting {
	@Test
	public void LicenceNumberTest() {
		Person grovolis = new Person("Georgios", "Rovolis");
		Calendar myCal = new GregorianCalendar(2011, 1, 25);
		LicenceNumber licNo = LicenceNumber.getInstance(grovolis, myCal.getTime());
		String initials = "GR";
		int licYearOfIssue = 2011;
		String rndNo = licNo.getStringRep().substring(8, licNo.getStringRep().length());
		assertEquals("Testing Initials: ", initials, licNo.getInitials());
		assertEquals("Testing Year of Issue: ", licYearOfIssue, licNo.getYearOfIssue());
		assertEquals("Testing Random Number: ", rndNo, Integer.toString(licNo.getSerialNum()));
		System.out.print("Driver's License Number: " +initials + "-" + licYearOfIssue +"-" + rndNo);
	}
}
