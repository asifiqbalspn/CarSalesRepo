package com.sales.car.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sales.car.bean.CustomerEnquiryBean;
import com.sales.car.service.CustomerEnquiryService;

/**
 * <h1>CustomerEnquiryController</h1>
 * Rest Controller which handles client request and communicate with service layer to process it.
 * This controller handles client car enquiry request.
 * It contains a method which get request when user submit car enquiry form and it call service layer methods to process it.
 * 
 * 
 * @author Asif Iqbal
 * @category Controller
 * @version 1.0
 * @since July 2016
 *
 */
@RestController
public class CustomerEnquiryController 
{

/*
 * customerEnquiryService - Service Layer class object which injected in controller by spring container
 */
	
@Autowired
private CustomerEnquiryService customerEnquiryService;

public CustomerEnquiryService getCustomerEnquiryService() {
	return customerEnquiryService;
}

public void setCustomerEnquiryService(CustomerEnquiryService customerEnquiryService) {
	this.customerEnquiryService = customerEnquiryService;
}


/**
 * <b>saveCustomerEnquiry</b>
 * This method handles client post request and it call service layer method to process the client submitted data.
 * 
 * @param customerEnquiryBean
 * @return status - form data inserted or failed
 */
@RequestMapping(value = "/saveEnquiryInfo", method = RequestMethod.POST)
public String saveCustomerEnquiry(@RequestBody CustomerEnquiryBean customerEnquiryBean) 
{
	// call customerEnquiryService method to process the client submitted data
	String status = customerEnquiryService.addCustomerEnquiry(customerEnquiryBean); 
	return status;

}

}
