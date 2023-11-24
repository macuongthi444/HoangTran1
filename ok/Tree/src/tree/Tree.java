/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tree;

public class Tree {

    Node root;

    void BSTree() {
        root = null;
    }

    void Insert(int x) {
        Node p = new Node(x);
        Node current = null;
        Node q = root;
        if (q != null) {

            if (q.info == x) {
                return;
            }
            if (q.info > x) {
                current = p.right;
            } else {
                current = p.left;
            }
        }
        if (current.info > x) {
            current.right = new Node(x);
        } else {
            current.left = new Node(x);
        }
    }

    Node Insert1(int x, Node p) {//dequy
        if (p != null) {
            if (p.info == x) {
                return p;
            }
            if (p.info > x) {
                p.right = Insert1(x, p.right);
            } else {
                p.left = Insert1(x, p.left);
            }
        } else {
            p = new Node(x);
        }
        return p;
    }

    void visit(Node p) {
        if (p != null) {
            System.out.print(p.info);
        }
    }

    public Node delete(Node x, int data) {
        if (x == null) {
            return x;

        } else if (data < x.info) {
            x.left = delete(x.left, data);

        }else if(data>x.info){
        x.right=delete(x.right,data);
        }
        
    }
