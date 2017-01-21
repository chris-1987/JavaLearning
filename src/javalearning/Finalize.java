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
class FDemo{

    int x;
    
    FDemo(int i) {
        
        x = i;
    }
    
    protected void finalize() {
    
        System.out.println("Finalizing " + x);
    }
    
    void generator(int i) {
        
        FDemo o = new FDemo(i);
    }
};


public class Finalize {
    public static void main(String args[]) {
    
        int count;
        
        FDemo ob = new FDemo(0);
        
        for (count = 1; count < 100000; count++) {
            
            ob.generator(count);
        }
    }
}
