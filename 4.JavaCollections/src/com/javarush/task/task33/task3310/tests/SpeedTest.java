package com.javarush.task.task33.task3310.tests;

import com.javarush.task.task33.task3310.Helper;
import com.javarush.task.task33.task3310.Shortener;
import com.javarush.task.task33.task3310.strategy.HashBiMapStorageStrategy;
import com.javarush.task.task33.task3310.strategy.HashMapStorageStrategy;
import org.junit.Assert;
import org.junit.Test;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class SpeedTest {

    public long getTimeForGettingIds(Shortener shortener, Set<String> strings, Set<Long> ids) {
        Date startDate = new Date();
        for (String string : strings) {
            ids.add(shortener.getId(string));
        }
        Date finishDate = new Date();
        long result = finishDate.getTime() - startDate.getTime();
        return result;
    }

    public long getTimeForGettingStrings(Shortener shortener, Set<Long> ids, Set<String> strings) {
        Date startDate = new Date();
        for (Long id : ids) {
            strings.add(shortener.getString(id));
        }
        Date finishDate = new Date();
        long result = finishDate.getTime() - startDate.getTime();
        return result;
    }

    @Test
    public void testHashMapStorage() {
        Shortener shortener1 = new Shortener(new HashMapStorageStrategy());
        Shortener shortener2 = new Shortener(new HashBiMapStorageStrategy());

        Set<String> origStrings = new HashSet<>();
        for (int i = 0; i < 10000; i++) {
            origStrings.add(Helper.generateRandomString());
        }
        Set<Long> ids1 = new HashSet<>();
        Set<Long> ids2 = new HashSet<>();

        long time1 = getTimeForGettingIds(shortener1, origStrings, ids1);
        long time2 = getTimeForGettingIds(shortener2, origStrings, ids2);
        Assert.assertTrue(time1 > time2);

        
        long timeStrings1 = getTimeForGettingStrings(shortener1, ids1, origStrings);
        long timeStrings2 = getTimeForGettingStrings(shortener2, ids2, origStrings);
        Assert.assertEquals(timeStrings1, timeStrings2, 30);
    }
}
