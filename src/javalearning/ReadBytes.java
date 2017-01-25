/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javalearning;

import java.io.*;
        
/**
 *
 * @author ywu
 */
public class ReadBytes {
    public static void main(String[] args) throws IOException{
    
        byte data[] = new byte[10];
        
        System.out.println("Enter some characters.");
        
        System.in.read(data);
        
        System.out.println("You entered: ");
        
        for (int i = 0; i < data.length; ++i) {
        
            System.out.print((char)data[i]);
        }
    }
}
