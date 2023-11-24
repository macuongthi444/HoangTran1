/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myhashtable;

import java.util.ArrayList;

/**
 *
 * @author hoang
 */
public class MyHashTable {

    //h(x) = x mod M where M = 10

    final int M = 10;
    ArrayList<Integer>[] a;

    public MyHashTable() {
        a = new ArrayList[M];
        for (int i = 0; i < M; i++) {
            a[i] = new ArrayList<>();
        }
    }

    public void add(int x) {
        int i = x % M;
        a[i].add(x);
    }

    public void traversal() {
        for (int i = 0; i < M; i++) {
            if (!a[i].isEmpty()) {
                System.out.println(a[i]);
            }
        }
    }

    public int search(int x) {
        int i = x % M;
        int k = a[i].indexOf(x);
        if (k != -1) {
            k = a[i].get(k);
        }
        return k;
    }
}
