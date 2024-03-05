package com.Vivek.FileWriterAndReader.FileWriter;

import java.io.BufferedWriter;
import java.io.FileWriter;
public class FileIO {
    public static void main(String[] args) {
        try {
            String currentDir = System.getProperty("user.dir");
            String fullPath = currentDir + "/src/com/Vivek/FileWriterAndReader/FileWriter/output.txt";
            BufferedWriter writer = new BufferedWriter(new FileWriter(fullPath));
            writer.write("WRITING TO THE FILE!!");
            writer.write("\nWRITING TO THE FILE!!");
            writer.close();
        } catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
}
