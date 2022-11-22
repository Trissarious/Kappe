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

import com.kappe.kappe.Entity.TransactionSupplierEntity;
import com.kappe.kappe.Service.TransactionSupplierService;

@RestController
@RequestMapping("/supplier_transaction")
public class TransactionSupplierController {
	@Autowired
	TransactionSupplierService tserv;
	
			//Create or insert a supplier record
			@PostMapping("/postSupplierTransaction")
			public TransactionSupplierEntity insertSupplierTransaction(@RequestBody TransactionSupplierEntity suppliertransaction) {
				return tserv.insertSupplierTransaction(suppliertransaction);
			}
			
			//Read all records
			@GetMapping("/getAllSupplierTransaction")
			public List<TransactionSupplierEntity> getAllSupplierTransaction(){
				return tserv.getAllSupplierTransaction();
			}
			
			//Read a record by farm name
			@GetMapping("/getByItem")
			public TransactionSupplierEntity findByItem(@RequestParam String item) {
				return tserv.findByItem(item);	
			}
			
			//Update a record
			@PutMapping("/putSupplierTransaction")
			public TransactionSupplierEntity putSupplierTransaction(@RequestParam int transactionsupplierid, @RequestBody TransactionSupplierEntity newSupplierTransactionDetails) throws Exception{
				return tserv.putSupplierTransaction(transactionsupplierid, newSupplierTransactionDetails);
			}
			
			//Delete a record
			@DeleteMapping("/deleteSupplierTransaction/{transactionsupplierid}")
			public String deleteSupplierTransaction(@PathVariable int transactionsupplierid) {
				return tserv.deleteSupplierTransaction(transactionsupplierid);
			}
}
