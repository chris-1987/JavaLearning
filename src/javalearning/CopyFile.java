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

public class CopyFile {

    public static void main(String[] args) {

        int i;

        FileInputStream fin = null;

        FileOutputStream fout = null;

        if (args.length != 2) {

            System.out.println("Usage: CopyFile from to");

            return;
        }

        // copy a file
        try {
            // attempt to open the files
            fin = new FileInputStream(args[0]);

            fout = new FileOutputStream(args[1]);

            do {

                i = fin.read();

                if (i != -1) {
                    fout.write(i);
                }

            } while (i != -1);

        } catch (IOException exc) {

            System.out.println("I/O Error: " + exc);

        } finally {

            try {
                if (fin != null) {
                    fin.close();
                }

            } catch (IOException exc) {

                System.out.println("Error closing Input file.");
            }

            try {
                if (fout != null) {
                    fout.close();
                }

            } catch (IOException exc) {

                System.out.println("Error closing Output file.");
            }
        }
    }
}
