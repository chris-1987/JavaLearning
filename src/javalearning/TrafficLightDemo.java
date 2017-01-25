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
enum TrafficLightColor {

    RED, GREEN, YELLOW;
}

class TrafficLightSimulator implements Runnable {

    private Thread thrd;

    private TrafficLightColor tlc;

    boolean stop = false;

    boolean changed = false;

    TrafficLightSimulator(TrafficLightColor init) {

        tlc = init;

        thrd = new Thread(this);

        thrd.start();
    }

    TrafficLightSimulator() {

        tlc = TrafficLightColor.RED;

        thrd = new Thread(this);

        thrd.start();
    }

    public void run() {

        while (!stop) {

            try {

                switch (tlc) {

                    case GREEN:

                        Thread.sleep(10000);

                        break;

                    case YELLOW:

                        Thread.sleep(2000);
                        break;

                    case RED:
                        Thread.sleep(12000);

                        break;
                }
            } catch (InterruptedException e) {

                System.out.println(e);
            }

            changeColor();
        }
    }

    synchronized void changeColor() {

        switch (tlc) {

            case RED:
                tlc = TrafficLightColor.GREEN;
                break;

            case YELLOW:
                tlc = TrafficLightColor.RED;
                break;

            case GREEN:
                tlc = TrafficLightColor.YELLOW;
                break;
        }

        changed = true;

        notify();
    }

    synchronized void waitForChange() {

        try {

            while (!changed) {

                wait();
            }

            changed = false;
        } catch (InterruptedException exc) {

            System.out.println(exc);
        }
    }
    
    synchronized TrafficLightColor getColor() {
    
        return tlc;
    }
    
    synchronized void cancel() {
    
        stop = true;
    }
}

public class TrafficLightDemo {

}
