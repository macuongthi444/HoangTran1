/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication17;

import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author hoang
 */
public class SelectionSort {

    public static Scanner scanner = new Scanner(System.in);

    public static void sort(int arr[], int n) {

        // Duyệt qua từng phần tử của mảng
        for (int i = 0; i < n - 1; i++) {

            // Tìm phần tử nhỏ nhất trong mảng chưa được sắp xếp
            int min = i;
            int minarr = arr[i];
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < minarr) {
                    min = j;
                    minarr = arr[j];
                }
            }

            // Hoán đổi phần tử nhỏ nhất và phần tử đầu tiên
            if (minarr < arr[i]) {
                int temp = arr[min];
                arr[min] = arr[i];
                arr[i] = temp;
            }
        }
    }
//nhap mang

    public static void Create_Array(int arr[], int n) {

        Random rand = new Random();
        for (int i = 0; i < n; i++) {
            arr[i] = rand.nextInt(30);
        }
    }

    // Xuất mảng
    public static int InputInt() {

        int a = 0;

        boolean inputter = true;

        while (inputter) {
            try {
                System.out.print("Input a number: ");
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

    public static void displayArray(int[] arr, int n) {
        System.out.print("[");
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i]);
            if (i < arr.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.print("]");
    }

    public static void main(String args[]) {
        SelectionSort selection = new SelectionSort();
        System.out.println("Create Array");
        int n = InputInt();

        int a[] = new int[n];

        Create_Array(a, n);

        displayArray(a, n);

        sort(a, n);

        displayArray(a, n);

    }
}
//    

//    Nhập Mảng
//
//    public static void NhapMang(int[] a, int n) {
//        Random rand = new Random();
//        for (int i = 0; i < n; i++) {
//            a[i] = rand.nextInt(50);    //bạn có thể điền số khác
//        }
//    }
////
////    //Xuất Mảng
//    public static void XuatMang(int[] a, int n) {
//        for (int i = 0; i < n; i++) {
//            System.out.print(" " + a[i]);
//        }
//    }
//////Hàm chính
////
//    public static void main(String[] args) {
//        Scanner input = new Scanner(System.in);
//
//        System.out.print("Nhập số phần tử:");
//        int n = input.nextInt();
//        int[] a = new int[n];
//        NhapMang(a, n);
//        System.out.print("Nội dung mảng: ");
//        XuatMang(a, n);
//    }

