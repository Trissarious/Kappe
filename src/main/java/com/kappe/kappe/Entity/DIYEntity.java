package com.kappe.kappe.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="tbl_diy")
public class DIYEntity {
	@Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private int diyID;
    private String results;
    private String recipe;
    
    public DIYEntity() {}
    
    public DIYEntity(int diyID, String results, String recipe) {
    	this.diyID = diyID;
    	this.results = results;
    	this.recipe = recipe;
    }

	public int getDiyID() {
		return diyID;
	}

//	public void setDiyID(int diyID) {
//		this.diyID = diyID;
//	}

	public String getResults() {
		return results;
	}

	public void setResults(String results) {
		this.results = results;
	}

	public String getRecipe() {
		return recipe;
	}

	public void setRecipe(String recipe) {
		this.recipe = recipe;
	}
}
