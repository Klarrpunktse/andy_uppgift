package org.example;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;


public class Main {

    public static void main(String[] args) throws IOException {
        // här behöver du följande:
        // en instans av ExpenseStorage (och IncomeStorage när du skapat den)
        IncomeStorage incomeStorage = new IncomeStorage();

        // kalla på readFile() OBS! viktigt att det sker först i main
        incomeStorage.readFile();


        // Du kan fixa till din meny sen men nu hårdkodar jag en Income för att
        // testa så att det funkar. Jag har skrivit en kommentar i din loop om vilka
        // val du behöver ha i din meny

        // skapar en ny Income
        Income income = new Income("2024-11-04", 1000);
        // kallar på addIncome() och skickar in income som nyss skapades
        incomeStorage.addIncome(income);

        // testar att lägga till en Income så att vi ser att den sparar båda och inte kör över
        Income secondIncome = new Income("2024-11-02", 3000);
        incomeStorage.addIncome(secondIncome);

        // viktigt att inte glömma att spara till fil!
        incomeStorage.saveFile();

        Scanner sc = new Scanner(System.in);
        boolean loop = true;
        double balance;
        int valet;
        //menu val


        //gjorde inlogginng
        String User_ID = "Leoryujin";
        String Code_ID = "LordOfLord";

        System.out.println("Användarnamn");
        String Username = sc.nextLine();
        System.out.println("Password");
        String Password = sc.nextLine();
        if (Username.equals(User_ID) && Password.equals(Code_ID)) {
            System.out.println("You are logged in");
        } else {
            System.out.println("prova igen");
        }

        while (loop) {
            // du vill ha dessa val:
            // - Lägg till en inkomst (typ lön, csn..)
            // - Lägg till en utgift (typ hyra, mat etc..)
            // - Ändra en inkomst
            // - Ändra en utgift
            // - Ta bort en inkomst
            // - Ta bort en utgift
            // - Räkna ut totalen (alla inkomster - alla utgifter)
            System.out.println("1.insättning\n2.ta ut\n3.saldo\n4.kontoInfo");

            valet = sc.nextInt();
            int sum = 10000;

            if (valet == 1) {
                System.out.println("sätta in hur mycket?");
                int deposit = sc.nextInt();

                if (sum > 0) {
                    deposit += sum;
                    System.out.println(deposit);
                }
            } else if (valet == 2) {
                System.out.println("Tar ut hur mycket");
                double withdraw = sc.nextInt();
                if (sum > 0 && sum <= withdraw) {
                    withdraw -= sum;
                    System.out.println(withdraw);
                }
                } else if (valet == 3) {
                    System.out.println(sum);
                } else if (valet == 4) {
                    //account Info
                    long UserInfo;
                    System.out.println();
                }
            }
        }
    }

