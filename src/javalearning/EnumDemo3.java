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
enum Transport3 {
    CAR(65), TRUCK(55), AIRPLANE(600), TRAIN(70), BOAT(22); // each enumeration constant is an instance of type Transport3

    private int speed;

    Transport3(int s) {
        speed = s;
    }

    int getSpeed() {
        return speed;
    }

}

public class EnumDemo3 {

    public static void main(String args[]) {

        Transport3 tp;

        System.out.println("Typical speed for an airplane is " + Transport3.AIRPLANE.getSpeed() + " miles per hour.\n");

        System.out.println("All Transport speeds: ");

        for (Transport3 t : Transport3.values()) {

            System.out.println(t + " typical speed is " + t.getSpeed() + " miles per hour.");
        }
    }
}
