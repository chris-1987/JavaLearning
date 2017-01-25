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
interface Containment<T> {

    boolean contains(T o);
}

class MyClass<T> implements Containment<T> {

    T[] arrayRef;

    MyClass(T[] o) {

        arrayRef = o;
    }
    
    public boolean contains(T o) {
    
        for (T x : arrayRef) {
        
            if (x.equals(o)) return true;
        }
        
        return false;
    }
}

public class GenIFDemo {

}
