package uk.ncl.ac.CarRental;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class LargeCarTesting {
	@Test
	public void LargeCarTest() {
		
		LargeCar testingLargeCar = new LargeCar();
		
		assertEquals("Testing for Max Tank Capacity", 60, testingLargeCar.getMaxTank());
		
		testingLargeCar.setTankCapacity(60);
		assertEquals("Testing for Current Fuel Capacity", 60, testingLargeCar.getCurrentTank());
		assertEquals("Testing for Full Tank", true, testingLargeCar.getIsFull());
		
		testingLargeCar.setCurrentFuel(0);
		assertEquals("Testing for Empty Tank", false, testingLargeCar.getIsFull());
		
		testingLargeCar.setonRent(false);
		assertEquals("Testing for Rental Status False", false, testingLargeCar.onRent());
		
		testingLargeCar.setonRent(true);
		assertEquals("Testing for Rental Status True", true, testingLargeCar.onRent());
		
		testingLargeCar.setCurrentFuel(60);
		assertEquals("Adding Fuel to the Tank when it's already Full", 0, testingLargeCar.fuelToAdd(100));
		
		testingLargeCar.setonRent(true);
		
		testingLargeCar.setCurrentFuel(0);
		
		assertEquals("Adding Fuel to the tank when car is Rented but not Full", 40, testingLargeCar.fuelToAdd(40));
		
		assertEquals("Testing Current Fuel", 40, testingLargeCar.getCurrentTank());
		
		testingLargeCar.setCurrentFuel(0);
		
		assertEquals("Adding more fuel than tank's Capacity", 60, testingLargeCar.fuelToAdd(999));
		
		assertEquals("Testing current fuel amount after overfueling", 60, testingLargeCar.getCurrentTank());
		
		testingLargeCar.setCurrentFuel(testingLargeCar.getMaxTank());
		//Litre Consumption and Distance Driven
		assertEquals("Testing Fuel used", 1, testingLargeCar.drivingDistance(10));	
		assertEquals("Testing Fuel used", 3, testingLargeCar.drivingDistance(30));
		assertEquals("Testing Fuel used", 5, testingLargeCar.drivingDistance(50));
		assertEquals("Testing Fuel used", 7, testingLargeCar.drivingDistance(80));
		}
}
