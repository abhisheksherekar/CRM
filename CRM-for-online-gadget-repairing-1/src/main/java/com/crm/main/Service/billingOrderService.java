package com.crm.main.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crm.main.Repo.billingOrderRepo;

@Service
public class billingOrderService {

	@Autowired
	private billingOrderRepo bilingorder;
	
	
	
	public billingOrderRepo getBillingOrder() {
		return bilingorder;		
	}
}
