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
public class Bubble {

    public static void main(String args[]) {

        int nums[] = {99, -10, 10012, 18, -978, 5535, 232, 1, 3, 121};

        int a, b, t;

        int size;

        size = nums.length;

        System.out.print("Original array is: ");

        for (int i = 0; i < size; ++i) {
            System.out.print(" " + nums[i]);
        }

        System.out.println();

        for (a = 1; a < size; ++a) {
            for (b = size - 1; b >= a; --b) {

                if (nums[b - 1] > nums[b]) {

                    t = nums[b - 1];

                    nums[b - 1] = nums[b];

                    nums[b] = t;
                }
            }
        }

        // 
        System.out.print("Sorted array is: ");

        for (int i = 0; i < size; ++i) {

            System.out.print(" " + nums[i]);
        }
        System.out.println();
    }
}
