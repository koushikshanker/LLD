package org.example.Problems.KLRUCache.cache.factories;

import org.example.Problems.KLRUCache.cache.Cache;
import org.example.Problems.KLRUCache.cache.policies.LRUEvictionPolicy;
import org.example.Problems.KLRUCache.cache.storage.HashMapBasedStorage;

public class CacheFactory<Key, Value> {

    public Cache<Key, Value> defaultCache(final int capacity) {
        return new Cache<Key, Value>(new LRUEvictionPolicy<Key>(),
                new HashMapBasedStorage<Key, Value>(capacity));
    }
}
