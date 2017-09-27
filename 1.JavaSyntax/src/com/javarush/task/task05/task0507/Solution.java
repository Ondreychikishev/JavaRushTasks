package com.javarush.task.task05.task0507;

/* 
Среднее арифметическое
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int sum = 0;
        int sch = 1;
        while (true) {

            String s = reader.readLine();
            int n = Integer.parseInt(s);

            if (n == -1) {
                break;
            } else

            sum +=n;

        }
        double result = (double) sum / (double)sch;
        System.out.println(result);

    }
}

