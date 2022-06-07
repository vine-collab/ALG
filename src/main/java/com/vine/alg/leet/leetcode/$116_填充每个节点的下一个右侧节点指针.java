package com.vine.alg.leet.leetcode;

import com.vine.alg.基本数据结构构造.Node;

/**
 * @author 阿季
 * @date 2022-06-03 5:45 PM
 */

public class $116_填充每个节点的下一个右侧节点指针 {


    /**
     * https://leetcode.cn/problems/populating-next-right-pointers-in-each-node/
     */
    public static void main(String[] args) {
        $116_填充每个节点的下一个右侧节点指针 t = new $116_填充每个节点的下一个右侧节点指针();

    }


    public Node connect(Node root) {
        if (root == null) return null;
        Node cur = root;

        while (cur != null) {
            Node dummy = new Node();
            Node pre = dummy;
            while (cur != null) {
                if (cur.left != null) {
                    pre.next = cur.left;
                    pre = pre.next;
                }

                if (cur.right != null) {
                    pre.next = cur.right;
                    pre = pre.next;
                }
                cur = cur.next;
            }
            cur = dummy.next;
        }
        return root;

    }

}

