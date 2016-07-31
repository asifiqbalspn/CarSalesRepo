package com.sales.car.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sales.car.bean.CustomerEnquiryBean;
import com.sales.car.model.TblCar;
import com.sales.car.model.TblCustomer;
import com.sales.car.model.TblEnquiry;

/**
 * <h1>CustomerEnquiryDaoImpl</h1>
 * 
 * provides implementation of CustomerEnquiryDao interface
 * 
 * @author Asif Iqbal
 * @category Implementation Class
 * @version 1.0.0
 * @since July 2016
 *
 */
@Repository
public class CustomerEnquiryDaoImpl implements CustomerEnquiryDao
{
	/*
	 * sessionFactory - Hibernate SessionFactory Object
	 * 	
	 */
	
	@Autowired
	private SessionFactory sessionFactory;


		public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public String addCustomerEnquiry(CustomerEnquiryBean customerEnquiryBean) {
		
		/*
		 * session - Hibernate Session Object 
		 * Tx - Hibernate Transaction Object
		 * status - status of database operation
		 */
		
		Session session=null;
	
		Transaction tx = null;
		
	
		String status="saved";
		
		try
		{
			//Create and initialize TblCustomer Object for saving customer information
			TblCustomer customer = new TblCustomer();
			// set customer email id
			customer.setEmail(customerEnquiryBean.getEmail());
			// set customer name
			customer.setName(customerEnquiryBean.getName());
			// set customer phone number
			customer.setPhoneNumber(customerEnquiryBean.getPhone());
			
			// when sessionfactory is not null
			if(sessionFactory!=null)
			{	// create session object
				session = sessionFactory.openSession();
			}
			
			//when session is not null
			if(session!=null)
			{	// create transaction object to begin new transaction
				tx = session.beginTransaction();
			}
			
			// when transaction is not null
			if(tx !=null)
			{
				// save Customer Object
				session.save(customer);
				
				
				
				// get TblCar Object for which user enquired
				TblCar car = (TblCar)session.get(TblCar.class, customerEnquiryBean.getCarId());
				
				// Create and initialised TblEnquiry Object
				TblEnquiry enquiry = new TblEnquiry();
				//set TblCar Object
				enquiry.setCar(car);
				// set TblCustomer object
				enquiry.setCustomer(customer);
				// set user message
				enquiry.setMessage(customerEnquiryBean.getMessage());
				
				//Saving TblEnquiry Object
				session.save(enquiry);
				
				
				// commit transaction
				
				tx.commit();
				
			}
			
		}
		//Handle exception at run time
		catch(Exception ex)
		{
			//if any exception occurs while saving above objects then rollback
			if(tx!=null)
			{
				// When transaction failed rollback everything
				tx.rollback();
			}
			
			// set status to failed
			status="failed";
			ex.printStackTrace();
		}
		finally
		{
			// Close Session
			if(session!=null)
			{
				session.close();
			}
		}
		
		// return status
		return status;
	}


	

}
