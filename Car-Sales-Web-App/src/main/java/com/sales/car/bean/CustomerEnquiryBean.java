package com.sales.car.bean;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

/**
 * <h1>CustomerEnquiryBean</h1>
 * This Java Bean class back the Car Enquiry form to create a CustomerEnquiry
 * 
 * @author Asif Iqbal
 * @category Bean
 * @version 1.0
 * @since July 2016
 *
 */
public class CustomerEnquiryBean
{

	/*
	* carId - unique identity of Object
	* name - name of the customer
	* email - email id of the customer
	* phone - contact number of the customer
	* message - Customer comments or enquiry message
	* 
	 */
	
	@NotNull
	private Long carId;

	@NotEmpty(message="Name is required")
	private String name;
	@NotEmpty(message="email is required")
	private String email;
	@NotEmpty(message="Phone No is required")
	private String phone;
	@NotEmpty(message="Message is required")
	private String message;
	public Long getCarId() {
		return carId;
	}
	public void setCarId(Long carId) {
		this.carId = carId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	

	
	
	
}
