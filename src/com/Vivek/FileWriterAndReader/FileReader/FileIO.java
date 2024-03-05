package com.Vivek.FileWriterAndReader.FileReader;

import java.io.BufferedReader;
import java.io.FileReader;

public class FileIO {
    public static void main(String[] args) {
        try{
            String systemPath = System.getProperty("user.dir");
            String filePath = "/src/com/Vivek/FileWriterAndReader/FileWriter/output.txt";
            String fullPath = systemPath + filePath;
            BufferedReader reader = new BufferedReader(new FileReader(fullPath));

            String line;
            while((line = reader.readLine()) != null){
                System.out.println(line);
            }
            reader.close();
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
}
