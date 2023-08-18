package com.example.Assignment.repository;
import com.example.Assignment.model.ProductPopupData;
import com.example.Assignment.model.SalesCommission;
import com.example.Assignment.model.SalesmanPopupData;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;


public interface SalesCommissionRepository extends JpaRepository<SalesCommission, Long> {
    List<SalesCommission> func(Date createdDate);

    List<SalesmanPopupData> SalesmanGrid(String name);

    List<ProductPopupData> ProductGrid(String name);
    
}
