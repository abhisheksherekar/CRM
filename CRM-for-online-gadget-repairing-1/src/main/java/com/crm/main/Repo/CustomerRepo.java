package com.crm.main.Repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.crm.main.Model.Customer;

@Repository
public interface CustomerRepo extends JpaRepository<Customer, Integer> {
	public Optional<Customer> findByCustomerEmail(String mailid);
	public Customer findByCustomerEmailAndCustomerPassword(String mailid, String password);
	//public Customer findByCustomerEmail(String mailid);
}
