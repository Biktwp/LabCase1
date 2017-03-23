package com.company;
import java.io.File;
import  java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;

public class Main {

    public static void reader(File f) throws IOException{
        FileReader fr = new FileReader(f);
        BufferedReader br = new BufferedReader(fr);
        String line;
        String test = "";
        SQueue word = new SQueue();
        String [] aux;
        while ((line = br.readLine()) != null) {
            test += line;
        }
        test = test.replaceAll("[^a-zA-Z]"," ");
        test = test.replace("  "," ");
        aux = test.split(" ");
        for (int i = 0; i < aux.length; i++){
            word.enqueue(aux[i]);
        }

        fr.close();
        br.close();
    }

    public static void main(String[] args) {
	// write your code here
        File f = new File("/home/tau/UNI/EDA/LabCase1.txt");
        DList Dictionary = new DList();
        try{
            reader(f);
        } catch (IOException e){
            e.printStackTrace();
        }





    }
}
