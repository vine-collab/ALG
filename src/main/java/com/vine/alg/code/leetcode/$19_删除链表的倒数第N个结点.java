package com.vine.alg.code.leetcode;

import com.vine.alg.基本数据结构构造.ListNode;

import java.util.Arrays;

/**
 * @author 阿季
 * @date 2022-06-01 8:20 PM
 */

public class $19_删除链表的倒数第N个结点 {


    /**
     * https://leetcode.cn/problems/remove-nth-node-from-end-of-list/
     * 给你一个链表，删除链表的倒数第n个结点，并且返回链表的头结点。
     * <p>
     * 示例 1：
     * <p>
     * 输入：head = [1,2,3,4,5], n = 2
     * 输出：[1,2,3,5]
     * <p>
     * 示例 2：
     * <p>
     * 输入：head = [1], n = 1
     * 输出：[]
     * 示例 3：
     * <p>
     * 输入：head = [1,2], n = 1
     * 输出：[1]
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode.cn/problems/remove-nth-node-from-end-of-list
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public static void main(String[] args) {
        $19_删除链表的倒数第N个结点 s = new $19_删除链表的倒数第N个结点();
        ListNode listNode = ListNode.createListNode(Arrays.asList(1, 2, 3));
        ListNode listNode1 = s.removeNthFromEnd(listNode, 1);
        listNode1.printf();
    }


    public ListNode removeNthFromEnd(ListNode head, int n) {

        ListNode dummy = new ListNode();
        dummy.next = head;

        // 找到倒数第n+1个节点
        ListNode reverseN = findReverseN(dummy, n + 1);
        reverseN.next = reverseN.next.next;

        return dummy.next;

    }

    /**
     * 寻找链表的倒数第n个节点
     *
     * @param head
     * @param n
     * @return
     */
    ListNode findReverseN(ListNode head, int n) {
        ListNode fast = head;

        for (int i = 0; i < n; i++) {
            fast = fast.next;
        }

        ListNode slow = head;

        while (fast != null) {
            slow = slow.next;
            fast = fast.next;
        }
        return slow;


    }

}















