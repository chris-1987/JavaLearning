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

public class TreeSetTest {

    public static void main(String[] args) {
        SortedSet<Item> parts = new TreeSet();

        parts.add(new Item("Toaster", 1234));

        parts.add(new Item("Widget", 4562));

        System.out.println(parts);

        SortedSet<Item> sortByDescription = new TreeSet<>(new Comparator<Item>() {

            public int compare(Item a, Item b) {

                String descrA = a.getDescription();

                String descrB = b.getDescription();

                return descrA.compareTo(descrB);
            }
        });
        
        sortByDescription.addAll(parts);
        
        
    }
}
