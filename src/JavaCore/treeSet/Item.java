/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JavaCore.treeSet;

/**
 *
 * @author ywu
 */
import java.util.*;

public class Item {

    private String description;

    private int partNumber;

    /**
     * Constructs an item.
     *
     * @param aDescription the item's description
     * @param apartNumber the item's part number
     */
    public Item(String aDescription, int aPartNumber) {

        description = aDescription;

        partNumber = aPartNumber;
    }

    /**
     * Gets the description of this item.
     *
     * @return the description
     */
    public String getDescription() {

        return description;
    }

    /**
     * to string
     */
    public String toString() {

        return "[description= " + description + ", partNumber=" + partNumber + "]";
    }

    public boolean equals(Object otherObject) {

        if (this == otherObject) {
            return true;
        }

        if (otherObject == null) {
            return false;
        }

        if (getClass() != otherObject.getClass()) {
            return false;
        }

        Item other = (Item) otherObject;

        return Objects.equals(description, other.description) && partNumber == other.partNumber;
    }

    public int hashCode() {

        return Objects.hash(description, partNumber);
    }

    public int compareTo(Item other) {

        return Integer.compare(partNumber, other.partNumber);
    }
}
