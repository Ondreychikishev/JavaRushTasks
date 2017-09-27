package com.javarush.task.task18.task1821;

/* 
Встречаемость символов
*/

import java.io.*;
import java.util.Arrays;
import java.util.HashMap;

public class Solution {
    public static void main(String[] args) throws IOException
    {
        FileInputStream inputStream = new FileInputStream(new File(args[0]));
//        BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
//        FileInputStream inputStream = new FileInputStream(new File(rd.readLine()));

        byte[] symbols = new byte[inputStream.available()];
        inputStream.read(symbols);
        Arrays.sort(symbols);

        HashMap<Byte, Integer> map = new HashMap<Byte, Integer>();

        int count;


        for (byte x : symbols) {
            count = 0;

            for (byte x1 : symbols) {
                if (x == x1) {
                    count++;
                }
            }

            if (!map.containsKey(x)) {
                map.put(x, count);
                System.out.println((char) x + " " + count);
            }


        }

        inputStream.close();

    }
}
