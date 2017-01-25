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
import java.io.*;

public class RandomAccessDemo {

    public static void main(String args[]) {

        double data[] = {19.4, 10.1, 123.54, 33.0, 87.9, 74.25};

        double d;

        // open and use a random access file.
        try (RandomAccessFile raf = new RandomAccessFile("random.dat", "rw")) {

            for (int i = 0; i < data.length; ++i) {

                raf.writeDouble(data[i]);
            }

            raf.seek(0);

            d = raf.readDouble();

            System.out.println("First value is " + d);

            raf.seek(8);

            d = raf.readDouble();

            System.out.println("Second value is " + d);

        } catch (IOException e) {

            System.out.println("I/O Error: " + e);  
        }
    }
}
