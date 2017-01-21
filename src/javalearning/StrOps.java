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
public class StrOps {

    public static void main(String[] args) {

        String str1 = "When it comes to Web programming, Java is #1.";

        String str2 = new String(str1);

        String str3 = "Java strings are powerful.";

        int result, idx;

        char ch;

        System.out.println("Length of str1 is: " + str1.length());

        for (int i = 0; i < str1.length(); ++i) {

            System.out.print(str1.charAt(i));
        }

        System.out.println();

        if (str1.equals(str2)) {

            System.out.println("str1 equals str2");
        } else {

            System.out.println("str1 does not equal str2. ");
        }

        result = str1.compareTo(str3);

        str2 = "One Two Three One";
        
        idx = str2.indexOf("One");

        System.out.println("Index of first occurrence of One: " + idx);

        idx = str2.lastIndexOf("One");

        System.out.println("Index of last occurrence of one: " + idx);
    }
}
