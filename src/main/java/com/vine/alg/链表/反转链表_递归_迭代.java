package com.vine.alg.链表;

import com.vine.alg.基本数据结构构造.ListNode;

import java.util.Arrays;

/**
 * @author 阿季
 * @date 2022-05-14 4:00 PM
 */

public class 反转链表_递归_迭代 {
    public static void main(String[] args) {
        反转链表_递归_迭代 f = new 反转链表_递归_迭代();

        ListNode listNode = ListNode.createListNode(Arrays.asList(1, 2, 3));
        listNode.printf();
        ListNode reverse = f.reverse(listNode);
        reverse.printf();

        ListNode listNode1 = f.reverseRecursive(ListNode.createListNode(Arrays.asList(1, 2, 3, 4, 5)));
        listNode1.printf();
    }


    /**
     * 迭代
     *
     * @param head
     * @return
     */
    ListNode reverse(ListNode head) {
        ListNode pre = null, cur = head;
        while (cur != null) {
            ListNode temp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = temp;
        }
        return pre;
    }


    ListNode reverseBetween(ListNode head, int n, int m) {

        if (head == null || head.next == null) {
            return null;
        }

        ListNode pre = null, cur = head;
        int i = 1, j = 1;

        while (cur != null) {
            if (i != n) {
                i++;
                pre = cur;
                cur = cur.next;
                continue;
            }
            ListNode temp = cur.next;
            cur.next = pre;
            cur = temp;
            j++;

        }


        return null;

    }

    /**
     * 递归：对于递归算法，最重要的就是明确递归函数的定义。具体来说，我们的 reverse 函数定义是这样的：
     * <p>
     * 输入一个节点 head，将「以 head 为起点」的链表反转，并返回反转之后的头结点。
     */
    ListNode reverseRecursive(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode last = reverseRecursive(head.next);
        //翻转当前节点指针
        head.next.next = head;
        //  当链表递归反转之后，新的头结点是 last，而之前的 head 变成了最后一个节点，别忘了链表的末尾要指向 null
        head.next = null;

        return last;
    }


}



















