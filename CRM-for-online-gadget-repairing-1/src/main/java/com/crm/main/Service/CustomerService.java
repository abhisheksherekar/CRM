package com.crm.main.Service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.crm.main.Model.Customer;
import com.crm.main.Model.Productdetails;
import com.crm.main.Repo.CustomerRepo;
import com.crm.main.Repo.ProductDetailsRepo;

@Service
public class CustomerService {

	@Autowired
	private CustomerRepo customerRepo;	
	
	@Autowired
	private ProductDetailsRepo detailsRepo;

	public Customer registerCustomer(Customer customerDetail) {
		return customerRepo.save(customerDetail);
	}
	
	public Optional<Customer> findUserByMailId(String mailid) {
		System.out.println("in service");
		return customerRepo.findByCustomerEmail(mailid);		
	}
	
	public Customer fetchCustomerByEmailAndPassword(String mailid, String password) {
		return	customerRepo.findByCustomerEmailAndCustomerPassword(mailid, password);
	}
	
	
	public Productdetails insertCustomerProductRecord( Productdetails productdetails  ) {
		return detailsRepo.save(productdetails);
	}
	
	public Productdetails getProductdetailsById(int pid) {
		Optional<Productdetails> opt= detailsRepo.findById(pid);
		return opt.get();
	}
}
