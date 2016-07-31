package com.sales.car;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.web.SpringBootServletInitializer;

/**
 * @author Asif Iqbal
 * @category Main Class
 * @version 1.0
 * @since July 2016
 */
@SpringBootApplication
public class CarSalesRestServiceApplication extends SpringBootServletInitializer {
	
	
	 @Override
	    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
	        return application.sources(CarSalesRestServiceApplication.class);
	    }

	public static void main(String[] args) {
		SpringApplication.run(CarSalesRestServiceApplication.class, args);
	}
}
