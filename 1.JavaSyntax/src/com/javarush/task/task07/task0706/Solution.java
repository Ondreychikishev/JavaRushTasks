package com.javarush.task.task07.task0706;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Улицы и дома
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int[] array = new int[15];

        for (int i = 0; i < 15; i++) {
            array[i] = Integer.parseInt(reader.readLine());//напишите тут ваш код
        }

        int n = 0;
        int n1 = 0;

        for (int j = 0; j < array.length; j++) {
            if (j % 2 == 0 || j == 0) {
                n += array[j];
            } else {
                n1 += array[j];
            }
        }

        if (n1 > n) {
            System.out.println("В домах с нечетными номерами проживает больше жителей.");
        } else {
            System.out.println("В домах с четными номерами проживает больше жителей.");
        }
    }
}
