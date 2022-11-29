package com.vine.alg.code.leetcode;

import com.vine.alg.基本数据结构构造.ListNode;
import com.vine.alg.基本数据结构构造.Utils;

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
        ListNode listNode = Utils.splitToListNode("1,");
        f.reverseList1(listNode).printf();
    }


    /**
     * 反转以head为头结点的链表，并返回新的头节点
     */
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode last = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return last;
    }


    public ListNode reverseList1(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode pre = null, cur = head, next = head.next;
        while (cur != null) {
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }

        return pre;

    }


}


