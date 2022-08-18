package com.vine.alg.code.topcode;

import com.vine.alg.基本数据结构构造.ListNode;

import java.util.Arrays;

public class $83_删除排序链表中的重复元素 {

    public static void main(String[] args) {
        $83_删除排序链表中的重复元素 s = new $83_删除排序链表中的重复元素();
        ListNode listNode = ListNode.createListNode(Arrays.asList(1, 1, 2, 3, 5, 5));
        ListNode listNode1 = s.deleteDuplicates(listNode);
        ListNode.printf(listNode1);
    }

    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode slow = head, fast = head;

        while (fast != null) {
            if (fast.val != slow.val) {
                slow.next = fast;
                slow = slow.next;
            }
            fast = fast.next;
        }
        slow.next = null;

        return head;
    }
}