package com.crm.main.Model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.NotBlank;

@Entity
public class Customer {

	@Id
	@GeneratedValue
	private int customerId;
	
	@NotEmpty(message ="customer Name Not Empty")
	
	private String customerName;
	
	@NotEmpty(message ="Customer Email Not Empty")
	@Column(unique = true, length = 30)
	private String customerEmail;
	
	@NotEmpty(message ="customer Mobile Not Empty")
	private String customerMobile;
	
	@NotEmpty(message ="customer password Not Empty")
	private String customerPassword;

	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public String getCustomerEmail() {
		return customerEmail;
	}
	public void setCustomerEmail(String customerEmail) {
		this.customerEmail = customerEmail;
	}
	public String getCustomerMobile() {
		return customerMobile;
	}
	public void setCustomerMobile(String customerMobile) {
		this.customerMobile = customerMobile;
	}
	public String getCustomerPassword() {
		return customerPassword;
	}
	public void setCustomerPassword(String customerPassword) {
		this.customerPassword = customerPassword;
	}
	@Override
	public String toString() {
		return "Customer [customerId=" + customerId + ", customerName=" + customerName + ", customerEmail="
				+ customerEmail + ", customerMobile=" + customerMobile + ", customerPassword=" + customerPassword + "]";
	}
	
	
}
