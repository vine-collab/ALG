package com.vine.alg.code.topcode;

import com.vine.alg.基本数据结构构造.ListNode;

import java.util.Arrays;

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
        ListNode listNode = ListNode.createListNode(Arrays.asList(1, 1, 2, 3, 5));
        ListNode listNode1 = s.deleteDuplicates(listNode);
        ListNode.printf(listNode1);
    }

    public ListNode deleteDuplicates(ListNode head) {

        if (head == null || head.next == null) {
            return head;
        }

        ListNode dummy = new ListNode(), cur = head, pre = dummy;
        dummy.next = head;
        while (cur != null) {
            // 发现重复
            if (cur.next != null && cur.val == cur.next.val) {
                // 去除重复
                while (cur.next != null && cur.val == cur.next.val) {
                    cur = cur.next;
                }
                cur = cur.next;
                if(cur == null) {
                    pre.next = null;
                }
            }
            // 没有发现重复
            else {
                pre.next = cur;
                cur = cur.next;
                pre = pre.next;
            }
        }

        return dummy.next;
    }


}


















