package com.kappe.kappe.Entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="tbl_donation")
public class DonationEntity {
	@Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private int donationID;
    private double donationamount;
    private String donationphonenum;
    
    @OneToMany(cascade = CascadeType.MERGE)
    private Set<CustomerEntity> customer;
    @ManyToOne
	@JoinColumn(name="FarmID")
	FarmEntity farm;
    
    public DonationEntity() {}
    
    public DonationEntity(int donationID, String donationfarm, String donationcustomer, double donationamount, String donationphonenum, Set<CustomerEntity> customer, FarmEntity farm) {
        this.donationID = donationID;
        this.donationamount = donationamount;
        this.donationphonenum = donationphonenum;        
        this.customer = customer;
        this.farm = farm;
    }

	public Set<CustomerEntity> getCustomer() {
		return customer;
	}

	public void setCustomer(Set<CustomerEntity> customer) {
		this.customer = customer;
	}

	public FarmEntity getFarm() {
		return farm;
	}

	public void setFarm(FarmEntity farm) {
		this.farm = farm;
	}

	public int getDonationID() {
		return donationID;
	}

//	public void setDonationID(int donationID) {
//		this.donationID = donationID;
//	}

	public double getDonationamount() {
		return donationamount;
	}

	public void setDonationamount(double donationamount) {
		this.donationamount = donationamount;
	}

	public String getDonationphonenum() {
		return donationphonenum;
	}

	public void setDonationphonenum(String donationphonenum) {
		this.donationphonenum = donationphonenum;
	}
}
