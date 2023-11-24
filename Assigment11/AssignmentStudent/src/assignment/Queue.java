/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment;

import java.util.LinkedList;
import java.util.NoSuchElementException;

/**
 *
 * @author hoang
 */
//front la luu giu nut truoc 
//rear luu giu not sau cua linklist
public class Queue {

  private LinkedList<String> items = new LinkedList<String>();
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
        return front.data;
    }

     
//   public void enqueue(String item) {
//      items.addLast(item);
//   }
//   public String dequeue() {
//      return items.removeFirst();
//   }
//    add student vao hang doi
//    Để thêm một phần tử vào queue, ta tăng rear lên 1 và đưa giá trị đó vào phần tử thứ rear trong mảng.
    public void enqueue(Student data) {

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
    
    
  
   


//    xoa student tu hang doi
//Để loại bỏ một phần tử khỏi queue, ta tăng front lên 1.
    public void dequeue() {

        //neu hang doi rong thi trar ve null
        if (isEmpty()) {
            return;
        }
        //luu front trong mot cai not moi vaf di chuyen len phia truocw
        Node newNode = this.front;
        this.front = this.front.next;

        ///neu cai front phia truocws tro thanh null thi phia sau cung la null
        if (this.front == null) {
            this.rear = null;
        }
    }

    void display() {
        Node p = front;
        while (p != null) {
            if (p == rear) {
                System.out.println(p.data + " ");
            } else {
                System.out.println(p.data + " ");
            }
            p = p.next;
        }
    }

    
}
