package com.sales.car.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.sales.car.bean.CarBean;
import com.sales.car.bean.CarId;
import com.sales.car.model.TblCar;
import com.sales.car.service.CarService;
import com.sales.car.util.Utility;

/**
 * <h1>CarController</h1>
 * 
 * CarController is a Rest Controller which handles client requests, process the client requests and return the response to the client
 * It communicates with Service Layer (CarService) to process the client request.
 * 
 * 
 * @author Asif Iqbal
 * @category Controller
 * @version 1.0
 * @since July 2016
 *
 */
@RestController
public class CarController 
{

	/*
	 * carService -   Service Layer class which contains methods to communicate with Dao Layer
	 *  utility - Utility Class which contains utility methods
	 */
	
@Autowired
private CarService carService; 

// Create Utility Class Object
private Utility utility = new Utility(); 


// Setters and Getters
	public Utility getUtility() {
	return utility;
}

public void setUtility(Utility utility) {
	this.utility = utility;
}

	public CarService getCarService() {
	return carService;
}

public void setCarService(CarService carService) {
	this.carService = carService;
}


	 
	 /**
	  * 
	  * This method handles Http Get request and is used to get the List of cars by communicating with service layer method.
	  * It also using utility method to generate List of CarBean objects and return to the user
	  * 
	  * @author Asif Iqbal
	  * @param none
	 *  @return List - List of CarBean Objects
	 *  
	 */
	@RequestMapping(value="/cars", method = RequestMethod.GET) 
	 public List<CarBean> listCars() {  
		 
		// get the list of cars for sale
		List<TblCar> tblCars = carService.listCars();
		
		// Preapre List of CarBean
		List<CarBean> carBeans = utility.prepareListofBean(tblCars);
		 
		return carBeans;
	 }  
	 
	
	 /**
	  * 
	  * This method handles Http Get request and is used to get the List of Cars Name or title by communicating with service layer method.
	  * This method call on home page loading of Web Application to get the list of all available cars name to user for car searching
	  * 
	  * 
	  * @param none
	 *  @return List - List of Cars Name or title
	 *  
	 */
	 
	 @RequestMapping(value="/carsmake", method = RequestMethod.GET) 
	 public List<String> listCarsMake() {  
		
		 // get the list of cars name for sale
		 List<String> carsMake=carService.getCarsMake();
		 
		 return carsMake;
	 }  
	 
	 

	 /**
	  * This method handles Http POST request and is used to get the List of Car Model Names or titles by communicating with service layer method.
	  * This method call on home page when user select car make and it return all available models of that car.
	  * 
	  * @param make - Car Name
	  * @return carsModel - String type List of Car Models Name
	  */
	@RequestMapping(value="/carmodels", method = RequestMethod.POST) 
	 public List<String> listCarModels(@RequestParam("make") String make)
	 {  
		 
		 
		 List<String> carsModel=null; // It holds list of selected car models names
		 
		 // When car make is not Any Make
		 if(!make.equalsIgnoreCase("Any Make"))
		 {
			 // get the car models name list
			 carsModel=carService.getCarModels(make);
		 }
		 return carsModel;
	 } 
	 
	 
	 /**
	 * This method handles Http POST request and is used to get the List CarBean Objects by communicating with service layer method.
	 * This method call on home page when user search for car.
	 * @param carBean
	 * @return - List of CarBean Objects
	 */
	@RequestMapping(value = "/searchcars", method = RequestMethod.POST)
	 public @ResponseBody List<CarBean> getSearchedCars(@RequestBody CarBean carBean) 
	 {
		 // get the List of TblCar objects and prepare List of CarBean for the response
		 return utility.prepareListofBean(carService.getSearchedCars(carBean));
	 }
	 
	 /**
	 * This method handles Http POST request and is used to get the Car Details by communicating with service layer method.
	 * This method call when user want to view details of any car.
	 * 
	 * @param carId
	 * @return carBean - CarBean Object which hold car details
	 */
	@RequestMapping(value = "/cardetails", method = RequestMethod.POST)
	 public CarBean getCarDetails(@RequestBody CarId carId) 
	 {
		// get the car details by passing unique car id to service layer
		TblCar tblCar = carService.getCar(carId.getId());
		
		// prepare CarBean object
		CarBean carBean = utility.prepareBean(tblCar);

		//return carBean Object
		 return carBean;
	 }
	 


}
