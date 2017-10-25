package uk.ncl.ac.CarRental;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class SmallCarTesting {
	@Test
	public void SmallCarTest() {
		SmallCar testingSmallCar = new SmallCar();
		
		assertEquals("Testing for Max Tank Capacity", 49, testingSmallCar.getMaxTank());
		
		testingSmallCar.setTankCapacity(49);
		assertEquals("Testing for Current Fuel Capacity", 49, testingSmallCar.getCurrentTank());
		assertEquals("Testing for Full Tank", true, testingSmallCar.getIsFull());
		
		testingSmallCar.setCurrentFuel(0);
		assertEquals("Testing for Empty Tank", false, testingSmallCar.getIsFull());
		
		testingSmallCar.setonRent(true);
		assertEquals("Testing for Rental Status True", true, testingSmallCar.onRent());
		
		testingSmallCar.setonRent(false);
		assertEquals("Testing for Rental Status True", false, testingSmallCar.onRent());
		
		testingSmallCar.setCurrentFuel(49);
		assertEquals("Adding Fuel to the Tank when it's already Full", 0, testingSmallCar.fuelToAdd(100));
		
		testingSmallCar.setonRent(true);
		
		testingSmallCar.setCurrentFuel(0);
		
		assertEquals("Adding Fuel to the tank when car is Rented but not Full", 40, testingSmallCar.fuelToAdd(40));
		
		assertEquals("Testing Current Fuel", 40, testingSmallCar.getCurrentTank());
		
		testingSmallCar.setCurrentFuel(0);
		
		assertEquals("Adding more fuel than tank's Capacity", 49, testingSmallCar.fuelToAdd(999));
		
		assertEquals("Testing current fuel amount after overfueling", 49, testingSmallCar.getCurrentTank());
		
		testingSmallCar.setCurrentFuel(testingSmallCar.getMaxTank());
		//Litre Consumption and Distance Driven
		assertEquals("Testing Fuel used", 1, testingSmallCar.drivingDistance(20));	
		assertEquals("Testing Fuel used", 2, testingSmallCar.drivingDistance(40));
		assertEquals("Testing Fuel used", 3, testingSmallCar.drivingDistance(60));
		assertEquals("Testing Fuel used", 4, testingSmallCar.drivingDistance(80));
	}
}
