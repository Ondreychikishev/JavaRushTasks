package com.javarush.task.task08.task0818;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* 
Только для богачей
*/

public class Solution {
    public static HashMap<String, Integer> createMap() {
        HashMap<String, Integer> map = new HashMap<>();
        map.put("Chikishev", 1000);
        map.put("Kashin", 400);
        map.put("Metenkanich", 300);
        map.put("Slivnicin", 600);
        map.put("Zhukov", 700);
        map.put("Kirilov", 600);
        map.put("Schnur", 550);
        map.put("Kim", 800);
        map.put("Slon", 900);
        map.put("Ivanov", 850);
        return map;
    }

    public static void removeItemFromMap(HashMap<String, Integer> map) {
        Iterator<Map.Entry<String, Integer>> iterator = map.entrySet().iterator();
        while (iterator.hasNext()) {
            HashMap.Entry pair = (HashMap.Entry)iterator.next();
            Integer n = (Integer) pair.getValue();
            if (n < 500) {
                iterator.remove();
            }
        }
    }

    public static void main(String[] args) {

    }
}