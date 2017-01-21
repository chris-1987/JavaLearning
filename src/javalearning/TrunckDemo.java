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
class Trunk extends Vehicle {

    private int cargocap;

    Trunk(int p, int f, int m, int c) {

        super(p, f, m);
        
        cargocap = c;
    }
    
    int getCargo() {return cargocap;}
    
    void putCargo(int c) {cargocap = c;}
};

public class TrunckDemo {

}
