package com.vine.alg.基本数据结构构造;

import lombok.Data;

@Data
public class TreeNode {
    public TreeNode left;
    public TreeNode right;
    public int val;

    public TreeNode(int x) {
        val = x;
    }


}