package com.vine.alg.leet.leetcode;

import com.vine.alg.基本数据结构构造.ListNode;

import java.util.PriorityQueue;

/**
 * @author 阿季
 * @date 2022-07-30 5:32 PM
 */

public class $148_排序链表 {


    /**
     * https://leetcode.cn/problems/sort-list/
     */
    public static void main(String[] args) {
        $148_排序链表 p = new $148_排序链表();
    }

    public ListNode sortList(ListNode head) {

        PriorityQueue<Integer> q = new PriorityQueue<>();
        while (head != null) {
            q.offer(head.val);
            head = head.next;
        }

        ListNode dummy = new ListNode(), cur = dummy;
        while (!q.isEmpty()) {
            cur.next = new ListNode(q.poll());
            cur = cur.next;
        }
        return dummy.next;


    }


}































































