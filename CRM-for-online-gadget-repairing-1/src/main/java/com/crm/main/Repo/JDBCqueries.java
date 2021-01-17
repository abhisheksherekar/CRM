package com.crm.main.Repo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.crm.main.Model.BillingOrder;
import com.crm.main.Model.CustomerInnovoice;
import com.crm.main.Model.Productdetails;

@Repository
public class JDBCqueries {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public List<BillingOrder> getBillingOrderbyCid(String cid) {
		String sql = "select * "
				+ " from productdetails join billing_order on billing_order.product_id = productdetails.product_id and productdetails.payment_status='Remaining.' and productdetails.customer_id ="+cid;
		
		return jdbcTemplate.query(sql, new RowMapper<BillingOrder>() {
			@Override
			public BillingOrder mapRow(ResultSet rs, int rowNum) throws SQLException {
				BillingOrder b = new BillingOrder();
				b.setBillId(rs.getInt(15));
				b.setAmountOne(rs.getString(16));
				b.setAmountTwo(rs.getString(17));
				b.setGrandTotal(rs.getString(18));
				b.setIssueOne(rs.getString(19));
				b.setIssueTwo(rs.getString(20));
				b.setProductId(rs.getString(21));
				b.setOrderRemark(rs.getString(22));
				return b;
			}} );
					
	}
	
	
	public void updateProductDetails(int pid, int spid) {
		String sql = "update productdetails SET sp_id ="+spid+" WHERE product_id="+pid;
		System.out.println("SQL "+sql);
		jdbcTemplate.execute(sql);
	}
	
	public void changeStatusToApprove(String pid) {
		String sql = "update productdetails set  order_status = 'Approved' where product_id ="+pid; 
		jdbcTemplate.execute(sql);
	}
	
	public void changeStatusToRject(String pid) {
		String sql = "update productdetails set  order_status = 'Rejected' where product_id ="+pid; 
		jdbcTemplate.execute(sql);
	}
	
	public void updatepaymentStatus(String pid) {
		String sql = "update productdetails set  payment_status = 'Completed.' where product_id ="+pid; 
		jdbcTemplate.execute(sql);
	}
	
	public void updateActiveStatusToInActive(String pid) {
		String sql = "update productdetails set  is_active = 'In Active.' where product_id ="+pid; 
		jdbcTemplate.execute(sql);
	}
	
	public List<Productdetails> getAllorderById(int spid){
		String sql = "select * from productdetails where order_status = 'Approved' and sp_id ="+spid    ;
		return jdbcTemplate.query(sql, new RowMapper<Productdetails>() {

			@Override
			public Productdetails mapRow(ResultSet rs, int rowNum) throws SQLException {
				
				Productdetails p = new Productdetails();				
				p.setProductId(rs.getInt(1));
				p.setBrandName(rs.getString(2));
				p.setMobileNumber(rs.getString(3));
				p.setModelNo(rs.getString(4));
				p.setPickupCity(rs.getString(5));
				p.setPinCode(rs.getString(6));
				p.setProductIssue(rs.getString(7));
				p.setProductType(rs.getString(8));
				p.setPurchaseDate(rs.getString(9));
				p.setCustomerId(rs.getInt(10));
				p.setOrderStatus(rs.getString(11));
				p.setSpId(rs.getInt(12));							
				return p;
			}} );
	}
	
	public List<CustomerInnovoice> getCustomerInnovoice(int pid){
		String sql = "select * from productdetails join billing_order on" + 
				" billing_order.product_id = productdetails.product_id join " + 
				" customer on productdetails.customer_id = customer.customer_id where productdetails.product_id="+pid;
		return jdbcTemplate.query(sql, new RowMapper<CustomerInnovoice>() {

			@Override
			public CustomerInnovoice mapRow(ResultSet rs, int rowNum) throws SQLException {
				CustomerInnovoice ci = new CustomerInnovoice();
				ci.setAmount_one(rs.getString(16));
				ci.setAmount_two(rs.getString(17));
				ci.setBrand_name(rs.getString(2));
				ci.setCustomer_email(rs.getString(24));
				ci.setCustomer_mobile(rs.getString(25));
				ci.setCustomer_name(rs.getString(26));
				ci.setGrand_total(rs.getString(18));//
				ci.setIssue_one(rs.getString(19));
				ci.setIssue_two(rs.getString(20));
				ci.setModel_no(rs.getString(4));
				
				ci.setCity(rs.getString(5));
				ci.setPinCode(rs.getString(6));
				ci.setCusRemark(rs.getString(22));
				//5  6pin 20remrk
				ci.setProduct_type(rs.getString(8));
				ci.setPurchase_date(rs.getString(9));
				return ci;
				
			}} );
	}
	
	

}
