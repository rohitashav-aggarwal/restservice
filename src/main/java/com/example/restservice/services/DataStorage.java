package com.example.restservice.services;

import org.springframework.stereotype.Component;

import java.io.*;
import java.util.Scanner;

@Component
public class DataStorage {

    public void writeToFile(String username, String password) throws IOException {
        BufferedWriter out = new BufferedWriter(new FileWriter("file.txt", true));
        out.write(username + "#" + password);
        out.newLine();
        out.close();
    }

    public boolean userExists(String username, String password){
        try {
            Scanner scanner = new Scanner(new FileReader("file.txt"));
            while(scanner.hasNext()) {
                String[] line = scanner.next().split("#", 2 );
                String string1 = line[0];
                String string2 = line[1];
                if (string1.equals(username) && string2.equals(password)) {
                    return true;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }
}
