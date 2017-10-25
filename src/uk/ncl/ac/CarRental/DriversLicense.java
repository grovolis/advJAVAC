package uk.ncl.ac.CarRental;

import java.util.Date;

public final class DriversLicense { //Driver's License Creation
	private final Person drName; //drivers name
	private final Date drDoB; //drivers DoB
	private final Date drDoI; //license date of issue
	private final LicenceNumber licNumb; //license number
	private final boolean fullLicense; //license status full or not
	private boolean rentalStatus = false; //drivers rental status
	//initialise drivers license values
	public DriversLicense(Person name, Date birthDate, Date issueDate, boolean fullLicense) {
		this.drName = name;
		this.drDoB = birthDate;
		this.drDoI = issueDate;
		this.licNumb = LicenceNumber.getInstance(name, issueDate);
		this.fullLicense = fullLicense;
	}

	public Person getDrName() { //returns driver name
		return drName;
	}

	public Date getDrDoB() { //returns driver DoB
		return drDoB;
	}

	public Date getDoI() { //returns date of issue
		return drDoI;
	}

	public LicenceNumber getLicNumb() { //returns license number
		return licNumb;
	}

	public boolean getLicenseStatus() { //returns license status
		return fullLicense;
	}

	public void setRentalStatus(Boolean bool) { //boolean to check driver rental status
		rentalStatus = bool;
	}

	public boolean getCurrentlyRenting() { //returns driver rental status
		return rentalStatus;
	}

	@Override
	public String toString() {
		return "Driver's License Details: \n" + drName.toString() + "\nDriver's Date of Birth: " + drDoB
				+ "\nLicense Date of Issue: " + drDoI + "\nLicense Number: " + licNumb.toString() + "\nFull License: " + fullLicense;
	}

}