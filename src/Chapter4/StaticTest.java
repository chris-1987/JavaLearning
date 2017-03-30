/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Chapter4;

/**
 *
 * @author ywu
 */
public class StaticTest {

    public static void main(String[] args) {

        Employee[] staff = new Employee[3];

        staff[0] = new Employee("Tom", 40000);
        staff[1] = new Employee("Dick", 60000);
        staff[2] = new Employee("Harry", 65000);

        for (Employee e : staff) {

            e.setId();

            System.out.println("name = " + e.getName() + ", id=" + e.getId() + ", salary=" + e.getSalary());
        }

        int n = Employee.getNextId();

        System.out.println("Next available id=" + n);
    }
}

