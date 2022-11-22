package com.kappe.kappe.Entity;



import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;



@Entity
@Table(name="tbl_farm")
public class FarmEntity {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private int farmID;
    
    private String farmname;
    private String lgu;
    
    public FarmEntity() {}
    
    public FarmEntity(int farmID, String farmname, String lgu) {
    	super();
        this.farmID = farmID;
        this.farmname = farmname;
        this.lgu = lgu;
        
    }



   public int getFarmID() {
        return farmID;
    }



//   public void setFarmID(int farmID) {
//        farmID = farmID;
//    }



   public String getFarmname() {
        return farmname;
    }



   public void setFarmname(String farmname) {
        this.farmname = farmname;
    }



   public String getLgu() {
        return lgu;
    }



   public void setLgu(String lgu) {
        this.lgu = lgu;
    }
    



}