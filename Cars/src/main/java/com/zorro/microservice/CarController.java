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
	CarService carService;
	
	
	@RequestMapping("/insert")
	public @ResponseBody Iterable<Car> insertCars(@RequestBody Car carsRqst) {		
		System.out.println("Vehicle #"+carsRqst.getRegNo());
		return carService.insertCar(carsRqst);
	}
		
	@RequestMapping("/findAll")
	public @ResponseBody Iterable<Car> findCars() {
		return carService.findCars();
	}
	
	@RequestMapping("/findOne")
	public @ResponseBody Car findCar(@RequestParam Integer regno) {
		return carService.findCar(regno);
	}
	
	@RequestMapping("/remove")
	public @ResponseBody Car removeCar(@RequestParam Integer regno) {
		return carService.removeCar(regno);
	}
}

