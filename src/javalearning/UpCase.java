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
public class UpCase {
    public static void main(String args[]) {
    
        char ch;
        
        for (int i = 0; i < 10; ++i) {
                    
            ch = (char) ('a' + i);
            
            System.out.print(ch);
            
            ch = (char) ((int)ch & 65503); 
            
            System.out.print(ch + " ");
        }
    }
}
