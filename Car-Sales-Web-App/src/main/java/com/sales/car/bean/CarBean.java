package com.sales.car.bean;



/**
 * <h1>CarBean</h1>
 * This java bean class back the Car Details
 * 
 * @author Asif Iqbal
 * @category Bean
 * @version 1.0
 * @since july 2016
 * 
 *  
 */
public class CarBean {
	/*
	 * carId - unique identifier
	 * make - car name or title
	 * model - model name of the car
	 * colour - colour of the car
	 * price - price of the car
	 * location - location of the seller
	 * year - Model year
	 * min - min price of car for search
	 * max - max price of car for search
	 * kilometres - mileage
	 * transmission - gear box in cars
	 * body - body of car
	 * interiorColor - Interior colour of the car
	 * 
	 */
	private Long carId;

	private String make;
	
	private String model;

	private String color;
	
	private Integer price;

	private String location;
	
	private String year;
	
	private Integer min;
	private Integer max;
	
	private String kilometers;

	private String Transmission;
	
	private String body;
	
	private String interiorColor;
	
	
	

	public String getKilometers() {
		return kilometers;
	}

	public void setKilometers(String kilometers) {
		this.kilometers = kilometers;
	}

	public String getTransmission() {
		return Transmission;
	}

	public void setTransmission(String transmission) {
		Transmission = transmission;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public String getInteriorColor() {
		return interiorColor;
	}

	public void setInteriorColor(String interiorColor) {
		this.interiorColor = interiorColor;
	}

	public Long getCarId() {
		return carId;
	}

	public void setCarId(Long carId) {
		this.carId = carId;
	}

	public String getMake() {
		return make;
	}

	public void setMake(String make) {
		this.make = make;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public Integer getMin() {
		return min;
	}

	public void setMin(Integer min) {
		this.min = min;
	}

	public Integer getMax() {
		return max;
	}

	public void setMax(Integer max) {
		this.max = max;
	}
	
	
	
}
