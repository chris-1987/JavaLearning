/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javalearning;

import java.io.*;

/**
 *
 * @author ywu
 */
class SumArray {

    private int sum;

    synchronized int sumArray(int nums[]) {

        sum = 0;

        for (int i = 0; i < nums.length; ++i) {

            sum += nums[i];

            System.out.println("Running total for " + Thread.currentThread().getName() + " is " + sum);

            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {

                System.out.println(" Thread interrupted.");
            }
        }

        return sum;
    }
}

class MyThread3 implements Runnable {

    Thread thrd;

    SumArray sa = new SumArray();

    int a[];

    int answer;

    MyThread3(String name, int nums[]) {

        thrd = new Thread(this, name);

        a = nums;

        thrd.start();

    }

    public void run() {

        int sum;

        System.out.println(thrd.getName() + " starting.");

        answer = sa.sumArray(a);

        System.out.println("Sum for " + thrd.getName() + " is " + answer);

        System.out.println(thrd.getName() + " terminating");
    }

}

public class Sync {

    public static void main(String args[]) {

        int a[] = {1, 2, 3, 4, 5};

        MyThread3 mt1 = new MyThread3("Child #1", a);
        
        MyThread3 mt2 = new MyThread3("Child #2", a);
        
        try{
            mt1.thrd.join();
            
            mt2.thrd.join();
        }catch(InterruptedException e) {
        
            System.out.println("Main thread interrupted.");
        }
        
    }
}
