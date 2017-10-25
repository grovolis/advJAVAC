package uk.ncl.ac.CarRental;

public class SmallCar extends SuperCar {
	private int smallCarTankCap = 49; //max tank fuel capacity
	private boolean carTypeBool = true; //true for small cars

	public SmallCar() {
		super();
		super.setTankCapacity(smallCarTankCap); //sets max tank capacity as appropriate
		super.setCurrentFuel(smallCarTankCap); //sets current fuel capacity as appropriate
	}

	public boolean carType() { //returns car type 
		return carTypeBool;
	}

	// returns the number of whole Litres of fuel consumed during the journey
	public int drivingDistance(int distance) {
		int fuelConsumed = 0;

		if (distance < 0) { //distance should be greater than 0
			throw new IllegalArgumentException("Distance should be bigger than 0");
		}

		if (super.onRent() && (super.getCurrentTank() > 0)) {
			fuelConsumed = (distance / 20); //1L per 20 KM for small cars
			super.setCurrentFuel(super.getCurrentTank() - fuelConsumed); //current fuel is calculated according to driving distance
			return fuelConsumed;
		}
		return fuelConsumed;
	}
	

	public boolean isFullTank() { //set boolean to full tank or not
		boolean bool = super.getIsFull();
		return bool;
	}
}
