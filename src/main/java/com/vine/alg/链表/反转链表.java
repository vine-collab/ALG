package com.vine.alg.链表;

import com.vine.alg.基本数据结构构造.ListNode;

import java.util.Arrays;
import java.util.List;

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

        ListNode listNode1 = f.reverseRecursive(ListNode.createListNode(Arrays.asList(1, 2, 3, 4, 5)));
        listNode1.printf();
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


    ListNode reverseBetween(ListNode head, int n, int m) {

        if (head == null || head.next == null) {
            return null;
        }

        ListNode pre = null, cur = head;
        int i = 1, j = 1;

        while (cur != null) {
            if (i != n) {
                i++;
                pre = cur;
                cur = cur.next;
                continue;
            }
            ListNode temp = cur.next;
            cur.next = pre;
            cur = temp;
            j ++;

        }


        return null;

    }

    ListNode reverseRecursive(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode last = reverseRecursive(head.next);
        //翻转当前节点指针
        head.next.next = head;
        //  切断指针
        head.next = null;

        return last;
    }



}



















