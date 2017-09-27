package com.javarush.task.task20.task2025;

import java.util.ArrayList;

/*
Алгоритмы-числа
*/
public class Solution {

    public static void main(String[] args) {
        Long t0 = System.currentTimeMillis();
        int n = 100000000;
        int[] numbers = getNumbers(n);
        Long t1 = System.currentTimeMillis();
        System.out.println("time: " + (t1 - t0) / 1000d + " sec");
        System.out.println("memory: " + (Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory()) / (1024 * 1024) + " mb");
        for (int i = 0; i < numbers.length; i++) {
            System.out.print(numbers[i] + ", ");
        }
        System.out.println();

    }

    public static int[] getNumbers(int N) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        for (int i = 1; i < N; i++) {
            if (isArmStrong(i)) list.add(i);
        }
        int[] result = null;
        result = new int[list.size()];
        for (int i = 0; i < list.size(); i++)
            result[i] = list.get(i);
        return result;
    }

    private static boolean isArmStrong(int number) {
        int result = 0;
        int orig = number;
        int exp = Integer.toString(orig).length();
        while (number != 0) {
            int remainder = number % 10;
            result += power(remainder, exp);
            number = number / 10;
        }
        //number is Armstrong return true
        if (orig == result) {
            return true;
        }
        return false;
    }

    static int power(double x, long n) {
        int result = 1;
        while (n != 0) {
            if (n % 2 != 0) {
                result *= x;
                n -= 1;
            }
            x *= x;
            n /= 2;
        }
        return result;
    }
}
