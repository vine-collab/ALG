package com.vine.alg.基本数据结构构造;

import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.List;

public class ListNode {
    public int val;
    public ListNode next;

    public ListNode() {

    }

    public ListNode(int x) {
        val = x;
    }

    public ListNode(int x, ListNode next) {
        this.val = x;
        this.next = next;
    }

    public static ListNode createListNode(int[] array) {
        ListNode head = null;
        for (int i = array.length - 1; i >= 0; i--) {
            head = new ListNode(array[i], head);
        }
        return head;
    }

    public static ListNode createListNode(List<Integer> array) {
        ListNode head = null;
        for (int i = array.size() - 1; i >= 0; i--) {
            head = new ListNode(array.get(i), head);
        }
        return head;
    }

    public void printf() {
        List<Integer> arr = new ArrayList<>();
        ListNode temp = this;
        while (temp != null) {
            arr.add(temp.val);
            temp = temp.next;
        }
        System.out.println(JSON.toJSONString(arr));

    }

}
