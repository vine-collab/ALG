package com.vine.alg.链表;

import com.vine.alg.基本数据结构构造.ListNode;

import java.util.Arrays;

/**
 * @author 阿季
 * @date 2022-05-14 6:03 PM
 */

public class 翻转链表部分 {
    public static void main(String[] args) {
        翻转链表部分 f = new 翻转链表部分();
        ListNode.createListNode(Arrays.asList(1, 3, 4, 5, 6, 7)).printf();
        f.reverseBetween(ListNode.createListNode(Arrays.asList(1, 3, 4, 5, 6, 7)), 3, 5).printf();
    }

    ListNode reverseBetween(ListNode head, int m, int n) {

        if (m == 1) {
            return reverseN(head, n);
        }

        head.next = reverseBetween(head.next, m - 1, n - 1);
        return head;

    }

    ListNode successor = null;

    ListNode reverseN(ListNode head, int n) {

        if(n == 1) {
            successor = head.next;
            return head;
        }

        // 以head.next为起点，翻转前n-1个节点
        ListNode listNode = reverseN(head.next, n - 1);
        head.next.next = head;
        head.next = successor;
        return listNode;

    }


}
