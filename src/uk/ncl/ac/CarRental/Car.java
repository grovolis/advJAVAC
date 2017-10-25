package uk.ncl.ac.CarRental;

public interface Car {

	public String getRegistrationNumber(); //gets registration number

	public int getMaxTank(); //gets tank's max capacity

	public int getCurrentTank(); //gets current amount of fuel in tank

	public void fullTank(); //checks if tank is full

	public boolean isFullTank(); //boolean true if tank is full

	public boolean onRent(); //boolean true if car is rented

	public void setonRent(Boolean myBool); //sets a car to rented status

	public int fuelToAdd(int addedFuel); //adds the amount of fuel needed to full the tank

	public int drivingDistance(int distanceKM); //calculates the driving distance

	public boolean carType(); //true if car is small false if its large

}
