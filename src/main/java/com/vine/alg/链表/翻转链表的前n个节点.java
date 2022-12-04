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

    // 后驱节点，即：第n+1个节点
    ListNode successor = null;

    /**
     * 将链表的前 n 个节点反转（n <= 链表长度）
     */
    ListNode reverseN(ListNode head, int n) {

        if (n == 1) {
            successor = head.next;
            return head;
        }

        // 以head.next为起点，翻转前n-1个节点
        ListNode listNode = reverseN(head.next, n - 1);
        head.next.next = head;
        // 让反转之后的 head 节点和后面的节点连起来
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




    /**
     * 反转以head为头结点链表的前n个节点
     */
    ListNode reverseN11(ListNode head, int n) {
        if(n == 1) {
            successor = head.next;
            return head;
        }
        ListNode last = reverseN11(head.next, n - 1);
        head.next.next = head;
        head.next = successor;
        return last;


    }









}
