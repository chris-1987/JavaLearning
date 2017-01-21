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
public class TwoDShape {

    double width;

    double height;

    void showDim() {

        System.out.println("Width and height are " + width + " and " + height);
    }
}

class Triangle extends TwoDShape {

    String style;

    double area() {

        return width * height / 2;
    }
    
    void showStyle() {
    
        System.out.println("Triangle is "  + style);
    }
};
