package com.vine.alg.code.leetcode;

import com.vine.alg.基本数据结构构造.ListNode;

/**
 * @author 阿季
 * @date 2022-07-30 2:49 PM
 */

public class $141_环形链表 {


    /**
     * https://leetcode.cn/problems/linked-list-cycle/
     */
    public static void main(String[] args) {
        $141_环形链表 h = new $141_环形链表();
    }

    public boolean hasCycle(ListNode head) {

        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                return true;
            }
        }
        return false;


    }


}































































