/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javalearning;

/**
 *
 * @author ywu
 */
public class KbIn {
    
    public static void main(String args[]) 
            throws java.io.IOException{
    
            char ch;
            
            System.out.print("Press a key followed by Enter: ");
            
            ch = (char) System.in.read(); // get a char
            
            System.out.println("Your key is:" + ch);
    }
}
