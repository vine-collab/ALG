package com.vine.alg.双指针技巧套路框架.快慢指针;

import com.vine.alg.基本数据结构构造.LinkNode;

/**
 * @author 阿季
 * @date 2022-04-09 4:50 PM
 */

public class 返回环链表环的起始位置 {

    public static void main(String[] args) {
        返回环链表环的起始位置 p = new 返回环链表环的起始位置();
        LinkNode head = new LinkNode();
        LinkNode head1 = new LinkNode();
        LinkNode head2 = new LinkNode();
        LinkNode head3 = new LinkNode();
        head.setValue(0);
        head1.setValue(1);
        head2.setValue(2);
        head3.setValue(3);

        head.setNext(head1);
        head1.setNext(head2);
        head2.setNext(head3);
        head3.setNext(head1);
        LinkNode linkNode = p.detectCycle(head);
        System.out.println(linkNode.getValue());

    }

    LinkNode detectCycle(LinkNode head) {
        LinkNode fast = head;
        LinkNode slow = head;

        while (fast != null && fast.getNext() != null) {
            fast = fast.getNext().getNext();
            slow = slow.getNext();
            if(slow == fast) {
                break;
            }
        }

        slow = head;
        while (slow != fast) {
            slow = slow.getNext();
            fast = fast.getNext();
        }
        return slow;

    }


}
