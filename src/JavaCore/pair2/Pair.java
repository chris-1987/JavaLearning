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
public class Pair<T> {

    private T first;

    private T second;

    public Pair() {
        first = null;
        second = null;
    }

    public Pair(T _first, T _second) {

        first = _first;

        second = _second;
    }

    public T getFirst() {

        return first;
    }

    public T getSecond() {

        return second;
    }

    public void setFirst(T _first) {

        first = _first;
    }

    public void setSecond(T _second) {

        second = _second;
    }
}
