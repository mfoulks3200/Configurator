package com.atlaspuplabs.configurator;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.util.Scanner;

public class Resources {
    public static String getTextFile(String relativePath){
        String output = "";
        try {
            File file = new File(System.getProperty("user.dir")+"/"+relativePath);
            Scanner reader = new Scanner(file);
            while (reader.hasNextLine()) {
                String data = reader.nextLine();
                output += data+"\n";
            }
            reader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return output;
    }

    public static void writeTextFile(String relativePath, String content){
        try {
            File file = new File(System.getProperty("user.dir")+"/"+relativePath);
            if(!file.exists()){
                file.createNewFile();
            }
            FileWriter writer = new FileWriter(file);
            writer.write(content);
            writer.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void appendTextFile(String relativePath, String content){
        String current = getTextFile(relativePath);
        try {
            File file = new File(System.getProperty("user.dir")+"/"+relativePath);
            if(!file.exists()){
                file.createNewFile();
            }
            FileWriter writer = new FileWriter(file);
            writer.write(current+(current.length() > 0 ? "\n" : "")+content);
            writer.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void createFile(String relativePath){
        try {
            File file = new File(System.getProperty("user.dir")+"/"+relativePath);
            if(!file.exists()){
                file.createNewFile();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static boolean exists(String relativePath){
        File file = new File(System.getProperty("user.dir")+"/"+relativePath);
        return file.exists();
    }
}
