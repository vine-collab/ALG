package com.vine.alg.code.leetcode;

import com.vine.alg.基本数据结构构造.ListNode;
import com.vine.alg.基本数据结构构造.Utils;

import java.util.HashMap;
import java.util.Map;

public class $1171_从链表中删去总和值为零的连续节点 {

    public static void main(String[] args) {
        $1171_从链表中删去总和值为零的连续节点 z = new $1171_从链表中删去总和值为零的连续节点();
        z.removeZeroSumSublists(Utils.splitToListNode("1,2,-3,3,1")).printf();
    }

    /**
     * https://leetcode.cn/problems/remove-zero-sum-consecutive-nodes-from-linked-list/
     */
    public ListNode removeZeroSumSublists(ListNode head) {
        ListNode p1 = head, dummy = new ListNode(), p2 = dummy;
        dummy.next = head;
        Map<Integer, ListNode> seen = new HashMap<>();
        int prefix = 0;
        while(p1 != null) {
            prefix += p1.val;
            seen.put(prefix, p1);
            p1 = p1.next;
        }
        prefix = 0;
        while (p2 != null) {
            prefix += p2.val;
            p2.next = seen.get(prefix).next;
            p2 = p2.next;
        }

        return dummy.next;




    }
}
