/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package studen70loc;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author hoang
 */
public class Inputter {

    static Scanner sc = new Scanner(System.in);

    public static double inputDouble(String msg) {
        boolean input = true;
        double number = 0;
        while (input) {
            try {
                System.out.println("");
                System.out.println(msg);
                sc = new Scanner(System.in);
                number = Double.parseDouble(sc.nextLine());
                if (number < 0 ) {
                    System.out.print("Math is greater than equal zero ");
                    continue;
                }else if(number>10){
                    System.out.print("Math is less than equal ten ");
                    continue;
                }
                input = false;
            } catch (Exception e) {
                System.out.print("Math is digit ");
            }
        }
        return number;
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
                a = sc.nextLine().trim();
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

   public static String inputYN() {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.print("Do you want to enter more student information?(Y/N):");
            String choice = sc.nextLine();
            if(choice.equalsIgnoreCase("N")||choice.equalsIgnoreCase("Y")){
                return choice;
            }else{
                System.out.println("Please input Y or N");
            }
        }
       
}
}
