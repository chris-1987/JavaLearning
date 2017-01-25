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

public class ShowFile {

    public static void main(String[] args) {

        int i;

        FileInputStream fin;

        if (args.length != 1) {

            System.out.println("Usage: ShowFile File");

            return;
        }

        try {

            fin = new FileInputStream(args[0]);

        } catch (FileNotFoundException e) {

            System.out.println("File not Found");

            return;
        }

        try {

            do {

                i = fin.read();

                if (i != -1) {
                    System.out.print((char) i);
                }

            } while (i != -1);
        } catch (IOException e) {

            System.out.println("Error reading file");
        } finally {
            try {

                fin.close();
            } catch (IOException e) {

                System.out.println("Error closing file");
            }
        }

    }
}
