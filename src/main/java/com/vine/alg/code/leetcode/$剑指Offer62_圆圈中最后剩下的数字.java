package com.vine.alg.code.leetcode;

import com.vine.alg.基本数据结构构造.Node;

/**
 * @author 阿季
 * @date 2023-09-07 10:13 PM
 */

public class $剑指Offer62_圆圈中最后剩下的数字 {


    /**
     * 0,1,···,n-1这n个数字排成一个圆圈，从数字0开始，每次从这个圆圈里删除第m个数字（删除后从下一个数字开始计数）。求出这个圆圈里剩下的最后一个数字。
     * <p>
     * 例如，0、1、2、3、4这5个数字组成一个圆圈，从数字0开始每次删除第3个数字，则删除的前4个数字依次是2、0、4、1，因此最后剩下的数字是3。
     * <p>
     * 示例 1：
     * <p>
     * 输入: n = 5, m = 3
     * 输出: 3
     * 示例 2：
     * <p>
     * 输入: n = 10, m = 17
     * 输出: 2
     * <p>
     * https://leetcode.cn/problems/yuan-quan-zhong-zui-hou-sheng-xia-de-shu-zi-lcof/description/
     */
    public static void main(String[] args) {
        $剑指Offer62_圆圈中最后剩下的数字 z = new $剑指Offer62_圆圈中最后剩下的数字();

        int i = z.lastRemaining(5, 1);
        System.out.println(i);
    }


    public int lastRemaining(int n, int m) {
        Node[] init = this.initNode(n);

        Node p = init[0], pre = init[1];
        int k = 1;
        while (p.next != p) {
            if (k == m) {
                pre.next = p.next;
                p = p.next;
                k = 1;
            } else {
                pre = p;
                p = p.next;
                k++;
            }
        }


        return p.val;

    }

    Node[] initNode(int n) {
        Node head = new Node(0), p = head;
        for (int i = 1; i < n; i++) {
            p.next = new Node(i);
            p = p.next;
        }
        p.next = head;
        return new Node[]{head, p};
    }


}




















