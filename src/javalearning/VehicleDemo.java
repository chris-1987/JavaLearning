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
class Vehicle {

    private int passengers;

    private int fuelcap;

    private int mpg;

    Vehicle(int p, int f, int m) {

        passengers = p;

        fuelcap = f;

        mpg = m;
    }

    void range() {

        System.out.println("Range is " + fuelcap * mpg);
    }
};

public class VehicleDemo {

    public static void main(String args[]) {

        Vehicle minivan = new Vehicle(5, 4, 2);

        int range;

        //       minivan.passengers = 7;
        //       minivan.mpg = 21;
        //      minivan.fuelcap = 16;
        //      range = minivan.fuelcap * minivan.mpg;
        //       System.out.println("Minivan can carry " + minivan.passengers + " with a range of " + range);
    }
}
