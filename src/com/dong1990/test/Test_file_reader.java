package com.dong1990.test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class Test_file_reader {
    public static void main(String[] args) {
        String pathString = "c:"+ File.separator+"Users"+File.separator+"XS-021"+
                File.separator+"Downloads"+File.separator+"tunnelSignature.txt";
        File file = new File(pathString);
        BufferedReader reder = null;
        try{
            reder = new BufferedReader(new InputStreamReader(new FileInputStream(file), "UTF-8"));
            String string = null;
            while ((string = reder.readLine()) != null) {
                System.out.println(string);
            }
        }catch(Exception e){

        }
    }
}
