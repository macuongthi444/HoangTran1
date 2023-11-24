/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mergesort;

import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author hoang
 */
public class MergeSort {
    public static Scanner scanner = new Scanner(System.in);
    // Merge hai mảng con của arr[].
    // Mảng con thứ nhất là arr[l..m]
    // Mảng con thứ hai là arr[m+1..r]
    void merge(int arr[], int l, int m, int r) {

        // Tìm kích thước của 2 mảng con để merged
        int n1 = m - l + 1;
        int n2 = r - m;

        // Tạo mảng tạm
        int L[] = new int[n1];
        int R[] = new int[n2];

        // Copy dữ liệu vào mảng tạm
        for (int i = 0; i < n1; ++i)
            L[i] = arr[l + i];
        for (int j = 0; j < n2; ++j)
            R[j] = arr[m + 1 + j];

        // Merge các mảng tạm lại

        // Chỉ mục ban đầu của 2 mảng con
        int i = 0, j = 0;

        // Chỉ mục ban đầu của mảng phụ được hợp nhất
        int k = l;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                arr[k] = L[i];
                i++;
            } else {
                arr[k] = R[j];
                j++;
            }
            k++;
        }

        // Sao chép các phần tử còn lại của L[] nếu có
        while (i < n1) {
            arr[k] = L[i];
            i++;
            k++;
        }

        // Sao chép các phần tử còn lại của R[] nếu có
        while (j < n2) {
            arr[k] = R[j];
            j++;
            k++;
        }
    }

    void sort(int arr[], int l, int r) {
        if (l < r) {

            // Tìm điểm chính giữa
            int m = (l + r) / 2;

            // Hàm đệ quy tiếp tục chia đôi
            sort(arr, l, m);
            sort(arr, m + 1, r);

            merge(arr, l, m, r);
        }
    }
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

    // In các phần tử của mảng
    static void printArray(int arr[],int n) {
        System.out.print("[");
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i]);
            if (i < arr.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.print("]");
    }
     public static void Create_Array(int arr[], int n) {

        Random rand = new Random();
        for (int i = 0; i < n; i++) {
            arr[i] = rand.nextInt(30);
        }
    }

    public static void main(String args[]) {
        int n = InputInt();
        int arr[] =new int[n];

        System.out.println("Mảng ban đầu:");
        printArray(arr,n);

        MergeSort ob = new MergeSort();
        ob.sort(arr, 0, arr.length - 1);

        System.out.println("Mảng sau khi sắp xếp:");
        printArray(arr,n);
    }
    
}
