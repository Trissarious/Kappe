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
@Table(name="tbl_inventory")
public class InventoryEntity {
	@Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
	private int inventoryID;
	
    private int quantity;
    private String description;
    private String category;
    private boolean status;
    
     //getting product name from product entity
    @OneToMany(cascade = CascadeType.MERGE)
    private Set<ProductEntity> product;
     //getting supplier name from the supplier entity
    @ManyToOne
    @JoinColumn(name="supplierID")
    private SupplierEntity supplier;
    
    public InventoryEntity() {}
    
    public InventoryEntity(int inventoryID, int quantity, String description, String category, boolean status, Set<ProductEntity> product, SupplierEntity supplier) {
    	super();
    	this.inventoryID = inventoryID;
        this.quantity = quantity;
        this.description = description;
        this.category = category;
        this.status = status;
        this.product = product;
        this.supplier = supplier;
    }

    public Set<ProductEntity> getProduct() {
		return product;
	}

	public void setProduct(Set<ProductEntity> product) {
		this.product = product;
	}

	public SupplierEntity getSupplier() {
		return supplier;
	}

	public void setSupplier(SupplierEntity supplier) {
		this.supplier = supplier;
	}

	public int getInventoryID() {
		return inventoryID;
	}
    
	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}
    
    
}
