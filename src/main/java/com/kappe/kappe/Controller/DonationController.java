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

import com.kappe.kappe.Entity.DonationEntity;
import com.kappe.kappe.Service.DonationService;

@RestController
@RequestMapping("/donation")
public class DonationController {
	@Autowired
	DonationService spserv;
		
		//Create or insert a donation record
		@PostMapping("/postDonation")
		public DonationEntity insertDonation(@RequestBody DonationEntity donation) {
			return spserv.insertDonation(donation);
		}
		
		//Read all donation records
		@GetMapping("/getAllDonation")
		public List<DonationEntity> getAllDonation(){
			return spserv.getAllDonation();
		}
//		
//		//Read a donation record by farm
//		@GetMapping("/getByfarm")
//		public DonationEntity findByDonationfarm(@RequestParam String donationfarm) {
//			return spserv.findByDonationfarm(donationfarm);	
//		}
//
//		//Read a donation record by customer
//		@GetMapping("/getBycustomer")
//		public SupplierEntity findBycustomer(@RequestParam String donationcustomer) {
//			return spserv.findByDonationcustomer(donationcustomer);	
//		}

		//Update a donation record
		@PutMapping("/putDonation")
		public DonationEntity putDonation(@RequestParam int donationID, @RequestBody DonationEntity newDonationDetails) throws Exception{
			return spserv.putDonation(donationID, newDonationDetails);
		}
		
		//Delete a donation record
		@DeleteMapping("/deleteDonation/{donationID}")
		public String deleteDonation(@PathVariable int donationID) {
			return spserv.deleteDonation(donationID);
		}
}
