package com.kappe.kappe.Entity;

import java.sql.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="tbl_customer")
	public class CustomerEntity {
			@Id
		    @GeneratedValue (strategy = GenerationType.IDENTITY)
		    private int customerid;
			
		    private String firstname;
		    private String lastname;
		    private Date birthdate;
		    private String phonenum;
		    
	public CustomerEntity(){}
	
	public CustomerEntity(int customerid, String firstname, String lastname, Date birthdate, String phonenum) {
		super();
		this.customerid = customerid;
		this.firstname = firstname;
		this.lastname = lastname;
		this.birthdate = birthdate;
		this.phonenum = phonenum;
	}

	public int getCustomerid() {
		return customerid;
	}

//	public void setCustomerid(int customerid) {
//		this.customerid = customerid;
//	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public Date getBirthdate() {
		return birthdate;
	}

	public void setBirthdate(Date birthdate) {
		this.birthdate = birthdate;
	}

	public String getPhonenum() {
		return phonenum;
	}

	public void setPhonenum(String phonenum) {
		this.phonenum = phonenum;
	}


}
