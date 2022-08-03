package com.vine.alg.code.leetcode;

import com.vine.alg.基本数据结构构造.ListNode;

/**
 * @author 阿季
 * @date 2022-08-03 9:59 PM
 */

public class 剑指Offer22_链表中倒数第k个节点 {


    /**
     * https://leetcode.cn/problems/lian-biao-zhong-dao-shu-di-kge-jie-dian-lcof/
     */
    public static void main(String[] args) {

    }

    public ListNode getKthFromEnd(ListNode head, int k) {
        ListNode fast = head, slow = head;
        for (int i = 0; i < k; i++) {
            fast = fast.next;
        }
        while (fast != null) {
            slow = slow.next;
            fast = fast.next;
        }

        return slow;


    }

}































































