package com.vine.alg.LRU;

import com.vine.alg.基本数据结构构造.Node;

import java.util.HashMap;

/**
 * @author 阿季
 * @date 2022-07-17 3:25 PM
 */

public class LRUCache {


    //key -> Node(key, val)
    private HashMap<Integer, Node> map;
    // Node(k1, v1) <-> Node(k2, v2)...
    private DoubleList cache;
    // 最大容量
    private int capacity;

    public LRUCache(int capacity) {
        map = new HashMap<>();
        cache = new DoubleList();
        this.capacity = capacity;
    }


    /* 将某个 key 提升为最近使用的 */
    private void makeRecently(int key) {
        Node node = map.get(key);
        // 删除
        cache.remove(node);
        // 插入到队尾
        cache.addLast(node);
    }


    /* 添加最近使用的元素 */
    private void addRecently(int key, int val) {
        Node x = new Node(key, val);
        // 插入队尾
        cache.addLast(x);
        // 添加映射
        map.put(key, x);
    }


    /* 删除某一个 key */
    private void deleteKey(int key) {
        Node node = map.get(key);
        // 链表移除
        cache.remove(node);
        // 从map中删除
        map.remove(key);

    }

    /* 删除最久未使用的元素 */
    private void removeLeastRecently() {
        // 链表头部的第一个元素就是最久未使用的
        Node node = cache.removeFirst();
        // 同时别忘了从 map 中删除它的 key
        int key = node.key;
        map.remove(key);

    }


    public int get(int key) {
        if(!map.containsKey(key)) {
            return -1;
        }

        // 提升为最近使用的
        this.makeRecently(key);
        return map.get(key).val;

    }


    public void put(int key, int value) {
        if(map.containsKey(key)) {
            // 删除旧数据
            this.deleteKey(key);
            // 插入新数据
            this.addRecently(key, value);
            return;
        }

        // 数据满了
        if(capacity == cache.size()) {
            removeLeastRecently();
        }

        // 添加元素
        this.addRecently(key, value);


    }

}































































