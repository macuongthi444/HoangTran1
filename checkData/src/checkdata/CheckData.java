/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package checkdata;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author hoang
 */
public class CheckData {

    private static final Scanner in = new Scanner(System.in);
    private static final String PHONE_VALID = "^[0-9]{10}$";
   private static final String EMAIL_VALID = "[A-Z0-9a-z._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,4}$";

    private static String checkInputString() {
        //loop until user input true value
        while (true) {
            String result = in.nextLine().trim();
            if (result.isEmpty()) {
                System.err.println("Not empty.");
            } else {
                return result;
            }
        }
    }

    private static String checkInputPhone() {
        while (true) {
            try {
                int phoneCheck = Integer.parseInt(in.nextLine());
                String resultCheck = String.valueOf(phoneCheck);
                if (!resultCheck.matches(PHONE_VALID)) {
                    System.err.println("Phone number must be 10 digits");
                } else {
                    return resultCheck;
                }
            } catch (NumberFormatException e) {
                System.out.print("Phone number: ");
                System.err.println("Phone number must be number");
            }
        }
    }
    public static String inputPattern(String msg, String pattern) {
        String a = new String();
        Scanner scanner = new Scanner(System.in);
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
            } catch (InputMismatchException e) {
                System.out.println("Must be input Pattern");
            }
        }
        return a;
    }

    private static String checkInputDate() {
        while (true) {
            try {
                String dateCheck = checkInputString();
                Date date = new SimpleDateFormat("dd/MM/yyyy").parse(dateCheck);
                return dateCheck;
            } catch (ParseException ex) {
                System.out.print("Date: ");
                System.err.println("Date to correct format(dd/MM/yyyy)");
            }
        }
    }

    private static String checkInputEmail() {
        while (true) {
            String emailCheck = checkInputString();
            if (!emailCheck.matches(EMAIL_VALID)) {
                System.err.println("Email must be correct format");
                System.out.print("Email: ");
            } else {
                return emailCheck;
            }
        }
    }

    public static String checkGender() {
        String gender = new String();
        Scanner scanner = new Scanner(System.in);
        boolean input = true;
        while (input) {
            try {
                System.out.print("Enter your gender (M/F): ");
                gender = scanner.nextLine();
                if (!gender.equalsIgnoreCase("M") && !gender.equalsIgnoreCase("F")) {
                    System.out.println("Invalid input. Gender must be either 'M' or 'F'");
                    continue;
                }
                input =false;
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }

        }
        return gender;
    }

    public static void main(String[] args) {
     //   "^[0-9]{4}[ ][0-9]{3}[ ][0-9]{10}$"
      //   "^[0-9]{4}[.][0-9]{3}[.][0-9]{10}$"
      //   "^[0-9]{4}[/][0-9]{3}[/][0-9]{10}$"
//        String phone = inputPattern("Phone number:", "^[0][0-9]{9}$");
//        System.out.print("Date: ");
//        String date = checkInputDate();
//        System.out.print("Email: ");
//        String email = checkInputEmail();
       String email = inputPattern("Email: ", "^\\w+@[a-zA-Z_]+?\\.[a-zA-Z]{2,3}$");
//        String gender = checkGender();
//        System.out.println(gender);

    }
}
