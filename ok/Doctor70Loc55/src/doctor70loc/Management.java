/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package doctor70loc;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Map;

import java.util.Scanner;
import java.util.Set;

/**
 *
 * @author hoang
 */
public class Management {

    static Scanner scanner = new Scanner(System.in);

    public static int menu() {
        System.out.println("");
        System.out.println("1. Add doctor");
        System.out.println("2. Update doctor");
        System.out.println("3. Delete doctor");
        System.out.println("4. Search doctor");
        System.out.println("5. Exit");
        System.out.print("Enter your choice: ");

        //loop until user input correct
        boolean input = true;
        int choice = 0;
        while (input) {
            try {
                scanner = new Scanner(System.in);
                choice = scanner.nextInt();
                if (choice < 1 || choice > 5) {
                    System.out.println("Must be input integer 1 to 5.");
                    System.out.print("Enter again: ");
                    continue;
                }
                input = false;
            } catch (NumberFormatException | InputMismatchException e) {
                System.out.println("Must be input integer 1 to 5.");
                System.out.print("Enter again: ");
            }
        }
        return choice;
    }

    public static void addDoctor(ArrayList<Doctor> list) {
        System.out.println("--------- Add Doctor ----------");
        String newCode;
        String newName;
        String newSpecilization;
        int newAvailability;

        newCode = CheckInput.inputPattern("Enter Code: ", "[D][O][C]\\d{1,6}");
        //kiểm tra Code có trong danh sách hay chưa 
        if (!CheckInput.checkCodeExist(list, newCode)) {
            System.out.println("Code Exist");
            return;
        }
        newName = CheckInput.inputStr("Enter Name:");

        newSpecilization = CheckInput.inputStr("Enter Specialization: ");

        newAvailability = CheckInput.inputInt("Enter Availability: ");

        Doctor doctor = new Doctor(newCode, newName, newSpecilization, newAvailability);

        list.add(doctor);
        System.out.println("Doctor " + newName + " has been added.");

    }

    public static void updateDoctor(ArrayList<Doctor> list) {
        System.out.println("--------- Update Doctor -------");
        String code;
        String codeUpdate;
        String nameUpdate;
        String specilizationUpdate;
        

        code = CheckInput.inputPattern("Enter Code: ", "[D][O][C][0-9]{1}");

        if (CheckInput.checkCodeExist(list, code)) {
            System.out.println("Not found Code Doctor");
            return;
        } else {
            scanner = new Scanner(System.in);

            Doctor doctor = getDoctorByCode(list, code);

            System.out.println("Enter Code Update");
            codeUpdate = scanner.nextLine().toUpperCase().trim();
            if (!CheckInput.checkCodeExist(list, codeUpdate)) {
                System.out.println("Code Exist");
                return;
            }
            if (!codeUpdate.isEmpty()) {
                doctor.setCode(codeUpdate);
            }

            System.out.println("Enter Name Update");
            nameUpdate = scanner.nextLine().trim();
            if (!nameUpdate.isEmpty()) {
                doctor.setName(nameUpdate);

            }

            System.out.println("Enter Specialization Update:");
            specilizationUpdate = scanner.nextLine().trim();
            if (!specilizationUpdate.isEmpty()) {
                doctor.setSpecilization(specilizationUpdate);
            }
int availabilityUpdate = 0;
            System.out.println("Enter Availability Update: ");
            String s = Integer.toString(availabilityUpdate);
            s = scanner.nextLine();
            if (!s.isEmpty() && s.matches("[0-9]{1}")) {
                doctor.setAvailability(Integer.parseInt(s));
            }

        }
    }

    public static void deleteDoctor(ArrayList<Doctor> list) {
        System.out.println("--------- Delete Doctor -------");
        String CodeSearch;
        CodeSearch = CheckInput.inputPattern("Enter Code: ", "[D][O][C][0-9]{1}");

        if (CheckInput.checkCodeExist(list, CodeSearch)) {
            System.out.println("Not found Code Doctor");
            return;
        }
        Doctor doctor = getDoctorByCode(list, CodeSearch);
        if (doctor == null) {
            System.out.println("Not found doctor.");
        } else {
            list.remove(doctor);
        }
        System.out.println("Delete ok");
    }

    public static void searchDoctor(ArrayList<Doctor> list) {
        System.out.println("---------- Search Doctor --------");
        String search;
        scanner = new Scanner(System.in);
        System.out.println("Enter text:");
        search = scanner.nextLine().trim();
        //tạo một danh sách trống để chứa các phần tử được tìm thấy
        System.out.println("--------- Result ------------");
        ArrayList<Doctor> listFoundBySearch = listFoundByText(list, search);

        if (listFoundBySearch.isEmpty()) {
            System.out.println("list empty");
        } else {
            System.out.println("Code\tName\tSpecilization\tAvailability");
            for (Doctor doctor : listFoundBySearch) {
                doctor.display();
            }
        }

    }

//    public static void display1(ArrayList<Doctor> list) {
//        System.out.println("Code\tName\tSpecilization\tAvailability");
//        for (Doctor doctor : list) {
//            doctor.display();
//        }
//    }
    public static Doctor getDoctorByCode(ArrayList<Doctor> list, String Code) {

        for (Doctor doctor : list) {// Doctor là kiểu dữ liệu của các phần tử trong danh sách list. doctor là biến được khai báo để truy cập các phần tử của danh sách.
            if (doctor.getCode().equalsIgnoreCase(Code)) {//so sánh trường hợp giữa hai chuỗi
                return doctor;
            }

        }
        return null;
    }

    public static ArrayList<Doctor> listFoundByText(ArrayList<Doctor> list, String text) {
        ArrayList<Doctor> listFoundByName = new ArrayList<>();

        for (Doctor doctor : list) {
            //kiểm tra xem  có chứa chuỗi `text` hay không
            if (doctor.getCode().contains(text.toUpperCase())) {
                listFoundByName.add(doctor);
            } else if (doctor.getName().contains(text)) {
                listFoundByName.add(doctor);

            } else if (doctor.getSpecilization().contains(text)) {
                listFoundByName.add(doctor);

            } else {
                try {
                    if (doctor.getAvailability() == Integer.parseInt(text)) {
                        listFoundByName.add(doctor);
                    }
                } catch (Exception e) {
                    System.out.println("");
                }
                
            }
        }
        return listFoundByName;
    }

    public static HashMap<String, Doctor> searchDoctor1(ArrayList<Doctor> list, String input) throws Exception {

        HashMap<String, Doctor> hashmap = new HashMap<>();
        for (Doctor doctor : list) {

            if (doctor.getCode().contains(input.toUpperCase())) {
                hashmap.put(doctor.getCode(), doctor);

            } 
                else if (doctor.getName().contains(input)) {
                hashmap.put(doctor.getName(), doctor);

            } 
            else if (doctor.getSpecilization().contains(input)) {
                hashmap.put(doctor.getSpecilization(), doctor);

            } else {
                try {
                    if (doctor.getAvailability() == Integer.parseInt(input)) {
                        hashmap.put(Integer.toString(doctor.getAvailability()), doctor);
                    }
                } catch (Exception e) {
                    System.out.println("");
                }
            }
        }
//        if (hashmap.isEmpty()) {
//            System.out.println("list empty");
//        } else {
//            System.out.println("Code\tName\tSpecilization\tAvailability");
//            for (HashMap.Entry<String, Doctor> entrySet : hashmap.entrySet()) {
//                Doctor value1 = entrySet.getValue();
//
//                System.out.println(value1.getCode() + "\t" + value1.getName() + "\t" + value1.getSpecilization() + "\t" + value1.getAvailability());
//            }
//
//        }
        return hashmap;
    }
        
    
    public static void searchDoctor123(ArrayList<Doctor> list) throws Exception {
        System.out.println("---------- Search Doctor --------");
        String search;
        scanner = new Scanner(System.in);
        System.out.println("Enter text:");
        search = scanner.nextLine().trim();
        //tạo một danh sách trống để chứa các phần tử được tìm thấy
        System.out.println("--------- Result ------------");
        HashMap<String, Doctor> hashmap = searchDoctor1(list, search);

        if (hashmap.isEmpty()) {
            System.out.println("list empty");
        } else {
            System.out.println("Code\tName\tSpecilization\tAvailability");
            for (HashMap.Entry<String, Doctor> entrySet : hashmap.entrySet()) {
                Doctor value1 = entrySet.getValue();

                System.out.println(value1.getCode() + "\t" + value1.getName() + "\t" + value1.getSpecilization() + "\t" + value1.getAvailability());
            }

        }
    }

}
