/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ywu
 */
public class Help {
    public static void main(String args[]) 
    throws java.io.IOException{
    
        System.out.println("Help on: \n 1. if \n 2. swith \n Choose one: ");
        
        char choice = (char)System.in.read();
        
        switch(choice) {
        
            case '1': System.out.println("The if:\n if (condition) statement; \n else statement;");
            
            break;
            
            case '2': System.out.println("The switch:\nswitch(expression) {\n  case constant: \n    statement sequence\n    break;\n    // ...\n}");
            break;
            
            default:
                System.out.println("Selection not found.");
        }
    }
}
