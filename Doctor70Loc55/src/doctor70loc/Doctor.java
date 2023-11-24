/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package doctor70loc;

/**
 *
 * @author hoang
 */
public class Doctor {

    private String code;
    private String name;
    private String specilization;
    private int availability;
    public Doctor(){
        
    }

    public Doctor(String Code, String Name, String Specilization, int Availability) {
        this.code = Code;
        this.name = Name;
        this.specilization = Specilization;
        this.availability = Availability;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String Code) {
        this.code = Code;
    }

    public String getName() {
        return name;
    }

    public void setName(String Name) {
        this.name = Name;
    }

    public String getSpecilization() {
        return specilization;
    }

    public void setSpecilization(String Specilization) {
        this.specilization = Specilization;
    }

    public int getAvailability() {
        return availability;
    }

    public void setAvailability(int Availability) {
        this.availability = Availability;
    }
    public void display(){
        System.out.println(code+"\t" + name + "\t" + specilization + "\t\t" + availability);
    }
}
