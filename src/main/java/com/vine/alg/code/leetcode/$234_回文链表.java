package com.vine.alg.code.leetcode;

import com.vine.alg.基本数据结构构造.ListNode;

import java.util.Arrays;

/**
 * @author 阿季
 * @date 2022-08-13 9:14 PM
 */

public class $234_回文链表 {

    public static void main(String[] args) {
        $234_回文链表 h = new $234_回文链表();
        boolean palindrome = h.isPalindrome(ListNode.createListNode(Arrays.asList(1, 2, 3, 2, 1)));
        System.out.println(palindrome);
    }

    public boolean isPalindrome(ListNode head) {

        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        if (fast != null) { // 链表为偶数个 则往后再移一个节点
            slow = slow.next;
        }

        ListNode right = this.reverse1(slow);

        ListNode left = head;

        while (right != null) {
            if (left.val != right.val) {
                return false;
            }
            right = right.next;
            left = left.next;
        }
        return true;


    }


    ListNode reverse(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode node = reverse(head.next);
        head.next.next = head;
        head.next = null;
        return node;


    }

    ListNode reverse1(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode cur = head, pre = null, temp;
        while (cur != null) {
            temp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = temp;

        }
        return pre;


    }


}































































