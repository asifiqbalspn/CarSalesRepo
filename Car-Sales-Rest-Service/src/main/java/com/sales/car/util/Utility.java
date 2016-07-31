package com.sales.car.util;

import java.util.ArrayList;
import java.util.List;

import com.sales.car.bean.CarBean;
import com.sales.car.model.TblCar;

/**
 * <h1>Utility</h1>
 * 
 * This class provides methods for preparing Model, Bean Objects or List of objects
 * 
 * @author Asif Iqbal
 * @category Utility class
 * @version 1.0.0
 * @since July 2016
 *
 */
public class Utility {
	
	
	/**
	 * <b> prepareModel(CarBean)</b>
	 * This method takes carBean object as an argument and create TblCar(Model) object
	 * 
	 * @param carBean
	 * @return car - TblCar Object
	 */
	public TblCar prepareModel(CarBean carBean)
	{
		// Create TblCar Object
		TblCar car = new TblCar();
		
		// set the values of CarBean object to TblCar object
		car.setColor(carBean.getColor());
		car.setLocation(carBean.getLocation());
		car.setMake(carBean.getMake());
		car.setModel(carBean.getModel());
		car.setPrice(carBean.getPrice());
		car.setYear(carBean.getYear());
		car.setBody(carBean.getBody());
		car.setInteriorColor(carBean.getInteriorColor());
		car.setTransmission(carBean.getTransmission());
		car.setKilometers(carBean.getKilometers());
		
		// return TblCar object
		return car;
	}

	/**
	 * <b> prepareBean(TblCar)</b>
	 * This method takes TblCar object as an argument and prepare CarBean object
	 * 
	 * @param carBean
	 * @return bean - CarBean Object
	 */
	public CarBean prepareBean(TblCar car)
	{
		// create CarBean object
		CarBean bean = new CarBean();
		
		// set the values of TblCar object to CarBean object
		bean.setCarId(car.getCarId());
		bean.setColor(car.getColor());
		bean.setLocation(car.getLocation());
		bean.setMake(car.getMake());
		bean.setModel(car.getModel());
		bean.setPrice(car.getPrice());
		bean.setYear(car.getYear());
		bean.setBody(car.getBody());
		bean.setInteriorColor(car.getInteriorColor());
		bean.setTransmission(car.getTransmission());
		bean.setKilometers(car.getKilometers());
		
		// return CarBean Object
		return bean;
	}
	
	/**
	 * <b>prepareListofBean(List<TblCar>)</b>
	 * This method takes List of TblCar object as an argument and prepare List of CarBean objects
	 * 
	 * @param carBean
	 * @return bean - CarBean Object
	 */
	public List<CarBean> prepareListofBean(List<TblCar> tblCars){  
		
		// List of CarBean objects
		  List<CarBean> beans = null;  
		  
		  CarBean bean = null;  
		  
		  // when Objects are available in tblCars list
		  if(tblCars != null && !tblCars.isEmpty())
		  {
		   // Initialised List
		   beans = new ArrayList<CarBean>();
		   
		   // iterate TblCar List
		   for(TblCar car : tblCars)
		   {  
			// create new CarBean object   
		    bean = new CarBean();  
		    
		    // set the values of TblCar to CarBean
		    bean.setCarId(car.getCarId());
		    bean.setColor(car.getColor());
			bean.setLocation(car.getLocation());
			bean.setMake(car.getMake());
			bean.setModel(car.getModel());
			bean.setPrice(car.getPrice());
			bean.setYear(car.getYear());
			bean.setBody(car.getBody());
			bean.setInteriorColor(car.getInteriorColor());
			bean.setTransmission(car.getTransmission());
			bean.setKilometers(car.getKilometers());
			
			// add CarBean object to list
		    beans.add(bean);  
		   }  
		  }  
		  
		  // return CarBean objects list
		  return beans;  
	}
	
}
