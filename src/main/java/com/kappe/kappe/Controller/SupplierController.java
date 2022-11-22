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

import com.kappe.kappe.Entity.SupplierEntity;
import com.kappe.kappe.Service.SupplierService;

@RestController
@RequestMapping("/supplier")
public class SupplierController {
	@Autowired
	SupplierService spserv;
	
		//printHelloSupplier
		@GetMapping("/print")
		public String printHelloSupplier() {
			return "Hello, Supplier!";
		}
		
		//Create or insert a supplier record
		@PostMapping("/postSupplier")
		public SupplierEntity insertSupplier(@RequestBody SupplierEntity supplier) {
			return spserv.insertSupplier(supplier);
		}
		
		//Read all records
		@GetMapping("/getAllSupplier")
		public List<SupplierEntity> getAllSupplier(){
			return spserv.getAllSupplier();
		}
		
		//Read a record by farm name
		@GetMapping("/getByLastname")
		public SupplierEntity findByFarmname(@RequestParam String supplierLname) {
			return spserv.findBySupplierLname(supplierLname);	
		}
		
		//Update a record
		@PutMapping("/putSupplier")
		public SupplierEntity putSupplier(@RequestParam int supplierID, @RequestBody SupplierEntity newSupplierDetails) throws Exception{
			return spserv.putSupplier(supplierID, newSupplierDetails);
		}
		
		//Delete a record
		@DeleteMapping("/deleteSupplier/{supplierID}")
		public String deleteSupplier(@PathVariable int supplierID) {
			return spserv.deleteSupplier(supplierID);
		}
}
