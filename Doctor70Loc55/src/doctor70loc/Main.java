/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package doctor70loc;

import static doctor70loc.Management.scanner;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

/**
 *
 * @author hoang
 */
public class Main {

    public static void main(String[] args) throws Exception {
        HashMap<String, Doctor> hashmap = new HashMap<>();
        ArrayList<Doctor> list = new ArrayList<>();

        Management m = new Management();
        list.add(new Doctor("DOC1", "Nghia", "Orthopedics", 3));
        list.add(new Doctor("DOC2", "Phuong", "Obstetrics", 2));
        list.add(new Doctor("DOC3", "Lien", "Orthodontic", 1));
        while (true) {
            int choice = Management.menu();

            switch (choice) {
                case 1:
                    Management.addDoctor(list);
                    break;
                case 2:
                    Management.updateDoctor(list);
                    break;
                case 3:
                    Management.deleteDoctor(list);
                    break;
                case 4:                                    
                    System.out.println("--------- Result ------------");
                    Management.searchDoctor123(list);

                    break;
                case 5:
                    return;

            }

        }
    }
}
