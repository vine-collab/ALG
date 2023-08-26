package com.vine.alg.二叉树.层次遍历;

import com.sun.org.apache.xerces.internal.dom.DeepNodeListImpl;
import com.vine.alg.基本数据结构构造.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author 阿季
 * @date 2023-08-26 12:01
 */

public class 层次遍历 {

    public static void main(String[] args) {
        层次遍历 z = new 层次遍历();
    }


    List<List<Integer>> res = new ArrayList<>();


    List<List<Integer>> levelTraverse(TreeNode root) {
        traverse(root, 0);
        return res;
    }


    void traverse(TreeNode root, int level) {
        if (root == null) {
            return;
        }

        if (res.size() <= level) {
            res.add(new LinkedList<>());
        }

        // 前序位置，在 depth 层添加 root 节点的值
        res.get(level).add(root.val);
        traverse(root.left, level + 1);
        traverse(root.right, level + 1);
    }


    List<List<Integer>> levelTraverse1(TreeNode root) {
        if (root == null) {
            return res;
        }
        List<TreeNode> nodes = new LinkedList<>();
        nodes.add(root);
        traverse(nodes);
        return res;
    }

    void traverse(List<TreeNode> curLevelNodes) {
        // base case
        if (curLevelNodes.isEmpty()) {
            return;
        }
        // 前序位置，计算当前层的值和下一层的节点列表
        List<Integer> nodeValues = new LinkedList<>();
        List<TreeNode> nextLevelNodes = new LinkedList<>();
        for (TreeNode node : curLevelNodes) {
            nodeValues.add(node.val);
            if (node.left != null) {
                nextLevelNodes.add(node.left);
            }
            if (node.right != null) {
                nextLevelNodes.add(node.right);
            }
        }
        // 前序位置添加结果，可以得到自顶向下的层序遍历
        res.add(nodeValues);
        traverse(nextLevelNodes);
        // 后序位置添加结果，可以得到自底向上的层序遍历结果
        // res.add(nodeValues);
    }


}































































