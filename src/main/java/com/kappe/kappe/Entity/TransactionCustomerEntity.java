package com.kappe.kappe.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="tbl_transactioncustomer")
public class TransactionCustomerEntity {
	@Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
	private int transactionid;
	private String item;
	private boolean status;
	private String paymenttype;
	private String paymentmethod;
	private double amount;
	
	@ManyToOne
	@JoinColumn(name="customerid")
	CustomerEntity customer;
	/*@ManyToOne
	@JoinColumn(name="id")
	KappeSupplierEntity supplier;
	*/
	
	public TransactionCustomerEntity(){}
	public TransactionCustomerEntity(int transactionid, String item, boolean status, String paymenttype, String paymentmethod, double amount, CustomerEntity customer) {
		super();
		this.transactionid = transactionid;
		this.item = item;
		this.status = status;
		this.paymenttype = paymenttype;
		this.paymentmethod = paymentmethod;
		this.amount = amount;
		this.customer = customer;
		//this.supplier = supplier;
	}
	public int getTransactionid() {
		return transactionid;
	}
//	public void setTransactionid(int transactionid) {
//		this.transactionid = transactionid;
//	}
	public String getItem() {
		return item;
	}
	public void setItem(String item) {
		this.item = item;
	}
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	public String getPaymenttype() {
		return paymenttype;
	}
	public void setPaymenttype(String paymenttype) {
		this.paymenttype = paymenttype;
	}
	public String getPaymentmethod() {
		return paymentmethod;
	}
	public void setPaymentmethod(String paymentmethod) {
		this.paymentmethod = paymentmethod;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public CustomerEntity getCustomer() {
		return customer;
	}
	public void setCustomer(CustomerEntity customer) {
		this.customer = customer;
	}
}
