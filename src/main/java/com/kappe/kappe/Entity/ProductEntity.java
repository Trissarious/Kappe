package com.kappe.kappe.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="tbl_product")
public class ProductEntity {

		@Id
	    @GeneratedValue (strategy = GenerationType.IDENTITY)
	    private int productID;
	    
	    private String productName;
	    private String productCategory;
	    private double productReview;
	    
	  //getting the farm name  from the farm entity
	    @ManyToOne
		@JoinColumn(name="FarmID")
		FarmEntity farm;
		
	    
	    public ProductEntity() {}
	    
	    public ProductEntity(int productID, String productName, String productCategory, double productReview, FarmEntity farm) {
	        this.productID = productID;
	        this.productName = productName;
	        this.productCategory = productCategory;
	        this.productReview = productReview;
	        this.farm = farm;
	    }

		

		public FarmEntity getFarm() {
			return farm;
		}

		public void setFarm(FarmEntity farm) {
			this.farm = farm;
		}

		public int getProductID() {
			return productID;
		}

//		public void setProductID(int productID) {
//			this.productID = productID;
//		}

		public String getProductName() {
			return productName;
		}

		public void setProductName(String productName) {
			this.productName = productName;
		}

		public String getProductCategory() {
			return productCategory;
		}

		public void setProductCategory(String productCategory) {
			this.productCategory = productCategory;
		}

		public double getProductReview() {
			return productReview;
		}

		public void setProductReview(double productReview) {
			this.productReview = productReview;
		}
	    
	    
}
