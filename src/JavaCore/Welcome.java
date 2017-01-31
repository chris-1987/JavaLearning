/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JavaCore;

/**
 *
 * @author ywu
 */
public class Welcome {

    public static void main(String[] args) {

        String[] greeting = new String[3];

        greeting[0] = "Welcome to Core java";

        greeting[1] = "by Cay Hrostmann";

        greeting[2] = "and Gary Cornell";

        for (String g : greeting) {

            System.out.println(g);
        }
    }
}
