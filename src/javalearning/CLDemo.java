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
public class CLDemo {

    public static void main(String args[]) {

        System.out.println("There are " + args.length + " command-line arguments");
        System.out.println("They are: ");

        for (int i = 0; i < args.length; ++i) {
            System.out.println("args[" + i + "]" + args[i]);
        }
    }
}
