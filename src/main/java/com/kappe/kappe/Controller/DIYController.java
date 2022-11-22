package com.kappe.kappe.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.kappe.kappe.Entity.DIYEntity;
import com.kappe.kappe.Service.DIYService;


@RestController
@RequestMapping("/diy")
public class DIYController {
	@Autowired
	DIYService dyserv;
	
	//Create or insert a diy record
			@PostMapping("/postDiy")
			public DIYEntity insertDiy(@RequestBody DIYEntity diy) {
				return dyserv.insertDiy(diy);
}
			//Read all records
			@GetMapping("/getAllDiy")
			public List<DIYEntity> getAllFarm(){
				return dyserv.getAllDIY();
			}
			
			//Update a diy record
			@PutMapping("/putDiy")
			public DIYEntity putDiy(@RequestParam int diyID, @RequestBody DIYEntity newDiyDetails) throws Exception{
				return dyserv.putDiy(diyID, newDiyDetails);
			}
			
			//Delete a diy record
			@DeleteMapping("/deleteDiy/{diyID}")
			public String deleteDiy(@PathVariable int diyID) {
				return dyserv.deleteDiy(diyID);
			}
}
