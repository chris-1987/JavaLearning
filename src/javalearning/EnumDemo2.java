/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javalearning;

enum Transport {
    CAR, TRUNCK, AIRPLANE, TRAIN, BOAT
}

/**
 *
 * @author ywu
 */
public class EnumDemo2 {

    public static void main(String[] args) {

        Transport tp;

        System.out.println("Here are all Transport constants.");

        Transport allTransports[] = Transport.values();

        for (Transport t : allTransports) {

            System.out.println(t);
        }

        System.out.println();

        tp = Transport.valueOf("TRAIN");

        System.out.println(tp);
    }
}
