/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package studentqueue;

import java.util.LinkedList;
import java.util.NoSuchElementException;

/**
 *
 * @author hoang
 */
public class Queue<T> {

    private Queue<Node<T>> queue;

    Node front, rear;
    int size;

    public Queue() {
        this.front = this.rear = null;
    }

    boolean isEmpty() {
        return (front == null);
    }

    void clear() {
        front = rear = null;
    }

    public int getSize() {
        return size;
    }

    Object peek() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        return front.getData();
    }

    public void enqueue(T data) {

        Node newNode = new Node(data);

        //neu hang doi trong thi nut moi o phia truoc va sau
        if (isEmpty()) {

            this.front = this.rear = newNode;
            return;
        }

        //them nut moi o cuoi hang doi queue va thay doi rear
        this.rear.next = newNode;
        this.rear = newNode;

    }

    public Node<T> dequeue() {

        //neu hang doi rong thi trar ve null
        if (isEmpty()) {
        }
        //luu front trong mot cai not moi vaf di chuyen len phia truocw
        Node newNode = this.front;
        this.front = this.front.next;

        ///neu cai front phia truocws tro thanh null thi phia sau cung la null
        if (this.front == null) {
            this.rear = null;
        }
        return null;
    }

    void display() {
        Node p = front;
        while (p != null) {
            if (p == rear) {
                System.out.println(p.getData() + " ");
            } else {
                System.out.println(p.getData() + " ");
            }
            p = p.next;
        }
    }

   
}
