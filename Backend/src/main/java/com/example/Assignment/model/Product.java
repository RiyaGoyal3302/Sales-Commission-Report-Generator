package com.example.Assignment.model;

public class Product {
	
	public String product_name;
	public double mrp_per_unit;
	public int quantity;
	
	public int salesman_id;
    
	public String getProductName() {
		return product_name;
	}
	public void setProductName(String productName) {
		this.product_name = productName;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public double getMrpPerUnit() {
		return mrp_per_unit;
	}
	public void setMrpPerUnit(double mrpPerUnit) {
		this.mrp_per_unit = mrpPerUnit;
	}
	public int getSalesmanId() {
		return salesman_id;
	}
	public void setSalesmanId(int salesmanId) {
		this.salesman_id = salesmanId;
	}

}
