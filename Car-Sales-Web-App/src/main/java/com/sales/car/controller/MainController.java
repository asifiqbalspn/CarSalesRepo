package com.sales.car.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import com.sales.car.bean.CarBean;
import com.sales.car.bean.CarId;
import com.sales.car.bean.CustomerEnquiryBean;

/**
 * <h1>HomeController</h1>
 * 
 * This controller has a GET and a POST methods mapped to request urls.
 * 
 * @author Asif Iqbal
 * @category Controller
 * @version 1.0.0
 * @since July 2016
 *
 */
@Controller
public class MainController
{

	/**
	 *  The home() method return the index(home page) template. It includes CarBean in it's signature so we can
	 *  set it as an attribute in ModelAndView
	 * 
	 * @param - request parameter CarBean object
	 * @return home page of the application
	 */
	@RequestMapping("/")
	public ModelAndView home(@ModelAttribute("carBean") CarBean carBean)
	{
		
		if(carBean == null)
		{
			carBean = new CarBean();
		}
		
		/*	Prepare Model View Object
	   	  * 	add CarBean Object as an attribute to model and  view (index)
	   	  *  
	   	 */
			
		ModelAndView mav = new ModelAndView("/view/index","carBean", carBean);
		
		
		return mav;
	}
	
	/** 
	 * The searchCarsPage() method return the searchcars template. It has 2 arguments
	 * 	1. carBean - CarBean Object
	 * 	2. model - Model Object
	 * 
	 * handles client POST request.
	 * handles client search form submitted data.
	 * Access RestService by using RestTemplate class of Spring
	 * 
	 * 
	 * 
	 * 	@return   searchCars.html page for successful response
	 */
	@RequestMapping(value="/searchcars", method=RequestMethod.POST)
	public ModelAndView searchCarsPage(@ModelAttribute("carBean") CarBean carBean, Model model)
	{
		// URL of Rest Service
	    final String uri = "http://localhost:8080/CarSaleRest/searchcars";
	 
	    // Create RestTemplate Object to access rest service
	    RestTemplate restTemplate = new RestTemplate();
	    
	    // generate post request for Rest Service which return Array of CarBean Objects
	    CarBean[] objects = restTemplate.postForObject(uri, carBean, CarBean[].class);
	    
	    // Create ArrayList object
	    List<CarBean> carlist = new ArrayList<>();
	    
	    // when objects is not null or it  contain objects
	    if(objects!=null && objects.length>0)
	    {
	    	// Iterate CarBean array
	    	 for(CarBean car: objects)
	 	    {
	    		 // add CarBean Object to List
	 	    	carlist.add(car);	
	 	    }
	    	 /*Prepare Model View Object
	    	  * adding the model(CarBean) List and the view search cars
	    	  * 
	    	 */
	    		return new ModelAndView("/view/searchcars","carlist", carlist);
	    }
	    else
	    {
	    	 /*	Prepare Model View Object
	    	  * add (MSG) String Object as an attribute to model and  view (search cars)
	    	  *  
	    	 */
	    	return new ModelAndView("/view/searchcars","MSG", "Sorry! No matching car found.");
	    	
	    }
	}
	

	/** 
	 * 
	 * The carDetails() method return the cardetails template. It has 2 arguments
	 * 	1. carId - which comes as request parameter
	 *  2. model - Model object
	 * 	
	 * handles client POST request.
	 * run when client want to check the details of any car.
	 * Access RestService by using RestTemplate class of Spring.
	 * 
	 * 
	 * 	@return    cardetails.html page for successful response
	 */
	
	@RequestMapping(value="/cardetailspage", method=RequestMethod.POST)
	public ModelAndView carDetails(@RequestParam("carId") Long carId, Model model, HttpServletRequest request)
	{
		
				// URL of Rest Service
		 		final String uri = "http://localhost:8080/CarSaleRest/cardetails";
		
		 		// Create CarId Object
		 		CarId cid = new CarId();
		 		// set car id which comes in request
		 		cid.setId(carId);
		 		
		 		//Create CustomerEnquiryBean Object
		 		CustomerEnquiryBean customerEnquiryBean = new CustomerEnquiryBean();
		 		
		 		// add CustomerEnquiryBean bean object in model for thymeleaf use
		 		model.addAttribute("customerEnquiryBean", customerEnquiryBean);
		 		
		 		// Create RestTemplate Object to access rest service
		 	    RestTemplate restTemplate = new RestTemplate();
		 	    
		 	    // generate post request for Rest Service which return CarBean Object
		 	    CarBean carBean = restTemplate.postForObject(uri, cid,CarBean.class);
		
		 	
		 	   /*	Prepare Model View Object
		    	  * adding (CarBean) Object as an attribute to model and the view cardetails
		    	  *  
		    	 */
		 	   
		 	    request.getSession().setAttribute("carBean", carBean);
		 	    
		 		return new ModelAndView("/view/cardetails","carBean", carBean);
		
	}
	
	/**
	 * The saveCustomerEnquiry() method return success template if request process successfully otherwise error template. It has 3 arguments
	 * 	1. customerEnquiryBean - CustomerEnquiryBean Object
	 * 	2. model - Model Object
	 * 	3. bindingResult - BindingResult Object for retrieving validation errors
	 * 
	 * handles client POST request.
	 * run when client submit enquiry form.
	 * Access RestService by using RestTemplate class of Spring.
	 * 
	 * 
	 * 
	 * 	@return   success or error
	 */
	
	@RequestMapping(value="/saveEnquiryInfo", method=RequestMethod.POST)
	public ModelAndView saveCustomerEnquiry(@Valid @ModelAttribute("customerEnquiryBean") CustomerEnquiryBean customerEnquiryBean,
												BindingResult bindingResult,
												Model model,
												HttpServletRequest request)
	{
		
		model.addAttribute("carBean",request.getSession(false).getAttribute("carBean"));
		System.out.println("--------------------------------------------------------------------------" + request.getSession(false).getAttribute("carBean"));
		
		
		// when any validation error occurs
		  if (bindingResult.hasErrors()) {
			  
			  
			  System.out.println(" Form Validation Errors");
	            return  new ModelAndView("/view/cardetails", "formerrors", bindingResult.getAllErrors());
	        }
		  
		// URL of Rest Service
	    final String uri = "http://localhost:8080/CarSaleRest/saveEnquiryInfo";
	    
	    // Create RestTemplate Object to access rest service
	    RestTemplate restTemplate = new RestTemplate();
	    
	 // generate post request for Rest Service which return CarBean Object
	    String status = restTemplate.postForObject(uri, customerEnquiryBean, String.class);
	    
	    //when record saved successfully by RestService
	    if(status.equals("saved"))
	    {	
	    	 /*	Prepare Model View Object
	    	  * add status as an attribute to model and the view success  
	    	  *  
	    	 */
	    	return new ModelAndView("/view/success","result", status);
	    }
	   
	    //when request failed
	    /*	Prepare Model View Object
   	  	* add status as an attribute to model and the view error  
   	  	*  
   	  	*/
		return new ModelAndView("/view/error","result", status);
		
	}
	

}
