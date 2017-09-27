package com.javarush.task.task33.task3310;

import com.javarush.task.task33.task3310.strategy.StorageStrategy;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by chikishev-93 on 22.09.17.
 */
public class Shortener {
    private Long lastId = new Long(0);
    private StorageStrategy storageStrategy;  //хранится стратегия данных

    Map<Long, String> map = new HashMap<>();

    public Shortener(StorageStrategy storageStrategy) {
        this.storageStrategy = storageStrategy;
    }

    public synchronized Long getId(String string) {
        if (storageStrategy.containsValue(string)){
            return storageStrategy.getKey(string);
        } else {
            lastId++;
            storageStrategy.put(lastId, string);
            return lastId;
        }
    }

    public synchronized String getString(Long id) {
        return storageStrategy.getValue(id);
    }

}
