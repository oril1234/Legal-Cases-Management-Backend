package com.project.Capstone.model;


import java.util.Date;

public class BetweenDates {

    private Date startDate;
    private Date endDate;

    //need default constructor for JSON Parsing
    public BetweenDates()
    {

    }

    public BetweenDates(Date startDate, Date endDate) {
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }
}
