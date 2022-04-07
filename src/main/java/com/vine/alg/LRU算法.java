package com.vine.alg;

import lombok.Data;

import java.util.HashMap;
import java.util.Map;

/**
 * Least Recently Used
 *
 * @author 阿季
 * @date 2022-04-02 8:55 PM
 */

public class LRU算法 {


}

class LRUCache {
    private Map<Integer, Node> map;

    private DoubleList cache;

    private int capacity;

    private LRUCache(int capacity) {
        map = new HashMap<>();
        cache = new DoubleList();
        this.capacity = capacity;
    }

    /*放入一个数据*/
    public void put(int key, int val) {
        // 如果数据存在
        if (map.containsKey(key)) {
            this.delete(key);
            this.addRecentLy(key, val);
            return;
        }
        if (capacity == cache.getSize()) {
            // 删除最久未使用的
            this.removeLeastRecently();
        }
        this.addRecentLy(key, val);


    }

    /* 获取某一个值 */
    public int get(int key) {
        if (!map.containsKey(key)) {
            return -1;
        }
        this.makeRecently(key);
        return map.get(key).val;
    }


    /*
        添加最近使用的元素
     */
    private void addRecentLy(Integer key, int val) {
        Node node = new Node(key, val);
        cache.addLast(node);
        map.put(key, node);
    }

    /*
       提升某个key成为最近使用的元素
    */
    private void makeRecently(Integer key) {
        Node node = map.get(key);
        if (node == null) {
            return;
        }
        cache.remove(node);
        cache.addLast(node);
    }


    /*
      删除某个key
    */
    private void delete(Integer key) {
        Node node = map.get(key);
        if (node == null) {
            return;
        }
        cache.remove(node);
        map.remove(key);

    }

    /* 删除最久未使用 */
    private void removeLeastRecently() {
        // 头插法第一个就是最久未使用
        Node node = cache.removeFirst();
        // 同时从map中删除
        map.remove(node.key);
    }


}


class Node {
    public int key, val;
    public Node next, prev;

    public Node(int k, int v) {
        this.key = k;
        this.val = v;
    }
}

class DoubleList {
    private Node head, tail;
    private int size;

    public DoubleList() {
        head = new Node(0, 0);
        tail = new Node(0, 0);
        head.next = tail;
        tail.prev = head;
        size = 0;
    }

    /* 尾插法 h ->
               <- tail
        插入x
        时间复杂度o(1)
     */
    public void addLast(Node x) {
        x.prev = tail.prev;
        x.next = tail;
        tail.prev = x;
        tail.prev.next = x;
        size++;
    }

    /*
        删除链表的x节点 （x 一定存在）

     */
    public void remove(Node x) {
        x.prev.next = x.next;
        x.next.prev = x.prev;
        size--;
    }

    /**
     * 删除头结点，并返回，头结点是最近最久未用到
     */
    public Node removeFirst() {

        if (head.next == null) {
            return null;
        }
        Node first = head.next;
        remove(first);
        return first;
    }

    public int getSize() {
        return size;
    }


}





















