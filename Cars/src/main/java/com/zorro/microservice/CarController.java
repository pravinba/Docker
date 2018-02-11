package com.zorro.microservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
@RequestMapping(path="/car")
public class CarController {	
	@Autowired
	private CarRepository carRepository;

	
	@RequestMapping("/insert")
	public @ResponseBody Iterable<Car> insertCars(@RequestBody Car carsRqst) {
		Car newCar = new Car();
		System.out.println("Vehicle #"+carsRqst.getRegNo());
		
		carRepository.save(carsRqst);
		
		return findCars();
	}
	
	@RequestMapping("/findAll")
	public @ResponseBody Iterable<Car> findCars() {
		return carRepository.findAll();
	}
	
	@RequestMapping("/findOne")
	public @ResponseBody Car findCar(@RequestParam Integer regno) {
		return carRepository.findOne(regno);
	}
}

