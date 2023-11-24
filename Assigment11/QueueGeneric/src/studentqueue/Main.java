/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package studentqueue;

/**
 *
 * @author hoang
 */
public class Main {
    public static void main(String[] args) {
        Queue<String> q =new Queue<>();
        //thêm phần tử 
        q.enqueue("cây");
        q.enqueue("cảnh");
        q.enqueue("cây");
        q.enqueue("hoa");
        //in ra các phần tử
        q.display();
//        ///lấy phần tử đầu tiên không xóa
        System.out.println( q.peek());
        q.display();
//        
        // xoa phần tử trong queue
        q.dequeue();
        q.display();
//        
        ////xóa các phần tử trong queue
        q.clear();
        q.display();
    }
}
