package com.javarush.task.task19.task1909;

/* 
Замена знаков
*/


import java.io.*;


public class Solution {
    public static void main(String[] args) throws IOException
    {
        BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
        String oneFile = rd.readLine();
        String twoFile = rd.readLine();

        BufferedReader reader = new BufferedReader(new FileReader(oneFile));
        BufferedWriter writer = new BufferedWriter(new FileWriter(twoFile));


        while(reader.ready()) {
            String str = reader.readLine();
            str = str.replaceAll("\\.", "!");
            writer.write(str);
            writer.newLine();
        }

        rd.close();
        reader.close();
        writer.close();

    }
}
