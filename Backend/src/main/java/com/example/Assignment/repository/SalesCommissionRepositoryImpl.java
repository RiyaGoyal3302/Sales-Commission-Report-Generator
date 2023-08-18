package com.example.Assignment.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.Assignment.model.ProductPopupData;
import com.example.Assignment.model.SalesCommission;
import com.example.Assignment.model.SalesmanPopupData;
@Repository
public class SalesCommissionRepositoryImpl{

	@Autowired
	private JdbcTemplate jdbcTemplate;

    
    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    	public List<SalesCommission> func(Date date) {
        String sql = "SELECT product, salesman_name, SUM(product_quantity) as total_product_quantity, SUM(sales_amount) as total_sales_amount, salesman_area, SUM(salesman_commission) as total_salesman_commission" + 
        			" FROM sales_commission " +
        			"WHERE created_date = ? "+
        			"GROUP BY product, salesman_name, salesman_area";
      
        return jdbcTemplate.query(sql, this::fun2, new Object[]{date});
         
    }

    private SalesCommission fun2(ResultSet rs, int row) throws SQLException {
        SalesCommission salesCommission = new SalesCommission();
        salesCommission.setProduct(rs.getString("Product"));
        salesCommission.setSalesmanName(rs.getString("salesman_name"));
        salesCommission.setProductQuantity(rs.getInt("total_product_quantity"));
        salesCommission.setSalesAmount(rs.getDouble("total_sales_amount"));
        salesCommission.setSalesmanArea(rs.getString("salesman_area"));
        salesCommission.setSalesmanCommission(rs.getDouble("total_salesman_commission"));
//        
        //salesCommission.setCreatedDate(rs.getDate("created_date"));
        return salesCommission;
    }
	
	public List<SalesmanPopupData> SalesmanGrid(String name) {
		String sql = "SELECT salesman_name, salesman_area, SUM(sales_amount) as total_sales_amount, SUM(salesman_commission) as total_salesman_commission" + 
    			" FROM sales_commission " +
    			"WHERE salesman_name = ? " +
    			"GROUP BY salesman_name, salesman_area";
		return jdbcTemplate.query(sql,this:: helpSales,name);
	}
	private SalesmanPopupData helpSales(ResultSet rs, int row) throws SQLException{
		SalesmanPopupData s = new SalesmanPopupData();
		s.setSalesmanArea(rs.getString("salesman_area"));
		s.setSalesmanName(rs.getString("salesman_name"));
		s.setTotalSalesAmount(rs.getDouble("total_sales_amount"));
		s.setTotalSalesmanCommission(rs.getDouble("total_salesman_commission"));
		return s;
	}
	public List<ProductPopupData> ProductGrid(String name) {
		String sql = "SELECT product, salesman_area, SUM(product_quantity) as total_product_quantity, SUM(sales_amount) as total_sales_amount" + 
    			" FROM sales_commission " +
    			"WHERE product = ? "+
    			"GROUP BY product, salesman_area";
		return jdbcTemplate.query(sql,this:: helpProduct,name);
	}
	private ProductPopupData helpProduct(ResultSet rs, int row) throws SQLException{
		ProductPopupData s = new ProductPopupData();
		s.setSalesmanArea(rs.getString("salesman_area"));
		s.setProduct(rs.getString("product"));
		s.setTotalSalesAmount(rs.getDouble("total_sales_amount"));
		s.setTotalProductQuantity(rs.getInt("total_product_quantity"));
		return s;
	}
}
