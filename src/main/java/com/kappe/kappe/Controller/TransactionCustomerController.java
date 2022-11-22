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

import com.kappe.kappe.Entity.TransactionCustomerEntity;
import com.kappe.kappe.Service.TransactionCustomerService;

@RestController
@RequestMapping("/transaction")
public class TransactionCustomerController {
	@Autowired
	TransactionCustomerService tserv;
	//Create or insert a student record
			@PostMapping("/postTransaction")
			public TransactionCustomerEntity insertTransaction(@RequestBody TransactionCustomerEntity transaction) {
				return tserv.insertTransaction(transaction);
			}
			
			//Read all records
			@GetMapping("/getAllTransaction")
			public List<TransactionCustomerEntity> getAllTransaction(){
				return tserv.getAllTransaction();
			}
			
			//Update a record
			@PutMapping("/putTransaction")
			public TransactionCustomerEntity putTransaction(@RequestParam int transactionid, @RequestBody TransactionCustomerEntity newTransactionDetails) throws Exception{
				return tserv.putTransaction(transactionid, newTransactionDetails);
			}
			
			//Delete a record 
			@DeleteMapping("/deleteTransaction/{transactionid}")
			public String deleteTransaction(@PathVariable int transactionid) {
				return tserv.deleteTransaction(transactionid);
			}
	
}
