package com.vine.alg.LRU;

import com.vine.alg.基本数据结构构造.Node;

/**
 * @author 阿季
 * @date 2022-07-17 3:16 PM
 */

public class DoubleList {

    // 头尾节点
    private Node head, tail;

    // 链表元素个数
    private int size;


    public DoubleList() {
        head = new Node(0, 0);
        tail = new Node(0, 0);
        head.next = tail;
        tail.pre = head;
        size = 0;
    }


    // 在链表尾部添加节点 x，时间 O(1)
    public void addLast(Node x) {
        x.pre = tail.pre;
        tail.pre = x;
        x.pre.next = x;
        x.next = tail;
        size++;

    }

    // 删除链表中的 x 节点（x 一定存在）
    // 由于是双链表且给的是目标 Node 节点，时间 O(1)
    public void remove(Node x) {

        x.pre.next = x.next;
        x.next.pre = x.pre;
        size--;

    }

    // 删除链表中第一个节点，并返回该节点，时间 O(1)
    public Node removeFirst() {
        if (head.next == tail) {
            return null;
        }
        Node first = head.next;
        this.remove(first);
        return first;
    }

    // 返回链表长度，时间 O(1)

    public int size() {
        return size;
    }


}






























































