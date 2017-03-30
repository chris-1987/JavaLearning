/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Chapter4;

import java.util.*;

class Employee {

    private static int nextId;

    private int id;

    private String name = ""; // field assignment

    private double salary;

    // static initialization block
    static {

        Random generator = new Random();

        nextId = generator.nextInt(10000);
    }

    // initialization block
    {
        id = nextId;

        nextId++;
    }

    public Employee(String n, double s) {

        name = n;

        salary = s;
    }

    public Employee(double s) {

        this("Emplyee #" + nextId, s);
    }

    public Employee() {

        // name initialized to ""
        // salary not explicitly set--initialized to 0
        // id initialized in initialization block
    }

    public String getName() {

        return name;
    }

    public double getSalary() {
        return salary;
    }

    public int getId() {

        return id;
    }

    public void setId(int id) {

        this.id = id;
    }
}
