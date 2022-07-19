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

    public ListNode reverseGroup(ListNode head, int k) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode a = head, b = head;
        for (int i = 0; i < k; i++) {
            // 不足k个了
            if (b == null) {
                return head;
            }
            b = b.next;
        }
        // 反转以[a, b) a.next 成为链表尾节点
        ListNode newHead = this.reverse(a, b);
        // 反转下k个，a.next 指向 k个的头节点
        a.next = this.reverseGroup(b, k);
        return newHead;


    }

    ListNode reverse(ListNode a, ListNode b) {
        ListNode pre = null, cur = a, temp;
        while (cur != b) {
            temp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = temp;
        }

        return pre;
    }


}