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
public class ThrowsDemo {

    public static char prompt(String str)
            throws java.io.IOException {

        System.out.print(str + ": ");

        return (char) System.in.read();
    }

    public static void main(String args[]) {

        char ch;

        try {

            ch = prompt("Enter a letter:");

        } catch (java.io.IOException exc) {

            System.out.println("I/O exception occurred.");

            ch = 'X';
        }
    }
}
