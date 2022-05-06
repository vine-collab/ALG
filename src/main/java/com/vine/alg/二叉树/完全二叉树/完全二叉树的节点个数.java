package com.vine.alg.二叉树.完全二叉树;

import com.vine.alg.基本数据结构构造.TreeNode;

/**
 * @author 阿季
 * @date 2022-05-06 9:19 PM
 */

public class 完全二叉树的节点个数 {


    /*
    https://leetcode-cn.com/problems/count-complete-tree-nodes/

    222. 完全二叉树的节点个数
    给你一棵 完全二叉树 的根节点 root ，求出该树的节点个数。

    完全二叉树 的定义如下：在完全二叉树中，除了最底层节点可能没填满外，其余每层节点数都达到最大值，并且最下面一层的节点都集中在该层最左边的若干位置。若最底层为第 h 层，则该层包含 1~ 2h 个节点。



    示例 1：


    输入：root = [1,2,3,4,5,6]
    输出：6
    示例 2：

    输入：root = []
    输出：0
    示例 3：

    输入：root = [1]
    输出：1

     */

    public static void main(String[] args) {
        完全二叉树的节点个数 w = new 完全二叉树的节点个数();

    }

    public int countNodes(TreeNode root) {
        TreeNode l = root, r = root;
        // 记录左右子树的高度
        int hl = 0, hr = 0;
        while (l != null) {
            l = l.left;
            hl++;
        }
        while (r != null) {
            r = r.right;
            hr++;
        }
        // 如果左右子树高端相同，则是一个满二叉树
        if (hl == hr) {
            return (int) Math.pow(2, hl) - 1;
        }

        // 高度不相通，则按照普通二叉树计算
        return 1 + countNodes(root.left) + countNodes(root.right);

    }

}
