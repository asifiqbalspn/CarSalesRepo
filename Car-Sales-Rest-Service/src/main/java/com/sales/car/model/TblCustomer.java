package com.sales.car.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * <h1>TblCustomer</h1>
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
@Table(name="tbl_customer")
public class TblCustomer implements Serializable
{
/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

@Id
@Column(name="customer_id")
@GeneratedValue(strategy=GenerationType.IDENTITY)
private Long customerId;

@Column(name="name")
private String name;
@Column(name="phone_number")
private String phoneNumber;

@Column(name="email_id")
private String email;


public TblCustomer() {
	super();
	// TODO Auto-generated constructor stub
}




public TblCustomer(Long customerId, String name, String phoneNumber, String email) {
	super();
	this.customerId = customerId;
	this.name = name;
	this.phoneNumber = phoneNumber;
	this.email = email;
}




public String getEmail() {
	return email;
}




public void setEmail(String email) {
	this.email = email;
}




public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getPhoneNumber() {
	return phoneNumber;
}
public void setPhoneNumber(String phoneNumber) {
	this.phoneNumber = phoneNumber;
}

public Long getCustomerId() {
	return customerId;
}
public void setCustomerId(Long customerId) {
	this.customerId = customerId;
}




}
