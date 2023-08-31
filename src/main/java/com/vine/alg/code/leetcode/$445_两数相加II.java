package com.vine.alg.code.leetcode;

import com.vine.alg.基本数据结构构造.ListNode;
import com.vine.alg.基本数据结构构造.Utils;
import sun.nio.ch.Util;

import java.util.Stack;

public class $445_两数相加II {

    /**
     * 链表相加
     * https://leetcode.cn/problems/add-two-numbers-ii/description/
     */
    public static void main(String[] args) {
        $445_两数相加II z = new $445_两数相加II();
        ListNode listNode = z.addTwoNumbers(Utils.splitToListNode("5,6,4"), Utils.splitToListNode("7,2,4,3"));
        listNode.printf();
    }


    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode p1 = l1, p2 = l2, dummy = new ListNode(), p = dummy;
        Stack<Integer> stk1 = new Stack<>();
        while(p1 != null) {
            stk1.push(p1.val);
            p1 = p1.next;
        }

        Stack<Integer> stk2 = new Stack<>();
        while(p2 != null) {
            stk2.push(p2.val);
            p2 = p2.next;
        }


        int reminder = 0;
        while (!stk1.isEmpty() || !stk2.isEmpty() || reminder != 0) {
            int x = stk1.isEmpty() ? 0 : stk1.pop();
            int y = stk2.isEmpty() ? 0 : stk2.pop();
            int sum = x + y + reminder;
            ListNode cur = new ListNode(sum % 10);
            reminder = sum / 10;
            cur.next = p.next;
            p.next = cur;
        }
        return dummy.next;

    }
}
