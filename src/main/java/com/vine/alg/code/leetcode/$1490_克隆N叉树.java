package com.vine.alg.code.leetcode;

import com.vine.alg.基本数据结构构造.Node;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

/**
 * @author 阿季
 * @date 2023-09-09 6:11 PM
 */

public class $1490_克隆N叉树 {


    public static void main(String[] args) {
        $1490_克隆N叉树 z = new $1490_克隆N叉树();

    }

    public Node cloneTree(Node root) {

        return dfs(root);
    }


    Node bfs(Node root) {
        if(root == null) {
            return null;
        }

        Map<Node, Node> map = new HashMap<>();
        Queue<Node> q = new LinkedList<>();
        q.offer(root);
        while (!q.isEmpty()) {
            int size = q.size();
            for(int i = 0; i < size; i++) {
                Node cur = q.poll();
                if(cur == null) {
                    continue;
                }
                Node curCopy = map.getOrDefault(cur, new Node(cur.val));
                map.put(cur, curCopy);

                for (Node child : cur.children) {
                    q.offer(child);
                    Node childCopy = map.getOrDefault(child, new Node(child.val));
                    curCopy.children.add(childCopy);
                    map.put(child, childCopy);
                }
            }
        }
        return map.get(root);
    }



    Node dfs(Node root) {
        if(root == null) {
            return null;
        }

        Node node = new Node(root.val);
        for (Node child : root.children) {
            node.children.add(dfs(child));
        }
        return node;
    }


}
