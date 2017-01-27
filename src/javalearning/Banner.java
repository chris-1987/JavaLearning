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
import java.applet.*;

import java.awt.*;

public class Banner extends Applet implements Runnable {

    String msg = " Java Rules the Web";

    Thread t;

    boolean stopFlag;

    public void init() {

        t = null;
    }

    public void start() {

        t = new Thread(this);

        stopFlag = false;

        t.start();
    }

    public void run() {

        for (;;) {

            try {

                repaint();

                Thread.sleep(250);

                if (stopFlag) {

                    break;
                }

            } 
            catch (InterruptedException exc) {
                //
            }
        }
    }

    public void stop() {

        stopFlag = true;

        t = null;
    }

    public void paint(Graphics g) {

        char ch;

        ch = msg.charAt(0);

        msg = msg.substring(1, msg.length());

        msg += ch;

        g.drawString(msg, 50, 30);
    }
}
