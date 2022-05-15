package com.vine.alg.leetcode.leetcode;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 阿季
 * @date 2022-04-28 10:24 PM
 */

public class $2_两数相加 {

    /*
    两数相加
    给你两个 非空 的链表，表示两个非负的整数。它们每位数字都是按照 逆序 的方式存储的，并且每个节点只能存储 一位 数字。
    请你将两个数相加，并以相同形式返回一个表示和的链表。
    你可以假设除了数字 0 之外，这两个数都不会以 0 开头。
    示例 1：
    输入：l1 = [2,4,3], l2 = [5,6,4]
    输出：[7,0,8]
    解释：342 + 465 = 807.
    示例 2：
    输入：l1 = [0], l2 = [0]
    输出：[0]
    示例 3：
    输入：l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
    输出：[8,9,9,9,0,0,0,1]
     */
    public static void main(String[] args) {
        $2_两数相加 l = new $2_两数相加();
//        ListNode listNode1111111111 = new ListNode(9);
//        ListNode listNode111111111 = new ListNode(9, listNode1111111111);
//
//        ListNode listNode11111111 = new ListNode(9, listNode111111111);
//        ListNode listNode1111111 = new ListNode(9,listNode11111111);
//        ListNode listNode111111 = new ListNode(9, listNode1111111);
//        ListNode listNode11111 = new ListNode(9, listNode111111);
//        ListNode listNode1111 = new ListNode(9, listNode11111);
//        ListNode listNode111 = new ListNode(9,listNode1111);
//        ListNode listNode11 = new ListNode(9, listNode111);
//        ListNode listNode1 = new ListNode(1,listNode11);
//
//        ListNode listNode222 = new ListNode(9);


        ListNode listNode111 = new ListNode(3);
        ListNode listNode11 = new ListNode(4, listNode111);
        ListNode listNode1 = new ListNode(2, listNode11);

        ListNode listNode222 = new ListNode(4);
        ListNode listNode22 = new ListNode(6, listNode222);
        ListNode listNode2 = new ListNode(5, listNode22);

        ListNode listNode = l.addTwoNumbers(listNode1, listNode2);
        System.out.println(JSON.toJSONString(listNode, SerializerFeature.DisableCircularReferenceDetect));


    }


    /*
        思路：342 + 465 每位相加只需要关注，个位：作为当前位的结果记录下来，十位作为下一个循环的起始结果累加
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int result = 0;
        ListNode h1 = l1;
        ListNode h2 = l2;
        List<Integer> re = new ArrayList<>();
        while (h1 != null || h2 != null) {
            if (h1 != null) {
                result += h1.val;
                h1 = h1.next;
            }
            if (h2 != null) {
                result += h2.val;
                h2 = h2.next;
            }
            re.add(result % 10);
            result = result / 10;
        }
        if (result != 0) {
            re.add(result);
        }
        ListNode temp = new ListNode();

        for (int i = re.size() - 1; i >= 0; i--) {
            ListNode newNode = new ListNode(re.get(i));
            newNode.next = temp.next;
            temp.next = newNode;
        }

        return temp.next;
    }

    private static class ListNode {

        public int getVal() {
            return val;
        }

        public void setVal(int val) {
            this.val = val;
        }

        public ListNode getNext() {
            return next;
        }

        public void setNext(ListNode next) {
            this.next = next;
        }

        int val;
        ListNode next;

        ListNode() {
        }

        public String toString() {
            return this.val + "";
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }


}
