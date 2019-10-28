package com.parkingLot.test;

import static org.junit.Assert.assertEquals;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import com.parkingLot.ParkingLot;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ParkingLotTest {

	public static ParkingLot pl = new ParkingLot();

	
	//Test the creation of parking lot with negative scenario
	@Test
	public void test01() {

		assertEquals("Parking Lot cannot be created", pl.createParkingLot(0));
	}

	//Test the creation of parking lot with
	@Test
	public void test02() {

		assertEquals("Parking Lot is Created", pl.createParkingLot(2));
	}

	//Test the negative Scenario
	// when the format of car number is not proper
	@Test
	public void test03() {

		assertEquals("Wrong Format of Registration Number", pl.parkACar("KA-02-JV-348", "White"));
	}
	
	//Test the parking functionality
	@Test
	public void test04() {

		assertEquals("Allocated slot number: 1", pl.parkACar("KA-01-JV-3489", "White"));
		assertEquals("Allocated slot number: 2", pl.parkACar("KA-02-JV-3487", "White"));
	}
	
	//Test the parking functionality
	//when the car is already present in the parking lot
	@Test
	public void test05() {

		assertEquals("Car already exist with this KA-01-JV-3489 number in parking slot", pl.parkACar("KA-01-JV-3489", "White"));
	}
	
	
	//Test the parking functionality
	//when the car does not belong to India
	@Test
	public void test06() {

		assertEquals("This Car does not belong to INDIA ", pl.parkACar("XA-02-JV-3489", "White"));
	}
	
	@Test
	public void test07() {

		assertEquals("Slot No. Registration No Color\n1 KA-01-JV-3489 White\n2 KA-02-JV-3487 White\n", pl.status());
	}

	//Testing when Parking Lot have some cars
	@Test
	public void test08() {

		assertEquals("KA-01-JV-3489, KA-02-JV-3487", pl.regNumberOfCarForAColor("white"));
	}
	
	//Testing scenario when Parking have some cars
	@Test
	public void test09() {

		assertEquals("1, 2", pl.slotNumberOfCarForAColor("White"));
	}
	
	//Testing when Parking Lot have cars
	@Test
	public void test10() {

		assertEquals("1", pl.slotNumberOfCarForRegNumber("KA-01-JV-3489"));
	}
	
	//Test the parking functionality
	//when the car parking slot is full
	@Test
	public void test11() {

		assertEquals("Sorry, parking lot is full", pl.parkACar("KA-12-JV-4489", "White"));
	}
	
	
	//Test removing a car from a slot
	@Test
	public void test12() {
		assertEquals("Slot number 1 is free", pl.removingACarFromASlot(1));
		assertEquals("Slot number 2 is free", pl.removingACarFromASlot(2));
	}
		
	//Test negative scenario
	//when parking slot is already free
	@Test
	public void test13() {

		assertEquals("Slot is already free", pl.removingACarFromASlot(1));
	}
	
	//Test negative scenario
	//when parking slot does not even exist
	@Test
	public void test14() {

		assertEquals("Slot number does not exist", pl.removingACarFromASlot(7));
	}
	//Test to check the status of the Parking Slot
	@Test
	public void test15() {

		assertEquals("No Car found in the Parking Slot", pl.status());
	}
	
	//Testing Negative scenario when Parking Lot is empty
	@Test
	public void test16() {

		assertEquals("Not found", pl.regNumberOfCarForAColor("white"));
	}
	
	//Testing Negative scenario when Parking Lot is empty
	@Test
	public void test17() {

		assertEquals("Not found", pl.slotNumberOfCarForAColor("White"));
	}
	
	//Testing Negative scenario when Parking Lot is empty
	@Test
	public void test18() {

		assertEquals("Not found", pl.slotNumberOfCarForAColor("KA-13-11-12AC"));
	}
	//Testing Negative scenario when Registration Number is Wrong
	@Test
	public void test19() {

		assertEquals("Wrong Format of Registration Number", pl.slotNumberOfCarForRegNumber("KA-13-11-12AC"));
	}
	//Testing Negative scenario when Car does not belong to India
	@Test
	public void test20() {

		assertEquals("This Car Number does not belong to INDIA ", pl.slotNumberOfCarForRegNumber("XA-13-AC-1234"));
	}
}
