package com.vine.alg.code.leetcode;

import com.vine.alg.基本数据结构构造.ListNode;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author 阿季
 * @date 2022-06-30 9:40 PM
 */

public class $23_合并K个升序链表 {


    /**
     * 给你一个链表数组，每个链表都已经按升序排列。
     * <p>
     * 请你将所有链表合并到一个升序链表中，返回合并后的链表。
     * 示例 1：
     * <p>
     * 输入：lists = [[1,4,5],[1,3,4],[2,6]]
     * 输出：[1,1,2,3,4,4,5,6]
     * 解释：链表数组如下：
     * [
     * 1->4->5,
     * 1->3->4,
     * 2->6
     * ]
     * 将它们合并到一个有序链表中得到。
     * 1->1->2->3->4->4->5->6
     * 示例 2：
     * <p>
     * 输入：lists = []
     * 输出：[]
     * <p>
     * 链接：https://leetcode.cn/problems/merge-k-sorted-lists
     */
    public static void main(String[] args) {
        $23_合并K个升序链表 h = new $23_合并K个升序链表();
        ListNode listNode = ListNode.createListNode(Arrays.asList(1, 4, 5));
        ListNode listNode1 = ListNode.createListNode(Arrays.asList(1, 3, 4));
        ListNode listNode2 = ListNode.createListNode(Arrays.asList(2, 6));
        ListNode[] listNodes = {listNode, listNode1, listNode2};
        ListNode listNode3 = h.mergeKLists(listNodes);
        listNode3.printf();

    }

    public ListNode mergeKLists(ListNode[] lists) {
        ListNode dummy = new ListNode(), cur = dummy;

        PriorityQueue<ListNode> q = new PriorityQueue<>(Comparator.comparingInt(a -> a.val));

        for (ListNode head : lists) {
            if (head != null) {
                q.add(head);
            }
        }

        while (!q.isEmpty()) {

            ListNode poll = q.poll();
            cur.next = poll;

            if (poll.next != null) {
                q.add(poll.next);
            }
            cur = cur.next;

        }
        return dummy.next;

    }

}






