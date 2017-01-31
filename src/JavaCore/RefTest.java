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
class Bingo {

    int cnt;

    void setCnt(int _cnt) {

        cnt = _cnt;
    }

    int getCnt() {

        return cnt;
    }
}

class Apple {

    Bingo b;

    Apple() {

        b = new Bingo();

        b.setCnt(3);
    }

    Bingo getBingo() {

        return b;
    }
}

public class RefTest {

    public static void main(String[] args) {

        Apple a = new Apple();

        Bingo obj = a.getBingo();

        System.out.println("before: " + a.getBingo().getCnt());

        a.getBingo().setCnt(4);

        System.out.println("after: " + a.getBingo().getCnt());

    }
}
