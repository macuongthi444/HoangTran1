/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package menubbsort;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author hoang
 */
public class Menubbsort {

    static Scanner scanner = new Scanner(System.in);
//System.out.println("Please input a number.");
//                System.out.print("Enter again: ");
//                
//                
//                 System.out.println("Input Length Of Arrays");
//        System.out.print("Enter number: ");
//        System.out.println("Please input number greater than zero.");
//                    System.out.print("Enter again: ");

    static int checkInputInt() {
        int a = 0;
        boolean input = true;
        while (input) {
            try {
                scanner = new Scanner(System.in);
                a = scanner.nextInt();
                break;

            } catch (NumberFormatException | InputMismatchException e) {
                System.out.println("Please input a number.");
                System.out.print("Enter again: ");

            }
        }
        return a;
    }

    public static int inputSizeOfArray() {

        int a = 0;

        boolean inputter = true;
        System.out.println("Input Length Of Arrays");
        System.out.print("Enter number: ");
        while (inputter) {
            try {

                scanner = new Scanner(System.in);
                a = scanner.nextInt();
                if (a <= 0) {
                    System.out.println("Please input number greater than zero.");
                    System.out.print("Enter again: ");
                    continue;
                }
                inputter = false;
            } catch (NumberFormatException | InputMismatchException e) {
                System.out.println("Please input number greater than zero.");
                System.out.print("Enter again: ");
            }
        }

        return a;

    }

    public static int[] inputValueOfArray() {
        int n = inputSizeOfArray();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            System.out.print("Enter number " + i + ": ");
            a[i] = checkInputInt();
        }
        return a;
    }

    public static void sortArray(int[] a, boolean choice) {
        int len = a.length;

        if (len == 0) {
            System.out.println("List empty.");
        }

        for (int i = 0; i < len; i++) {

            for (int j = 0; j < len - i - 1; j++) {

                if (choice == true) {
                    if (a[j] > a[j + 1]) {
                        // swap arr[j+1] và arr[i]
                        int temp = a[j];
                        a[j] = a[j + 1];
                        a[j + 1] = temp;
                    }

                }

                if (choice == false) {

                    if (a[j] < a[j + 1]) {
                        // swap arr[j+1] và arr[i]
                        int temp = a[j];
                        a[j] = a[j + 1];
                        a[j + 1] = temp;

                    }
                }

            }
        }
    }

    static void printf(int[] a, boolean choice) {

        System.out.println();
        for (int i = 0; i < a.length; i++) {
            if (i == a.length - 1) {
                System.out.print("[" + a[i] + "]");
            }
            if (i != a.length - 1 && choice == true) {
                System.out.print("[" + a[i] + "]->");
            }
            if (i != a.length - 1 && choice == false) {
                System.out.print("[" + a[i] + "]<-");
            }
        }

//            if(choice ==false){
//                System.out.println();
//        for (int i = 0; i < a.length; i++) {
//            if (i == a.length - 1) {
//                System.out.print("[" + a[i] + "]");
//                break;
//            }
//            System.out.print("[" + a[i] + "]<-");
//        }
//        System.out.println();
//            }
    }

    //    public static void sortArrayAscending(int[] a) {
//        int len = a.length;
//        if (len == 0) {
//            System.out.println("List empty.");
//        }
//        for (int i = 0; i < len; i++) {
//            
//            for (int j = 0; j < len - i - 1; j++) {
//
//                if (a[j] > a[j + 1]) {
//
//                    // swap arr[j+1] và arr[i]
//                    int temp = a[j];
//                    a[j] = a[j + 1];
//                    a[j + 1] = temp;
//                    
//                }
//            }
//            
//        }
//        System.out.println();
//        for (int i = 0; i < a.length; i++) {
//            if (i == len - 1) {
//                System.out.print("[" + a[i] + "]");
//                break;
//            }
//            System.out.print("[" + a[i] + "]->");
//        }
//        System.out.println();
//    }
//    public static void sortArrayDescending(int[] a) {
//        int len = a.length;
//        if (len == 0) {
//            System.out.println("List empty.");
//        }
//        for (int i = 0; i < len; i++) {
//            
//            for (int j = 0; j < len - i - 1; j++) {
//
//                if (a[j] < a[j + 1]) {
//
//                    // swap arr[j+1] và arr[i]
//                    int temp = a[j];
//                    a[j] = a[j + 1];
//                    a[j + 1] = temp;
//                    
//                }
//            }
//            
//        }
//        System.out.println();
//        for (int i = 0; i < a.length; i++) {
//            if (i == a.length - 1) {
//                System.out.print("[" + a[i] + "]");
//                break;
//            }
//            System.out.print("[" + a[i] + "]<-");
//        }
//        System.out.println();
//    }
    public static int menu() {
        System.out.println("");
        System.out.println("1. Input Element");
        System.out.println("2. Sort Ascending");
        System.out.println("3. Sort Desceding");
        System.out.println("4. Exit.");
        System.out.print("Enter your choice: ");
        //loop until user input correct

        boolean input = true;
        int choice = 0;
        while (input) {
            try {
                scanner = new Scanner(System.in);
                choice = scanner.nextInt();
                if (choice < 1 || choice > 4) {
                    System.out.println("Must be input integer 1 to 4.");
                    System.out.print("Enter again: ");
                    continue;
                }
                input = false;
            } catch (NumberFormatException | InputMismatchException e) {
                System.out.println("Must be input integer 1 to 4.");
                System.out.print("Enter again: ");
            }
        }
        return choice;
    }

    public static void main(String[] args) {
        int[] a = new int[0];
        //loop until user want to exit
        while (true) {
            int choice = menu();
            switch (choice) {
                case 1:
                    a = inputValueOfArray();
                    break;
                case 2:
                    sortArray(a,true);
                    printf(a, true);
                    break;
                case 3:
                    sortArray(a,false);
                    printf(a, false);
                    break;
                case 4:
                    return;
            }
        }

    }
}
