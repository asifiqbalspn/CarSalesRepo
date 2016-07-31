package com.sales.car.service;

import java.util.List;

import com.sales.car.bean.CarBean;
import com.sales.car.model.TblCar;

/**
 * <h1>CarService</h1>
 * 
 * This is service Layer interface provide methods to interact with DAO Layer API'S
 * 
 * @author Asif Iqbal
 * @category interface
 * @version 1.0.0
 * @since July 2016
 *
 */
public interface CarService
{


	/**
	 * <b>listCars()</b><br></br>
	 * This method call the DAO class method to get all TblCar Objects.
	 * @param none
	 * @return List - List of TblCar Objects
	 */
	public List<TblCar> listCars();

	/**
	 * <b>getCar(Long carId)</b><br></br>
	 * This method call the DAO class method to get the TblCar object for given identity
	 * 
	 * @param carId
	 * @return TblCar object
	 */
	public TblCar getCar(Long carId);
	
	/**
	 * <b>getCarsMake()</b><br></br>
	 * This method call the DAO class method to get the list of all available cars name
	 * @param non
	 * @return List - List of String type
	 */
	public List<String> getCarsMake();
	

/**
 * <b>getSearchedCars(CarBean)</b><br></br>
 * This method call the DAO class method to get the List of car models for the given car make
 * @param make
 * @return List - List of String type
 */
	public List<String> getCarModels(String make);
	
	/**
	 * <b>getSearchedCars(CarBean)</b><br></br>
	 * This method call the DAO class method to get the list of Car Objects.
	 * It pass CarBean object as an argument to DAO method.
	 * CarBean argument contain information of Car search form which user submit
	 * @param bean
	 * @return List - List of TblCar objects
	 */
	public List<TblCar> getSearchedCars(CarBean bean);
	
}
