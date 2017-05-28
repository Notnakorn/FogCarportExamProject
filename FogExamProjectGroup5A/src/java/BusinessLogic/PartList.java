
package BusinessLogic;

import java.util.ArrayList;

/**
 * The PartList holds partlistlines that then holds parts.
 * The PartList has a Overrided toString method that is used to generate the email 
 * that is then send to customer and Fog-worker. 
 *
 * @author Kasper and Anton
 */
public class PartList {
    
    private ArrayList<PartListLine> partList = new ArrayList<PartListLine>();
    private double price;

    public PartList(ArrayList<PartListLine> partList, double price) {
        this.partList = partList;
        this.price = price;
    }

    public ArrayList<PartListLine> getPartList() {
        return partList;
    }

    public double getPrice() {
        return price;
    }
    
    @Override
    public String toString()
    {
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < partList.size(); i++) {
            
            
            res.append(StringUtil.setLength(partList.get(i).getPart().getPartType(), 35));
            res.append("  ");
            res.append(StringUtil.setLength(""+partList.get(i).getPart().getPartLength(), 5));
            res.append("  ");
            res.append(StringUtil.setLength(""+partList.get(i).getCount(), 5));
            res.append("  ");
            res.append(StringUtil.setLength(""+partList.get(i).getPart().getPartUnitName(), 5));
            res.append("  ");
            res.append(StringUtil.setLength(""+partList.get(i).getPart().getPartDescription(), 100));
            res.append("  ");          
            res.append('\n');
        }
        res.append("\nTotal price: ");
        res.append(price);
        return res.toString();
    }
    
}
