/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JavaCore.pair2;

/**
 *
 * @author ywu
 */
import java.util.*;

public class Pairtest2 {

    public static void main(String[] args) {

        GregorianCalendar[] birthdays = {
            new GregorianCalendar(1906, Calendar.DECEMBER, 9),
            new GregorianCalendar(1815, Calendar.DECEMBER, 10),
            new GregorianCalendar(1903, Calendar.DECEMBER, 3),
            new GregorianCalendar(1910, Calendar.DECEMBER, 22),};

        Pair<GregorianCalendar> mm = ArrayAlg.minmax(birthdays);

        System.out.println("min = " + mm.getFirst().getTime());

        System.out.println("max = " + mm.getSecond().getTime());
    }
}

class ArrayAlg {

    public static <T extends Comparable> Pair<T> minmax(T[] a) {

        if (a == null || a.length == 0) {
            return null;
        }

        T min = a[0];

        T max = a[0];

        for (int i = 1; i < a.length; ++i) {

            if (min.compareTo(a[i]) > 0) {
                min = a[i];
            }

            if (max.compareTo(a[i]) < 0) {
                max = a[i];
            }
        }

        return new Pair<>(min, max);
    }
}
