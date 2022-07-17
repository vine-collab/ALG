package com.vine.alg.LFU;

import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;

/**
 * @author 阿季
 * @date 2022-07-17 4:20 PM
 */

public class LFUCache {

    // key -> val 的映射
    Map<Integer, Integer> keyToVal;

    // key 到 freq 的映射，我们后文称为 KF 表
    Map<Integer, Integer> keyToFreq;

    // freq 到 key 列表的映射，我们后文称为 FK 表
    Map<Integer, LinkedHashSet<Integer>> freqToKeys;

    // 记录最小的频次
    int minFreq;

    // 记录 LFU 缓存的最大容量
    int cap;


    // 构造容量为 capacity 的缓存
    public LFUCache(int capacity) {
        keyToVal = new HashMap<>();
        keyToFreq = new HashMap<>();
        freqToKeys = new HashMap<>();
        this.cap = capacity;
        this.minFreq = 0;
    }


    // 在缓存中查询 key
    public int get(int key) {
        if (!keyToVal.containsKey(key)) {
            return -1;
        }
        this.increaseFreq(key);
        return keyToVal.get(key);
    }

    // 将 key 和 val 存入缓存
    public void put(int key, int val) {
        if (this.cap <= 0) {
            return;
        }

        if (keyToVal.containsKey(key)) {
            keyToVal.put(key, val);
            this.increaseFreq(key);
            return;
        }

        if (keyToVal.size() >= this.cap) {
            this.removeMinFreqKey(key);
        }
        // 插入kv表
        keyToVal.put(key, val);
        // 插入freq表
        keyToFreq.put(key, 1);
        // 插入fk表
        freqToKeys.putIfAbsent(1, new LinkedHashSet<>());
        freqToKeys.get(1).add(key);
        // 插入新 key 后最小的 freq 肯定是 1
        this.minFreq = 1;


    }

    private void removeMinFreqKey(int key) {
        // freq 最小的 key 列表
        LinkedHashSet<Integer> keyList = freqToKeys.get(this.minFreq);
        // 其中最先被插入的那个 key 就是该被淘汰的 key
        Integer deleteKey = keyList.iterator().next();
        /* 更新 FK 表 */
        keyList.remove(deleteKey);
        if (keyList.isEmpty()) {
            freqToKeys.remove(this.minFreq);
        }
        /* 更新 KV 表 */
        keyToVal.remove(deleteKey);
        /* 更新 KF 表 */
        keyToFreq.remove(deleteKey);
    }


    private void increaseFreq(int key) {

        Integer freq = keyToFreq.get(key);
        /* 更新 KF 表 */
        keyToFreq.put(key, freq + 1);
        /* 更新 FK 表 */
        // 将 key 从 freq 对应的列表中删除
        freqToKeys.get(freq).remove(key);
        // 将 key 加入 freq + 1 对应的列表中
        freqToKeys.putIfAbsent(freq + 1, new LinkedHashSet<>());
        freqToKeys.get(freq + 1).add(key);
        // 如果 freq 对应的列表空了，移除这个 freq
        if (freqToKeys.get(freq).isEmpty()) {
            freqToKeys.remove(freq);
            // 如果这个 freq 恰好是 minFreq，更新 minFreq
            if (freq == this.minFreq) {
                this.minFreq++;
            }
        }


    }


}































































