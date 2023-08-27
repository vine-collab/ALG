package com.vine.alg.code.leetcode;

import com.vine.alg.基本数据结构构造.Node;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author 阿季
 * @date 2022-05-22 12:09 PM
 */

public class $117_填充每个节点的下一个右侧节点指针II {

    public static void main(String[] args) {
        $117_填充每个节点的下一个右侧节点指针II t = new $117_填充每个节点的下一个右侧节点指针II();

    }


    public Node connect(Node root) {
        if (root == null) {
            return null;
        }
        Queue<Node> q = new LinkedList<>();
        q.offer(root);
        while (!q.isEmpty()) {

            int size = q.size();
            Node pre = null;
            for (int i = 0; i < size; i++) {

                Node cur = q.poll();
                if (pre != null) {
                    pre.next = cur;
                }
                pre = cur;
                if (cur.left != null) {
                    q.offer(cur.left);
                }
                if (cur.right != null) {
                    q.offer(cur.right);
                }
            }
        }

        return root;

    }

    public Node connect2(Node root) {
        if (root == null) {
            return null;
        }

        Node cur = root;
        while (cur != null) {
            Node dummy = new Node();
            Node pre = dummy;
            // 串联下一个层
            while (cur != null) {
                while (cur.left != null) {
                    pre.next = cur.left;
                    pre = pre.next;
                }

                while (cur.right != null) {
                    pre.next = cur.right;
                    pre = pre.next;
                }
                cur = cur.next;
            }
            // 将下一层串连好的链表赋值给cur，进行下一层循环，直到cur == null；
            cur = dummy.next;
        }
        return root;

    }
}
