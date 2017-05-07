/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data.BusinessLogic;

/**
 *
 * @author kasper
 */
public class Part {
    
    private int partID;
    private int partPackageSize;
    private double partLength;
    private double partPrice;
    private String partUnitName;
    private String partType;
    private String partDescription;

    public Part(int partID, int partPackageSize, double partLength, double partPrice, String partUnitName, String partType, String partDescription) {
        this.partID = partID;
        this.partPackageSize = partPackageSize;
        this.partLength = partLength;
        this.partPrice = partPrice;
        this.partUnitName = partUnitName;
        this.partType = partType;
        this.partDescription = partDescription;
    }

    public int getPartID() {
        return partID;
    }

    public int getPartPackageSize() {
        return partPackageSize;
    }

    public double getPartLength() {
        return partLength;
    }

    public double getPartPrice() {
        return partPrice;
    }

    public String getPartUnitName() {
        return partUnitName;
    }

    public String getPartType() {
        return partType;
    }

    public String getPartDescription() {
        return partDescription;
    }
    
    
    
}
