package com.vine.naive.leetcode;

import java.util.List;

/**
 * @author 阿季
 * @date 2022-05-08 8:03 PM
 */

public class $82_删除排序链表中的重复元素II {
    /*
    https://leetcode-cn.com/problems/remove-duplicates-from-sorted-list-ii/
    82. 删除排序链表中的重复元素 II
    给定一个已排序的链表的头 head ， 删除原始链表中所有重复数字的节点，只留下不同的数字 。返回 已排序的链表 。
    示例 1：
    输入：head = [1,2,3,3,4,4,5]
    输出：[1,2,5]

    示例 2：
    输入：head = [1,1,1,2,3]
    输出：[2,3]

     */
    public static void main(String[] args) {
        $82_删除排序链表中的重复元素II s = new $82_删除排序链表中的重复元素II();
        ListNode listNode1 = new ListNode(5, new ListNode(1, new ListNode(1, new ListNode(2, new ListNode(3)))));


        ListNode listNode = s.deleteDuplicates(listNode1);

    }

    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return null;
        }

        ListNode res = new ListNode();

        ListNode temp = head;

        while (head.next != null) {
            int v = head.val;

            while (v == head.next.val) {
                head = head.next.next;
            }
            temp = head;
            res.next = head;
            res = res.next;
            head = head.next;
        }

        return res;


    }
}
