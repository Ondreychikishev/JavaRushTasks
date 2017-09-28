package com.javarush.task.task37.task3708.retrievers;

import com.javarush.task.task37.task3708.cache.LRUCache;
import com.javarush.task.task37.task3708.storage.Storage;


public class CachingProxyRetriever implements Retriever{
    OriginalRetriever originalRetriever;
    LRUCache<Long, Object> lruCache;

    public CachingProxyRetriever(Storage storage) {
        this.originalRetriever = new OriginalRetriever(storage);
        this.lruCache = new LRUCache<>(14);
    }

    @Override
    public Object retrieve(long id) {
        Object object = lruCache.find(id);
        if (object == null) {
            object = originalRetriever.retrieve(id);
            lruCache.set(id, object);
        }
        return object;
    }
}
