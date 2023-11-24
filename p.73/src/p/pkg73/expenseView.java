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
import common.validate;
import controller.expenselist;
import java.util.ArrayList;
import java.util.List;
import model.expense;
public class expenseView {
    expenselist exlist = new expenselist();  //lop luu tru danh sach chi phi
    validate check = new validate();    //kiem tra dau vao
    
    public void createExpense(){
        int ID;
        //set ID auto increment
        if (exlist.sizeList()== 0) ID = 1; //neu danh sach doi tuong = 0 thi dat iD =1
        else ID = exlist.sizeList() + 1; //neu khong no se dat gia tri kich thuoc hien tai + 1
        
        //nhap ngay thang 
        String date = check.inputDate("Enter Date: ");
        //nhap so tien
        double amount = check.inputDouble("Enter Amount: ", 0, Double.MAX_VALUE);
        //nhap noi dung
        String content = check.inputString("Enter Content: ");
        //tao doi tuong moi theo cac thuoc tinh da nhap o tren
        expense e = new expense(ID, date, amount, content);
        //add expense to exlist
        exlist.addExpense(e);
        System.out.println("Add new expense successfully");
    }
    
    public void removeEx(){
        //nhap ID tu nho den lon
        int ID = check.inputInt("Enter ID: ", Integer.MIN_VALUE, Integer.MAX_VALUE);
        //kiem tra ID co ton tai truoc do hay khong
        if(exlist.checkIdExist(ID)==-1){ //neu no khong ton tai thi se thong bao khong ton tai
            System.out.println("ID does not exist");
        } else {
            //neu ton tai no se thong bao rang chi phi da duoc xoa thanh cong
            exlist.removeExpense(ID);
            System.out.println("Remove successfully");           
        }
    }
    public void displayEx() {
        double total = 0; //tao bien luu cac chi phi
        //dinh dang chuoi cho dau ra theo form ID DATE Amount Content
        System.out.println(String.format("%-4s%-15s%-15s%-20s", "ID", "Date", "Amount", "Content"));
        //point to each expense in list
        for (expense e: exlist.getList()) {  //lap qua danh sach 
            System.out.println(e);
            total += e.getAmount(); //tinh tong chi phi 
        }
        System.out.printf("Total: " + total);
        System.out.println("");
    }
    
}

