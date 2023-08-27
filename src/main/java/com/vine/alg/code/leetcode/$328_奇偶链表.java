package com.vine.alg.code.leetcode;

import com.vine.alg.基本数据结构构造.ListNode;

/**
 * @author 阿季
 * @date 2023-08-26 20:53
 */

public class $328_奇偶链表 {


    /**
     * https://leetcode.cn/problems/odd-even-linked-list/description/
     *
     * 给定单链表的头节点 head ，将所有索引为奇数的节点和索引为偶数的节点分别组合在一起，然后返回重新排序的列表。
     *
     * 第一个节点的索引被认为是 奇数 ， 第二个节点的索引为 偶数 ，以此类推。
     *
     * 请注意，偶数组和奇数组内部的相对顺序应该与输入时保持一致。
     *
     * 你必须在 O(1) 的额外空间复杂度和 O(n) 的时间复杂度下解决这个问题。
     * 输入: head = [1,2,3,4,5]
     * 输出: [1,3,5,2,4]
     */
    public static void main(String[] args) {
        $328_奇偶链表 z = new $328_奇偶链表();
    }



    public ListNode oddEvenList(ListNode head) {

        if(head == null) {
            return head;
        }

        ListNode dummy1 = new ListNode(), p1 = dummy1;
        ListNode dummy2 = new ListNode(), p2 = dummy2;

        ListNode cur = head;
        int i = 1;
        while (cur != null) {
            if(i % 2 != 0) {
                p1.next = cur;
                cur = cur.next;
                p1 = p1.next;
                p1.next = null;
            } else {
                p2.next = cur;
                cur = cur.next;
                p2 = p2.next;
                p2.next = null;
            }

            i++;
        }

        p1.next = dummy2.next;
        return dummy1.next;



    }
}































































