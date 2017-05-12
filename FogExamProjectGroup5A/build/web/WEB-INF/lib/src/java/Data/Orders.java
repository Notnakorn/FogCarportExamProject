/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data;

/**
 *
 * @author Smaug
 */
public class Orders {
    
    private int cupcakeBottom;
    private int cupcakeTopping;
    private int amount;
    
    public Orders(int bottom, int topping, int amount){
        this.cupcakeBottom = bottom;
        this.cupcakeTopping = topping;
        this.amount = amount;
    }

    /**
     * @return the cupcakeBottom
     */
    public int getCupcakeBottom() {
        return cupcakeBottom;
    }

    /**
     * @param cupcakeBottom the cupcakeBottom to set
     */
    public void setCupcakeBottom(int cupcakeBottom) {
        this.cupcakeBottom = cupcakeBottom;
    }

    /**
     * @return the cupcakeTopping
     */
    public int getCupcakeTopping() {
        return cupcakeTopping;
    }

    /**
     * @param cupcakeTopping the cupcakeTopping to set
     */
    public void setCupcakeTopping(int cupcakeTopping) {
        this.cupcakeTopping = cupcakeTopping;
    }

    /**
     * @return the amount
     */
    public int getAmount() {
        return amount;
    }

    /**
     * @param amount the amount to set
     */
    public void setAmount(int amount) {
        this.amount = amount;
    }

}
