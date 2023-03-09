package com.harshitprajapati.harshitproject;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ReadUsername {
    public static void main(String[] args) {
        try {
            FileReader reader = new FileReader("Username.txt");
            BufferedReader bufferedReader = new BufferedReader(reader);
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                System.out.println((String) line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
