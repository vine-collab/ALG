package com.vine.alg.基本数据结构构造;

import com.google.common.collect.Sets;
import lombok.Data;

import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Data
public class TreeNode {
    public TreeNode left;
    public TreeNode right;
    public int val;

    public TreeNode(int x) {
        val = x;
    }

    public TreeNode(String x) {
        if (x == null) {
            return;
        }
        val = Integer.parseInt(x);

    }


    // 先序
    public static TreeNode createPreorder(String s) {
        if (s == null || s.isEmpty()) {
            return null;
        }
        List<String> collect = Stream.of(s.split(",")).collect(Collectors.toList());
        LinkedList<String> collect1 = new LinkedList<>(collect);
        TreeNode deserialize = deserialize(collect1);
        return deserialize;
    }


    static Set<String> placeholder = Sets.newHashSet("null", "#");

    static TreeNode deserialize(LinkedList<String> list) {
        if (list == null || list.isEmpty()) {
            return null;
        }
        String s = list.removeFirst().trim();
        if (placeholder.contains(s)) {
            return null;
        }

        TreeNode root = new TreeNode(s);

        root.left = deserialize(list);
        root.right = deserialize(list);
        return root;

    }

}













