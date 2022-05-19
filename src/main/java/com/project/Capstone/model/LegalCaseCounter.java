package com.project.Capstone.model;

public class LegalCaseCounter {

    private String name;
    private int amountOfCases;

    public LegalCaseCounter(String name, int amountOfCases) {
        this.name = name;
        this.amountOfCases = amountOfCases;
    }

    public String getName() {
        return name;
    }

    public int getAmountOfCases() {
        return amountOfCases;
    }
}
