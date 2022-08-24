package com.vine.alg.code.leetcode;

import com.vine.alg.基本数据结构构造.ListNode;
import com.vine.alg.基本数据结构构造.Utils;

/**
 * @author 阿季
 * @date 2022-08-20 11:40 AM
 */

public class $24_两两交换链表中的节点 {


    /**
     * 给你一个链表，两两交换其中相邻的节点，并返回交换后链表的头节点。
     * 你必须在不修改节点内部的值的情况下完成本题（即，只能进行节点交换）。
     * <p>
     * <p>
     * 示例 1：
     * <p>
     * <p>
     * 输入：head = [1,2,3,4]
     * 输出：[2,1,4,3]
     * <p>
     * 链接：https://leetcode.cn/problems/swap-nodes-in-pairs
     */
    public static void main(String[] args) {
        $24_两两交换链表中的节点 l = new $24_两两交换链表中的节点();

        l.swapPairs(ListNode.createListNode(Utils.splitToIntArr1("1"))).printf();
    }


    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode a = head, b = head;
        for (int i = 0; i < 2; i++) {
            b = b.next;
        }

        ListNode node = this.reverse(a, b);
        ListNode listNode = swapPairs(b);

        a.next = listNode;
        return node;
    }


    /**
     * 反转[a, b) 之间元素
     */
    ListNode reverse(ListNode a, ListNode b) {
        ListNode cur = a, pre = null, temp;
        while (cur != b) {
            temp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = temp;
        }

        return pre;

    }

}































































