/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JavaCore.priorityQueue;

/**
 *
 * @author ywu
 */
import java.util.*;

public class PriorityQueueTest {

    public static void main(String[] args) {

        PriorityQueue<GregorianCalendar> pq = new PriorityQueue();

        pq.add(new GregorianCalendar(1906, Calendar.DECEMBER, 9));
        pq.add(new GregorianCalendar(1903, Calendar.DECEMBER, 9));
        pq.add(new GregorianCalendar(1902, Calendar.DECEMBER, 9));

        System.out.println("Iterating over elements...");

        for (GregorianCalendar date : pq) {

            System.out.println(date.get(Calendar.YEAR));
        }

        System.out.println("Removing elements...");

        while (!pq.isEmpty()) {

            System.out.println(pq.remove().get(Calendar.YEAR));
        }
    }
}
