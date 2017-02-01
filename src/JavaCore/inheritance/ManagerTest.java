/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JavaCore.inheritance;

import JavaCore.inheritance.Employee;

/**
 *
 * @author ywu
 */
public class ManagerTest {

    public static void main(String[] args) {
        Manager boss = new Manager("Carl Cracker", 80000, 1987, 12, 15);

        boss.setBonus(5000);

        Employee[] staff = new Employee[3];

        staff[0] = boss;

        staff[1] = new Employee("Harry Hacker", 50000, 1989, 10, 1);

        staff[2] = new Employee("Tommy Tester", 40000, 1990, 3, 15);

        for (Employee e : staff) {

            System.out.println("");
        }
    }
}
