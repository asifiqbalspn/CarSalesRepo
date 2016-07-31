package com.sales.car.service;



import com.sales.car.bean.CustomerEnquiryBean;

/**
 * <h1>CustomerEnquiryService</h1>
 * 
 * This interface provides service Layer methods.
 * 
 * @author Asif Iqbal
 * @category interface
 * @version 1.0.0
 * @since July 2016
 *
 */
public interface CustomerEnquiryService 
{

	
	/**
	 * <b>addCustomerEnquiry(CustomerEnquiryBean)</b>
	 * 
	 * This method takes CustomerEnquiryBean object as an argument and
	 * call DAO method to store Customer enquiry information in database.
	 * 
	 * @param customerEnquiryBean
	 * @return String - status
	 */
	public String addCustomerEnquiry(CustomerEnquiryBean customerEnquiryBean);

}
