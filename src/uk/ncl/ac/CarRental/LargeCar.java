package uk.ncl.ac.CarRental;

public class LargeCar extends SuperCar {
	private int largeCarTankCap = 60; //large car capacity
	private boolean carTypeBool = false; //boolean becomes false for large cars

	// Calls the super constructor, sets the fields appropriately
	public LargeCar() { //sets current and max fuel capacity appropriately to the car type
		super();
		super.setTankCapacity(largeCarTankCap);
		super.setCurrentFuel(largeCarTankCap);
	}

	public boolean carType() {
		return carTypeBool; //returns car type (false = not small car
	}
	
	// returns the number of whole Litres of fuel consumed during the journey
	public int drivingDistance(int distance) {
		int fuelConsumed = 0;

		if (distance < 0) { //distance should be greater than 0
			throw new IllegalArgumentException("Distance should be bigger than 0");
		}

		if (super.onRent() && (super.getCurrentTank() > 0)) {
			
			if (distance <= 50) {
				fuelConsumed = (distance / 10); //for the first 50 KM consumption is 1L per 10 KM
				super.setCurrentFuel(super.getCurrentTank() - fuelConsumed); //calculate consumption
				return fuelConsumed;
			} else {
				int moreThan = (distance - 50); //if distance is more than 50KM then consumption changes to 1L per 15KM
				fuelConsumed = (50 / 10) + (moreThan / 15);
				super.setCurrentFuel(super.getCurrentTank() - fuelConsumed);
				return fuelConsumed;
			}
		}

		return fuelConsumed;
	}


	public boolean isFullTank() { //boolean to store that tank is full or not
		boolean bool = super.getIsFull();
		return bool;
	}
}
