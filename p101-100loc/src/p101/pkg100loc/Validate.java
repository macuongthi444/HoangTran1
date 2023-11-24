/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package p101.pkg100loc;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author hoang
 */
public class Validate {

    static Scanner scanner = new Scanner(System.in);

    public static String inputString(String msg) {
        String a = new String();
        scanner = new Scanner(System.in);
        boolean input = true;
        while (input) {
            try {
                System.out.println(msg);
                a = scanner.nextLine().trim();
                if (a.isEmpty()) {
                    System.out.println("Must be input String. Not empty");
                    continue;
                }
                input = false;
            } catch (Exception e) {
                System.out.println("Must be input String");
            }
        }
        return a;
    }

    public static String inputPattern(String msg, String pattern) {
        String a = new String();
        scanner = new Scanner(System.in);
        boolean input = true;
        while (input) {
            try {
                System.out.println(msg);
                a = scanner.nextLine().trim();
                if (a.isEmpty() || !a.matches(pattern)) {
                    System.out.println("Must be input Pattern. Not empty");
                    continue;
                }
                input = false;
            } catch (Exception e) {
                System.out.println("Must be input Pattern");
            }
        }
        return a;
    }

    public static String checkGender(String msg) {
        String gender = new String();
        scanner = new Scanner(System.in);
        boolean input = true;
        while (input) {
            try {
                System.out.print("Enter your gender (M/F): ");
                gender = scanner.nextLine();
                if (!gender.equalsIgnoreCase("M") && !gender.equalsIgnoreCase("F")) {
                    System.out.println("Invalid input. Gender must be either 'M' or 'F'");
                    continue;
                }
                input = false;
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }

        }
        return gender;
    }

    public static int checkSalary(String msg) {
        int a = 0;

        boolean inputter = true;
        scanner = new Scanner(System.in);
        while (inputter) {
            try {
                System.out.println(msg);
                scanner = new Scanner(System.in);
                a = scanner.nextInt();
                if (a <= 0) {
                    System.out.println("Please input number greater than zero.");
                    System.out.print("Enter again: ");
                    continue;
                }
                inputter = false;
            } catch (NumberFormatException | InputMismatchException e) {
                System.out.println("Please input number greater than zero.");
                System.out.print("Enter again: ");
            }
        }

        return a;
    }

    public static boolean checkEmployer(ArrayList<Employer> list, String infor) {
        for (Employer employer : list) {
            if (employer.getID().contains(infor)
                    ||employer.getEmail().contains(infor)
                    ||employer.getPhone().contains(infor)) 
            {
                return false;
            }
        }
        return true;
    }
}
