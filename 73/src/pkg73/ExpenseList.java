/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg73;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 *
 * @author hoang
 */
public class ExpenseList {

    private List<Expense> list = new ArrayList<>();
    
private Validation check = new Validation();
    public void addExpense() {
        int ID;
       
        if (list.isEmpty()) {
            ID = 1;
        } else {
            ID = list.get(list.size() - 1).getId()+ 1;
        }
        String date = check.inputDate("Enter Date: ");
        double amount = check.inputDouble("Enter Amount: ", 0, Double.MAX_VALUE);
        String content = check.inputString("Enter Content: ", "[A-Za-z0-9\\s]+");
        Expense e = new Expense(ID, date, amount, content);
        list.add(e);
        System.out.println("Add new expense successfully");
    }

    public void removeExpense() {
        int ID = check.inputInt("Enter ID: ", Integer.MIN_VALUE, Integer.MAX_VALUE);
        for (Expense expense:list) {
            if (expense.getId()== ID) {
                list.remove(expense);
                System.out.println("Remove successfully");
                return;
            }
        }
        System.out.println("ID does not exist");
    }

    public void display() {
        double total = 0;
        HashMap<String,Double> hashmap= new HashMap<>();
        ArrayList<Expense> list12= new ArrayList<>();
        System.out.println(String.format("%-4s%-15s%-15s%-20s", "ID", "Date", "Amount", "Content"));
        for (Expense e : list) {
             e.display();
            total = total + e.getAmount();
            if(hashmap.containsKey(e.getDate())){
                hashmap.put(e.getDate(), hashmap.get(e.getDate())  + e.getAmount());
            }else {
                hashmap.put(e.getDate(), e.getAmount());
            }
            if(hashmap.get(e.getDate())>1000){              
                list12.add(e);               
            }
       
        }
        
        
        System.out.println("\t\tTotal: " + total);
        for (Expense list121 : list12) {
            list121.display();
            System.out.println(hashmap.get(list121.getDate())-1000);
        }
        
    }

}
