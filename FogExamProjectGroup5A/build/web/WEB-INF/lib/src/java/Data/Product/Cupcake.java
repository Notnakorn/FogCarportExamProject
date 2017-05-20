
package Data.Product;


public class Cupcake {

Bottoms bottoms;
Toppings toppings;
    
private String description;
private double price;

public Cupcake(Bottoms bottoms, Toppings toppings){
    
    this.description = bottoms.getDescription()+ " cupcake with a toppong of " + toppings.getDescription();
    this.price = bottoms.getPrice() + toppings.getPrice();
    
    this.bottoms = bottoms;
    this.toppings = toppings;

}    

    /**
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @return the price
     */
    public double getPrice() {
        return price;
    }


}
