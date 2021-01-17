package com.crm.main.Controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.crm.main.Exception.CustomerEmailidNotFoundException;
import com.crm.main.Exception.userNameOrPasswordIncorrect;
import com.crm.main.Model.Customer;
import com.crm.main.Model.Feedback;
import com.crm.main.Model.Productdetails;
import com.crm.main.Repo.CustomerRepo;
import com.crm.main.Repo.FeedbackRepo;
import com.crm.main.Repo.JDBCqueries;
import com.crm.main.Repo.ProductDetailsRepo;
import com.crm.main.Service.CustomerService;
import com.crm.main.Service.sendMailServ;


@RestController
public class CustomerController {
		
		@Autowired
		private CustomerService customerService;		
		@Autowired
		private CustomerRepo customerRepo;		
		@Autowired
		private JDBCqueries jdbc;
		@Autowired
		private ProductDetailsRepo prdrepo;
		@Autowired
		private FeedbackRepo feedbackrepo;
		@Autowired
		private sendMailServ mailsend;
		
		public String mailid ;
		
		
		
		//addCustomer
		@PostMapping(value = "/addCustomer")
		@CrossOrigin(origins="*")
		public Customer addCustomer(@Valid @RequestBody Customer customerDetail) throws Exception {
			String mailid = customerDetail.getCustomerEmail();
				
			if(mailid.length() > 1) {
			Optional<Customer> tempuser =customerService.findUserByMailId(mailid);			
				if(tempuser.isPresent()) {
					System.out.println("abh");
					throw new CustomerEmailidNotFoundException("Customer with "+mailid+" Already exist. ");
				}
			}
			String to = customerDetail.getCustomerEmail();
			String body = "Thanks ...!!!"+ customerDetail.getCustomerName()+"   You have successfully register with us... ";
			String topic = "REGISTRATION SUCCESSFULL.";
			mailsend.sendEmail(to, body, topic);
			return customerService.registerCustomer(customerDetail);
		}
		
		//loginCustomer
		
		@PostMapping(value = "/loginCustomer")
		@CrossOrigin(origins="*")
		public Customer loginCustomer(@RequestBody Customer customer) throws Exception {
			String tempEmail = customer.getCustomerEmail();
			this.mailid = tempEmail;
			String tempPass = customer.getCustomerPassword();
			System.out.println(tempEmail+" ==== "+tempPass);
			Customer customerObj = null;
			if(tempEmail != null && tempPass != null) {
				 customerObj = customerService.fetchCustomerByEmailAndPassword(tempEmail, tempPass);
			}
			if(customerObj == null ) {
				throw new userNameOrPasswordIncorrect("BAD CREDENTIALS.!!!!");
			}
			//System.out.println("///////////// "+customerObj.getCustomerId());
			Productdetails productdetails = null;
			//productdetails.setCustomerId(customerObj.getCustomerId());
			return customerObj;
		}
		
		//insertProductDetails
//		@PostMapping(value = "/addProductDetails")
//		@CrossOrigin(origins="*")
//		public Productdetails insertProductDetails(@RequestBody Productdetails productdetails, @RequestParam(value ="cid") String cid, @RequestParam(value ="spid") String spid) {
//			System.out.println(cid);
//			productdetails.setCustomerId(Integer.parseInt(cid));
//			productdetails.setOrderStatus("Pending");
//			//System.out.println("spid = "+spid);
//			//;if(spid != null)
//				productdetails.setSpId(Integer.parseInt(spid));
//				productdetails.setPaymentStatus("Remaining.");
//				productdetails.setIsActive("Active");
//			return customerService.insertCustomerProductRecord(productdetails);
//		}
		
		@PostMapping(value = "/addProductDetails")
		@CrossOrigin(origins="*")
		public Productdetails insertProductDetails(@RequestBody Productdetails productdetails) {
			//System.out.println(cid);
		//	productdetails.setCustomerId(Integer.parseInt(cid));
			productdetails.setOrderStatus("Pending");
			productdetails.setPaymentStatus("Remaining.");
			productdetails.setIsActive("Active");
			
			//System.out.println("spid = "+spid);
			//;if(spid != null)
				//productdetails.setSpId(Integer.parseInt(spid));
		 	 int cid = productdetails.getCustomerId();
		 	 Optional<Customer> custOpt = customerRepo.findById(cid);
		 	Customer custObj = custOpt.get();
			String to = custObj.getCustomerEmail();
			System.out.println("to : "+to);
			String body = "Your request is Recieve to us......Currently status of your request is PENDING.";
			String subject = "YOUR REQUEST IS PENDING FOR APPROVAL";
			mailsend.sendEmail(to, body, subject);
			return customerService.insertCustomerProductRecord(productdetails);
		}
		
		
		@GetMapping(value = "/updateProductPayment/{pid}")
		@CrossOrigin(origins="*")
		public void updateProductDetails(@PathVariable String pid) {
			//System.out.println("update going");
			String to = this.mailid;
			System.out.println("to : "+to);
			String body = "Your Payment is Recieve to us. Thanks for being with us . ";
			String subject = "PAYMENT SUCCESS.";
			mailsend.sendEmail(to, body, subject);
			jdbc.updatepaymentStatus(pid);
			
		} 
		
		@PutMapping(value = "/updateActiveStatusToInActive/{pid}")
		@CrossOrigin(origins="*")
		public void updateActiveStatusToInActive(@PathVariable String pid) {
			//System.out.println("update going");
			jdbc.updateActiveStatusToInActive(pid);			
		} 
		
//		@PostMapping(value = "/updateProductDetails")
//		@CrossOrigin(origins="*")
//		public void updateProductDetails(@RequestParam int pid, @RequestParam int spid) {
//			System.out.println("update going");
//			jdbc.updateProductDetails(pid, spid);
//			System.out.println("update Successssss");
//		} 
		
		@GetMapping("/getProductDetails/{pid}")
		@CrossOrigin(origins="*")
		public Productdetails getProductDetailsbyId(@PathVariable String pid) {
			return customerService.getProductdetailsById(Integer.parseInt(pid));
		}
		
		//findByCustomerId
		@GetMapping("/findByCustomerId/{pid}")
		@CrossOrigin(origins="*")
		public List<Productdetails> findByCustomerId(@PathVariable String pid) {
			return prdrepo.findByCustomerId(Integer.parseInt(pid));
		}
		
		@GetMapping("/getFeedbackByspid/{pid}")
		@CrossOrigin(origins="*")
		public List<Feedback> getFeedback(@PathVariable int pid) {
			return feedbackrepo.findByspID(pid);
		}
		
		@PostMapping(value = "/insertFeedback")
		@CrossOrigin(origins="*")
		public Feedback insertFeedback(@RequestBody Feedback obj) throws Exception {			
			return feedbackrepo.save(obj);
		}
		
		
		@PostMapping("/customerForgotPassword")
		@CrossOrigin(origins="*")
		public Customer customerForgotPassword(@RequestBody Customer cust) {
			String emailId = cust.getCustomerEmail();
			Optional<Customer> custOpt = customerService.findUserByMailId(emailId);
			Customer customerObj = custOpt.get();
			
			
			
			String body = "Your Password is = "+customerObj.getCustomerPassword();
			String topic = "FORGOT PASSWORD MAIL";
			mailsend.sendEmail(customerObj.getCustomerEmail(), body, topic);
			return customerObj;
			
		}
		
}
