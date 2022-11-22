package com.kappe.kappe.Service;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kappe.kappe.Entity.InventoryEntity;
import com.kappe.kappe.Repository.InventoryRepository;

@Service
public class InventoryService {
	@Autowired
	InventoryRepository irepo;

	//C - Create or insert a product record
		public InventoryEntity insertInventory(InventoryEntity inventory) {
			return irepo.save(inventory);
		}
		
		//Read a record from the table named tbl_supplier
		public List<InventoryEntity> getAllInventory() {
			return irepo.findAll();
		}
		
		//R - Read or search student record by category
				public InventoryEntity findByCategory(String category) {
					if (irepo.findByCategory(category) !=null)
						return irepo.findByCategory(category);
					else
						return null;
				}
				
				//U - Update a product record
				public InventoryEntity putInventory(int inventoryID, InventoryEntity newInventoryDetails) throws Exception{
					InventoryEntity inventory = new InventoryEntity();
					
					try {
						//steps in updating
						//Step 1 - search the id number of the product
						inventory = irepo.findById(inventoryID).get();  //findById() is a pre-defined method
						
						//Step 2 - update the record
						inventory.setCategory(newInventoryDetails.getCategory());
						inventory.setDescription(newInventoryDetails.getDescription());
						inventory.setQuantity(newInventoryDetails.getQuantity());
						inventory.setStatus(newInventoryDetails.isStatus());
						inventory.setProduct(newInventoryDetails.getProduct());
						
						//Step 3 - save the information and return the value
						return irepo.save(inventory);
						
					} catch (NoSuchElementException nex) {
						throw new Exception("Inventory " + inventory + " does not exist!");
					}
				}
				
				//D - Delete product record
				public String deleteInventory(int inventoryID) {
					String msg;
					if (irepo.findById(inventoryID) != null) {					//Step 1 - find the record
						irepo.deleteById(inventoryID);                                //Step 2 - delete the record
						
						msg = "Inventory " + inventoryID  + " is successfully deleted!";
					} else
						msg = "Inventory " + inventoryID + " is NOT found!";
					
					return msg;
				}
}
