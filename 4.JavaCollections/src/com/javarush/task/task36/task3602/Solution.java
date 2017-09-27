package com.javarush.task.task36.task3602;

import java.util.Collection;
import java.util.Collections;

/* 
Найти класс по описанию
*/
public class Solution {
    public static void main(String[] args) {
        System.out.println(getExpectedClass());
    }

    public static Class getExpectedClass() {
        Class c = Collections.EMPTY_LIST.getClass();
        Class[] classes = Collection.class.getDeclaredClasses();
        return c;
    }
}
