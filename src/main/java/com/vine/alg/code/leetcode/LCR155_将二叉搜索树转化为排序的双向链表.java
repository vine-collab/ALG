package com.vine.alg.code.leetcode;

import com.vine.alg.基本数据结构构造.Node;

/**
 * @author 阿季
 * @date 2023-09-23 11:00 AM
 */

public class LCR155_将二叉搜索树转化为排序的双向链表 {


    /**
     * https://leetcode.cn/problems/er-cha-sou-suo-shu-yu-shuang-xiang-lian-biao-lcof/description/
     */
    public static void main(String[] args) {
        LCR155_将二叉搜索树转化为排序的双向链表 z = new LCR155_将二叉搜索树转化为排序的双向链表();

    }


    public Node treeToDoublyList(Node root) {
        if (root == null) {
            return null;
        }
        dfs(root);
        // 最后拼接头尾节点
        pre.right = head;
        head.left = pre;
        return head;

    }

    Node pre; // 尾节点
    Node head; // 头节点


    void dfs(Node cur) {
        if (cur == null) {
            return;
        }
        dfs(cur.left);
        if (pre == null) {
            head = cur;
        } else {
            pre.right = cur;
        }
        cur.left = pre;
        pre = cur;
        dfs(cur.right);

    }


}
