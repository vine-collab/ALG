package com.vine.alg.code.leetcode;

import com.vine.alg.基本数据结构构造.ListNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author 阿季
 * @date 2022-07-27 9:50 PM
 */

public class $143_重排链表 {

    public static void main(String[] args) {
        $143_重排链表 c = new $143_重排链表();

        ListNode listNode = ListNode.createListNode(Arrays.asList(1, 2, 3, 4, 5));
        c.reorderList(listNode);
        listNode.printf();
    }

    public void reorderList(ListNode head) {
        if (head == null) {
            return;
        }

        List<ListNode> list = new ArrayList<>();
        ListNode cur = head;
        while (cur != null) {
            list.add(cur);
            cur = cur.next;
        }

        int i = 0, j = list.size() - 1;
        while (i < j) {
            list.get(i).next = list.get(j);
            i++;
            if (i == j) {
                break;
            }
            list.get(j).next = list.get(i);
            j--;
        }
        list.get(i).next = null;

    }


}































































