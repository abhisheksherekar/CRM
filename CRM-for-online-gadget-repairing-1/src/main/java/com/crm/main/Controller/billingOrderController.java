package com.crm.main.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.crm.main.Model.BillingOrder;
import com.crm.main.Model.Productdetails;
import com.crm.main.Repo.JDBCqueries;
import com.crm.main.Repo.billingOrderRepo;

@RestController
public class billingOrderController {

	@Autowired
	private JDBCqueries jdbCqueries;
	@Autowired
	private billingOrderRepo billrepo;
	
	@GetMapping("getbillingOrder/{cid}")
	@CrossOrigin(origins="*")
	public BillingOrder getPerticularOrder(@PathVariable String cid){
		List<BillingOrder> li = jdbCqueries.getBillingOrderbyCid(cid);
		return li.get(0); 
	}
	
	@PostMapping(value = "savebills")
	@CrossOrigin(origins="*")
	public BillingOrder saveBills(@RequestBody BillingOrder bil) {
		return billrepo.save(bil);
	}
}
