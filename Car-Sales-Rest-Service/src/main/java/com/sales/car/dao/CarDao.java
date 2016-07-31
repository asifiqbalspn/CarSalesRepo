package com.sales.car.dao;

import java.util.List;

import com.sales.car.bean.CarBean;
import com.sales.car.model.TblCar;

/**
 * <h1>CarDao</h1>
 * 
 * Provides Dao methods for TblCar (Model) Objects
 * 
 * 
 * @author Asif Iqbal
 * @category interface
 * @version 1.0
 * @since July 2016
 *
 */

public interface CarDao 
{

/**
 * <b>getCar(Long carId)</b><br></br>
 * This method of Dao class get the TblCar object from database by using its identity.
 * 
 * @param carId
 * @return TblCar object
 */
public TblCar getCar(Long carId);

/**
 * <b>getCarsMake()</b><br></br>
 * This method get the List of available Cars Name from Database.
 * @param non
 * @return List - List of String type
 */
public List<String> getCarsMake();

/**
 * This method get the List all maodels of given make
 * @param make
 * @return List - List of String type
 */
public List<String> getCarModels(String make);

/**
 * <b>getSearchedCars(CarBean)</b><br></br>
 * This method get the List of TblCar Objects based on user criteria
 * @param bean
 * @return List - List of TblCar objects
 */
public List<TblCar>  getSearchedCars(CarBean bean);

/**
 * <b>listCars()</b><br></br>
 * This method get the List of TblCar Objects from database table
 * @param none
 * @return List - List of TblCar Objects
 */
public List<TblCar> listCars();

}
