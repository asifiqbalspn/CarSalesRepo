package com.sales.car.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.sales.car.bean.CarBean;
import com.sales.car.dao.CarDao;
import com.sales.car.model.TblCar;

/**
 * <h1>CarServiceImpl</h1>
 * 
 * This class implements CarService interface
 * 
 * @author Asif Iqbal
 * @category Implementation Class
 * @version 1.0.0
 * @since July 2016
 *
 */
@Service("carService")
@Transactional(propagation=Propagation.REQUIRED, readOnly=false)
public class CarServiceImpl implements CarService
{
	/*
	 * carDao - CarDao class object
	 * 
	 */

@Autowired
private CarDao carDao;


	@Override
	public List<TblCar> listCars() {
		/*
		 * cars - holds the list of TblCar Objects return by DAO method 
		 */
		
		// call DAO class method to get the list of TblCar Objects and collect it in cars variable
		List<TblCar> cars = carDao.listCars();
		
		return cars;
	}


	@Override
	public TblCar getCar(Long carId) {
		
		// call DAO class method to get TblCar Object and return it to controller
		return carDao.getCar(carId);
	}

	public CarDao getCarDao() {
		return carDao;
	}

	public void setCarDao(CarDao carDao) {
		this.carDao = carDao;
	}

	@Override
	public List<String> getCarsMake() {
		/*
		 * carsMake - hold the list of Cars name return by DAO method
		 */
		
		// call DAO class method to get List of Cars name and return it to controller
		List<String> carsMake = carDao.getCarsMake();
		return carsMake;
	}

	@Override
	public List<String> getCarModels(String make) {
		// call DAO class method to get List of Car Models of given car make and return it to controller
		return carDao.getCarModels(make);
	}

	@Override
	public List<TblCar> getSearchedCars(CarBean bean) {
		// call DAO class method to get the list TblCar Objects and return it to controller
		return carDao.getSearchedCars(bean);
	}


	
}
