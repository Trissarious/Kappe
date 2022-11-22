package com.kappe.kappe.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kappe.kappe.Entity.SupplierEntity;

	@Repository
	public interface SupplierRepository extends JpaRepository<SupplierEntity, Integer>{
			
					//user-defined query
		SupplierEntity findBySupplierLname(String supplierLname); 
}
