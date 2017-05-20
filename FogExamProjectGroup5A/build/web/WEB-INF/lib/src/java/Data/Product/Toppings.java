/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data.Product;

/**
 *
 * @author Katja Kaj
 */
public class Toppings {
    
    private int tno;
    private String description;
    private double price;
    
   public Toppings(int tno,String description, double price){
       
       this.tno = tno;
       this.description = description;
       this.price = price;
       
   }

    /**
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description the description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * @return the price
     */
    public double getPrice() {
        return price;
    }

    /**
     * @param price the price to set
     */
    public void setPrice(double price) {
        this.price = price;
    }
    
}
