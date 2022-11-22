package com.kappe.kappe.Service;

import java.util.List;
import java.util.NoSuchElementException;
import com.kappe.kappe.Entity.FarmEntity;
import com.kappe.kappe.Repository.FarmRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FarmService {
	@Autowired
	FarmRepository frepo;
	
	//C - Create or insert a student record
	public FarmEntity insertFarm(FarmEntity farm) {
		return frepo.save(farm);
	}
	
	
	//Read a record from the table named tbl_student
	public List<FarmEntity> getAllFarm() {
		return frepo.findAll();
	}
	
	//R - Read or search student record by farm name
	public FarmEntity findByFarmname(String farmname) {
		if (frepo.findByFarmname(farmname) !=null)
			return frepo.findByFarmname(farmname);
		else
			return null;
	}
	
	//U - Update a student record
	public FarmEntity putFarm(int farmID, FarmEntity newFarmDetails) throws Exception{
		FarmEntity farm = new FarmEntity();
		
		try {
			//steps in updating
			//Step 1 - search the id number of the student
			farm = frepo.findById(farmID).get();  //findById() is a pre-defined method
			
			//Step 2 - update the record
			farm.setFarmname(newFarmDetails.getFarmname());
			farm.setLgu(newFarmDetails.getLgu());
			
			//Step 3 - save the information and return the value
			return frepo.save(farm);
			
		} catch (NoSuchElementException nex) {
			throw new Exception("Farm " + farmID + " does not exist!");
		}
	}
	
	//D - Delete student record
	public String deleteFarm(int farmID) {
		String msg;
		if (frepo.findById(farmID) != null) {					//Step 1 - find the record
			frepo.deleteById(farmID);                                //Step 2 - delete the record
			
			msg = "Farm " + farmID  + " is successfully deleted!";
		} else
			msg = "Farm " + farmID + " is NOT found!";
		
		return msg;
	}
}
