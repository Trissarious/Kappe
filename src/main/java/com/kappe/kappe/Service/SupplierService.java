package com.kappe.kappe.Service;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kappe.kappe.Entity.SupplierEntity;
import com.kappe.kappe.Repository.SupplierRepository;

@Service
public class SupplierService {
	@Autowired
	SupplierRepository srepo;

	//C - Create or insert a supplier record
		public SupplierEntity insertSupplier(SupplierEntity supplier) {
			return srepo.save(supplier);
		}
		
		//Read a record from the table named tbl_supplier
		public List<SupplierEntity> getAllSupplier() {
			return srepo.findAll();
		}
		
		//R - Read or search student record by supplier last name
		public SupplierEntity findBySupplierLname(String supplierLname) {
			if (srepo.findBySupplierLname(supplierLname) !=null)
				return srepo.findBySupplierLname(supplierLname);
			else
				return null;
		}
		
		//U - Update a supplier record
		public SupplierEntity putSupplier(int supplierID, SupplierEntity newSupplierDetails) throws Exception{
			SupplierEntity supplier = new SupplierEntity();
			
			try {
				//steps in updating
				//Step 1 - search the id number of the supplier
				supplier = srepo.findById(supplierID).get();  //findById() is a pre-defined method
				
				//Step 2 - update the record
				supplier.setSupplierFname(newSupplierDetails.getSupplierFname());
				supplier.setSupplierLname(newSupplierDetails.getSupplierLname());
				supplier.setReview(newSupplierDetails.getReview());
				
				//Step 3 - save the information and return the value
				return srepo.save(supplier);
				
			} catch (NoSuchElementException nex) {
				throw new Exception("Supplier " + supplierID + " does not exist!");
			}
		}
		
		//D - Delete supplier record
		public String deleteSupplier(int supplierID) {
			String msg;
			if (srepo.findById(supplierID) != null) {					//Step 1 - find the record
				srepo.deleteById(supplierID);                                //Step 2 - delete the record
				
				msg = "Supplier ID " + supplierID  + " is successfully deleted!";
			} else
				msg = "Supplier ID " + supplierID + " is NOT found!";
			
			return msg;
		}
}
