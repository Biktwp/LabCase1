package com.company;
import java.io.File;
import  java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;

public class Main {

    public static void reader(File f) throws IOException{
        FileReader fr = new FileReader(f);
        BufferedReader br = new BufferedReader(fr);
        String line ;
        String[] word;
        line = br.readLine();
        word = line.split(" ");
        int i = 0;
        while (fr != null) {

            while (line != null) {
                while (i < word.length) {
                    System.out.println(word[i]);
                    i++;
                }
            }
        }
        fr.close();
        br.close();
    }

    public static void main(String[] args) {
	// write your code here
        File f = new File("/home/tau/UNI/EDA/LabCase1.txt");
        try{
            reader(f);
        } catch (IOException e){
            e.printStackTrace();
        }
        System.out.println();

    }
}
