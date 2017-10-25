package uk.ncl.ac.CarRental;


public abstract class SuperCar implements Car {
	private RegistrationNumber regNumber; //registration number
	private int tankMaxCapacity; //max tank capacity
	private int currentFuelInTank; //current fuel in tank
	private boolean fullTank; //if tank is full = true
	private boolean onRent; //if car is rented = true

	//initialise car
	public SuperCar() { 
		RegistrationNumber myRegNumber = RegistrationNumber.getInstance(); //creates car object
		regNumber = myRegNumber; //registration number to object so it can be only 1
		fullTank = true; //tank at first is full
		setonRent(false); //and car is not rented
	}

	public String getRegistrationNumber() { //return registration number string
		return regNumber.getFullLicenseNumber();
	}

	public void setTankCapacity(int capacity) { //sets fuel capacity to full
		this.tankMaxCapacity = capacity;
	}

	public int getMaxTank() { //returns fuel capacity
		return tankMaxCapacity;
	}

	public int getCurrentTank() { //returns current fuel capacity
		return currentFuelInTank;
	}

	public void fullTank() { //if current fuel is bigger or equal to capacity tank becomes full
		if ((currentFuelInTank - tankMaxCapacity) >= 0) {
			fullTank = true;
		} else
			fullTank = false;
	}
	
	public void setCurrentFuel(int amount) { //amount need to make the tank full
		currentFuelInTank = amount;
		fullTank();
	}

	

	// Calls the method fullTank method and then returns isFull
	public boolean getIsFull() {
		fullTank();
		return fullTank;
	}

	public boolean onRent() { //returns if car's status
		return onRent;
	}

	public void setonRent(Boolean bool) { //sets car state to rented or not (boolean)
		onRent = bool;
	}

	public int fuelToAdd(int amountToAdd) { //checks input on the amount of fuel
		if (amountToAdd <= 0) {
			throw new IllegalArgumentException("Amount to be added should be greater that 0");
		}

		if (fullTank || !onRent) { //amounts returns 0 if tank is full or car not rented
			return 0;
		}

		if ((currentFuelInTank + amountToAdd) <= tankMaxCapacity) { //adds fuel till its full
			currentFuelInTank += amountToAdd;
			if (currentFuelInTank == tankMaxCapacity) { //when tank is full
				fullTank = true; //becomes true
				return amountToAdd; //returns amount added
			} else
				return amountToAdd;
		}

		if ((currentFuelInTank + amountToAdd) > tankMaxCapacity) { //checks if current fuel capacity if bigger than max tank capacity
			int missingFuel = (tankMaxCapacity - currentFuelInTank); //calculates the difference
			currentFuelInTank = tankMaxCapacity; //makes current fuel equal to tank's max capacity
			fullTank = true; //tank becomes full
			return missingFuel; //returns difference
		}
		//if added amount makes current fuel in tank bigger than max tank capacity
		return -1;
	}
}
