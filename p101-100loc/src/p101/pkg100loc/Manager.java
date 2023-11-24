/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package p101.pkg100loc;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author hoang
 */
public class Manager {

    static Scanner scanner = new Scanner(System.in);

    public static int menu() {

        System.out.println("1. Add employees");
        System.out.println("2. Update employees");
        System.out.println("3. Remove employees");
        System.out.println("4. Search employees");
        System.out.println("5. Sort employees by salary");
        System.out.println("6. Exit");
        System.out.print("Enter your choice: ");

        //loop until user input correct
        boolean input = true;
        int choice = 0;
        while (input) {
            try {
                scanner = new Scanner(System.in);
                choice = scanner.nextInt();
                if (choice < 1 || choice > 6) {
                    System.out.println("Must be input integer 1 to 6.");
                    System.out.print("Enter again: ");
                    continue;
                }
                input = false;
            } catch (NumberFormatException | InputMismatchException e) {
                System.out.println("Must be input integer 1 to 6.");
                System.out.print("Enter again: ");
            }
        }
        return choice;
    }

    public static void addEmployees(ArrayList<Employer> list) {
        String ID;
        String FirstName;
        String LastName;
        String Phone;
        String Email;
        String Address;
        String DOB;
        String Sex;
        int Salary;
        String Egency;

        ID = Validate.inputPattern("Check ID", "[Ee][0-9]{0,2}");
        if (!Validate.checkEmployer(list, ID)) {
            System.out.println("Id Exit");
            return;
        }

        FirstName = Validate.inputString("First Name");

        LastName = Validate.inputString("Last Name");

        Phone = Validate.inputPattern("Input Phone Number", "^[0][0-9]{9}");
        if (!Validate.checkEmployer(list, Phone)) {
            System.out.println("Phone Exit");
            return;
        }

        Email = Validate.inputPattern("Input Email", "^\\w+@[a-zA-Z_]+?\\.[a-zA-Z]{2,3}$");
        if (!Validate.checkEmployer(list, Email)) {
            System.out.println("Email Exit");
            return;
        }
        Address = Validate.inputString("Address");
        DOB = Validate.inputString("DOB");
        Sex = Validate.checkGender("Male or Female");
        Salary = Validate.checkSalary("Salary");
        Egency = Validate.inputString("Egency");

        Employer e = new Employer(ID, FirstName, LastName, Phone, Email, Address, DOB, Sex, Salary, Egency);
        list.add(e);
    }

    public static void updateEmployer(ArrayList<Employer> list) {
        String ID;
        String updateID;
        String updateFirstName;
        String updateLastName;
        String updatePhone;
        String updateEmail;
        String updateAddress;
        String updateDOB;
        String updateSex;
        int updateSalary;
        String updateEgency;

        ID = Validate.inputPattern("Check ID", "[E][0-9]{0,2}");
        if (Validate.checkEmployer(list, ID)) {
            System.out.println("Id not found");
            return;
        }

        Employer e = getEmployerById(list, ID);
        updateID = Validate.inputPattern("Check ID", "[E][0-9]{0,2}");
        if (!Validate.checkEmployer(list, updateID)) {
            System.out.println("Id Exit");
            return;
        }

        updateFirstName = Validate.inputString("First Name");

        updateLastName = Validate.inputString("Last Name");

        updatePhone = Validate.inputPattern("Input Phone Number", "^[0][0-9]{9}");
        if (!Validate.checkEmployer(list, updatePhone)) {
            System.out.println("Phone Exit");
            return;
        }

        updateEmail = Validate.inputPattern("Input Email", "^\\w+@[a-zA-Z_]+?\\.[a-zA-Z]{2,3}$");
        if (!Validate.checkEmployer(list, updateEmail)) {
            System.out.println("Email Exit");
            return;
        }
        updateAddress = Validate.inputString("Address");
        updateDOB = Validate.inputString("DOB");
        updateSex = Validate.checkGender("Male or Female");
        updateSalary = Validate.checkSalary("Salary");
        updateEgency = Validate.inputString("Egency");

        e.setID(updateID);
        e.setFirstName(updateFirstName);
        e.setLastName(updateLastName);
        e.setPhone(updatePhone);
        e.setEmail(updateEmail);
        e.setAddress(updateAddress);
        e.setDOB(updateDOB);
        e.setSex(updateSex);
        e.setSalary(updateSalary);
        e.setEgency(updateEgency);
    }

    public static void deleteEmployer(ArrayList<Employer> list) {
        System.out.println("--------- Delete Employer -------");
        String idSearch;
        idSearch = Validate.inputPattern("Check ID", "[E][0-9]{0,2}");
        if (Validate.checkEmployer(list, idSearch)) {
            System.out.println("Id not found");
            return;
        }

        Employer e = getEmployerById(list, idSearch);
        if (idSearch == null) {
            System.out.println("Not found doctor.");
        } else {
            list.remove(e);
        }
        System.out.println("Delete ok");
    }

    public static void searchEmployer(ArrayList<Employer> list) {
        System.out.println("---------- Search Employer --------");
        String search;
        scanner = new Scanner(System.in);
        System.out.println("Enter text:");
        search = scanner.nextLine().trim();
        //tạo một danh sách trống để chứa các phần tử được tìm thấy
        System.out.println("--------- Result ------------");
        ArrayList<Employer> listFoundBySearch = searchbyName(list, search);

        if (listFoundBySearch.isEmpty()) {
            System.out.println("list empty");
        } else {

            for (Employer e : listFoundBySearch) {
                e.display();
            }
        }

    }

    public static void sortEmployer(ArrayList<Employer> list) {
         Collections.sort(list, new Comparator<Employer>(){

             @Override
             public int compare(Employer e1, Employer e2) {
                 if(e1.getSalary() < e2.getSalary()){
                     return 1;
                 }if(e1.getSalary() == e2.getSalary()){
                     return 0;
                 }else{
                     return -1;
                 }
             }
             
         }
         );
         for(Employer employer : list){
             employer.display();
         }
          }

    public static void sortEmployerByName(ArrayList<Employer> list) {
         Collections.sort(list, new Comparator<Employer>(){

             @Override
             public int compare(Employer e1, Employer e2) {
                 if(e1.getSalary() < e2.getSalary()){
                     return 1;
                 }if(e1.getSalary() == e2.getSalary()){
                     return 0;
                 }else{
                     return -1;
                 }
             }
             
         }
         );
         for(Employer employer : list){
             employer.display();
         }
          }
    public static void display(ArrayList<Employer> list) {
        for (Employer employer : list) {
            employer.display();
        }
    }

    public static Employer getEmployerById(ArrayList<Employer> list, String ID) {
        for (Employer list1 : list) {
            if (list1.getID().equalsIgnoreCase(ID)) {
                return list1;
            }
        }
        return null;
    }

    public static ArrayList<Employer> searchbyName(ArrayList<Employer> list, String name) {
        ArrayList<Employer> listFoundByName = new ArrayList<>();
        for (Employer employer : list) {
            if (employer.getFirstName().contains(name) || employer.getLastName().contains(name)) {
                listFoundByName.add(employer);
            }
        }
        return listFoundByName;
    }
}
