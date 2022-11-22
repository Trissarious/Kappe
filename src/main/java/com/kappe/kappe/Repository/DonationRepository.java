package com.kappe.kappe.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kappe.kappe.Entity.DonationEntity;

	@Repository
	public interface DonationRepository extends JpaRepository<DonationEntity, Integer>{
		
}
