package com.kappe.kappe.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="tbl_transactionsupplier")
public class TransactionSupplierEntity {
	@Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
	private int transactionsupplierid;
	
	private String item;
	private boolean status;
	private String paymenttype;
	private String paymentmethod;
	private double amount;
	
    @ManyToOne
	@JoinColumn(name="supplierID")
	SupplierEntity supplier;
    
    public TransactionSupplierEntity() {}
    
	 public TransactionSupplierEntity(int transactionsupplierid, String item, boolean status, String paymenttype, String paymentmethod, double amount, SupplierEntity supplier) {
			super();
			this.transactionsupplierid = transactionsupplierid;
			this.item = item;
			this.status = status;
			this.paymenttype = paymenttype;
			this.paymentmethod = paymentmethod;
			this.amount = amount;
			this.supplier = supplier;
		}
	 
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
		public SupplierEntity getSupplier() {
			return supplier;
		}
		public void setSupplier(SupplierEntity supplier) {
			this.supplier = supplier;
		}
		public int getTransactionsupplierid() {
			return transactionsupplierid;
		}
}
