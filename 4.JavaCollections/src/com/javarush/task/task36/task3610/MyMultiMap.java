package com.javarush.task.task36.task3610;

import java.io.Serializable;
import java.util.*;

public class MyMultiMap<K, V> extends HashMap<K, V> implements Cloneable, Serializable {
    static final long serialVersionUID = 123456789L;
    private HashMap<K, List<V>> map;
    private int repeatCount;

    public MyMultiMap(int repeatCount) {
        this.repeatCount = repeatCount;
        map = new HashMap<>();
    }

    @Override
    public int size() {
        return values().size();//напишите тут ваш код
    }

    @Override
    public V put(K key, V value) {
        List<V> v = map.get(key);
        V v1 =null;

        if (v == null) {
            v = new ArrayList<>();
        } else {
            v1 = v.get(v.size() - 1);
            if (v.size() == repeatCount) {
                v.remove(0);
            }
        }
        v.add(value);
        map.put(key, v);
        return v1;
        //напишите тут ваш код
    }

    @Override
    public V remove(Object key) {
        //напишите тут ваш код
        List<V> v = map.get(key);
        if (v == null) {
            return null;
        }

        V v1 = v.get(0);
        v.remove(0);

        if (v.size() == 0) {
            map.remove(key);
        }

        return v1;
    }

    @Override
    public Set<K> keySet() {
        //напишите тут ваш код
        return map.keySet();
    }

    @Override
    public Collection<V> values() {
        //напишите тут ваш код
        ArrayList<V> v = new ArrayList<>();
        for (List<V> vList : map.values()) {
            v.addAll(vList);
        }
        return v;
    }

    @Override
    public boolean containsKey(Object key) {
        //напишите тут ваш код
        return keySet().contains(key);
    }

    @Override
    public boolean containsValue(Object value) {
        //напишите тут ваш код
        return values().contains(value);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("{");
        for (Map.Entry<K, List<V>> entry : map.entrySet()) {
            sb.append(entry.getKey());
            sb.append("=");
            for (V v : entry.getValue()) {
                sb.append(v);
                sb.append(", ");
            }
        }
        String substring = sb.substring(0, sb.length() - 2);
        return substring + "}";
    }
}