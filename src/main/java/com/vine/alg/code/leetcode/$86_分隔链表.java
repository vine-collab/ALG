package com.vine.alg.code.leetcode;

import com.vine.alg.基本数据结构构造.ListNode;

import java.util.Arrays;

/**
 * @author 阿季
 * @date 2022-06-30 9:23 PM
 */

public class $86_分隔链表 {


    /**
     * 给你一个链表的头节点 head 和一个特定值 x ，请你对链表进行分隔，使得所有 小于 x 的节点都出现在 大于或等于 x 的节点之前。
     * <p>
     * 你应当 保留 两个分区中每个节点的初始相对位置。
     * <p>
     * <p>
     * 示例 1：
     * <p>
     * 输入：head = [1,4,3,2,5,2], x = 3
     * 输出：[1,2,2,4,3,5]
     * 示例 2：
     * <p>
     * 输入：head = [2,1], x = 2
     * 输出：[1,2]
     * <p>
     * 链接：https://leetcode.cn/problems/partition-list
     */
    public static void main(String[] args) {
        $86_分隔链表 f = new $86_分隔链表();
        ListNode listNode = ListNode.createListNode(Arrays.asList(1, 4, 3, 2, 5, 2));
        ListNode partition = f.partition(listNode, 3);
        partition.printf();
    }

    public ListNode partition(ListNode head, int x) {
        ListNode dummy = new ListNode(), cur = dummy;
        ListNode dummy1 = new ListNode(), cur1 = dummy1;

        while (head != null) {
            if (head.val < x) {
                cur.next = new ListNode(head.val);
                head = head.next;
                cur = cur.next;
            } else {
                cur1.next = new ListNode(head.val);
                head = head.next;
                cur1 = cur1.next;
            }
        }

        cur.next = dummy1.next;
        return dummy.next;

    }

}














