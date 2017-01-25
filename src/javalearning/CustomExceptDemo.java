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
class NonIntResultException extends Exception {

    int n;

    int d;

    NonIntResultException(int n, int d) {

        this.n = n;

        this.d = d;
    }

    public String toString() {

        return "Result of " + n + " / " + d + " is non-integer.";
    }
}

public class CustomExceptDemo {

    public static void main(String args[]) {

        int numer[] = {4, 8, 15, 32, 64, 127, 256, 512};

        int denom[] = {2, 0, 4, 4, 0, 8};

        for (int i = 0; i < numer.length; ++i) {

            try {

                if ((numer[i] % 2) != 0) {

                    throw new NonIntResultException(numer[i], denom[i]);
                }
                System.out.println(numer[i] + "/ " + denom[i] + " is " + numer[i] / denom[i]);
            } catch (ArrayIndexOutOfBoundsException exc) {

                System.out.println("No matching element found.");
            } catch (NonIntResultException exc) {
                
                System.out.println(exc);
            }
        }
    }
}
