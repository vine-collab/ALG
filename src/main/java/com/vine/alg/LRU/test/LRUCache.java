package com.vine.alg.LRU.test;

import java.util.HashMap;
import java.util.Map;

class LRUCache {

    int capacity;
    DoubleNodeList cache;
    Map<Integer, Node> map;


    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.cache = new DoubleNodeList();
        this.map = new HashMap<>();
    }
    
    public int get(int key) {
        Node node = map.get(key);
        if(node == null) {
            return -1;
        } 
        makeRecently(key);
        return node.val;

    }
    
    public void put(int key, int value) {
        // key存在
        if(map.containsKey(key)) {
            Node x = map.get(key);
            cache.remove(x);
            Node node =  new Node(key, value);
            cache.addLast(node);
            map.put(key, node);
        } 
        // 不存在
        else {
            // 存储满了
            if(cache.size() == capacity) {
                Node x = cache.removeFirst();
                map.remove(x.key);
                Node node =  new Node(key, value);
                cache.addLast(node);
                map.put(key, node);
            }
            // 存储没有满
            else {
                Node node =  new Node(key, value);
                cache.addLast(node);
                map.put(key, node);
            }
        }



        
    }


    void makeRecently(int key) {
        Node node = map.get(key);
        if(node == null) {
            return;
        }

        cache.remove(node);
        cache.addLast(node);
    }



    class DoubleNodeList{
        int size;
        Node head, tail;
        DoubleNodeList() {
            this.head = new Node(-1, -1);
            this.tail = new Node(100, 100);
            size = 0;
            head.next = tail;
            tail.pre = head;
        }

        void addLast(Node x) {
            tail.pre.next = x;
            x.pre = tail.pre;
            x.next = tail;
            tail.pre = x;
            size++;
        }

        void remove(Node x) {
            x.pre.next = x.next;
            x.next.pre = x.pre;
            size--;
        }

        Node removeFirst() {
            if(head.next == tail) {
                return null;
            }
            Node first = head.next;
            remove(head.next);
            return first;
        }


        public int size() {
            return size;
        }

    }


    class Node{
        Node pre, next;
        int val;
        int key;
        Node(int key, int val) {
            this.val = val;
            this.key = key;
        }


    }

    public static void main(String[] args) {
        LRUCache lRUCache = new LRUCache(2);
        lRUCache.put(1, 1); // 缓存是 {1=1}
        lRUCache.put(2, 2); // 缓存是 {1=1, 2=2}
        lRUCache.get(1);    // 返回 1
        lRUCache.put(3, 3); // 该操作会使得关键字 2 作废，缓存是 {1=1, 3=3}
        lRUCache.get(2);    // 返回 -1 (未找到)
        lRUCache.put(4, 4); // 该操作会使得关键字 1 作废，缓存是 {4=4, 3=3}
        lRUCache.get(1);    // 返回 -1 (未找到)
        lRUCache.get(3);    // 返回 3
        lRUCache.get(4);    // 返回 4

    }

}