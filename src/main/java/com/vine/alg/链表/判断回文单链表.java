package com.vine.alg.链表;


import com.vine.alg.基本数据结构构造.ListNode;

import java.util.logging.Level;

/**
 * @author 阿季
 * @date 2022-05-12 10:02 PM
 */

public class 判断回文单链表 {
    public static void main(String[] args) {
        判断回文单链表 p = new 判断回文单链表();
    }

    ListNode left;

    boolean isPalindrome(ListNode head) {
        left = head;
        return traverse(head);
    }

    boolean traverse(ListNode right) {
        if (right == null) {
            return true;
        }
        boolean res = traverse(right.next);
        res = res && (right.val == left.val)
        left = left.next;
        return res;
    }


}
