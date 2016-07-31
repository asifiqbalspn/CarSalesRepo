package com.sales.car.service;




import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.sales.car.bean.CustomerEnquiryBean;
import com.sales.car.dao.CustomerEnquiryDao;

/**
 * <h1>CustomerEnquiryServiceImpl</h1>
 * 
 * This class implements CustomerEnquiryService interface
 * 
 * @author Asif Iqbal
 * @category Implementation Class
 * @version 1.0.0
 * @since July 2016
 *
 */
@Service
@Transactional(propagation=Propagation.REQUIRED, readOnly=false)
public class CustomerEnquiryServiceImpl implements CustomerEnquiryService
{

	/*
	 * customerEnquiryDao - CustomerEnquiryDao class object
	 * 
	 */
	
@Autowired
private CustomerEnquiryDao customerEnquiryDao;


// getter method
public CustomerEnquiryDao getCustomerEnquiryDao() {
	return customerEnquiryDao;
}

// setter method
public void setCustomerEnquiryDao(CustomerEnquiryDao customerEnquiryDao) {
	this.customerEnquiryDao = customerEnquiryDao;
}

@Override
@Transactional(propagation=Propagation.REQUIRED, readOnly=false)
public String addCustomerEnquiry(CustomerEnquiryBean customerEnquiryBean) {
	
	// Call DAO class method to save Customer Enquiry details in database tables
		return customerEnquiryDao.addCustomerEnquiry(customerEnquiryBean);
	
}



	
	
}
