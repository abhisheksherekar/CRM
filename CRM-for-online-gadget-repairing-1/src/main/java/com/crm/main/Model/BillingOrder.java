package com.crm.main.Model;

import javax.persistence.*;

@Entity
public class BillingOrder {

	@Id
	@GeneratedValue
	private int billId;
	private String issueOne;
	private String issueTwo;
	private String amountOne;
	private String amountTwo;
	private String grandTotal;
	private String productId;
	private String orderRemark;
	
	
	public int getBillId() {
		return billId;
	}
	public void setBillId(int billId) {
		this.billId = billId;
	}
	public String getIssueOne() {
		return issueOne;
	}
	public void setIssueOne(String issueOne) {
		this.issueOne = issueOne;
	}
	public String getIssueTwo() {
		return issueTwo;
	}
	public void setIssueTwo(String issueTwo) {
		this.issueTwo = issueTwo;
	}
	public String getAmountOne() {
		return amountOne;
	}
	public void setAmountOne(String amountOne) {
		this.amountOne = amountOne;
	}
	public String getAmountTwo() {
		return amountTwo;
	}
	public void setAmountTwo(String amountTwo) {
		this.amountTwo = amountTwo;
	}
	public String getGrandTotal() {
		return grandTotal;
	}
	public void setGrandTotal(String grandTotal) {
		this.grandTotal = grandTotal;
	}
	public String getProductId() {
		return productId;
	}
	public void setProductId(String productId) {
		this.productId = productId;
	}
	public String getOrderRemark() {
		return orderRemark;
	}
	public void setOrderRemark(String orderRemark) {
		this.orderRemark = orderRemark;
	}
	
	

	
}	
