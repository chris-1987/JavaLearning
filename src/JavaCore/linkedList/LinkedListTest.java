/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JavaCore.linkedList;

/**
 *
 * @author ywu
 */
import java.util.*;

public class LinkedListTest {
    public static void main (String[] args) {
    
        List<String> a = new LinkedList<>();
        
        a.add("Amy");
        
        a.add("Carl");
        
        a.add("Erica");
        
        List<String> b = new LinkedList<>();
        
        b.add("Bob");
        
        b.add("Doug");
        
        b.add("Frances");
        
        b.add("Gloria");
        
        // merge the words from b into a
        ListIterator<String> aIter = a.listIterator();
        
        Iterator<String> bIter = b.listIterator();
        
        while (bIter.hasNext()){
        
            if (aIter.hasNext()) {
                
                aIter.add(bIter.next());
            }
        }
        
        System.out.println(a);
        
        bIter = b.iterator();
        
        while (bIter.hasNext()) {
        
            bIter.next();
            
            if (bIter.hasNext()) {
                
                bIter.next();
                
                bIter.remove();
            }
        }
        
        System.out.println(b);
        
        a.removeAll(b);
        
        System.out.println(a);
    }
}
