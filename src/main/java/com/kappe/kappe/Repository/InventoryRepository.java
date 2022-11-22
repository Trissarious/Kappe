package com.kappe.kappe.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kappe.kappe.Entity.InventoryEntity;
import com.kappe.kappe.Entity.ProductEntity;


@Repository
public interface InventoryRepository extends JpaRepository<InventoryEntity, Integer>{
	InventoryEntity findByCategory(String category); 
}
