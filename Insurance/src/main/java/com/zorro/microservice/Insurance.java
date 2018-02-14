package com.zorro.microservice;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Insurance {
	@Id
	public Integer regNo;
	public String insuranceId;
	public String insuranceType;
	
	public String getInsuranceType() {
		return insuranceType;
	}
	public void setInsuranceType(String insuranceType) {
		this.insuranceType = insuranceType;
	}
	public String getInsuranceId() {
		return insuranceId;
	}
	@Override
	public String toString() {
		return "Insurance [regNo=" + regNo + ", insuranceId=" + insuranceId + ", insuranceType=" + insuranceType + "]";
	}
	public void setInsuranceId(String insuranceId) {
		this.insuranceId = insuranceId;
	}
	
	public Integer getRegNo() {
		return regNo;
	}
	public void setRegNo(Integer regNo) {
		this.regNo = regNo;
	}
	
	}
