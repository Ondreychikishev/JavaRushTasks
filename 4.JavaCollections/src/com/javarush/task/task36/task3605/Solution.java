package com.javarush.task.task36.task3605;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.TreeSet;

/* 
Использование TreeSet
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        TreeSet<Character> treeSet = new TreeSet<>();
        sortChar(treeSet, "/Users/chikishev-93/Desktop/2.txt");
        deletAndPrint(treeSet);
    }

    public static TreeSet<Character> sortChar (TreeSet<Character> set, String fileName) {
        try (BufferedReader fileReader = new BufferedReader(new FileReader(new File(fileName)))) {
            while (fileReader.ready()) {
                String s = fileReader.readLine().toLowerCase().replaceAll("[^\\p{Alpha}]","");
                for (int i = 0; i < s.length(); i++)
                    set.add(s.charAt(i));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return set;
    }

    public static void deletAndPrint (TreeSet<Character> treeSet) {
        Iterator<Character> iterator = treeSet.iterator();
        int n = treeSet.size() < 5 ? treeSet.size() : 5;

        for (int i = 0; i < n; i++) {
            System.out.print((iterator.next()));
        }
    }
}
