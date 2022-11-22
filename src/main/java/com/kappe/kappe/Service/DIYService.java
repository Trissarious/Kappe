package com.kappe.kappe.Service;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kappe.kappe.Entity.DIYEntity;
import com.kappe.kappe.Repository.DIYRepository;



@Service
public class DIYService {
	@Autowired
	DIYRepository dyrepo;
	
	//C - Create or insert a supplier record
	public DIYEntity insertDiy(DIYEntity diy) {
		return dyrepo.save(diy);
	}
	
	//Read a record from the table named tbl_supplier
	public List<DIYEntity> getAllDIY() {
		return dyrepo.findAll();
	}
	
	//U - Update a donation record
	public DIYEntity putDiy(int diyID, DIYEntity newDiyDetails) throws Exception{
		DIYEntity diy = new DIYEntity();
		
		try {
			diy = dyrepo.findById(diyID).get(); 
			diy.setResults(newDiyDetails.getResults());
			diy.setRecipe(newDiyDetails.getRecipe());
			return dyrepo.save(diy);
			
		} catch (NoSuchElementException nex) {
			throw new Exception("DIY ID " + diyID + " does not exist!");
		}
	}
	
	//D - Delete student record
	public String deleteDiy(int diyID) {
		String msg;
		if (dyrepo.findById(diyID) != null) {					//Step 1 - find the record
			dyrepo.deleteById(diyID);                                //Step 2 - delete the record
			
			msg = "DIY ID " + diyID  + " is successfully deleted!";
		} else
			msg = "DIY ID " + diyID + " is NOT found!";
		
		return msg;
	}
}
