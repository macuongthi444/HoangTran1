/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package studen70loc;

import java.util.HashMap;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

/**
 *
 * @author hoang
 */
public class StudentList {

    static Scanner scanner = new Scanner(System.in);

    public void addStudent(List<Student> list) {

        String name;
        String className;
        double math;
        double chemistry;
        double physical;

        name = Inputter.inputStr("Name: ");

        className = Inputter.inputPattern("Classes: ", "[F][U]\\d{1,3}");

        math = Inputter.inputDouble("Math: ");

        chemistry = Inputter.inputDouble("Chemistry: ");

        physical = Inputter.inputDouble("Physics: ");

        Student student = new Student(name, className, math, chemistry, physical);

        list.add(student);
        System.out.println("Student " + name + " has been added.");

    }

    public void display(List<Student> list) {
        int i = 1;
        for (Student list1 : list) {
            System.out.println("------Student " + i + " Info-------");
            list1.dislay();
            i++;
        }
    }

    public HashMap<String, Double> getPercentTypeStudent(List<Student> students) {
        HashMap<String, Double> hashmap = new HashMap<String, Double>();
        double countA = 0;
        double countB = 0;
        double countC = 0;
        double countD = 0;
        int total = students.size();
        for (Student st : students) {
            if (st.getAVG() > 7.5) {
                countA++;
            } else if (st.getAVG() >= 6) {
                countB++;
            } else if (st.getAVG() >= 4) {
                countC++;
            } else {
                countD++;
            }
        }
        hashmap.put("A", countA * 100/total);
        hashmap.put("B", countB * 100/total);
        hashmap.put("C", countC * 100/total);
        hashmap.put("A", countD * 100/total);
        return hashmap;
    }

    public void display1(HashMap<String, Double> hashmap) {
        Set<String> keySet = hashmap.keySet();
        for (String st : keySet) {
            System.out.println(st + " : " + hashmap.get(st) + "%");
        }

    }

}
