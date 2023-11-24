/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dequy;

import static dequy.Dequy.lucas;

/**
 *
 * @author hoang
 */
public class Dequy {

    public static double day1(double value) {
        int n = 1;
        if (value <= 1) {
            return 1;
        } else {
            return (double) 1 / 2 * day1(n - 1);
        }

    }

    public static int day2(int x) {
        int x1 = -1;

        int n = (27 ^ (x1)) * (3 ^ x);

        return day2(x - 1);
    }

    public static int lucas(int n) {

        int n1 = 2, n2 = 1, n3;

        return 0;
    }

    public static int day5(int n) {

        if (n < 2) {
            return n;
        } else {
            return 2 * day5(n - 1) + day5(n - 2);
        }

    }

    

    static int fractorial(int n) {
        if (n <= 1) {
            return 1;
        } else {
            return n * fractorial(n - 1);
        }
    }

    static void tail(int n) {
        if (n > 0) {
            System.out.print(n);
            tail(n - 1);
            System.out.print(n);
        }
    }

    static String ex237(int n) {
        if (n <= 0) {
            return "";
        }
        return (ex237(n - 3) + n + ex237(n - 2) + n);
    }

    static int sum(int n) {
        if (n <= 1) {
            return 1;
        } else {
            return n + sum(n - 1);
        }
    }

    static int min(int a[], int n) {
        if (n == 1) {
            return a[0];
        }
        if (a[0] > a[n - 1]) {
            a[0] = a[n - 1];
        }
        return min(a, n - 1);
    }

    static boolean isPlindrome(char c[], int n) {
        if (n == 1) {
            return true;
        }
        int m = c.length;
        if (c[m - n] != c[n - 1]) {
            return false;
        } else {
            return isPlindrome(c, n - 1);
        }
    }

    public static void main(String[] args) {
        System.out.println(fractorial(5));
        System.out.println(sum(7));//28
        int[] a = {7, 2, 10, 1, -9, 2};
        System.out.println(min(a, a.length));
        char[] c = "radar".toCharArray();
        System.out.println(isPlindrome(c, c.length));
        //        int n1 = 1;
//
//        day1(10);
//        int n = 9;
//        System.out.println(lucas(n));
        int n = 10;
        for (int i = 1; i <= n; i++) {

            System.out.println(day5(i));
        }
    }
}
