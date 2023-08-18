package com.example.Assignment.model;


public class Salesman {
	public int salesman_id;
	public String salesman_name;
	public String salesman_area;
	public double commission_rate;
    
	public int getSalesmanId() {
		return salesman_id;
	}
	public void setSalesmanId(int salesmanId) {
		this.salesman_id = salesmanId;
	}
	public String getSalesmanName() {
		return salesman_name;
	}
	public void setSalesmanName(String salesmanName) {
		this.salesman_name = salesmanName;
	}
	public String getSalesmanArea() {
		return salesman_area;
	}
	public void setSalesmanArea(String salesmanArea) {
		this.salesman_area = salesmanArea;
	}
	public double getCommissionRate() {
		return commission_rate;
	}
	public void setCommissionRate(double commissionRate) {
		this.commission_rate = commissionRate;
	}
}
