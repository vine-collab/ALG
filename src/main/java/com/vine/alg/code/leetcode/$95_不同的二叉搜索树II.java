package com.vine.alg.code.leetcode;

import com.alibaba.fastjson.JSON;
import com.vine.alg.基本数据结构构造.TreeNode;

import java.util.LinkedList;
import java.util.List;

/**
 * @author 阿季
 * @date 2022-07-16 3:34 PM
 */

public class $95_不同的二叉搜索树II {


    /**
     * 给你一个整数 n ，请你生成并返回所有由 n 个节点组成且节点值从 1 到 n 互不相同的不同 二叉搜索树 。可以按 任意顺序 返回答案。
     * <p>
     * <p>
     * 示例 1：
     * <p>
     * <p>
     * 输入：n = 3
     * 输出：[[1,null,2,null,3],[1,null,3,2],[2,1,3],[3,1,null,null,2],[3,2,null,1]]
     * 示例 2：
     * <p>
     * 输入：n = 1
     * 输出：[[1]]
     * <p>
     * 链接：https://leetcode.cn/problems/unique-binary-search-trees-ii
     */

    public static void main(String[] args) {
        $95_不同的二叉搜索树II b = new $95_不同的二叉搜索树II();
        List<TreeNode> treeNodes = b.generateTrees(3);
        System.out.println(JSON.toJSONString(treeNodes));

    }


    public List<TreeNode> generateTrees(int n) {
        return buildTree(1, n);
    }

    List<TreeNode> buildTree(int lo, int hi) {

        List<TreeNode> res = new LinkedList<>();
        // base case
        if (lo > hi) {
            res.add(null);
            return res;
        }

        // 穷举可能性
        for (int i = lo; i <= hi; i++) {
            // 构造左右子树
            List<TreeNode> leftTree = buildTree(lo, i - 1);
            List<TreeNode> rightTree = buildTree(i + 1, hi);
            for (TreeNode left : leftTree) {
                for (TreeNode right : rightTree) {
                    // i节点作为根节点
                    TreeNode root = new TreeNode(i);
                    root.left = left;
                    root.right = right;
                    res.add(root);
                }
            }


        }
        return res;


    }


}
























