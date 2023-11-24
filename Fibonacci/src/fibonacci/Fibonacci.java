/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fibonacci;

import java.util.Scanner;

/**
 *
 * @author hoang
 */
public class Fibonacci {

    static int n1 = 0, n2 = 1, n3 = 0;

    static int printFibonacci(int count) {
        if (count >= 1){
            n3 = n1 + n2;
            n1 = n2;
            n2 = n3;
            System.out.print(" " + n3);
            printFibonacci(count - 1);
        }
        else{
            return count;
        }
        return 0;
    }

    public static void main(String args[]) {
        int count = 45;
        System.out.println("The 45 sequence fibonacci");
        System.out.print(n1 + " " + n2);//printing 0 and 1    
        printFibonacci(count - 2);//n-2 because 2 numbers are already printed   
    }

}
