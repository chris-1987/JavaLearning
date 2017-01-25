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
public interface ICharQ {
    
    void put(char ch) throws QueueFullException;
    
    char get() throws QueueEmptyException;
}
