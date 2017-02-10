/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JavaCore.map;

import java.util.*;

/**
 *
 * @author ywu
 */
public class MapTest {
    
    public static void main(String[] args) {
    
        Map<String, Employee> staff = new HashMap<>();
        
        staff.put("144-25-5464", new Employee("Amy Lee"));
  
        staff.put("567-24-2546", new Employee("Harry Hacker"));
            
        staff.put("157-62-7935", new Employee("Gary Cooper"));
        
        System.out.println(staff);
        
        staff.remove("567-24-2546");
        
        staff.put("456-62-5527", new Employee("Francesca Miller"));
        
        System.out.println(staff.getClass("157-62-7935"));
        
        for (Map.Entry<String, Employee> entry : staff.entrySet()) {
        
            String key = entry.getKey();
            
            Employee value = entry.getValue();
            
            System.out.println("key = " + key + ", value = " + value);
        }
    }
    
}
