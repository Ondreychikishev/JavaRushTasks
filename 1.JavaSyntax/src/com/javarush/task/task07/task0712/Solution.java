package com.javarush.task.task07.task0712;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Самые-самые
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));//напишите тут ваш код
        ArrayList<String> list = new ArrayList<>();
        int maxin = 0;
        int minin = 0;

        for (int i = 0; i < 10; i++) {
            list.add(reader.readLine());
        }
        String max = list.get(0);
        String min = list.get(0);

        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).length() > max.length()) {
                max = list.get(i);
                maxin = i;
            } else if (list.get(i).length() < min.length()){
                min = list.get(i);
                minin = i;
            }
        }

        if (maxin < minin) {
            System.out.println(max);
        }
        if (maxin > minin) {
            System.out.println(min);
        }
    }
}
