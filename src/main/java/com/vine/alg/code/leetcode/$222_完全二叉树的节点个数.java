package com.vine.alg.code.leetcode;

import com.vine.alg.基本数据结构构造.TreeNode;

/**
 * @author 阿季
 * @date 2022-07-16 6:20 PM
 */

public class $222_完全二叉树的节点个数 {


    /**
     * https://leetcode.cn/problems/count-complete-tree-nodes/
     */
    public static void main(String[] args) {
        $222_完全二叉树的节点个数 w = new $222_完全二叉树的节点个数();


    }


    public int countNodes(TreeNode root) {

        TreeNode l = root, r = root;
        int hl = 0, hr = 0;
        while (l != null) {
            l = l.left;
            hl++;
        }

        while (r != null) {
            r = r.right;
            hr++;
        }
        if(hl == hr) {
            return (int) Math.pow(2, hl) - 1;

        }

        return 1 + countNodes(root.left) + countNodes(root.right);

    }


}































































