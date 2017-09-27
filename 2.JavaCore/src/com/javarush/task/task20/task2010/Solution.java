package com.javarush.task.task20.task2010;

import java.io.*;

/*
Как сериализовать что-то свое?
*/
public class Solution  {
    public static class Object implements Serializable {
        public String string1;
        public String string2;
    }

    public static int countStrings;

    public static class String implements  Serializable {
        private final int number;

        public String() {
            number = ++countStrings;
        }

        public void print() {
            System.out.println("string #" + number);
        }
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {

       /* Object object = new Object();
        FileOutputStream fileOutputStream = new FileOutputStream("/Users/chikishev-93/Desktop/1.txt");
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
        objectOutputStream.writeObject(object);
        fileOutputStream.close();
        objectOutputStream.close();

        FileInputStream fileInputStream = new FileInputStream("/Users/chikishev-93/Desktop/1.txt");
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
        Object object1 = (Object) objectInputStream.readObject();
        fileInputStream.close();
        objectInputStream.close();

        Object object2 = object1;*/
    }
}
