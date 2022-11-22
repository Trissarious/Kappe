package com.kappe.kappe.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.kappe.kappe.Entity.CustomerEntity;
import com.kappe.kappe.Service.CustomerService;

@RestController
@RequestMapping("/customer")
public class CustomerController {
	@Autowired
	CustomerService cserv;
	
		//Create 
		@PostMapping("/postCustomer")
		public CustomerEntity insertCustomer(@RequestBody CustomerEntity customer) {
			return cserv.insertCustomer(customer);
		}
		
		//Read all records
		@GetMapping("/getAllCustomer")
		public List<CustomerEntity> getAllCustomer(){
			return cserv.getAllCustomer();
		}
		
//		//Read a record by farm name
//		@GetMapping("/getByLastname")
//		public SupplierEntity findByFarmname(@RequestParam String supplierLname) {
//			return spserv.findBySupplierLname(supplierLname);	
//		}
		
		//Update a record
		@PutMapping("/putCustomer")
		public CustomerEntity putCustomer(@RequestParam int customerid, @RequestBody CustomerEntity newCustomerDetails) throws Exception{
			return cserv.putCustomer(customerid, newCustomerDetails);
		}
		
		//Delete a record
		@DeleteMapping("/deleteCustomer/{customerid}")
		public String deleteCustomer(@PathVariable int customerid) {
			return cserv.deleteCustomer(customerid);
		}
}
