package com.vine.alg.链表;

import com.vine.alg.基本数据结构构造.ListNode;

import java.util.Arrays;

/**
 * @author 阿季
 * @date 2022-05-14 4:00 PM
 */

public class 反转链表 {
    public static void main(String[] args) {
        反转链表 f = new 反转链表();

        ListNode listNode = ListNode.createListNode(Arrays.asList(1, 2, 3));
        listNode.printf();
        ListNode reverse = f.reverse(listNode);
        reverse.printf();
    }


    ListNode reverse(ListNode head) {
        ListNode pre = null, cur = head;
        while (cur != null) {
            ListNode temp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = temp;
        }


        return pre;
    }


}
