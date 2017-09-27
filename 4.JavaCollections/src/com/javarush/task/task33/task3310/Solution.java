package com.javarush.task.task33.task3310;

import com.javarush.task.task33.task3310.strategy.*;
import javafx.scene.chart.PieChart;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by chikishev-93 on 22.09.17.
 */
public class Solution {

    public static void main(String[] args) {
        HashMapStorageStrategy hashMapStorageStrategy = new HashMapStorageStrategy();
        testStrategy(hashMapStorageStrategy, 10000);
        OurHashMapStorageStrategy ourHashMapStorageStrategy = new OurHashMapStorageStrategy();
        testStrategy(ourHashMapStorageStrategy, 10000);
        FileStorageStrategy fileStorageStrategy = new FileStorageStrategy();
        testStrategy(fileStorageStrategy, 3);
        OurHashBiMapStorageStrategy ourHashBiMapStorageStrategy = new OurHashBiMapStorageStrategy();
        testStrategy(ourHashBiMapStorageStrategy, 10000);
        HashBiMapStorageStrategy hashBiMapStorageStrategy = new HashBiMapStorageStrategy();
        testStrategy(hashBiMapStorageStrategy, 10000);
        DualHashBidiMapStorageStrategy dualHashBidiMapStorageStrategy = new DualHashBidiMapStorageStrategy();
        testStrategy(dualHashBidiMapStorageStrategy, 10000);
    }

    public static Set<Long> getIds(Shortener shortener, Set<String> strings) {
        Set<Long> ids = new HashSet<>();

        for (String string : strings) {
            Long idString = shortener.getId(string);
            ids.add(idString);
        }
        return ids;
    }

    public static Set<String> getStrings(Shortener shortener, Set<Long> keys) {
        Set<String> stringSet = new HashSet<>();

        for (Long key : keys) {
            String idKey = shortener.getString(key);
            stringSet.add(idKey);
        }
        return stringSet;
    }

    public static void testStrategy(StorageStrategy strategy, long elementsNumber) {
        Helper.printMessage(strategy.getClass().getSimpleName());

        Set<String> testSetStrings = new HashSet<>();
        for (long i = 0; i < elementsNumber; i++)
        {
            testSetStrings.add(Helper.generateRandomString());
        }

        Shortener shortener = new Shortener(strategy);
        Date startDate = new Date();
        long start = startDate.getTime();
        Set<Long> set = getIds(shortener, testSetStrings);
        Date finishDate = new Date();
        long finish = finishDate.getTime();
        long resultGetIds = finish - start;
        Helper.printMessage(Long.toString(resultGetIds));

        Date startDate1 = new Date();
        long start1 = startDate.getTime();
        Set<String> set1 = getStrings(shortener, set);
        Date finishDate1 = new Date();
        long finish1 = finishDate.getTime();
        long resultGetStrings = finish1 - start1;
        Helper.printMessage(Long.toString(resultGetStrings));

        if (testSetStrings.equals(set1)) {
            Helper.printMessage("Тест пройден.");
        } else {
            Helper.printMessage("Тест не пройден.");
        }
    }
}
