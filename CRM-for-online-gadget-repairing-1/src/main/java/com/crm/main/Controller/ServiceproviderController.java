package com.crm.main.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.crm.main.Model.Productdetails;
import com.crm.main.Model.ServiceProvider;
import com.crm.main.Service.CustomerService;
import com.crm.main.Service.ServiceproviderService;

@RestController
@CrossOrigin(origins="*")
public class ServiceproviderController {

	@Autowired
	private ServiceproviderService  serviceproviderService;
	@Autowired
	private CustomerService custserv;  
	
	
	@GetMapping("/getAllprovider")
	public List<ServiceProvider> getallprovider(){
		return serviceproviderService.getAllprovider();	
	}
	
	@PostMapping("/registerSP")
	public ServiceProvider addSP(@RequestBody ServiceProvider provider) throws Exception {
		String tempmailid = provider.getSpEmail();
		if(tempmailid != null ) {
			ServiceProvider obj  =  serviceproviderService.checkSpbyMailId(tempmailid);
			if (obj != null) {
				throw new Exception("EMAIL already EXIST");
			}
		}
		return serviceproviderService.registerSP(provider);
		
	}
	
	
	@PostMapping("/loginSP")
	public ServiceProvider loginSP(@RequestBody ServiceProvider provider) throws Exception {
		ServiceProvider obj = serviceproviderService.loginSP(provider);
		if(obj == null) {
			throw new Exception("BAD CREDENTIAL ");
		}
		else {
			return obj;
		}
	}
	
	@GetMapping("showAllorderById/{spid}")
	public List<Productdetails> showAllorderById1(@PathVariable String spid){
		return serviceproviderService.showAllorderById(Integer.parseInt(spid) );
	}
	
	@GetMapping("displayById/{pid}")
	public Productdetails displayAllorderById1(@PathVariable String pid){
		return custserv.getProductdetailsById(Integer.parseInt(pid) );
	}
	
	
}
