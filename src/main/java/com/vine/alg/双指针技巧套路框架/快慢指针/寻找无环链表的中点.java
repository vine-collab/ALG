package com.vine.alg.双指针技巧套路框架.快慢指针;

import com.vine.alg.基本数据结构构造.LinkNode;

/**
 * @author 阿季
 * @date 2022-04-09 5:19 PM
 */

public class 寻找无环链表的中点 {

    public static void main(String[] args) {
        寻找无环链表的中点 x = new 寻找无环链表的中点();

    }

    LinkNode getMiddle(LinkNode head) {

        LinkNode fast = head;
        LinkNode slow = head;

        while (fast != null && fast.getNext() != null) {
            fast = fast.getNext().getNext();
            slow = slow.getNext();
        }
        return slow;


    }


}
