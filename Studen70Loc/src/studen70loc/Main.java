/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package studen70loc;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


/**
 *
 * @author hoang
 */
public class Main {

    public static void main(String[] args) {
        List<Student> list = new ArrayList<>();
        StudentList list1 = new StudentList();
        list.add(new Student("hoang", "FU1", 9, 8, 5));
        list.add(new Student("tran", "FU2", 10, 9, 8));
        list.add(new Student("van", "FU3", 9, 8, 9));
        System.out.println("====== Management Student Program ======");
        StudentList st = new StudentList();

        while (true) {
            st.addStudent(list);
            if (Inputter.inputYN().equalsIgnoreCase("N")) {
                break;
            }
        }
        st.display(list);
        System.out.println("--------Classification Info -----");
        HashMap<String,Double> map= list1.getPercentTypeStudent(list);
        list1.display1(map);
    }
}
