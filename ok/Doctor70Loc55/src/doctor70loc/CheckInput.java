/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package doctor70loc;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author hoang
 */
public class CheckInput {

    static Scanner sc = new Scanner(System.in);

    

    public static int inputInt(String msg) {

        int a = 0;

        boolean inputter = true;

        while (inputter) {
            try {
                System.out.println(msg);
                sc = new Scanner(System.in);
                a = sc.nextInt();
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

    public static String inputStr(String msg) {

        String a = new String();
        boolean input = true;

        while (input) {
            try {
                System.out.println("");
                System.out.println(msg);
                sc = new Scanner(System.in);
                a = sc.nextLine().trim();
                if (a.isEmpty()) {
                    System.out.println("No accept for null string! "
                            + "Please enter again!");
                    continue;
                }
                input = false;
            } catch (InputMismatchException e) {
                System.out.println("No input accepted! Please enter again!");
            }
        }

        return a;

    }

    public static String inputPattern(String msg, String pattern) {

        String a = new String();

        boolean inputDeny = true;

        System.out.println(msg);
        while (inputDeny) {
            try {
                sc = new Scanner(System.in);
                a = sc.nextLine().toUpperCase().trim();
                if (a.isEmpty() || !a.matches(pattern)) {
                    System.out.println("This string must be in right format!");
                    System.out.println("Please enter again!");
                    continue;
                }
                inputDeny = false;
            } catch (InputMismatchException e) {
                System.out.println("No input accepted! Please enter again!");
            }
        }

        return a;

    }

    public static boolean checkCodeExist(ArrayList<Doctor> ld, String code) {
        //check from first to last list doctor
        for (Doctor doctor : ld) {
            if (code.equalsIgnoreCase(doctor.getCode())) {
                return false;
            }
        }
        return true;
    }

}
