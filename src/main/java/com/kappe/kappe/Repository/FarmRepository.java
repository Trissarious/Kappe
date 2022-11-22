package com.kappe.kappe.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.kappe.kappe.Entity.*;

@Repository
public interface FarmRepository extends JpaRepository<FarmEntity, Integer>{
		
				//user-defined query
			    FarmEntity findByFarmname(String farmname); 
		
}
