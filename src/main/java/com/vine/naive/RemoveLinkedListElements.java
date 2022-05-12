package com.vine.naive;

import com.vine.alg.基本数据结构构造.ListNode;

/**
 * 移除链表指定元素
 *
 * @author hekai
 * @create 2017-10-20 下午3:42
 */

public class RemoveLinkedListElements {


    public ListNode removeElements(ListNode head, int val) {
        ListNode helper = new ListNode(0);
        helper.next = head;
        ListNode p = helper;

        while (p.next != null) {
            if (p.next.val == val) {
                p.next = p.next.next;
            } else {
                p = p.next;
            }
        }

        return helper.next;
    }


    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode helper = head;
        helper.next = new ListNode(2);
        helper = helper.next;
        helper.next = new ListNode(2);
        helper = helper.next;
        helper.next = new ListNode(3);
        helper = helper.next;
        helper.next = new ListNode(2);
        RemoveLinkedListElements removeLinkedListElements = new RemoveLinkedListElements();
        ListNode listNode = removeLinkedListElements.removeElements(head, 2);
        System.out.println(listNode);
    }
}


