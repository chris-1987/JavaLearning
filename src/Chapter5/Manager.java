/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Chapter5;

/**
 *
 * @author ywu
 */
public class Manager extends Employee {

    private double bonus;

    public Manager(String name, double salary, int year, int month, int day) {

        super(name, salary, year, month, day); // invoke super ctor; otherwise, invode no-argument ctor

        bonus = 0;
    }

    public double getSalary() {

        double baseSalary = super.getSalary();

        return baseSalary + bonus;
    }
    
    public void setBonus (double b) {
    
        bonus = b;
    }
}
