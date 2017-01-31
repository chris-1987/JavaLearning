/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JavaCore;

import java.util.*;

/**
 *
 * @author ywu
 */
public class InputTest {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        System.out.println("What is your name? ");

        String name = in.nextLine();

        System.out.println("How old are you?");

        int age = in.nextInt();

        System.out.println("Hello, " + name + ". Next year, you will be " + (age + 1));
    }
}
