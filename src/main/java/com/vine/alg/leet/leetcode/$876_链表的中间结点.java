package com.vine.alg.leet.leetcode;

import com.vine.alg.基本数据结构构造.ListNode;

import java.util.Arrays;

/**
 * @author 阿季
 * @date 2022-06-01 8:14 PM
 */

public class $876_链表的中间结点 {


    /**
     * https://leetcode.cn/problems/middle-of-the-linked-list/submissions/
     *
     * 给定一个头结点为 head 的非空单链表，返回链表的中间结点。
     *
     * 如果有两个中间结点，则返回第二个中间结点。
     */
    public static void main(String[] args) {
        $876_链表的中间结点 l = new $876_链表的中间结点();
        ListNode listNode = ListNode.createListNode(Arrays.asList(1, 3, 4, 5, 6, 7));
        ListNode listNode1 = l.middleNode(listNode);
        listNode1.printf();

    }


    public ListNode middleNode(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while(fast!= null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        return slow;
    }
}
