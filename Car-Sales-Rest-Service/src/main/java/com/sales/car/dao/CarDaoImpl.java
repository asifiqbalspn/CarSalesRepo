package com.sales.car.dao;


import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sales.car.bean.CarBean;
import com.sales.car.model.TblCar;

/**
 * <h1>CarDaoImpl</h1>
 * 
 * This class implements methods of CarDao Interface
 * 
 * @author Asif Iqbal
 * @category Implementation class
 * @version 1.0.0
 * @since July 2016
 *
 */
@Repository
public class CarDaoImpl implements CarDao
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

	
	
	@SuppressWarnings("unchecked")
	@Override
	public List<TblCar> listCars() {
		// TODO Auto-generated method stub
		
		/*
		 * session - Hibernate Session Object 
		 * Transaction - Hibernate Transaction Object
		 * List - TblCar Object List
		 */
		
		Session session=null;
		Transaction transaction=null;
		Criteria criteria=null;
		List<TblCar> cars=null;
		try
		{	// when sessionfactory is not null
			if(sessionFactory!=null)
			{	// craete session object
				session = sessionFactory.openSession();
			}
			
			// when session is not null
			if(session!=null)
			{	// create criteria object get TblCar Objects List
				criteria = session.createCriteria(TblCar.class);
				// create transaction object to begin transatcion
				transaction = session.beginTransaction();
			}
			//when criteria is not null
			if(criteria!=null)
			{	// execute it and get list of TblCar Objects
				cars = (List<TblCar>)criteria.list();
			}
			
			if(transaction!=null)
			{
				// commit transaction
				transaction.commit();
			}
		}
		catch(Exception ex)
		{
			if(transaction!=null)
			{	// When transaction failed rollback everything
				transaction.rollback();
			}
			ex.printStackTrace();
		}
		finally
		{
			if(session!=null)
			{	// close session object
				session.close();
			}
		}
		return cars;
	}

	

	@Override
	public TblCar getCar(Long carId) {
		/*
		 * session - Hibernate Session Object 
		 * Transaction - Hibernate Transaction Object
		 * car - TblCar Object
		 */
		
		Session session=null;
		Transaction transaction=null;
		TblCar car=null;
		
		
		try
		{	//When SessionFactory is not null
			if(sessionFactory!=null)
			{	// Create Session Object
				session = sessionFactory.openSession();
			}
			
			// When session is not null
			if(session!=null)
			{	// Start the Hibernate Transaction by creating Transaction Object
				transaction = session.beginTransaction();
			}
			
			// When Transaction begin successfully
			if(transaction!=null)
			{
				// Get the TblCar object by using database identity
				car = (TblCar)session.get(TblCar.class, carId);
			
				// commit the transaction
				transaction.commit();
			}
		}
		// When any exception occurs at run time catch block code execute
		catch(Exception ex)
		{
			if(transaction!=null)
			{	// When transaction failed rollback everything
				transaction.rollback();
			}
			ex.printStackTrace();
		}
		finally
		{
			// close session object
			if(session!=null)
			{
				session.close();
			}
		}
		return car;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<String> getCarsMake() {
		
		/*
		 * session - Hibernate Session Object 
		 * Transaction - Hibernate Transaction Object
		 * carsMake - List of TblCar Objects
		 */
		
		Session session=null;
		Transaction transaction=null;
		//List of Cars Title
		List<String> carsMake=null;
		try
		{	//When SessionFactory is not null
			if(sessionFactory!=null)
			{	// create session object
				session = sessionFactory.openSession();
			}
			// When session is not null
			if(session!=null)
			{	// Start the Hibernate Transaction by creating Transaction Object
				transaction = session.beginTransaction();
			}
			// When Transaction begin successfully
			if(transaction!=null)
			{	// prepare and execute the query
				carsMake = (List<String>)session.createQuery("select tc.make from TblCar tc").list();
				
				// commit transaction
				transaction.commit();
			}
		}
		catch(Exception ex)
		{
			if(transaction!=null)
			{	// When transaction failed rollback everything
				transaction.rollback();
			}
			ex.printStackTrace();
		}
		finally
		{
			if(session!=null)
			{	// close session object
				session.close();
			}
		}
		return carsMake;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<String> getCarModels(String make) {
		
		/*
		 * session - Hibernate Session Object 
		 * Transaction - Hibernate Transaction Object
		 * carModels - String type List of car models name
		 */
		
		Session session=null;
		Transaction transaction=null;
		//List of Cars Title
		List<String> carModels=null;
		
		
		try
		{	// when sessionFactory is not null
			if(sessionFactory!=null)
			{	// Create sesison object
				session = sessionFactory.openSession();
			}
			//when session is not null
			if(session!=null)
			{	// create transaction object to begin new transaction
				transaction = session.beginTransaction();
			}
			//when transaction begin successfully
			if(transaction!=null)
			{
				// prepare and execute Hibernate Query and get the records
				carModels = (List<String>)session.createQuery("select tc.model from TblCar tc where tc.make=:make").setParameter("make", make).list();
				
				// commit transaction
				transaction.commit();
			}
		}
		catch(Exception ex)
		{	
			if(transaction!=null)
			{	// When transaction failed rollback everything
				transaction.rollback();
			}
			ex.printStackTrace();
		}
		finally
		{
			//when session is not null
			if(session!=null)
			{	// close session object
				session.close();
			}
		}
		return carModels;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<TblCar> getSearchedCars(CarBean bean)
	{
		/*
		 * session - Hibernate Session Object 
		 * transaction - Hibernate Transaction Object
		 * cars - List of  TblCar Objects
		 * make - query parameter
		 * model - query parameter
		 * min - query parameter
		 * max - query parameter
		 */
		
		
		Session session=null;
		
		Transaction transaction=null;
		
		List<TblCar> cars=null;
	
		
		//Declaring Query Parameters
		String make="";
		String model="";
		String min="";
		String max="";
		
		
		//When User selected any Car
		if(!bean.getMake().equalsIgnoreCase("Any Make"))
		{
			// write the query condition
			make = " make='"+bean.getMake()+"'";
		}
		
		//When User selected any Car model
		if(!bean.getModel().equalsIgnoreCase("Any Model"))
		{
			// write the query condition
			model = " and model='"+bean.getModel()+"'";
		}
		
		//When user selected min price for the car and make
		if(bean.getMin()>0 && !bean.getMake().equalsIgnoreCase("Any Make"))
		{	// write the query condition
			min =" and price>="+ bean.getMin();
		}
		
		//When user selected min price for the car only
		else if(bean.getMin()>0)
		{	// write the query condition
			min =" price>="+ bean.getMin();
		}
		
		//When user selected max price
		if(bean.getMax()>0 && !bean.getMake().equalsIgnoreCase("Any Make") && bean.getMin()>0)
		{	// write the query condition
			max = " and price<=" + bean.getMax();
		}
		// when user selected max price and min price only
		else if(bean.getMax()>0 && bean.getMin()>0)
		{
			max = " and price<=" + bean.getMax();
		}
		// when user selected max price only
		else if(bean.getMax()>0)
		{
			max = " price<=" + bean.getMax();
		}
		
	
		// prepare the query when user  not selected any search option
		String query="from TblCar";
		
		// prepare the query when user selected search options
		if(!bean.getMake().equalsIgnoreCase("Any Make") || !bean.getModel().equalsIgnoreCase("Any Model") || bean.getMin()>0 || bean.getMax()>0)
		{
			query = "from TblCar Where" + make + model + min + max;
		}
		
		try
		{
			
			// when sessionfactory is not null
			if(sessionFactory!=null)
			{	// create the session object
				session = sessionFactory.openSession();
			}
			// when session is not null
			if(session!=null)
			{	// create the transaction object to begin new transaction
				transaction = session.beginTransaction();
			}
			// when transaction is not null
			if(transaction!=null)
			{	// execute the query and collect the records
				cars = (List<TblCar>)session.createQuery(query).list();
				
				// commit the transaction
				transaction.commit();
			}
		}
		catch(Exception ex)
		{
			if(transaction!=null)
			{	// When transaction failed rollback everything
				transaction.rollback();
			}
			ex.printStackTrace();
		}
		finally
		{
			if(session!=null)
			{	// close session object
				session.close();
			}
		}
		return cars;
	}



}
