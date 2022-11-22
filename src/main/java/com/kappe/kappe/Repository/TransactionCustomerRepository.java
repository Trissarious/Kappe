package com.kappe.kappe.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kappe.kappe.Entity.TransactionCustomerEntity;
import com.kappe.kappe.Entity.TransactionSupplierEntity;

@Repository
public interface TransactionCustomerRepository extends JpaRepository<TransactionCustomerEntity, Integer>{
	TransactionCustomerEntity findByItem(String item); 
}
