package com.vine.alg.双指针技巧套路框架.快慢指针;

import com.vine.alg.基本数据结构构造.LinkNode;

/**
 * @author 阿季
 * @date 2022-04-09 5:22 PM
 */

public class 寻找单链表的倒数第k个元素 {

    public static void main(String[] args) {
        寻找单链表的倒数第k个元素 x = new 寻找单链表的倒数第k个元素();

    }

    LinkNode getPos(LinkNode head, int k) {
        LinkNode fast, slow;
        fast = slow = head;

        while (k-- > 0) {
            if (fast.getNext() == null) {
                return null;
            }
            fast = fast.getNext();
        }
        while (fast.getNext() != null) {
            fast = fast.getNext();
            slow = slow.getNext();
        }

        return slow;
    }


}
