/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package taskmanagement71;

import java.util.ArrayList;

/**
 *
 * @author hoang
 */
public class Main {
    public static void main(String[] args) {
        ArrayList<Task> list = new ArrayList<>();
//        list.add(new Task(1, "Dev Program", "Code", "28-6-2015", "8.0", "17.5", "dev", "lead"));
//        list.add(new Task(2, "Dev ", "Test", "20-02-2020", "9.0", "17.5", "cod", "eqw"));
//        list.add(new Task(3, "Dev Code", "Design", "19-7-2016", "10.0", "17.5", "rd", "asd"));
//        list.add(new Task(4, "Dev Program", "Review ", "14-9-2017", "11.0", "17.5", "deqwev", "xczzx"));
//        
        int id=1;
        
        while (true){
            int choice= Manager.menu();
            switch(choice){
                case 1:
                    Manager.addTask(list, id);
                    id++;
                    break;
                case 2:
                    Manager.deleteTask(list, id);
                    id--;
                    break;
                case 3:
                    Manager.sort(list);
                    Manager.displayData(list);
                    break;
                case 4 :
                    return;
            }
    }
    
}
}