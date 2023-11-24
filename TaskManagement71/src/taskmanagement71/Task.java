/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package taskmanagement71;

import java.util.Date;

/**
 *
 * @author hoang
 */
public class Task {

    private int ID;
    private String taskTypeID;
    private String requirementName;
    private Date date;
    private String planFrom;
    private String planTo;
    private String assignee;
    private String reviewer;

    public Task() {

    }

    public Task(int ID, String taskTypeID, String requirementName, Date date, String planFrom, String planTo, String assignee, String reviewer) {
        this.ID = ID;
        this.taskTypeID = taskTypeID;
        this.requirementName = requirementName;
        this.date = date;
        this.planFrom = planFrom;
        this.planTo = planTo;
        this.assignee = assignee;
        this.reviewer = reviewer;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getTaskTypeID() {
        return taskTypeID;
    }

    public void setTaskTypeID(String taskTypeID) {
        this.taskTypeID = taskTypeID;
    }

    public String getRequirementName() {
        return requirementName;
    }

    public void setRequirementName(String requirementName) {
        this.requirementName = requirementName;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getPlanFrom() {
        return planFrom;
    }

    public void setPlanFrom(String planFrom) {
        this.planFrom = planFrom;
    }

    public String getPlanTo() {
        return planTo;
    }

    public void setPlanTo(String planTo) {
        this.planTo = planTo;
    }

    public String getAssignee() {
        return assignee;
    }

    public void setAssignee(String assignee) {
        this.assignee = assignee;
    }

    public String getReviewer() {
        return reviewer;
    }

    public void setReviewer(String reviewer) {
        this.reviewer = reviewer;
    }


    public double getTime(){
        double time = Double.parseDouble(getPlanTo())-Double.parseDouble(getPlanFrom());
        return time;
    }
    public void display(){
        System.out.println("");
        System.out.printf("%s %20s %20s %20s %20s %20s %20s",ID,requirementName, taskTypeID, date, getTime(), assignee, reviewer);
        System.out.println("");
    }
}
