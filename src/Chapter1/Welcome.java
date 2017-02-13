/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Chapter1;

/**
 *
 * @author ywu
 */
public class Welcome {
    public static void main(String[] args) {
    
        String greeting = "Welcome to core Java!";
        
        System.out.println(greeting);
        
        for (int i = 0; i < greeting.length(); ++i) {
        
            System.out.println("=");
        }
        
        System.out.println();
    }
}
