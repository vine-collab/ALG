package com.vine.alg.基本数据结构构造;

public class Node {
    public int key;
    public int val;
    public Node left;
    public Node right;
    public Node next;
    public Node pre;

    public Node() {
    }

    public Node(int key, int val) {
        this.key = key;
        this.val = val;
    }

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }


    public Node(int key, int val, Node left, Node right, Node next, Node pre) {
        this.key = key;
        this.val = val;
        this.left = left;
        this.right = right;
        this.next = next;
        this.pre = pre;
    }
}