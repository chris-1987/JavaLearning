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
public class IfDemo {

    public static void main(String args[]) {

        int a, b, c;

        a = 2;
        b = 3;

        if (a < b) {
            System.out.println("a is less than b.");
        }

        if (a == b) {
            System.out.println("you won't see me.");
        }

        System.out.println();

        c = a - b;

        System.out.println("c contains - 1");
        
        if (c >= 0) {
            
            System.out.println("c is non-negative.");
        }

        if (c < 0) {
            
            System.out.println("c is negative");
        }
    }
}
