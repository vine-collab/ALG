package com.vine.alg.code.leetcode;

import com.vine.alg.基本数据结构构造.ListNode;

import java.util.Arrays;

/**
 * @author 阿季
 * @date 2022-06-03 4:25 PM
 */

public class $21_合并两个有序链表 {


    /**
     * 21. 合并两个有序链表
     *
     * https://leetcode.cn/problems/merge-two-sorted-lists/

     */

    public static void main(String[] args) {
        $21_合并两个有序链表 h = new $21_合并两个有序链表();
        ListNode listNode = ListNode.createListNode(Arrays.asList(1, 2, 4));
        ListNode listNode1 = ListNode.createListNode(Arrays.asList(1, 3, 4));
        ListNode listNode2 = h.mergeTwoLists(listNode, listNode1);
        listNode2.printf();
    }

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode();
        ListNode cur = dummy;
        ListNode h1 = list1;
        ListNode h2 = list2;

        while (h1 != null && h2 != null) {
            if (h2.val >= h1.val) {
                cur.next = new ListNode(h1.val);
                h1 = h1.next;
            } else {
                cur.next = new ListNode(h2.val);
                h2 = h2.next;
            }
            cur = cur.next;
        }
        if (h1 == null) {
            cur.next = h2;
        } else {
            cur.next = h1;
        }
        return dummy.next;
    }
}