
package Data.BusinessLogic;

/**
 * The StringUtil helps us with the Overridden toString method in PartList.
 *
 * @author Tobias
 */
public class StringUtil
{
    public static String setLength(String str, int length)
    {
        
        
        String res;
        //Method implementation
        if(str.length() < length)
        {
            StringBuilder builder = new StringBuilder(str);
            for(int i = str.length(); i < length; ++i)
            {
                builder.append(' ');
            }
            res = builder.toString();
        }
        else if(str.length() > length)
        {
            res = str.substring(0, length-3) + "...";
        }
        else
        {
            res = str;
        }
        
        
        
        return res;
    }
}
