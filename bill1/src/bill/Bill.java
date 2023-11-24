/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bill;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author hoang
 */
public class Bill {

    private static int checkInputInt() {

        Scanner scanner = new Scanner(System.in);
        int a = 0;

        boolean inputter = true;
        System.out.println("Input Length Of Arrays");
        System.out.print("Enter number: ");
        while (inputter) {
            try {

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

    //Get array bills that user input
    private static int[] inputBills() {
        System.out.println("======= Shopping program ==========");
        System.out.print("Input number of bill: ");
        int size = checkInputInt();
        int[] bills = new int[size];
        //allow user input bills
        for (int i = 0; i < bills.length; i++) {
            System.out.print("Input value of bill " + (i + 1) + ": ");
            bills[i] = checkInputInt();
        }
        return bills;
    }

    //Get amount that user input
    private static int inputWallet() {
        System.out.print("Input value of wallet: ");
        int wallet = checkInputInt();
        return wallet;
    }

    //Calculate the total amount of the bills
    private static int calcTotal(int[] bills) {
        int total = 0;
        for (int i = 0; i < bills.length; i++) {
            total += bills[i];
        }
        return total;
    }

    //Check whether the amount in the wallet is enough to pay. 
    //Print total of bill and result
    private static void result(int[] bills, int wallet) {
        int total = calcTotal(bills);
        System.out.println("This is total of bill: " + total);
        if (total < wallet) {
            System.out.println("You can buy it");
        } else {
            System.out.println("You can't buy it.");
        }
    }

    public static void main(String[] args) {
        //allow user input input bill
        Scanner sc = new Scanner(System.in);

        int[] bills = inputBills();
        //allow user in put amount of wallet
        int wallet = inputWallet();
        //print total of bill and result
        result(bills, wallet);

    }

}
