package org.example;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.io.*;
import java.lang.reflect.Type;
import java.util.Map;

public class IncomeStorage {
    // den här klassen ska hantera all logic kring Income
    // den behöver följande:

    // - en lista med alla incomes
    private Map<String, Income> incomeList;
    // vi skapar en Map som sen blir en HashMap. Mycket mycket enklare att hantera än en ArrayList
    // <String, Income> innebär att vi sätter key till datatypen String, key är ungefär som index i en array
    // men vi har friheten att bestämma vilken datatyp och vad det ska vara. Det bör vara String eller Integer men kan vara objekt också
    // så vi säger kort sagt att vår lista är av typen Income men key värdet ska vara String

    // - gson instans så att vi kan spara och läsa till fil
    Gson gson = new GsonBuilder().setPrettyPrinting().create();
    // det här har ni fått länk till kod repo av mig med kod ni får använda
    // setPrettyPrinting spara data i json filen snygg

    // - en variabel för filnamn så att den vet vart den ska spara och läsa
    private  String fileName = "src/main/incomes.json";
    // viktigt att det är korrekt path, jag har skapat filen incomes.json i main foldern
    // jag la tomma {} i den för att det inte ska bråka sen

    // - en tom constructor
    public IncomeStorage() {

    }

    // metoder som den här klassen bör ha:

    // - readFile(): metod för att läsa in filen, den här metoden ska ALLTID köras först i programmet annars blir det knas
    // den här koden har ni fått lov att använda och finns länk till repot i kursmaterialet
    public void readFile() throws FileNotFoundException {
        Type type = new TypeToken<Map<String, Income>>() {}.getType();
        //här används TypeToken från gson för att få information om den typ som Gson
        // ska avkoda från JSON-filen. Eftersom Map<String, Income> är en generisk typ och
        // Java inte direkt hanterar generics vid körning, behövs TypeToken för att
        // Gson ska veta vilken typ som ska användas vid deserialisering.
        Reader reader = new FileReader(new File(fileName));
        // en FileReader används här för att läsa från filen som lagras i variabeln fileName.
        // FileReader öppnar en ström för att läsa filens innehåll tecken för tecken.
        incomeList = gson.fromJson(reader, type);
        // här används Gson för att konvertera JSON-innehållet i filen till ett Java-objekt.
        // i detta fall kommer den att konvertera JSON-innehållet till en Map<String, Income>-struktur.
        // fromJson() tar två argument: en läsare (reader) och typen (type).
    }


    // - saveFile(): metod för att spara till json filen
    // den här koden har ni fått lov att använda och finns länk till repot i kursmaterialet
    public void saveFile() throws IOException {
        FileWriter fw = new FileWriter(new File(fileName));
        // en FileWriter öppnas för att skriva till den fil som specificeras av fileName.
        // om filen inte finns, skapar FileWriter den. Om filen redan finns, skrivs dess innehåll över.
        gson.toJson(incomeList, fw);
        // här används Gson för att konvertera incomeList (som är en Map<String, Income>) till
        // JSON-format och skriva den till filen med hjälp av FileWriter (fw). toJson() tar
        // två argument: objektet som ska konverteras (här expenseList) och den Writer som ska användas (här fw).
        fw.close();
        // strömmen stängs, vilket säkerställer att allt skrivs till filen och att filresurserna frigörs.
        // super viktigt att stänga strömmen här!
        System.out.println("File saved.");
    }

    // - addIncome(): lägg till en expense i listan med expenses
    // den här fanns i mitt exempel men jag hade slagit ihop add och save i en funktion
    // put() lägger till ett objekt i en Hashmap, vi ska lägga till en Income så vi ser till
    // att metoden tar emot en Income som argument
    public void addIncome(Income income) {
        // put() metoden vill ha två argument:
        // första är key (alltså en String för det har vi sagt tidigare att det ska vara)
        // andra är i det här fallet en Income
        // eftersom date på en Income är av typen String skulle vi ju kunna sätta date som key
        incomeList.put(income.getDate(), income);
        // vi hämtar datumer med gettern andra argumentet är hela incomen
    }

    // - listAllIncomes(): visa alla incomes i din lista
    // - removeIncome(): ta bort en incomes från listan
    // - updateIncome(): uppdatera en incomes

    // - totalIncomes(): gör den här absolut sist men i uppgiften står att ni ska räkna ihop alla inkomster och utgifter
}
