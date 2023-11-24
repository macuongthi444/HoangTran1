/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package insertionsort;

import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author hoang
 */
public class InsertionSort {

    public static Scanner scanner = new Scanner(System.in);

    public static void sort(int arr[], int n) {

        for (int i = 1; i < n; ++i) {
            int key = arr[i];
            int j = i - 1;

            // Di chuyển các phần tử của arr [0 ... i - 1], lớn hơn key
            // đến một vị trí trước vị trí hiện tại của chúng
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j = j - 1;
            }
            arr[j + 1] = key;
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
        int arr[] = new int[n];
        create_array(arr, n);
        printf_array(arr, n);
        sort(arr, n);
        printf_array(arr, n);
    }

}
