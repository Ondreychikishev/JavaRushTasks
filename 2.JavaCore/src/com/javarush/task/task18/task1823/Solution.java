package com.javarush.task.task18.task1823;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/* 
Нити и байты
*/

public class Solution {
    public static Map<String, Integer> resultMap = new HashMap<String, Integer>();

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        while(true) {
            String fileName = reader.readLine();
            if (fileName.equals("exit")) {
                break;
            }
            new ReadThread(fileName).start();
        }
        reader.close();

    }

    public static class ReadThread extends Thread {
        private String fileName;

        public ReadThread(String fileName) {
            this.fileName = fileName;//implement constructor body
        }

        public void run() {
            TreeMap<Byte, Integer> map = new TreeMap<Byte, Integer>();
            try {
                FileInputStream in = new FileInputStream(fileName);
                byte buff[] = new byte[in.available()];
                if (in.available() > 0) {
                    in.read(buff);
                }

                for (int i = 0; i < buff.length; i++) {
                    byte bytes = buff[i];
                    if (map.containsKey(bytes)) {
                        int value = map.get(bytes);
                        value++;
                        map.put(bytes, value);
                    } else {
                        map.put(buff[i], 1);
                    }
                }
                int count = 0;
                int bytes = Byte.MIN_VALUE;
                for (Map.Entry<Byte, Integer> entry : map.entrySet()) {
                    if (entry.getValue() > count) {
                        count = entry.getValue();
                        bytes = entry.getKey();
                    }
                }
                synchronized (resultMap) {
                    resultMap.put(fileName, bytes);
                }
                in.close();
            } catch (IOException e) {
            }

        }
       // implement file reading here - реализуйте чтение из файла тут
    }
}
