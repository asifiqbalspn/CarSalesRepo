package com.sales.car.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * <h1>TblEnquiry</h1>
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
@Table(name="tbl_enquiry")
public class TblEnquiry implements Serializable
{

/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
@Id	
@Column(name="id")	
@GeneratedValue(strategy=GenerationType.IDENTITY)
private Long id;
@Column(name="message")
private String message;

@ManyToOne(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
@JoinColumn(name="car_id")
private TblCar car;

@ManyToOne(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
@JoinColumn(name="customer_id")
private TblCustomer customer;



public TblEnquiry() {
	super();
	// TODO Auto-generated constructor stub
}



public TblEnquiry(Long id, String message, TblCar car, TblCustomer customer) {
	super();
	this.id = id;
	this.message = message;
	this.car = car;
	this.customer = customer;
}



public Long getId() {
	return id;
}



public void setId(Long id) {
	this.id = id;
}



public String getMessage() {
	return message;
}



public void setMessage(String message) {
	this.message = message;
}



public TblCar getCar() {
	return car;
}



public void setCar(TblCar car) {
	this.car = car;
}



public TblCustomer getCustomer() {
	return customer;
}



public void setCustomer(TblCustomer customer) {
	this.customer = customer;
}




}
