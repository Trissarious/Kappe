package com.kappe.kappe.Service;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kappe.kappe.Entity.CustomerEntity;
import com.kappe.kappe.Repository.CustomerRepository;

@Service
public class CustomerService {
	@Autowired
	CustomerRepository crepo;
	
	//C - Create or insert a supplier record
			public CustomerEntity insertCustomer(CustomerEntity customer) {
				return crepo.save(customer);
			}
			
			//Read a record from the table named tbl_supplier
			public List<CustomerEntity> getAllCustomer() {
				return crepo.findAll();
			}
//			
//			//R - Read or search student record by supplier last name
//			public SupplierEntity findBySupplierLname(String supplierLname) {
//				if (srepo.findBySupplierLname(supplierLname) !=null)
//					return srepo.findBySupplierLname(supplierLname);
//				else
//					return null;
//			}
//			
			//U - Update a supplier record
			public CustomerEntity putCustomer(int customerid, CustomerEntity newCustomerDetails) throws Exception{
				CustomerEntity customer = new CustomerEntity();
				
				try {
					customer =crepo.findById(customerid).get();
					customer.setFirstname(newCustomerDetails.getFirstname());
					customer.setLastname(newCustomerDetails.getLastname());
					customer.setBirthdate(newCustomerDetails.getBirthdate());
					customer.setPhonenum(newCustomerDetails.getPhonenum());
					return crepo.save(customer);
					
				} catch (NoSuchElementException nex) {
					throw new Exception("Customer " + customerid + " does not exist!");
				}
			}
			
			//D - Delete supplier record
			public String deleteCustomer(int customerid) {
				String msg;
				if(crepo.findById(customerid)!=null) {
					crepo.deleteById(customerid);
					msg="Customer ID number "+ customerid +" is successfully deleted!";
				}
				else {
					msg="Customer ID number "+ customerid +" is successfully deleted!";
				}
				return msg;
			}
}
