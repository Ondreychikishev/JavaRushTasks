package com.javarush.task.task20.task2009;

import java.io.*;

/*
Как сериализовать static?
*/
public class Solution {
    public static class ClassWithStatic implements Serializable {
        public static String staticString = "it's test static string";
        public int i;
        public int j;
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {

        ClassWithStatic classWithStatic = new ClassWithStatic();
        FileOutputStream fileOutputStream = new FileOutputStream("/Users/chikishev-93/Desktop/1.txt");
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
        objectOutputStream.writeObject(classWithStatic);
        fileOutputStream.close();
        objectOutputStream.close();

        FileInputStream fileInputStream = new FileInputStream("/Users/chikishev-93/Desktop/1.txt");
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
        Object object = objectInputStream.readObject();
        fileInputStream.close();
        objectInputStream.close();

        ClassWithStatic newClassWithStatic = (ClassWithStatic) object;

    }
}
