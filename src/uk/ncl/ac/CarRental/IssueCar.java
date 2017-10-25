package uk.ncl.ac.CarRental;

import java.util.*;


public class IssueCar {
	private static List<Car> myCars = new ArrayList<Car>(); //list of cars
	private static Map<DriversLicense, Car> corpVehicles = new HashMap<DriversLicense, Car>(); //maps list of cars with the driving license

	public IssueCar() { //populate list of cars
		populateList();
	}

	private void populateList() {
		for (int i = 0; i < 20; i++) { //Creates 20 small cars
			myCars.add(new SmallCar());
		}

		for (int i = 0; i < 10; i++) { //creates 10 large cars
			myCars.add(new LargeCar());
		}
	}

	public List<Car> returnListofCars() { //returns the entire list of cars
		return myCars;
	}

	public Map<DriversLicense, Car> getCorpVehicles() { //returns the entire amount of corporate vehicles
		return corpVehicles;
	}

	public int availableCars(Boolean isSmall) { //true is for small, false is for large
		int counter = 0; //counter of rented cars
		for (Car myTemp : myCars) { //for all objects in the list
			if (myTemp.carType() == isSmall) //if car is small
				if (!myTemp.onRent()) { //and not rented
					counter++;
				} else if (!myTemp.onRent()) {
					counter++; //increase count
				}
		}
		return counter; //return counter
	}

	// Returns the list of cars that are currently on rent
	public List<Car> getRentedCars() { //cars that are currently rented
		List<Car> rentedCars = new ArrayList<Car>();
		for (Car myTemp : myCars) {
			if (myTemp.onRent()) { //if cars are rented add to the list
				rentedCars.add(myTemp);
			}
		}
		return rentedCars; //return list
	}

	public Car getCar(DriversLicense drLicence) {
		if (corpVehicles.containsKey(drLicence)) {
			return corpVehicles.get(drLicence); //returns driving license to matching car
		} else
			return null;
	}

	public void issueCar(DriversLicense drLicense, Boolean isSmall) { //issue car method
		Calendar dob = Calendar.getInstance(); //create calendar for DoB
		dob.setTime(drLicense.getDrDoB()); //sets calendar to drivers date of birth
		Calendar today = Calendar.getInstance(); //creates todays calendar
		int age = today.get(Calendar.YEAR) - dob.get(Calendar.YEAR); //calculate drivers age
		Calendar doi = Calendar.getInstance(); //creates calendar for date of issue
		doi.setTime(drLicense.getDoI()); //sets calendar to date of issue
		int yearsHeld = today.get(Calendar.YEAR) - doi.get(Calendar.YEAR); //calculate years held


		boolean result = false; //boolean becomes true when car is issued
		
		if ((drLicense.getLicenseStatus()) && (!drLicense.getCurrentlyRenting())) {
			// If the person has a full licence and is not currently renting
			for (Car myTemp : myCars) {
				// searches the list of cars
				if (myTemp.carType() == isSmall) {
					// depending on the car type
					if ((age >= 20) && (yearsHeld >= 1)) {
						// checks the age and license year of issue
						if ((!myTemp.onRent()) && (myTemp.isFullTank())) {
							// check if the car is available and has a full tank
							myTemp.setonRent(true); //makes car rented
							drLicense.setRentalStatus(true); //assigns drivers license to the car
							corpVehicles.put(drLicense, myTemp); //stores them in the map
							result = false;
							break;
						} else if ((age >= 25) && (yearsHeld >= 5) && (!myTemp.onRent()) && (myTemp.isFullTank())) {
							// checks the age and license year of issue
							// check if the car is available and has a full tank
							myTemp.setonRent(true); //makes car rented
							drLicense.setRentalStatus(true); //assigns drivers license to the car
							corpVehicles.put(drLicense, myTemp); //stores them in the map
							result = false;
							break;
						} else
							result = true; //if non of the IF is true for the person then no car is appropriate for them
					} else
						result = true;
				} else
					result = true;
			}
		} else
			result = true;
		if (result) {
			System.out.println("No car can be issued");
		}
	}

	public int terminateRental(DriversLicense drLicense) { //removes pair from car and driver license upon termination
		if (corpVehicles.containsKey(drLicense)) { //if licence exists in fleet
			int fuelTillRefill = ((corpVehicles.get(drLicense).getMaxTank()) - (corpVehicles.get(drLicense).getCurrentTank())); //calculate fuel to refill
			drLicense.setRentalStatus(false); //set car rental status to false
			corpVehicles.get(drLicense).setonRent(false); //sets license status to false
			corpVehicles.remove(drLicense); //remove license from fleet
			return fuelTillRefill; //returns required fuel amount till refill
		}
		return -1;
	}
}
