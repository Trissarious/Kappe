package com.kappe.kappe.Entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="tbl_supplier")
public class SupplierEntity {
	@Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private int supplierID;
    
    private String supplierFname;
    private String supplierLname;
    private double review;
    
    //getting the productname and review from the product
    @OneToMany(cascade = CascadeType.MERGE)
    private Set<ProductEntity> product;
    
    public SupplierEntity() {}
    
    public SupplierEntity(int supplierID, String supplierFname, String supplierLname,  double review ,Set<ProductEntity> product) {
        this.supplierID = supplierID;
        this.supplierFname = supplierFname;
        this.supplierLname = supplierLname;
        this.review = review;
        this.product = product;
    }

	public int getSupplierID() {
		return supplierID;
	}

//	public void setSupplierID(int supplierID) {
//		this.supplierID = supplierID;
//	}

	public String getSupplierFname() {
		return supplierFname;
	}

	public void setSupplierFname(String supplierFname) {
		this.supplierFname = supplierFname;
	}

	public String getSupplierLname() {
		return supplierLname;
	}

	public double getReview() {
		return review;
	}

	public void setReview(double review) {
		this.review = review;
	}

	public void setSupplierLname(String supplierLname) {
		this.supplierLname = supplierLname;
	}

	public Set<ProductEntity> getProduct() {
		return product;
	}

	public void setProduct(Set<ProductEntity> product) {
		this.product = product;
	}
 
	
    
}
