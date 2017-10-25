package uk.ncl.ac.CarRental;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class PersonTesting 
{
	@Test
	public void NameTest() {
		Person testName = new Person("Georgios", "Rovolis");
		String firstName = testName.getFirstName();
		String lastName = testName.getLastName();
		assertEquals("Testing for First Name: ", firstName, testName.getFirstName());
		assertEquals("Testing for Last Name: ", lastName, testName.getLastName());
		String myName = "Georgios";
		String mySurname = "Rovolis";
		assertEquals("Testing First Name: ", myName, testName.getFirstName());
		assertEquals("Testing Surname: ", mySurname, testName.getLastName());
		System.out.println("Full Name: "+myName + " "+ mySurname);
	}
}
