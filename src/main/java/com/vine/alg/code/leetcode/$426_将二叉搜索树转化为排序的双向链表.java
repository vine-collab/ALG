package com.vine.alg.code.leetcode;

import com.vine.alg.基本数据结构构造.Node;

/**
 * @author 阿季
 * @date 2023-09-22 11:24 PM
 */

public class $426_将二叉搜索树转化为排序的双向链表 {


    public static void main(String[] args) {
        $426_将二叉搜索树转化为排序的双向链表 z = new $426_将二叉搜索树转化为排序的双向链表();

    }


    Node first;
    Node last;

    public Node treeToDoublyList(Node root) {
        if (root == null) {
            return null;
        }

        last.right = first;
        first.left = last;
        return first;

    }

    private void helper(Node node) {
        if(node == null) {
            return;
        }

        helper(node.left);

        if(last != null) {
            last.right = node;
            node.left = last;
        } else {
            first = node;
        }

        last = node;
        helper(node.right);


    }


}

















