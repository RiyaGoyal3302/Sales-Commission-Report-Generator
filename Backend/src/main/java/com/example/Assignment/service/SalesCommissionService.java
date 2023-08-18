package com.example.Assignment.service;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.Assignment.model.Product;
import com.example.Assignment.model.ProductPopupData;
import com.example.Assignment.model.Sales;
import com.example.Assignment.model.SalesCommission;
import com.example.Assignment.model.Salesman;
import com.example.Assignment.model.SalesmanPopupData;
import com.example.Assignment.repository.SalesCommissionRepository;



@Service
public class SalesCommissionService{  
	@Autowired
	SalesCommissionRepository salesCommissionRepository;
	SalesCommission salesCommission = null;
//	@Autowired
	//private SalesRepository salesRepository;
	
	
	public void calculateAndSaveSalesCommission(Sales sales) {
		for(Salesman s:sales.getSalesman()) {
			for(Product p:sales.getProducts()) {
				if(s.salesman_id==p.salesman_id) {
					salesCommission=new SalesCommission();
					salesCommission.setCreatedDate(new Date());
					salesCommission.setProduct(p.product_name);
					salesCommission.setSalesmanName(s.salesman_name);
					salesCommission.setProductQuantity(p.quantity);
					salesCommission.setSalesAmount(p.quantity*p.mrp_per_unit);
					salesCommission.setSalesmanArea(s.salesman_area);
					salesCommission.setSalesmanCommission(salesCommission.getSalesAmount()*s.commission_rate/100);
				}
				if(salesCommission!=null)
					salesCommissionRepository.save(salesCommission);
				salesCommission=null;
			}
		}
	}
	public List<SalesCommission> getSalesCommision(Date date) {
	return salesCommissionRepository.func(date);
		
	}
	public List<SalesmanPopupData> getSalesmanData(String name) {
        return salesCommissionRepository.SalesmanGrid(name);
    }

    public List<ProductPopupData> getProductData(String name) {
        return salesCommissionRepository.ProductGrid(name);
    }
}