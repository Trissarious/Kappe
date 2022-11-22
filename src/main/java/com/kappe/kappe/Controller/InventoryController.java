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

import com.kappe.kappe.Entity.InventoryEntity;
import com.kappe.kappe.Service.InventoryService;

@RestController
@RequestMapping("/inventory")
public class InventoryController {

	@Autowired
	InventoryService iserv;

	//printHelloSupplier
			@GetMapping("/print")
			public String printHelloInventory() {
				return "Hello, Inventory!";
			}
			
			//Create or insert an inventory
			@PostMapping("/postInventory")
			public InventoryEntity insertInventory(@RequestBody InventoryEntity inventory) {
				return iserv.insertInventory(inventory);
			}
			
			//Read all records
			@GetMapping("/getAllInventory")
			public List<InventoryEntity> getAllInventory(){
				return iserv.getAllInventory();
			}
			
			//Read a record by product name
			@GetMapping("/getByInventory")
			public InventoryEntity findByCategory(@RequestParam String category) {
				return iserv.findByCategory(category);	
			}
			
			//Update a record
			@PutMapping("/putInventory")
			public InventoryEntity putInventory(@RequestParam int inventoryID, @RequestBody InventoryEntity newInventoryDetails) throws Exception{
				return iserv.putInventory(inventoryID, newInventoryDetails);
			}
			
			//Delete a record
			@DeleteMapping("/deleteInventory/{inventoryID}")
			public String deleteInventory(@PathVariable int inventoryID) {
				return iserv.deleteInventory(inventoryID);
			}
}
