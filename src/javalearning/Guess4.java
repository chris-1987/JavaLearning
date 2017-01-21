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
public class Guess4 {

    public static void main(String[] args)
            throws java.io.IOException {

        char ch, ignore, answer = 'K';

        do {

            System.out.println("I'm thinking of a letter btw A and Z.");

            System.out.println("Can you guess it:");

            // read a character from the console
            ch = (char) System.in.read();

            // discard any other characters in the buffered line
            do {
                ignore = (char) System.in.read();
            } while (ignore != '\n');

            if (ch == answer) {
                System.out.println("Right.");
            } else {
                System.out.print("... Sorry, you're ");

                if (ch < answer) {
                    System.out.println("too low");
                } else {
                    System.out.println("too high");
                }
                System.out.println("Try again\n");
            }
        } while (answer != ch);
    }
}
