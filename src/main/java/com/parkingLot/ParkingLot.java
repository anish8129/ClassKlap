package com.parkingLot;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.regex.Pattern;
import java.util.TreeMap;
import java.util.TreeSet;

import com.parkingLot.constants.CarNumbersMapper;
import com.parkingLotPojo.Car;

public class ParkingLot {
	private TreeSet<Integer> parkingSlots;
	private TreeMap<Integer, Car> parkedCars = new TreeMap<>();
	private Map<String,Car> isCarExist= new HashMap<String,Car>();
	private int sizeOfParkingArea;

	public TreeSet<Integer> getParkingSlots() {
		return parkingSlots;
	}

	public void setParkingSlots(TreeSet<Integer> parkingSlots) {
		this.parkingSlots = parkingSlots;
	}

	public TreeMap<Integer, Car> getParkedCars() {
		return parkedCars;
	}

	public void setParkedCars(TreeMap<Integer, Car> parkedCars) {
		this.parkedCars = parkedCars;
	}

	public Map<String, Car> getIsCarExist() {
		return isCarExist;
	}

	public void setIsCarExist(Map<String, Car> isCarExist) {
		this.isCarExist = isCarExist;
	}



	public int getSizeOfParkingArea() {
		return sizeOfParkingArea;
	}

	public void setSizeOfParkingArea(int sizeOfParkingArea) {
		this.sizeOfParkingArea = sizeOfParkingArea;
	}

	
	
	//Creating A Parking Lot with a given Size
	//input int: size of the parking lot
	public String createParkingLot(int size) {
		if (size <= 0)
			return "Parking Lot cannot be created";
		else {
			parkingSlots = new TreeSet<Integer>();
			this.setSizeOfParkingArea(size);
		for (int i = 1; i <= size; i++)
			parkingSlots.add(i);
		return "Parking Lot is Created";
		}
	}

	//Function to allot a slot to a Car.
	//input String: registration number of the car
	//input String: color of the car
	public String parkACar(String regNumber,String color) {
		if(!isCarExist.containsKey(regNumber)) {
			Object object=Car.getCarInstance(regNumber, color);
			if (object instanceof Car) {

				if (this.parkedCars.size() < this.sizeOfParkingArea) {
					int slotNumber = this.parkingSlots.first();
					this.parkedCars.put(slotNumber, (Car) object);
					this.parkingSlots.remove(slotNumber);
					this.isCarExist.put(regNumber, (Car)object);
					return "Allocated slot number: " + slotNumber;
				}

				else {
					return "Sorry, parking lot is full";
				}

			} else
				return object.toString();
		}
		else
			return "Car already exist with this "+regNumber+" number in parking slot";
	}

	//Function to remove a car from a slot
	//input int: slotNumber of the parking lot
	public String removingACarFromASlot(int slotNumber) {

		if (this.parkedCars.containsKey(slotNumber)) {
			this.isCarExist.remove(this.parkedCars.get(slotNumber).getCarNumber());
			this.parkedCars.remove(slotNumber);
			this.parkingSlots.add(slotNumber);
			
			return "Slot number " + slotNumber + " is free";
		}

		else if (this.parkingSlots.contains(slotNumber)) {
			return "Slot is already free";
		}

		else {
			return "Slot number does not exist";
		}
	}
	
	
	//Function to list the registration numbers of cars of same color.
	//input String: color of the car.
	public String regNumberOfCarForAColor(String color) {
		String s="";
		if(this.parkedCars.size()>0) {
			Iterator<Entry<Integer, Car>> iterator = this.parkedCars.entrySet().iterator();
			while (iterator.hasNext()) {
				Map.Entry<Integer, Car> element = (Map.Entry<Integer, Car>) (iterator.next());
				Car car = element.getValue();
				if (car.getColor().equalsIgnoreCase(color))
					s += car.getCarNumber() + ", ";
			}
		}
		else
			s= "Not found  ";
		return s.substring(0, s.length() - 2);
	}

	//Function to list the slot numbers of cars of same color.
	//input String: color of the car
	public String slotNumberOfCarForAColor(String color) {
		String s="";
		if(this.parkedCars.size()>0) {
			Iterator<Entry<Integer, Car>> iterator = this.parkedCars.entrySet().iterator();
			while (iterator.hasNext()) {
				Map.Entry<Integer, Car> element = (Map.Entry<Integer, Car>) (iterator.next());
				Car car = element.getValue();
				if (car.getColor().equalsIgnoreCase(color))
					s += element.getKey() + ", ";
			}
		}
		else
			s= "Not found  ";
		return s.substring(0,s.length()-2);
	}

	//Function which returns the slot number of a car.
	//input String : Registration number of the car.
	public String slotNumberOfCarForRegNumber(String regNumber){
		
		if (!Pattern.matches("[A-z]{2}-\\d{2}-[A-Z]{2}-\\d{4}",regNumber))
			return "Wrong Format of Registration Number";
		
		else if (Pattern.matches("[A-z]{2}-\\d{2}-[A-Z]{2}-\\d{4}",regNumber)
				&&!CarNumbersMapper.carNumbers.containsKey(regNumber.split("-")[0]))
			return "This Car Number does not belong to INDIA ";
		
		else if(this.parkedCars.size()>0) {
			Iterator<Entry<Integer, Car>> iterator = this.parkedCars.entrySet().iterator();
			while (iterator.hasNext()) {
				Map.Entry<Integer, Car> element = (Map.Entry<Integer, Car>) (iterator.next());
				Car car = element.getValue();
				if (car.getCarNumber().equals(regNumber))
					return element.getKey().toString();
				}
		}
		return "Not found";
	}

	//Function which list the car details present in the Parking lot
	public String status() {
		String s="";
		if(this.parkedCars.size()>0) {
			Iterator<Entry<Integer, Car>> iterator = this.parkedCars.entrySet().iterator();
			s="Slot No. Registration No Color\n";
			while(iterator.hasNext()) {
				Map.Entry<Integer, Car> element=(Map.Entry<Integer, Car>)(iterator.next());
				s+=element.getKey()+" "+element.getValue().getCarNumber()+" "+element.getValue().getColor()+"\n";
			}
		}
		else
			s="No Car found in the Parking Slot";
		return s;
	}
}