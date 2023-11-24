/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment;

/**
 *
 * @author hoang
 */
public class Node {
    Student data;
    Node next;
    //ham tao de tao node lien ket moi
    public Node(Student data){
        this.data=data;
        this.next=null;
    }
}
