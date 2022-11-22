package com.kappe.kappe.Service;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kappe.kappe.Entity.TransactionCustomerEntity;
import com.kappe.kappe.Repository.TransactionCustomerRepository;

@Service
public class TransactionCustomerService {
	@Autowired
	TransactionCustomerRepository trepo;
	
	public TransactionCustomerEntity insertTransaction(TransactionCustomerEntity transaction) {
		return trepo.save(transaction);
	}

	public List<TransactionCustomerEntity> getAllTransaction(){
		return trepo.findAll();
	}
	
//	public TransactionCustomerEntity findByItem(TransactionCustomerEntity item) {
//		if(trepo.findByItem(item)!=null)
//			return trepo.findByItem(item);
//		else
//			return null;
//	}
	
	public TransactionCustomerEntity putTransaction(int transactionid, TransactionCustomerEntity newTransactionDetails)throws Exception{
		TransactionCustomerEntity transaction= new TransactionCustomerEntity();
		try{
			transaction =trepo.findById(transactionid).get();
			transaction.setItem(newTransactionDetails.getItem());
			transaction.setStatus(newTransactionDetails.isStatus());
			transaction.setPaymenttype(newTransactionDetails.getPaymenttype());
			transaction.setPaymentmethod(newTransactionDetails.getPaymentmethod());
			transaction.setAmount(newTransactionDetails.getAmount());
			return trepo.save(transaction);
		}catch(NoSuchElementException nex){
			throw new Exception("It does not exist");
		}
	}
	public String deleteTransaction(int transactionid){
		String msg;
		if(trepo.findById(transactionid)!=null) {
			trepo.deleteById(transactionid);
			msg="Customer ID Number "+ transactionid+ " is successfully deleted!";
		}
		else {
			msg="Customer ID Number " + transactionid+ " is successfully deleted!";
		}
		return msg;
	}
}
