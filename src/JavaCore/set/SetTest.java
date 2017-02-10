/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JavaCore.set;

/**
 *
 * @author ywu
 */
import java.util.*;


public class SetTest {
    public static void main(String[] args) {
    
        Set<String> words = new HashSet<>();
        
        long totalTime = 0;
        
        Scanner in = new Scanner(System.in);
        
        while (in.hasNext()) {
        
            String word = in.next();
            
            long callTime = System.currentTimeMillis();
            
            words.add(word);
            
            callTime = System.currentTimeMillis() - callTime;
            
            totalTime += callTime;
        }
        
        Iterator<String> iter = words.iterator();
        
        for (int i = 1; i <=20; ++i) {
        
            System.out.println(iter.next());
        }
        
        System.out.println("...");
        
        System.out.println(words.size() + " distinct words " + totalTime + " milliseconds");
    }
}
