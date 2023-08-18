package com.example.Assignment.model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class SalesCommission {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
	private String product;
    private int productQuantity;
    private double salesAmount;
    private String salesmanName;
    private double salesmanCommission;
    private String salesmanArea;
    private Date createdDate=new Date();

    public SalesCommission() {}
    
	public String getProduct() {
		return product;
	}
	public void setProduct(String product) {
		this.product = product;
	}
	public int getProductQuantity() {
		return productQuantity;
	}
	public void setProductQuantity(int productQuantity) {
		this.productQuantity = productQuantity;
	}
	public double getSalesAmount() {
		return salesAmount;
	}
	public void setSalesAmount(double salesAmount) {
		this.salesAmount = salesAmount;
	}
	public String getSalesmanName() {
		return salesmanName;
	}
	public void setSalesmanName(String salesmanName) {
		this.salesmanName = salesmanName;
	}
	public double getSalesmanCommission() {
		return salesmanCommission;
	}
	public void setSalesmanCommission(double salesmanCommission) {
		this.salesmanCommission = salesmanCommission;
	}
	public String getSalesmanArea() {
		return salesmanArea;
	}
	public void setSalesmanArea(String salesmanArea) {
		this.salesmanArea = salesmanArea;
	}
//    public Long getId() {
//	return id;
//}
//
//public void setId(Long id) {
//	this.id = id;
//}

public Date getCreatedDate() {
	
	SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
	String format = formatter.format(createdDate);
	Date date = new Date();
    try {
		date = formatter.parse(format);
	} catch (ParseException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return date;
}

public void setCreatedDate(Date date) {
	SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
	String format = formatter.format(date);
    try {
		date = formatter.parse(format);
	} catch (ParseException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	this.createdDate = date;
}
}
