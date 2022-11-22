package com.kappe.kappe.Service;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kappe.kappe.Entity.SupplierEntity;
import com.kappe.kappe.Entity.TransactionSupplierEntity;
import com.kappe.kappe.Repository.TransactionSupplierRepository;

@Service
public class TransactionSupplierService {
	@Autowired
	TransactionSupplierRepository trepo;
	
	//C - Create or insert a supplier record
		public TransactionSupplierEntity insertSupplierTransaction(TransactionSupplierEntity suppliertransaction) {
			return trepo.save(suppliertransaction);
		}
		
		//Read a record from the table named tbl_suppliertransaction
		public List<TransactionSupplierEntity> getAllSupplierTransaction() {
			return trepo.findAll();
		}
		
		//R - Read or search student record by supplier last name
		public TransactionSupplierEntity findByItem(String item) {
			if (trepo.findByItem(item) !=null)
				return trepo.findByItem(item);
			else
				return null;
		}
		
		//U - Update a supplier record
		public TransactionSupplierEntity putSupplierTransaction(int transactionsupplierid, TransactionSupplierEntity newSupplierTransactionDetails) throws Exception{
			TransactionSupplierEntity suppliertransaction = new TransactionSupplierEntity();
			
			try {
				//steps in updating
				//Step 1 - search the id number of the supplier
				suppliertransaction = trepo.findById(transactionsupplierid).get();  //findById() is a pre-defined method
				
				//Step 2 - update the record
				suppliertransaction =trepo.findById(transactionsupplierid).get();
				suppliertransaction.setItem(newSupplierTransactionDetails.getItem());
				suppliertransaction.setStatus(newSupplierTransactionDetails.isStatus());
				suppliertransaction.setPaymenttype(newSupplierTransactionDetails.getPaymenttype());
				suppliertransaction.setPaymentmethod(newSupplierTransactionDetails.getPaymentmethod());
				suppliertransaction.setAmount(newSupplierTransactionDetails.getAmount());
				
				//Step 3 - save the information and return the value
				return trepo.save(suppliertransaction);
				
			} catch (NoSuchElementException nex) {
				throw new Exception("Supplier Transaction " + transactionsupplierid + " does not exist!");
			}
		}
		
		//D - Delete supplier record
		public String deleteSupplierTransaction(int transactionsupplierid) {
			String msg;
			if (trepo.findById(transactionsupplierid) != null) {					//Step 1 - find the record
				trepo.deleteById(transactionsupplierid);                                //Step 2 - delete the record
				
				msg = "Supplier Transaction" + transactionsupplierid  + " is successfully deleted!";
			} else
				msg = "Supplier Transaction" + transactionsupplierid + " is NOT found!";
			
			return msg;
		}
}
