package com.javarush.task.task22.task2210;

import java.util.ArrayList;
import java.util.StringTokenizer;

/*
StringTokenizer
*/
public class Solution {
    public static void main(String[] args) {
        for (String s : getTokens("level22.lesson13.task01", "."))
            System.out.println(s);
    }

    public static String [] getTokens(String query, String delimiter) {
        ArrayList<String> strings  = new ArrayList<String>();
        StringTokenizer stringTokenizer = new StringTokenizer(query, delimiter);
        while(stringTokenizer.hasMoreTokens()){
            String token = stringTokenizer.nextToken();
            strings.add(token);
        }
        String [] s = new String[strings.size()];
        return strings.toArray(s);
    }
}
