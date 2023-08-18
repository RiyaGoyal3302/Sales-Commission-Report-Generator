package com.example.Assignment.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.Assignment.model.ProductPopupData;
import com.example.Assignment.model.Sales;
import com.example.Assignment.model.SalesCommission;
import com.example.Assignment.model.SalesmanPopupData;
import com.example.Assignment.service.SalesCommissionService;


@RestController
@CrossOrigin(origins="http://localhost:4200")
@RequestMapping("/sales")
public class SalesController {

	
	SalesCommissionService service;

    @Autowired
    public SalesController(SalesCommissionService service) {
        this.service = service;
    }

    @PostMapping
    public String calculateCommission(@RequestBody Sales sales) {
        try {
            service.calculateAndSaveSalesCommission(sales);
            return "{\"status\": \"200\", \"message\": \"Success\"}";
        } catch (Exception e) {
            return "{\"status\": \"400\", \"message\": \"" + e.getMessage() + "\"}";
        }
    }

    @GetMapping("/commission")
    public List<SalesCommission> getCommissionsByDate(@RequestParam(name = "date") String timestamp) {
    	SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        Date date = new Date();
		try {
			date = formatter.parse(timestamp);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        return service.getSalesCommision(date);
    }
    @GetMapping("/salesman")
    public List<SalesmanPopupData> getSalesmanData(@RequestParam String name) {
        return service.getSalesmanData(name);
    }

    @GetMapping("/product")
    public List<ProductPopupData> getProductData(@RequestParam String name) {
        return service.getProductData(name);
    }
 }