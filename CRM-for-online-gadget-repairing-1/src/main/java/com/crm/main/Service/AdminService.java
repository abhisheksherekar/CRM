package com.crm.main.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crm.main.Model.Admin;
import com.crm.main.Model.Customer;
import com.crm.main.Model.Productdetails;
import com.crm.main.Model.ServiceProvider;
import com.crm.main.Repo.AdminRepo;
import com.crm.main.Repo.ProductDetailsRepo;
import com.crm.main.Repo.ServiceProviderReop;

@Service
public class AdminService {

	@Autowired
	private AdminRepo adminRepo;
	@Autowired
	private ProductDetailsRepo detailsRepo;
	@Autowired
	private ServiceProviderReop providerReop;
	
	
	public Admin fetchAdminByEmailAndPassword(String mailid, String password) {
		return	adminRepo.findByAdminEmailAndAdminPassword(mailid, password);
	}
	
	public Admin addAdmin(Admin admin) {
		return adminRepo.save(admin);
	}
	
	public List<Productdetails> getAllproductList() {
		return detailsRepo.findAll();
	}
	
	public List<ServiceProvider> getAllProviderList() {
		return providerReop.findAll();
	}
	
	public void deleteSP(int spid) {
		 providerReop.deleteById(spid);	
	}
	
	public void updateSP(ServiceProvider provider) {
		providerReop.save(provider);
    }

	public ServiceProvider getproviderById(int spid) {
		Optional<ServiceProvider> spobj = providerReop.findById(spid);
		return spobj.get();
	}
	
	public Productdetails fetchOrderlistById(String   pid) {
		int a  = Integer.parseInt(pid);
		Optional<Productdetails> productdetails =  detailsRepo.findById(a);
		return productdetails.get();
	}
	
}
