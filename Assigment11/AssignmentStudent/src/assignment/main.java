/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 *
 * @author hoang
 */
public class main {

    public static void main(String[] args) {
        
       

        Queue q = new Queue();
        q.enqueue(new Student("HE164485", "VAN", 10));
        q.enqueue(new Student("he164280", "Hoang", 7));
        q.enqueue(new Student("he164260", "tran", 8));
        q.enqueue(new Student("he164270", "hai", 10));
        q.dequeue();
        q.dequeue();
        q.display();
        System.out.println("first student");
        System.out.println(q.peek());
       
        q.clear();
    }
}
