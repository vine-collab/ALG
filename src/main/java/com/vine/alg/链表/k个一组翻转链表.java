package com.vine.alg.链表;

import com.vine.alg.基本数据结构构造.ListNode;

import java.util.Arrays;

/**
 * @author 阿季
 * @date 2022-05-14 6:27 PM
 */

public class k个一组翻转链表 {

    public static void main(String[] args) {
        k个一组翻转链表 k = new k个一组翻转链表();
        k.reverseGroup(ListNode.createListNode(Arrays.asList(1, 3, 4, 5, 6, 7)), 3).printf();

    }

    ListNode reverseGroup(ListNode head, int k) {
        if (head == null) {
            return null;
        }
        ListNode a = head, b = head;
        for (int i = 0; i < k; i++) {
            if (b == null) {
                return head;
            }
            b = b.next;
        }
        ListNode reverse = reverse(a, b);
        a.next = reverseGroup(b, k);
        return reverse;

    }

    ListNode reverse(ListNode a, ListNode b) {
        ListNode pre = null, cur = a, temp;
        while (cur != b) {
            temp = cur.next;
            cur.next=pre;
            pre = cur;
            cur = temp;
        }

        return pre;
    }

}