package com.javarush.task.task22.task2211;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/* 
Смена кодировки
*/
public class Solution {
    static String win1251TestString = "РќР°СЂСѓС€РµРЅРёРµ РєРѕРґРёСЂРѕРІРєРё РєРѕРЅСЃРѕР»Рё?"; //only for your testing

    public static void main(String[] args) throws IOException {
        FileInputStream inputStream=new FileInputStream(args[0]);
        FileOutputStream outputStream=new FileOutputStream(args[1]);
        byte[] buff=new byte[inputStream.available()];
        inputStream.read(buff);
        String s= new String(buff, "UTF-8");
        outputStream.write(s.getBytes("Windows-1251"));
        inputStream.close();
        outputStream.close();
    }
}
