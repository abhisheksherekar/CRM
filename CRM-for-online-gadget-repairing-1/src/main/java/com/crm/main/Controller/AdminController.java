package com.crm.main.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


import com.crm.main.Model.Admin;
import com.crm.main.Model.Customer;
import com.crm.main.Model.CustomerInnovoice;
import com.crm.main.Model.Productdetails;
import com.crm.main.Model.ServiceProvider;
import com.crm.main.Repo.AdminRepo;
import com.crm.main.Repo.CustomerRepo;
import com.crm.main.Repo.JDBCqueries;
import com.crm.main.Repo.ProductDetailsRepo;
import com.crm.main.Repo.ServiceProviderReop;
import com.crm.main.Service.AdminService;
import com.crm.main.Service.sendMailServ;

@RestController
public class AdminController {

	@Autowired
	private AdminService adminserv;
	@Autowired
	private JDBCqueries jdbcqueries;
	@Autowired 
	private ProductDetailsRepo productrepo;
	@Autowired
	private ServiceProviderReop sprepo;
	@Autowired
	private sendMailServ mailserv;
	@Autowired
	private CustomerRepo custrepo;
	
	
	@PostMapping(value = "/addAdmin")
	@CrossOrigin(origins="*")
	public Admin addAdmin(@RequestBody Admin admin) {
		return adminserv.addAdmin(admin);
	}
	

	@PostMapping(value = "/loginAdmin")
	@CrossOrigin(origins="*")
	public Admin loginAdmin(@RequestBody Admin admin) throws Exception {
		String mailid = admin.getAdminEmail();
		String password= admin.getAdminPassword();
		Admin AdminObj = null;
		if(mailid !=null && password != null)
			AdminObj = adminserv.fetchAdminByEmailAndPassword(mailid, password);
		if(AdminObj == null) {
			throw new Exception("BAD CREDENTIALS.!!!!");
		}
		
		return AdminObj;
	}
	
	@GetMapping("getAllOrders")
	@CrossOrigin(origins="*")
	public List<Productdetails> getAllOrders(){
		return adminserv.getAllproductList();
	}
	
	@GetMapping("getAllProvider")
	@CrossOrigin(origins="*")
	public List<ServiceProvider> getAllProvider(){
		return adminserv.getAllProviderList();
	}
	
	@GetMapping("getPerticularOrder/{pid}")
	@CrossOrigin(origins="*")
	public Productdetails getPerticularOrder(@PathVariable String pid){
		return adminserv.fetchOrderlistById(pid);
	}
	
//	@GetMapping(value = "updatestatusapprove/{pid}")
//	@CrossOrigin(origins="*")
//	public void updatestatustoapprove(@PathVariable String pid) {
//		jdbcqueries.changeStatusToApprove(pid);
//	}
//	
//	@GetMapping(value = "updatestatusreject/{pid}")
//	@CrossOrigin(origins="*")
//	public void updatestatustoReject(@PathVariable(value = "pid") String pid) {
//		System.out.println("...........");
//		System.out.println("---> "+ pid);
//		jdbcqueries.changeStatusToRject(pid);
//	}
	@PutMapping(value = "updatestatusreject/{pid}")
	@CrossOrigin(origins="*")
	public Productdetails updatestatustoReject(@PathVariable String pid, @RequestBody Productdetails productdetails) {
		//Optional<Productdetails> tempprd =  productrepo.findById(Integer.parseInt(pid));
		System.out.println(".....Rejct......");
		System.out.println("---> "+ pid);
		Productdetails temp = adminserv.fetchOrderlistById(pid);
		temp.setOrderStatus("Rejected");
		return productrepo.save(temp);
		//jdbcqueries.changeStatusToApprove(pid);
	}

	@PutMapping(value = "updatestatusapprove/{pid}")
	@CrossOrigin(origins="*")
	public Productdetails updatestatustoapprove(@PathVariable String pid, @RequestBody Productdetails productdetails) {
		Optional<Productdetails> detailOpt = productrepo.findById(Integer.parseInt(pid) );
		Productdetails prddetail = detailOpt.get();
		  Optional<Customer> custForMailopt = custrepo.findById(prddetail.getCustomerId()) ;
		  Customer custformailObj = custForMailopt.get();
		//Optional<Productdetails> tempprd =  productrepo.findById(Integer.parseInt(pid));
		System.out.println("...........");
		System.out.println("---> "+ pid);
		Productdetails temp = adminserv.fetchOrderlistById(pid);
		temp.setOrderStatus("Approved");
		String to = custformailObj.getCustomerEmail();
		System.out.println("to approve: "+to);
		String body = "Great your request has been Approve. we will revert back to you soon ";
		String subject = "YOUR REQUEST IS PENDING FOR APPROVAL";
		mailserv.sendEmail(to, body, subject);
		return productrepo.save(temp);
		//jdbcqueries.changeStatusToApprove(pid);
	}
	
	@PutMapping(value = "/updateProvider/{spid}")
	@CrossOrigin(origins="*")
	public ServiceProvider updateProvider(@PathVariable String spid, @RequestBody ServiceProvider provider) {
		ServiceProvider providerobj = adminserv.getproviderById(Integer.parseInt(spid));
		providerobj.setSpCity(provider.getSpCity());
		providerobj.setSpEmail(provider.getSpEmail());
		providerobj.setSpGSTno(provider.getSpGSTno());
		providerobj.setSpLandmark(provider.getSpLandmark());
		providerobj.setSpMobilenumber(provider.getSpMobilenumber());
		providerobj.setSpName(provider.getSpName());
		providerobj.setSpPincode(provider.getSpPincode());
		providerobj.setSpRegnumber(provider.getSpRegnumber());
		providerobj.setSpShopname(provider.getSpShopname());
		adminserv.updateSP(providerobj);
		return providerobj;
	}
	
	@DeleteMapping("/deleteProvider/{spid}")
	@CrossOrigin(origins="*")
	public String deleteProvider(@PathVariable String spid) {
		System.out.println("delete "+ spid);
		sprepo.deleteById(Integer.parseInt(spid));
		return "success";
	} 
	
	
	@GetMapping("/getprovider/{id}")
	@CrossOrigin(origins="*")
	public ServiceProvider getprovider(@PathVariable String id){
		Optional<ServiceProvider> sp = sprepo.findById(Integer.parseInt(id));
		 return sp.get();
	}
	
	@DeleteMapping("deleteOrderbyId/{pid}")
	@CrossOrigin(origins="*")
	public String deleteOrderbyId(@PathVariable int pid) {
		productrepo.deleteById(pid);
		return "Done";
		
	}
	
	@GetMapping("/getInnoivce/{id}")
	@CrossOrigin(origins="*")
	public List<CustomerInnovoice> getInnoivce(@PathVariable int id){
		
		 return jdbcqueries.getCustomerInnovoice(id);
	}
	
	
	 
	
	
}
