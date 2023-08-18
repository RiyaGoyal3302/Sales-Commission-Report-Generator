package com.example.Assignment.model;

public class ProductPopupData {
	public String product;
	public String salesmanArea;
	public int totalProductQuantity;
	public double totalSalesAmount;
	public String getProduct() {
		return product;
	}
	public void setProduct(String product) {
		this.product = product;
	}
	public String getSalesmanArea() {
		return salesmanArea;
	}
	public void setSalesmanArea(String salesmanArea) {
		this.salesmanArea = salesmanArea;
	}
	public int getTotalProductQuantity() {
		return totalProductQuantity;
	}
	public void setTotalProductQuantity(int totalProductQuantity) {
		this.totalProductQuantity = totalProductQuantity;
	}
	public double getTotalSalesAmount() {
		return totalSalesAmount;
	}
	public void setTotalSalesAmount(double totalSalesAmount) {
		this.totalSalesAmount = totalSalesAmount;
	}
}
