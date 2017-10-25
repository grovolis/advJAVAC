package uk.ncl.ac.CarRental;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Calendar;

public final class LicenceNumber {
	private static final Map<String, LicenceNumber> licenseNumber = new HashMap<String, LicenceNumber>(); //map that stores driver name and license number
	private final String drInitials; //driver initials
	private final int issueYear; //license year of issue
	private final int rndNumber; //random serial number
	private final String fullLicenseNumber; //full license number
	//initialise license
	private LicenceNumber(String initials, int issueDate, int rnd2Digit) { 
		this.drInitials = initials;
		this.issueYear = issueDate;
		this.rndNumber = rnd2Digit;
		fullLicenseNumber = initials + "-" + issueDate + "-" + rnd2Digit;
	}

	public static LicenceNumber getInstance(Person fullName, Date issueDate) {
		final String initials = fullName.getFirstName().substring(0, 1) + fullName.getLastName().substring(0, 1); //stores initials into a string
		Calendar myCal = Calendar.getInstance(); //creates calendar
		myCal.setTime(issueDate); //sets calendar to date of issue
		final int issueYear = myCal.get(Calendar.YEAR); //assign year of issue to the calendar
		Random rnd = new Random(); //generate a random number
		final int serialNumber = rnd.nextInt(90)+10; //generate random number between 1-11
		final String completeLicense = initials + "-" + issueYear + "-" + serialNumber; //set full registration number format

		if (!licenseNumber.containsKey(completeLicense)) { //if license number generated is unique store the information to the hashmap
			licenseNumber.put(completeLicense, new LicenceNumber(initials, issueYear, serialNumber));
		} else if (licenseNumber.containsKey(completeLicense)) {
			return getInstance(fullName, issueDate); //otherwise run the getinstance again to generated another random number
		}

		return licenseNumber.get(completeLicense);
	}

	public String getInitials() { //returns driver initials
		return drInitials;
	}

	public int getYearOfIssue() { //returns year of issue
		return issueYear;
	}

	public int getSerialNum() { //returns random number
		return rndNumber;
	}

	public String getStringRep() { //returns full license number
		return fullLicenseNumber;
	}

	@Override
	public String toString() { //converts whole license to string
		return  fullLicenseNumber;
	}
}
