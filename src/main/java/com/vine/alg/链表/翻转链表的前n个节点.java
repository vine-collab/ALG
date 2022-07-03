package com.vine.alg.链表;

import com.vine.alg.基本数据结构构造.ListNode;

import java.util.Arrays;

/**
 * @author 阿季
 * @date 2022-05-14 5:40 PM
 */

public class 翻转链表的前n个节点 {
    public static void main(String[] args) {
        翻转链表的前n个节点 f = new 翻转链表的前n个节点();
        ListNode.createListNode(Arrays.asList(1, 3, 4, 5, 6, 7)).printf();
        f.reverseN(ListNode.createListNode(Arrays.asList(1, 3, 4, 5, 6, 7)), 3).printf();
    }

    ListNode successor = null;

    ListNode reverseN(ListNode head, int n) {

        if (n == 1) {
            successor = head.next;
            return head;
        }

        // 以head.next为起点，翻转前n-1个节点
        ListNode listNode = reverseN(head.next, n - 1);
        head.next.next = head;
        head.next = successor;
        return listNode;

    }


    ListNode reverseN1(ListNode head, int n) {


        if (n == 1) {
            successor = head.next;
            return head;
        }
        ListNode listNode = reverseN1(head, n - 1);
        head.next.next = head;

        head.next = successor;
        return listNode;

    }


}
