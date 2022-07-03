package com.vine.alg.leet.leetcode;

import com.vine.alg.基本数据结构构造.ListNode;

import java.util.Arrays;

/**
 * @author 阿季
 * @date 2022-07-03 3:38 PM
 */

public class $160_相交链表 {

    /**
     * https://leetcode.cn/problems/intersection-of-two-linked-lists/
     */
    public static void main(String[] args) {
        $160_相交链表 x = new $160_相交链表();

        ListNode listNode1 = ListNode.createListNode(Arrays.asList(4, 1, 8, 4, 5));
        ListNode listNode = ListNode.createListNode(Arrays.asList(5, 6, 1, 8, 4, 5));
        ListNode intersectionNode = x.getIntersectionNode(listNode, listNode1);
        System.out.println(intersectionNode.toString());
    }


    ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        // p1 指向 A 链表头结点，p2 指向 B 链表头结点
        ListNode p1 = headA, p2 = headB;
        while (p1 != p2) {
            // p1 走一步，如果走到 A 链表末尾，转到 B 链表
            if (p1 == null) p1 = headB;
            else p1 = p1.next;
            // p2 走一步，如果走到 B 链表末尾，转到 A 链表
            if (p2 == null) p2 = headA;
            else p2 = p2.next;
        }
        return p1;
    }


}
