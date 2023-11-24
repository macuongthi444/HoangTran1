/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package p.pkg73;

/**
 *
 * @author hoang
 */
public class Main {
    static void menu() {
        System.out.println("1. Add an expense");
        System.out.println("2. Display all expense");
        System.out.println("3. Delete an expense");
        System.out.println("4. Quit");
    }
    
    public static void main(String[] args) {
        validate check = new validate();
        expenseView ex = new expenseView();
        //allow user can choose different option
        while(true) {
            menu();
            int option = check.inputInt("Your choice: ", 1, 4);
            //handing option
            switch(option) {
                case 1:
                    ex.createExpense();
                    break;
                case 2:
                    ex.displayEx();
                    break;
                case 3:
                    ex.removeEx();
                    break;
                case 4: 
                    //return;
                    System.exit(0);
            }
        }
    }
}
