package com.sales.car;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.web.SpringBootServletInitializer;

/**
 * <h1>CarSalesWebAppApplication</h1>
 * 
 * @author Asif Iqbal
 * @category Main Class
 * @version 1.0
 * @since July 2016
 */

@SpringBootApplication
public class CarSalesWebAppApplication extends SpringBootServletInitializer {
	
	
	 @Override
	    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
	        return application.sources(CarSalesWebAppApplication.class);
	    }


	public static void main(String[] args) {
		SpringApplication.run(CarSalesWebAppApplication.class, args);
	}
}
