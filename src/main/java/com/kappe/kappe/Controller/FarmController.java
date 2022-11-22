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
import com.kappe.kappe.Entity.*;
import com.kappe.kappe.Service.FarmService;


@RestController
@RequestMapping("/farm")
public class FarmController {
	@Autowired
	FarmService fserv;
	
	//printHelloFarmer
	@GetMapping("/print")
	public String printHelloFarm() {
		return "Hello, Farmer!";
	}
	
	//Create or insert a student record
	@PostMapping("/postFarm")
	public FarmEntity insertFarm(@RequestBody FarmEntity farm) {
		return fserv.insertFarm(farm);
	}
	
	
	//Read all records
	@GetMapping("/getAllFarm")
	public List<FarmEntity> getAllFarm(){
		return fserv.getAllFarm();
	}
	
	//Read a record by farm name
	@GetMapping("/getByFarmname")
	public FarmEntity findByFarmname(@RequestParam String farmname) {
		return fserv.findByFarmname(farmname);	
	}
	
	//Update a record
	@PutMapping("/putFarm")
	public FarmEntity putFarm(@RequestParam int farmID, @RequestBody FarmEntity newFarmDetails) throws Exception{
		return fserv.putFarm(farmID, newFarmDetails);
	}
	
	//Delete a record
	@DeleteMapping("/deleteFarm/{farmID}")
	public String deleteFarm(@PathVariable int farmID) {
		return fserv.deleteFarm(farmID);
	}
}
