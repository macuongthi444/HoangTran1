/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment;

/**
 *
 * @author hoang
 */
public class Student {

    private String ID;
    private String Name;
    private long mark;

    public Student() {

    }

    public Student(String ID, String Name, long mark) {
        this.ID = ID;
        this.Name = Name;
        this.mark = mark;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public long getMark() {
        return mark;
    }

    public void setMark(long mark) {
        this.mark = mark;
    }

    @Override
    public String toString() {
        return ("(" + ID + ", " + Name + ", " + mark + ")");

    }

}
