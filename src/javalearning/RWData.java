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
public class RWData {

    public static void main(String args[]) {

        int i = 10;

        double d = 1023.56;

        boolean b = true;

        try (DataOutputStream dataOut = new DataOutputStream(new FileOutputStream("testData"))) { // try-with-resources

               System.out.println("Writing " + i);
               
               dataOut.writeInt(i);
               
               System.out.println("Writing " + d);
               
               dataOut.writeDouble(d);
               
                 System.out.println("Writing " + b);
               
               dataOut.writeBoolean(b);             
        }catch(IOException e) {
        
            System.out.println("Write Error");
            
            return;
        }
    }
}
