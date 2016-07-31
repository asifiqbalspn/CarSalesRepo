package com.sales.car.dao;



import com.sales.car.bean.CustomerEnquiryBean;


/**
 * <h1>CustomerEnquiryDao</h1>
 * provides Dao methods for TblCustomerEnquiry Objects
 * 
 * @author Asif Iqbal
 * @category Interface
 * @version 1.0.0
 * @since July 2016
 *
 */
public interface CustomerEnquiryDao 
{

/**
 * <b>addCustomerEnquiry(CustomerEnquiryBean)</b><br>
 * add TblCustomer and TblEnquiry objects in database tables
 * 
 * @param customerEnquiryBean
 * @return String - status of database operation
 */
public String addCustomerEnquiry(CustomerEnquiryBean customerEnquiryBean);


}
