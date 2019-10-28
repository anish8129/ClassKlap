package com.parkingLotPojo;

import java.util.regex.Pattern;

import com.parkingLot.constants.CarNumbersMapper;

public class Car {

	private String carNumber;
	private String color;

	public String getCarNumber() {
		return carNumber;
	}

	public void setCarNumber(String carNumber) {
		this.carNumber = carNumber;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}
	
	
	
	public Car(String carNumber, String color) {
		super();
		this.carNumber = carNumber;
		this.color = color;
	}

	public static Object getCarInstance(String regNo,String color) {
		if (!Pattern.matches("[A-z]{2}-\\d{2}-[A-Z]{2}-\\d{4}",regNo))
			return "Wrong Format of Registration Number";
		
		else if (Pattern.matches("[A-z]{2}-\\d{2}-[A-Z]{2}-\\d{4}",regNo) &&
				!CarNumbersMapper.carNumbers.containsKey(regNo.split("-")[0]))
			return "This Car does not belong to INDIA ";
		else {
			return new Car(regNo,color);
		}		

	}
}