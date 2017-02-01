/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JavaCore.inheritance;

/**
 *
 * @author ywu
 */
public class Manager extends Employee{

    private double bonus;
    
    public Manager(String n, double s, int year, int month, int day) {
    
        super(n, s, year, month, day);
        
        bonus = 0;
    }
    
    public double getSalary() {
        
        double baseSalary = super.getSalary();
        
        return baseSalary + bonus;
    }
    
    public void setBonus(double b) {
    
        bonus = b;
    }
}
