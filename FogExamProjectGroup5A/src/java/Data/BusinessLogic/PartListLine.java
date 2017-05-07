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
public class PartListLine {
        
        private Part part;
        private int count;

    public PartListLine(Part part, int count) {
        this.part = part;
        this.count = count;
    }

    public Part getPart() {
        return part;
    }

    public int getCount() {
        return count;
    }
    
}
