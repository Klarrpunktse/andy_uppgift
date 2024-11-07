package org.example;

import com.google.gson.Gson;
import org.example.UserInfo;

import java.io.FileWriter;
import java.io.IOException;


public class IncomeID {
    public IncomeID() throws IOException {

        Gson gson = new Gson();
        String fileName = "src/incomeID.json";
        UserInfo userInfo = new UserInfo(1234, "Jason Koo", 10000);
        FileWriter fw = new FileWriter(fileName);
        gson.toJson(userInfo, fw);
        fw.close();
        System.out.println(userInfo.getId() + " " + userInfo.getNamn());
    }
}
