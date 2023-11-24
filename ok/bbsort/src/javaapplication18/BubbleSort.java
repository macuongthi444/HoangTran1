/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication18;

import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author hoang
 */
public class BubbleSort {

    public static Scanner scanner = new Scanner(System.in);

    public static void bubbleSort(int arr[], int n) {
        
       
        for (int i = 0; i < n; i++) {
            
            for (int j = 0; j < n - i - 1; j++) {

                if (arr[j] > arr[j + 1]) {

                    // swap arr[j+1] và arr[i]
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    
                }
            }
            
        
            if (i == n - 1) {
                System.out.print("[" + arr[i] + "]");
                break;
            }
            System.out.print("[" + arr[i] + "]->");
        
        
        }
    }

    public static void create_array(int arr[], int n) {

        Random rand = new Random();
        for (int i = 0; i < n; i++) {
            arr[i] = rand.nextInt(30);
        }
    }

    // xuatmang
    public static void printf_array(int arr[], int n) {
        for (int i = 0; i < n; ++i) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static int InputInt() {

        int a = 0;

        boolean inputter = true;

        while (inputter) {
            try {
                System.out.print("Enter number of array: ");
                scanner = new Scanner(System.in);
                a = scanner.nextInt();
                if (a <= 1) {
                    System.out.println("The number you can not create array");
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

    public static void main(String[] args) {

        int n = InputInt();

        int a[] = new int[n];
        create_array(a, n);
        System.out.print("Unsorted array: ");
//        printf_array(a, n);
        System.out.print("Sorted array: ");
        bubbleSort(a, n);
        
//        printf_array(a, n);

    }
}
