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
interface StringFunc {

    String func(String str);
}

public class LambdaArgumentDemo {

    static String changeStr(StringFunc sf, String s) {

        return sf.func(s);
    }

    public static void main(String args[]) {

        String inStr = "Lambda Expressions Expand java";

        String outStr;

        System.out.println("Here is input string: " + inStr);

        StringFunc reverse = (str) -> {

            String result = "";

            for (int i = str.length() - 1; i >= 0; i--) {

                result += str.charAt(i);
            }

            return result;
        };

        outStr = changeStr(reverse, inStr);

        System.out.println("The string reversed: " + outStr);
    }
}
