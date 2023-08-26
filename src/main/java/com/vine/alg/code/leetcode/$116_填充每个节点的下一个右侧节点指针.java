package com.vine.alg.code.leetcode;

import com.vine.alg.基本数据结构构造.Node;

import java.util.LinkedList;

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


    public Node connect1(Node root) {
        if (root == null) {
            return root;
        }
        traverse(root.left, root.right);
        return root;
    }

    void traverse(Node root1, Node root2) {
        if (root1 == null || root2 == null) {
            return;
        }
        root1.next = root2;
        traverse(root1.left, root1.right);
        traverse(root2.left, root2.right);
        traverse(root1.right, root2.left);

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






    public Node connect11(Node root) {
        if(root == null) {
            return root;
        }
        LinkedList nodes = new LinkedList();
        nodes.add(root);
        traverse(nodes);
        return root;
    }

    void traverse(LinkedList<Node> nodes) {
        if(nodes.isEmpty()) {
            return;
        }
        Node p = new Node();
        LinkedList<Node> nextNodes = new LinkedList<>();
        for (Node node : nodes) {
            p.next = node;
            p = p.next;
            if(node.left != null) {
                nextNodes.addLast(node.left);
            }
            if(node.right != null){
                nextNodes.addLast(node.right);
            }
        }
        traverse(nextNodes);
    }

















}

