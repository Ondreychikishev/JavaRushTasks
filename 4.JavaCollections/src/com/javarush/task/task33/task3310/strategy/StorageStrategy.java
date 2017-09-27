package com.javarush.task.task33.task3310.strategy;

/**
 * Created by chikishev-93 on 22.09.17.
 */
public interface StorageStrategy {
    boolean containsKey(Long key);

    boolean containsValue(String value);

    void put(Long key, String value);

    Long getKey(String value);

    String getValue(Long key);
}
