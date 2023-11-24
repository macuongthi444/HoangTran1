/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication20;

import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author hoang
 */
public class Menu {

    static Scanner scanner = new Scanner(System.in);
static int checkSizeOfArray(){
    int a = 0;

        boolean inputter = true;

        while (inputter) {
            try {
                System.out.print("Input a number: ");
                scanner = new Scanner(System.in);
                a = scanner.nextInt();
                if (a <=0) {
                    System.out.println("Input Error");
                    System.out.println("Please enter again!");
                    continue;
                }
                inputter = false;
            } catch (NumberFormatException | InputMismatchException e) {
                System.out.println("No input accepted! Please enter again!");
            }
        }

        return a;
}
static int fun(int n){
    if(n==1||n==2){
       return 1;
    }else
        return fun(n-1)+3*fun(n-2);
        
    
}
    public static void main(String[] args) {
//        System.out.println(" printf n");
//        int n = checkSizeOfArray();
//        
//        int n = 10/2;
//        System.out.println(n);
        System.out.println(fun(3));
    }
}
