package org.example;

public class Income extends Transaction {
    // efter Income ärver Transaction måste den implementra Transactions constructor med super
    // om man bara klicka på det röda så ger den ett förslag, klickar man där så fixar den
    // constructorn automatiskt

    // vi skippar category nu...


    public Income(String date, double amount) {
        super(date, amount);
    }
}
