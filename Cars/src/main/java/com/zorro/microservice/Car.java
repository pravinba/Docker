package com.zorro.microservice;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Car {
	@Id
	public Integer regNo;	
	public String make;
	public String modelName;
	public String trim;
	
	public Integer getRegNo() {
		return regNo;
	}	
	public void setRegNo(Integer regNo) {
		this.regNo = regNo;
	}
	public String getMake() {
		return make;
	}
	public void setMake(String make) {
		this.make = make;
	}
	public String getModelName() {
		return modelName;
	}
	public void setModelName(String modelName) {
		this.modelName = modelName;
	}
	public String getTrim() {
		return trim;
	}
	public void setTrim(String trim) {
		this.trim = trim;
	}
	@Override
	public String toString() {
		return "Car [regNo=" + regNo + ", make=" + make + ", modelName=" + modelName + ", trim=" + trim + "]";
	}
}