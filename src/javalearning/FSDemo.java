/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javalearning;

class FailSoftArray {

    private int a[];

    private int errval;

    public int length;

    public FailSoftArray(int size, int errv) {

        a = new int[size];

        errval = errv;

        length = size;
    }

    public int get(int index) {

        if (indexOK(index)) {
            return a[index];
        }

        return errval;
    }

    public boolean put(int index, int val) {

        if (indexOK(index)) {

            a[index] = val;

            return true;
        }

        return false;
    }

    private boolean indexOK(int index) {

        if (index >= 0 & index < length) {
            return true;
        }
        return false;
    }
};

/**
 *
 * @author ywu
 */
public class FSDemo {

    public static void main(String args[]) {

        FailSoftArray fs = new FailSoftArray(5, -1);

        int x;

        System.out.println("Fail quietly.");

        for (int i = 0; i < (fs.length * 2); ++i) {
            fs.put(i, i * 10);
        }

        for (int i = 0; i < (fs.length * 2); ++i) {

            x = fs.get(i);
        }

        System.out.println("");
    }
}
