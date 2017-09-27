package com.javarush.task.task35.task3505;

import java.security.Key;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ConvertableUtil {

    public static Map convert(List<? extends Convertable> list) {
        Map <Object, Convertable<?>> result = new HashMap();
        for (Convertable<?> v : list) {
            result.put(v.getKey(), v);
        }
        return result;
    }
}
