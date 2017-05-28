
package BusinessLogic;

/**
 * PartListLines work as lines in the PartList and contain a part and a count,
 * to show how many of that specific part there is. 
 * 
 *
 * @author Kasper and Anton
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
