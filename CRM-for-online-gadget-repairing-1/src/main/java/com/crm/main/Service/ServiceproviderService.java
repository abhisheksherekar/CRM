package com.crm.main.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crm.main.Model.Productdetails;
import com.crm.main.Model.ServiceProvider;
import com.crm.main.Repo.JDBCqueries;
import com.crm.main.Repo.ProductDetailsRepo;
import com.crm.main.Repo.ServiceProviderReop;

@Service
public class ServiceproviderService {
	
	@Autowired
	private ServiceProviderReop providerReop;
	@Autowired
	private JDBCqueries jdbCqueries;
	@Autowired
	private ProductDetailsRepo detailsRepo;
	
	public List<ServiceProvider> getAllprovider() {
		return providerReop.findAll();
		
	}
	
	public ServiceProvider registerSP(ServiceProvider provider) {
		return providerReop.save(provider);
	}

	public ServiceProvider loginSP(ServiceProvider provider) {		
		return providerReop.findBySpEmailAndSpPasssword(provider.getSpEmail(), provider.getSpPasssword());
	}
	
	public ServiceProvider checkSpbyMailId(String mailid) {
		return providerReop.findBySpEmail(mailid);
	}
	
	public List<Productdetails> showAllorderById(int spid) {
		return jdbCqueries.getAllorderById(spid);
	}
	
//	public List<Productdetails> displayAllorderById(int spid) {
//		Optional<Productdetails> opt = detailsRepo.findById(spid);
//		return opt.get();
//	}
	
}
