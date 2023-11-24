/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package p101.pkg100loc;

/**
 *
 * @author hoang
 */
public class Employer {

    private String ID;
    private String FirstName ;
    private String LastName ;
    private String Phone; 
    private String Email; 
    private String Address; 
    private String DOB; 
    private String Sex; 
    private int Salary ;
    private String Egency;
    public Employer(){
        
    }

    public Employer(String ID, String FirstName, String LastName, String Phone, String Email, String Address, String DOB, String Sex, int Salary, String Egency) {
        this.ID = ID;
        this.FirstName = FirstName;
        this.LastName = LastName;
        this.Phone = Phone;
        this.Email = Email;
        this.Address = Address;
        this.DOB = DOB;
        this.Sex = Sex;
        this.Salary = Salary;
        this.Egency = Egency;

}

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getFirstName() {
        return FirstName;
    }

    public void setFirstName(String FirstName) {
        this.FirstName = FirstName;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String LastName) {
        this.LastName = LastName;
    }

    public String getPhone() {
        return Phone;
    }

    public void setPhone(String Phone) {
        this.Phone = Phone;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String Address) {
        this.Address = Address;
    }

    public String getDOB() {
        return DOB;
    }

    public void setDOB(String DOB) {
        this.DOB = DOB;
    }

    public String getSex() {
        return Sex;
    }

    public void setSex(String Sex) {
        this.Sex = Sex;
    }

    public int getSalary() {
        return Salary;
    }

    public void setSalary(int Salary) {
        this.Salary = Salary;
    }

    public String getEgency() {
        return Egency;
    }

    public void setEgency(String Egency) {
        this.Egency = Egency;
    }
    public void display(){
        System.out.println(ID+"\t"+FirstName+"\t"+LastName+"\t"+Phone+"\t"+Email+"\t"+Address+"\t"+DOB+"\t"+Sex+"\t"+Salary+"\t"+Egency);
    }
    
}