package com.vine.alg.LRU;

import java.util.LinkedHashMap;
import java.util.LinkedList;

/**
 * @author 阿季
 * @date 2022-07-17 3:59 PM
 */

public class LRU {

    private int cap;

    private LinkedHashMap<Integer, Integer> cache = new LinkedHashMap<>();

    public LRU(int capacity) {
        this.cap = capacity;
    }


    public int get(int key) {
        if (!cache.containsKey(key)) {
            return -1;
        }

        this.makeRecently(key);
        return cache.get(key);
    }


    public void put(int key, int value) {
        if (cache.containsKey(key)) {
            cache.put(key, value);
            makeRecently(key);
            return;
        }

        if (cache.size() >= this.cap) {
            Integer oldestKey = cache.keySet().iterator().next();
            cache.remove(key);
        }

        cache.put(key, value);


    }


    private void makeRecently(int key) {
        Integer val = cache.get(key);
        cache.remove(key);
        cache.put(key, val);
    }


}































































