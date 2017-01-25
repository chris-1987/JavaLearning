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
class ExcTest {

    static void genException() {

        int nums[] = new int[4];

        System.out.println("Before exception is generated.");

        nums[7] = 10;

        System.out.println("this won't be displayed");
    }
}

class UseThrowablemethods {

    public static void main(String args[]) {

        try {
            ExcTest.genException();
        } catch (ArrayIndexOutOfBoundsException exc) {

            System.out.println("Standard message is: ");

            System.out.println(exc);

            System.out.println("\n Stack trace:");

            exc.printStackTrace();
        }

        System.out.println("After the catch statement.");
    }
}