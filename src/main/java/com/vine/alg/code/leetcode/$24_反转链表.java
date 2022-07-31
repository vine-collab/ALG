package com.vine.alg.code.leetcode;

import com.vine.alg.基本数据结构构造.ListNode;

/**
 * @author 阿季
 * @date 2022-07-03 5:15 PM
 */

public class $24_反转链表 {

    /**
     * https://leetcode.cn/problems/fan-zhuan-lian-biao-lcof/
     */
    public static void main(String[] args) {
        $24_反转链表 f = new $24_反转链表();
    }

    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode node = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return node;


    }
}


