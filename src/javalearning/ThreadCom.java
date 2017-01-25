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
class TickTock {

    String state;

    synchronized void tick(boolean running) {

        if (!running) {

            state = "ticked";

            notify();

            return;
        }

        System.out.print("Tick");

        state = "ticked";

        notify();

        try {
            while (!state.equals("tocked")) {
                wait();
            }
        } catch (InterruptedException e) {

            System.out.println("Thread interrupted.");
        }
    }

    synchronized void tock(boolean running) {

        if (!running) {

            state = "tocked";

            notify();

            return;
        }

        System.out.println("Tock");

        state = "tocked";

        notify();

        try {

            while (!state.equals("ticked")) {
                wait();
            }
        } catch (InterruptedException e) {

            System.out.println("Thread interrupted.");
        }
    }

}

class MyThread4 implements Runnable {

    Thread thrd;

    TickTock ttOb;

    MyThread4(String name, TickTock tt) {

        thrd = new Thread(this, name);

        ttOb = tt;

        thrd.start();
    }

    public void run() {

        if (thrd.getName().compareTo("Tick") == 0) {

            for (int i = 0; i < 5; ++i) {
                ttOb.tick(true);
            }

            ttOb.tick(false);
        } else {

            for (int i = 0; i < 5; ++i) {
                ttOb.tock(true);
            }

            ttOb.tock(false);
        }
    }
}

public class ThreadCom {

    public static void main(String args[]) {

        TickTock tt = new TickTock();

        MyThread4 mt1 = new MyThread4("Tick", tt);

        MyThread4 mt2 = new MyThread4("Tock", tt);

        try {

            mt1.thrd.join();

            mt2.thrd.join();
        } catch (InterruptedException exc) {

            System.out.println("Main thread interrupted.");
        }
    }
}
