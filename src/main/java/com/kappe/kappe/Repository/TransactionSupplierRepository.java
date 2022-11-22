package com.kappe.kappe.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kappe.kappe.Entity.SupplierEntity;
import com.kappe.kappe.Entity.TransactionSupplierEntity;

@Repository
	public interface TransactionSupplierRepository extends JpaRepository<TransactionSupplierEntity, Integer>{
	TransactionSupplierEntity findByItem(String item); 
}
