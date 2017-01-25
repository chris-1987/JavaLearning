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
class MyThread2 extends Thread {

    MyThread2(String name) {

        super(name);

        start();
    }

    public void run() {

        System.out.println(getName() + " starting.");

        try {
            for (int count = 0; count < 10; ++count) {
                Thread.sleep(400);

                System.out.println("In " + getName() + ", count is " + count);
            }
        } catch (InterruptedException e) {
            System.out.println(getName() + " Interrupted.");
        }

        System.out.println(getName() + "terminating.");
    }
};

public class ExtendThread {

    public static void main(String args[]) {

        System.out.println("Main thread starting.");

        MyThread mt = new MyThread("Child #1");

        for (int i = 0; i < 50; ++i) {

            System.out.print(".");

            try {

                Thread.sleep(100);
            } catch (InterruptedException exc) {

                System.out.println("Main thread interrupted.");
            }
        }

        System.out.println("Main thread ending.");
    }
}
