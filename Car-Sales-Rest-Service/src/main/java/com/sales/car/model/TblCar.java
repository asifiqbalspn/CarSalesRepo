package com.sales.car.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * <h1>TblCar</h1>
 * 
 * POJO/Model class mapped to Database Table
 * 
 * @author Asif Iqbal
 * @category POJO/Model Class
 * @version 1.0.0
 * @since july 2016
 *
 */
@Entity
@Table(name="tbl_car")
public class TblCar implements Serializable
{

	private static final long serialVersionUID = 1L;

@Id
@Column(name="car_id", nullable=false)
@GeneratedValue(strategy=GenerationType.IDENTITY)
private Long carId;
@Column(name="make")
private String make;
@Column(name="model")
private String model;
@Column(name="color")
private String color;
@Column(name="price")
private Integer price;
@Column(name="location")
private String location;
@Column(name="year")
private String year;
@Column(name="kilometers")
private String kilometers;
@Column(name="transmission")
private String transmission;
@Column(name="body")
private String body;
@Column(name="interior_color")
private String interiorColor;


public TblCar() {
	super();
	// TODO Auto-generated constructor stub
}





public TblCar(Long carId, String make, String model, String color, Integer price, String location, String year,
		String kilometers, String transmission, String body, String interiorColor) {
	super();
	this.carId = carId;
	this.make = make;
	this.model = model;
	this.color = color;
	this.price = price;
	this.location = location;
	this.year = year;
	this.kilometers = kilometers;
	this.transmission = transmission;
	this.body = body;
	this.interiorColor = interiorColor;
}





public String getKilometers() {
	return kilometers;
}





public void setKilometers(String kilometers) {
	this.kilometers = kilometers;
}





public String getTransmission() {
	return transmission;
}





public void setTransmission(String transmission) {
	this.transmission = transmission;
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

public Long getCarId() {
	return carId;
}

public void setCarId(Long carId) {
	this.carId = carId;
}

public Integer getPrice() {
	return price;
}

public void setPrice(Integer price) {
	this.price = price;
}



}
