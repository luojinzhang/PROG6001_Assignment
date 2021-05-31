
package ass3.mygame;
/**
 * The Item class contains information about the item
 * @author Cam Chuong Lac
 * @version 1.0
 */
public class Item
{
    private String description;
    private String name;
    private int destructivePower;
    private double healingPower;
    /**
     * Constructor of Item class
     * @param name A String represents the name of item
     * @param description A String with information about description of item
     * @param destructivePower An Integer represents the destructive power of item
     */
    public Item(String name, String description, int destructivePower)
    {
        this.name = name;
        this.description = description;
        this.destructivePower = destructivePower;
    }
    
    /**
     * Constructor of Item class
     * @param name A String represents the name of item
     * @param description A String with information about description of item
     * @param healingPower A Double represents the healing power of item
     */
    public Item(String name, String description, double healingPower)
    {
        this.name = name;
        this.description = description;
        this.healingPower = healingPower;
    }
    
    /**
     * The method getName
     * @return the name of item
     */
    public String getName(){
        return name;
    }
    /**
     * the method getDescription
     * @return the description of item
     */
    public String getDescription(){
        return description;
    }
    
    /**
     * The method getPower
     * @return the destructive power of item
     */
    public int getPower(){
        return destructivePower;
    }
}
