package com.vine.alg.code.leetcode;

import com.vine.alg.基本数据结构构造.ListNode;

import java.util.Arrays;

/**
 * @author 阿季
 * @date 2022-07-30 2:52 PM
 */

public class $92_反转链表II {


    public static void main(String[] args) {
        $92_反转链表II f = new $92_反转链表II();
        ListNode listNode = ListNode.createListNode(Arrays.asList(5));
        f.reverseBetween2(listNode, 1, 1).printf();

    }


    public ListNode reverseBetween(ListNode head, int left, int right) {
        // 设置 dummyNode 是这一类问题的一般做法
        ListNode dummyNode = new ListNode(-1);
        dummyNode.next = head;
        ListNode pre = dummyNode;
        for (int i = 0; i < left - 1; i++) {
            pre = pre.next;
        }
        ListNode cur = pre.next;
        ListNode temp;
        for (int i = 0; i < right - left; i++) {
            temp = cur.next;
            cur.next = temp.next;
            temp.next = pre.next;
            pre.next = temp;
        }
        return dummyNode.next;
    }


    /**
     * 反转[a, b) 链表
     */
    ListNode reverse(ListNode a, ListNode b) {
        ListNode cur = a, pre = null, temp;
        while (cur != b) {
            temp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = temp;
        }
        return pre;


    }

    ListNode successor = null; // 后驱节点


    public ListNode reverseBetween2(ListNode head, int left, int right) {
        if(left == 1) {
            return reverse(head, right);
        }

        head.next = reverseBetween2(head.next, left - 1, right -1);
        return head;

    }

    /**
     * 反转以a起点的n个节点，返回新的头结点
     *
     * @param head
     * @param n
     * @return
     */
    ListNode reverse(ListNode head, int n) {
        if (n == 1) {
            // 后驱节点
            successor = head.next;
            return head; // 反转后的头结点
        }

        // 以a.next 为起点的，反转前n - 1 个节点
        ListNode last = reverse(head.next, n - 1);
        head.next.next = head;
        head.next = successor;
        return last;

    }
}































































