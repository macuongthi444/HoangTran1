/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package taskmanagement71;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author hoang
 */
public class Manager {

    static Scanner scanner = new Scanner(System.in);

    public static int menu() {
        System.out.println("=========Task Program===========");
        System.out.println("1. Add Task");
        System.out.println("2. Delete Task");
        System.out.println("3. Display Task");
        System.out.println("4. Exit");
        System.out.print("Enter your choice: ");

        //loop until user input correct
        boolean input = true;
        int choice = 0;
        while (input) {
            try {
                scanner = new Scanner(System.in);
                choice = scanner.nextInt();
                if (choice < 1 || choice > 4) {
                    System.out.println("Must be input integer 1 to 4.");
                    System.out.print("Enter again: ");
                    continue;
                }
                input = false;
            } catch (NumberFormatException | InputMismatchException e) {
                System.out.println("Must be input integer 1 to 4.");
                System.out.print("Enter again: ");
            }
        }
        return choice;
    }

    public static void addTask(ArrayList<Task> list, int ID) {

        String taskTypeID;
        String requirementName;
        Date date;
        String planFrom;
        String planTo;
        String assignee;
        String reviewer;
        System.out.println("------------Add Task--------------");
        requirementName = CheckInput.inputStr("Requirement Name: ");
        taskTypeID = CheckInput.inputTaskTypeID("Task Type: ");
        date = CheckInput.inputDate("Date: ");
        planFrom = CheckInput.inputTimeFrom("From: ");
        planTo = CheckInput.inputTimeTo(planFrom, "To: ");
        assignee = CheckInput.inputStr("Assignee");
        reviewer = CheckInput.inputStr("Reviewer");

        Task task = new Task(ID, requirementName, taskTypeID, date, planFrom, planTo, assignee, reviewer);
        list.add(task);

    }

    public static void deleteTask(ArrayList<Task> list, int ID) {
//        
        System.out.println("------------Del Task--------------");
        ID = CheckInput.inputInt(" ID:");
        if (checkTaskExist(list, ID)) {
            System.out.println("Not found ID Task");
            return;
        }
        Task task = getTaskById(list, ID);
        if (task == null) {
            System.out.println("Not found doctor.");
        } else {
            list.remove(task);
        }
        System.out.println("Delete ok");
    }

    public static void displayData(ArrayList<Task> list) {
        System.out.println("----------------------------Task----------------------------------");
        System.out.printf("%s %20s %20s %20s %20s %20s %20s", "ID", "Name", "TaskType", "  Date", " Time", " Assinee", "Reviewer");
        System.out.println("");
        for (Task task : list) {
            task.display();
        }
    }

    public static boolean checkTaskExist(ArrayList<Task> list, int Id) {
        //check from first to last list doctor
        for (Task task : list) {
            if (Id == task.getID()) {
                return false;
            }
        }
        return true;
    }

    public static Task getTaskById(ArrayList<Task> list, int Id) {
        for (Task task : list) {
            if (Id == task.getID()) {
                return task;
            }
        }
        return null;
    }

    public static void sort(ArrayList<Task> list) {
        Collections.sort(list, new Comparator<Task>() {

            @Override
            public int compare(Task o1, Task o2) {

                return o1.getDate().compareTo(o2.getDate());

            }

        }
        );
    }
     
}
