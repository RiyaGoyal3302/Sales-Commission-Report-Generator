package com.example.Assignment.model;

import java.util.List;

public class Sales {
	 private List<Salesman> salesman;
	 private List<Product> products;
	 
	 
	public List<Salesman> getSalesman() {
		return salesman;
	}
	public void setSalesman(List<Salesman> salesman) {
		this.salesman = salesman;
	}
	public List<Product> getProducts() {
		return products;
	}
	public void setProducts(List<Product> products) {
		this.products = products;
	}
	 
}
