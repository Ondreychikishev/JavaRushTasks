package com.javarush.task.task35.task3512;


public class Generator<T> {
    private Class<T> tClass;

    public Generator(Class<T> t) {
        this.tClass = t;
    }

    T newInstance() throws IllegalAccessException, InstantiationException {
        return (T) tClass.newInstance();
    }
}
