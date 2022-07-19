package com.vine.alg.leet.leetcode;

import com.vine.alg.基本数据结构构造.ListNode;

import java.util.Arrays;
import java.util.Stack;

/**
 * @author 阿季
 * @date 2022-06-03 4:39 PM
 */

public class $206_反转链表 {
    public static void main(String[] args) {
        $206_反转链表 f = new $206_反转链表();
        ListNode listNode = ListNode.createListNode(Arrays.asList(1, 2, 3, 4, 5));
        ListNode listNode1 = f.reverseList1(listNode);
        listNode1.printf();
    }


    public ListNode reverseList(ListNode head) {
        Stack<ListNode> stack = new Stack<ListNode>();
        while (head != null) {
            stack.push(new ListNode(head.val));
            head = head.next;
        }

        ListNode dummy = new ListNode();
        ListNode cur = dummy;
        while(!stack.isEmpty()) {
            cur.next = stack.pop();
            cur = cur.next;
        }
        return dummy.next;

    }


    public ListNode reverseList1(ListNode head) {
        if(head == null || head.next == null) {
            return head;
        }
        ListNode cur = head, pre = null, temp = null;
        while(cur != null) {
            temp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = temp;
        }
        return pre;

    }

}
