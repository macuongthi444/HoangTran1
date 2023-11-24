/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package p101.pkg100loc;

import java.util.ArrayList;

/**
 *
 * @author hoang
 */
public class Main {
    public static void main(String[] args) {
        ArrayList<Employer> list = new ArrayList<Employer>();
        
        list.add(new Employer("E1","tran", "hoang", "0974858982", "hoangluffy098@gmail.com", "318hanoi", "gádja", "M", 74, "JASHDA"));
        list.add(new Employer("E2","tran", "ho", "0974858684", "hoangluffy7@gmail.com", "386hanoi", "gádja", "M", 36, "ádasd"));
        list.add(new Employer("E3","tran", "ang", "0974858987", "hoangluffy8@gmail.com", "346hanoi", "gádja", "M", 64, "áda"));
        list.add(new Employer("E4","tran", "van", "0974858478", "hoangluffy08@gmail.com", "396hanoi", "gádja", "M", 28, "ádsasd"));
        while(true){
            int choice = Manager.menu();
            switch(choice){
                case 1:
                    Manager.addEmployees(list);
                    break;
                case 2:
                    Manager.updateEmployer(list);
                    break;
                case 3:
                    Manager.deleteEmployer(list);
                    break;
                case 4:
                    Manager.searchEmployer(list);
                    break;
                case 5:
                    Manager.sortEmployer(list);
                    break;
                case 6:
                    return;
            }
        }
        
}
}
