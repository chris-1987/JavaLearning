
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


class CircularQueue implements ICharQ {

    private char q[];

    private int putloc, getloc;

    public CircularQueue(int size) {

        q = new char[size + 1];

        putloc = getloc = 0;
    }

    public void put(char ch) {

        if (putloc + 1 == getloc | (putloc == q.length - 1) & (getloc == 0)) {

            System.out.println(" - Queue is full.");
        }

        q[putloc++] = ch;

        if (putloc == q.length) {
            putloc = 0;
        }

        return;
    }

    public char get() {

        if (getloc == putloc) {

            System.out.println(" - Queue is empty.");

            return (char) 0;
        }

        char ch = q[getloc++];

        if (getloc == q.length) {
            getloc = 0;
        }

        return ch;
    }
}

// a dynamic queue.
class DynQueue implements ICharQ {

    private char q[];

    private int putloc, getloc;

    public DynQueue(int size) {

        q = new char[size];

        putloc = getloc = 0;
    }

    // put a character into the queue
    public void put(char ch) {

        if (putloc == getloc) {

            char t[] = new char[q.length * 2];

            for (int i = 0; i < q.length; ++i) {

                t[i] = q[i];
            }

            q = t;
        }

        q[putloc++] = ch;
    }

    // get a character from the queue.
    public char get() {

        if (getloc == putloc) {

            System.out.println(" - Queue is empty.");

            return (char) 0;
        }

        return q[getloc++];
    }
};

class IQDemo {

    public static void main(String args[]) {

        FixedQueue q1 = new FixedQueue(10);

        DynQueue q2 = new DynQueue(5);

        CircularQueue q3 = new CircularQueue(10);

        ICharQ iq;

        char ch;

        int i;

        iq = q1;
        
        for (i = 0; i < 10; ++i) {
        
            try {
            iq.put((char) ('A' + i));
            }
            catch (QueueFullException e) {
            
                // do nothing
            }
        }
    }
};
