package com.kappe.kappe.Service;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kappe.kappe.Entity.DonationEntity;
import com.kappe.kappe.Repository.DonationRepository;

@Service
public class DonationService {
	@Autowired
	DonationRepository drepo;

	//C - Create or insert a donation record
		public DonationEntity insertDonation(DonationEntity donation) {
			return drepo.save(donation);
		}
		
		//Read a record from the table named tbl_donation
		public List<DonationEntity> getAllDonation() {
			return drepo.findAll();
		}
		
//		//R - Read or search donation record by customer
//		public DonationEntity findByDonationcustomer(String donationcustomer) {
//			if (drepo.findByDonationcustomer(donationcustomer) !=null)
//				return drepo.findByDonationcustomer(donationcustomer);
//			else
//				return null;
//		}

//		//R - Read or search donation record by farm
//		public DonationEntity findByDonationfarm(String donationfarm) {
//			if (drepo.findByDonationarm(donationfarm) !=null)
//				return drepo.findByDonationfarm(donationfarm);
//			else
//				return null;
//		}
		
		//U - Update a donation record
		public DonationEntity putDonation(int donationID, DonationEntity newDonationDetails) throws Exception{
			DonationEntity donation = new DonationEntity();
			
			try {
				//steps in updating donation
				//Step 1 - search the id number of the donation
				donation = drepo.findById(donationID).get();  //findById() is a pre-defined method
				
				//Step 2 - update the donation record
				donation.setFarm(newDonationDetails.getFarm());
				donation.setCustomer(newDonationDetails.getCustomer());
				donation.setDonationamount(newDonationDetails.getDonationamount());
				donation.setDonationphonenum(newDonationDetails.getDonationphonenum());
				
				//Step 3 - save the information and return the value
				return drepo.save(donation);
				
			} catch (NoSuchElementException nex) {
				throw new Exception("Donation " + donationID + " does not exist!");
			}
		}
		
		//D - Delete student record
		public String deleteDonation(int donationID) {
			String msg;
			if (drepo.findById(donationID) != null) {					//Step 1 - find the record
				drepo.deleteById(donationID);                                //Step 2 - delete the record
				
				msg = "Donation ID " + donationID  + " is successfully deleted!";
			} else
				msg = "Donation ID " + donationID + " is NOT found!";
			
			return msg;
		}
}
