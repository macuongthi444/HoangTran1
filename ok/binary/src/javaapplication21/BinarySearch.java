/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication21;

import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author hoang
 */
public class BinarySearch {

    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        System.out.println("Enter number of array:");
        int length = InputInt();

        int[] array = new int[length];
        Create_Array(array, length);
        bubbleSort(array);
        System.out.println("");
        System.out.println("Enter search value:");
        int search = scanner.nextInt();
//        System.out.println("\nFound " + search + " at index: " +binary(array, search, 0, length-1));
        System.out.println("\nFound " + search + " at index: " + binarySearch(array, search, 0, length-1));
    }

    public static void Create_Array(int arr[], int n) {

        Random rand = new Random();
        for (int i = 0; i < n; i++) {
            arr[i] = rand.nextInt(10);
        }

    }

//    public static void displayArray(int[] arr) {
//        System.out.print("[");
//        for (int i = 0; i < arr.length; i++) {
//            System.out.print(arr[i]);
//            if (i < arr.length - 1) {
//                System.out.print(", ");
//            }
//        }
//        System.out.print("]");
//    }
    public static void bubbleSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    // swap arr[j+1] và arr[i]
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;

                }
            }
        }
        System.out.println("Sorted array: ");
        System.out.print("[");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
            if (i < arr.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.print("]");
    }

    static int binarySearch(int[] array, int value, int left, int right) {
//        if (left > right) {
//            return -1;
//        }
//        int middle = (left + right) / 2;
//        if (array[middle] == value) {
//            return middle;
//        } else if (array[middle] > value) {
//            return binarySearch(array, value, left, middle - 1);
//        } else {//array[middle] < value
//            return binarySearch(array, value, middle + 1, right);
//        }            
        int result = -1; // Khởi tạo kết quả là -1
        while (left <= right) {
            int middle = (left + right) / 2;
            if (array[middle] == value) {
                result = middle; // Gán kết quả thành middle nếu tìm thấy giá trị
                break; // Thoát khỏi vòng lặp
            } else if (array[middle] > value) {
                right = middle - 1;
            } else {
                left = middle + 1;
            }
        }
        return result; // Trả về kết quả
    }

    static int binary(int[] array, int value, int left, int right) {
        while (left <= right) {
            int mid = (left + right) / 2;
            if (array[mid] == value) {
                return mid;
            } else if (array[mid] > value) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }

        }
    return -1;
    }

    

    public static int InputInt() {

        int a = 0;

        boolean inputter = true;

        while (inputter) {
            try {
                System.out.print("Input a number: ");
                scanner = new Scanner(System.in);
                a = scanner.nextInt();
                if (a <= 0) {
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
}
