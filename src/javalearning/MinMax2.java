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
public class MinMax2 {

    public static void main(String args[]) {

        int nums[] = {99, -10, 10012, 18, -978, 5535, 232, 1, 3, 121};

        int min, max;

        min = max = nums[0];

        for (int i = 1; i < 10; ++i) {
            if (nums[i] < min) {
                min = nums[i];
            }

            if (nums[i] > max) {
                max = nums[i];
            }
        }

        System.out.println("min: " + min + " max: " + max + "\n");
    }
}
