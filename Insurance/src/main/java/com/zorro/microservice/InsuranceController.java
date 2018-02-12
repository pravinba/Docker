package com.zorro.microservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
@RequestMapping(path="/insurance")
public class InsuranceController {	
	@Autowired
	private InsuranceRepository insuranceRepository;

	
	@RequestMapping("/insert")
	public @ResponseBody Iterable<Insurance> insertCars(@RequestBody Insurance insuranceRqst) {
		Insurance newInsurance = new Insurance();
		System.out.println("Vehicle #"+insuranceRqst.getInsuranceId());
		
		insuranceRepository.save(insuranceRqst);
		
		return findInsurance();
	}
	
	@RequestMapping("/findAll")
	public @ResponseBody Iterable<Insurance> findInsurance() {
		return insuranceRepository.findAll();
	}
	
	@RequestMapping("/findOne")
	public @ResponseBody Insurance findInsurance(@RequestParam Integer regno) {
		return insuranceRepository.findOne(regno);
	}
	
	@RequestMapping("/remove")
	public @ResponseBody Insurance removeInsurance(@RequestParam Integer regno) {
		Insurance removeInsurance = new Insurance();
		removeInsurance = insuranceRepository.findOne(regno);
		insuranceRepository.delete(removeInsurance);
		return removeInsurance;
	}
}

