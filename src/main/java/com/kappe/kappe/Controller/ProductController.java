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

import com.kappe.kappe.Entity.ProductEntity;
import com.kappe.kappe.Entity.SupplierEntity;
import com.kappe.kappe.Service.ProductService;




@RestController
@RequestMapping("/product")
public class ProductController {

		@Autowired
		ProductService pserv;

		//printHelloSupplier
				@GetMapping("/print")
				public String printHelloProduct() {
					return "Hello, Product!";
				}
		
				//Create or insert a product record
				@PostMapping("/postProduct")
				public ProductEntity insertProduct(@RequestBody ProductEntity product) {
					return pserv.insertProduct(product);
				}
				
				//Read all records
				@GetMapping("/getAllProduct")
				public List<ProductEntity> getAllProduct(){
					return pserv.getAllProduct();
				}
				
				//Read a record by product name
				@GetMapping("/getByProduct")
				public ProductEntity findByProductName(@RequestParam String productName) {
					return pserv.findByProductName(productName);	
				}
				
				//Update a record
				@PutMapping("/putProduct")
				public ProductEntity putProduct(@RequestParam int productID, @RequestBody ProductEntity newProductDetails) throws Exception{
					return pserv.putProduct(productID, newProductDetails);
				}
				
				//Delete a record
				@DeleteMapping("/deleteProduct/{productID}")
				public String deleteProduct(@PathVariable int productID) {
					return pserv.deleteProduct(productID);
				}
}
