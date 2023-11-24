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


    public class expense {
    private int id;
    private String date;
    private double amount;
    private String content;
    public expense() {
    }
    public expense(int id, String date, double amount, String content) {
        this.id = id;
        this.date = date;
        this.amount = amount;
        this.content = content;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getDate() {
        return date;
    }
    public void setDate(String date) {
        this.date = date;
    }
    public double getAmount() {
        return amount;
    }
    public void setAmount(double amount) {
        this.amount = amount;
    }
    public String getContent() {
        return content;
    }
    public void setContent(String content) {
        this.content = content;
    }
    public String toString() {
        return String.format("%-4s%-15s%-15s%-20s", id, date, amount, content);
    }
    
    
}
    

