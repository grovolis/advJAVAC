package uk.ncl.ac.CarRental;

public final class Person {

	private String firstName; //person first name
	private String lastName; //person last name

	public Person(String firstName, String lastName) { //initialise values
		setFirstName(firstName);
		setLastName(lastName);
	}

	public String getFirstName() { //returns first name
		return firstName;
	}

	public String getLastName() { //returns last name
		return lastName;
	}

	private void setFirstName(String firstName) { //check if first name is empty
		if ((firstName == null) || (firstName.isEmpty())) {
			throw new IllegalArgumentException("Person's First Name cannot be empty");
		}
		this.firstName = firstName; //set first name
	}

	private void setLastName(String lastName) { //check if last name is empty 
		if ((lastName == null) || (lastName.isEmpty())) {
			throw new IllegalArgumentException("Person's Last Name cannot be empty");
		}
		this.lastName = lastName; //return last name
	}

	@Override
	public String toString() { //convert name to string
		return "First Name: " + firstName + " - " + "Last Name: " + lastName;
	}

}
