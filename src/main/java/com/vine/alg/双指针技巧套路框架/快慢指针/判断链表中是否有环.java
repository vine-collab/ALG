package com.vine.alg.双指针技巧套路框架.快慢指针;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author 阿季
 * @date 2022-04-09 4:36 PM
 */

public class 判断链表中是否有环 {

    public static void main(String[] args) {
        判断链表中是否有环 p = new 判断链表中是否有环();
        LinkNode head = new LinkNode();
        LinkNode head1 = new LinkNode();
        LinkNode head2 = new LinkNode();
        LinkNode head3 = new LinkNode();

        head.setNext(head1);
        head1.setNext(head2);
        head2.setNext(head3);
        head3.setNext(head1);
        boolean b = p.hasCycle(head);
        System.out.println(b);


    }


    boolean hasCycle(LinkNode linkNode) {

        LinkNode fast = linkNode;
        LinkNode slow = linkNode;

        while (fast != null && slow != null) {
            fast = fast.getNext().getNext();
            slow = slow.getNext();
            if (fast == slow) {
                return true;
            }
        }
        return false;
    }

}

@Builder
@Data
@Setter
@NoArgsConstructor
class LinkNode {
    private LinkNode pre;
    private LinkNode next;

    public LinkNode getPre() {
        return pre;
    }

    public void setPre(LinkNode pre) {
        this.pre = pre;
    }

    public LinkNode getNext() {
        return next;
    }

    public void setNext(LinkNode next) {
        this.next = next;
    }
}
