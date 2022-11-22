package com.kappe.kappe.Service;
import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kappe.kappe.Entity.ProductEntity;
import com.kappe.kappe.Repository.ProductRepository;

@Service
public class ProductService {
	@Autowired
	ProductRepository prepo;
	
	//C - Create or insert a product record
	public ProductEntity insertProduct(ProductEntity product) {
		return prepo.save(product);
	}
	
	//Read a record from the table named tbl_supplier
	public List<ProductEntity> getAllProduct() {
		return prepo.findAll();
	}
	
	//R - Read or search student record by product name
			public ProductEntity findByProductName(String productName) {
				if (prepo.findByProductName(productName) !=null)
					return prepo.findByProductName(productName);
				else
					return null;
			}
			
			//U - Update a product record
			public ProductEntity putProduct(int productID, ProductEntity newProductDetails) throws Exception{
				ProductEntity product = new ProductEntity();
				
				try {
					//steps in updating
					//Step 1 - search the id number of the product
					product = prepo.findById(productID).get();  //findById() is a pre-defined method
					
					//Step 2 - update the record
					product.setProductName(newProductDetails.getProductCategory());
					product.setProductCategory(newProductDetails.getProductCategory());
					product.setProductReview(newProductDetails.getProductReview());
					
					//Step 3 - save the information and return the value
					return prepo.save(product);
					
				} catch (NoSuchElementException nex) {
					throw new Exception("Product " + productID + " does not exist!");
				}
			}
			
			//D - Delete product record
			public String deleteProduct(int productID) {
				String msg;
				if (prepo.findById(productID) != null) {					//Step 1 - find the record
					prepo.deleteById(productID);                                //Step 2 - delete the record
					
					msg = "Product " + productID  + " is successfully deleted!";
				} else
					msg = "Product " + productID + " is NOT found!";
				
				return msg;
			}
}
