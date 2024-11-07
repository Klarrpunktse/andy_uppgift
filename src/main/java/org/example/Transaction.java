package org.example;

public class Transaction {
    // transaction ska ha date och amount
    // vi sätter date till string för att inte komplicera det hela...
    private String date;
    private double amount;

    public Transaction(String date, double amount) {
        this.date = date;
        this.amount = amount;
    }

    // samma sak med getter + setters de kan autogenereras
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


}
