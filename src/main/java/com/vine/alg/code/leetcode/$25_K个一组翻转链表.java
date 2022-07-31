package com.vine.alg.code.leetcode;

import com.vine.alg.基本数据结构构造.ListNode;

import java.util.Arrays;

/**
 * @author 阿季
 * @date 2022-07-03 5:24 PM
 */

public class $25_K个一组翻转链表 {


    /**
     * 给你链表的头节点 head ，每k个节点一组进行翻转，请你返回修改后的链表。
     * <p>
     * k 是一个正整数，它的值小于或等于链表的长度。如果节点总数不是k的整数倍，那么请将最后剩余的节点保持原有顺序。
     * <p>
     * 你不能只是单纯的改变节点内部的值，而是需要实际进行节点交换。
     * <p>
     * 示例 1：
     * <p>
     * <p>
     * 输入：head = [1,2,3,4,5], k = 2
     * 输出：[2,1,4,3,5]
     * 示例 2：
     * <p>
     * <p>
     * <p>
     * 输入：head = [1,2,3,4,5], k = 3
     * 输出：[3,2,1,4,5]
     * <p>
     * <p>
     * 提示：
     * <p>
     * 链接：https://leetcode.cn/problems/reverse-nodes-in-k-group
     */
    public static void main(String[] args) {
        $25_K个一组翻转链表 k = new $25_K个一组翻转链表();
        ListNode listNode = ListNode.createListNode(Arrays.asList(1, 3, 4, 5, 6, 7, 8));
        k.reverseKGroup(listNode, 2).printf();
    }

    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode a = head, b = head;
        for (int i = 0; i < k; i++) {
            // 以head开头的链表长度 不足 k 个，不需要反转，base case
            if (b == null) {
                return head;
            }
            b = b.next;
        }
        // reverse 为当前组的头结点
        ListNode reverse = reverse(a, b);
        //a：为当前组的最后一个节点， 递归反转，拼接链表
        a.next = reverseKGroup(b, k);
        return reverse;

    }

    /**
     * 反转 [a, b) 之间的元素， 左闭右开
     */
    ListNode reverse(ListNode a, ListNode b) {
        ListNode pre = null, cur = a, temp;
        while (cur != b) {
            temp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = temp;
        }
        // 返回头结点
        return pre;
    }

}





























