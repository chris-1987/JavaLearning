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
public class StringSwitch {

    public static void main(String[] args) {

        String command = "cancel";

        switch (command) {

            case "connect":
                System.out.println("Connecting");

                break;
            case "cancel":
                System.out.println("Canceling");
                break;

            case "disconnect":
                System.out.println("disconnecting");
                break;
            default:
                System.out.println("Command Error!");
                break;
        }
    }
}
