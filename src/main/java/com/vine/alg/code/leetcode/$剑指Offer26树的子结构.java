package com.vine.alg.code.leetcode;

import com.vine.alg.基本数据结构构造.TreeNode;

/**
 * @author 阿季
 * @date 2023-08-20 19:51
 */

public class $剑指Offer26树的子结构 {

    public static void main(String[] args) {
        $剑指Offer26树的子结构 z = new $剑指Offer26树的子结构();
    }

    /**
     * 输入两棵二叉树A和B，判断B是不是A的子结构。(约定空树不是任意一个树的子结构)
     *
     * B是A的子结构， 即 A中有出现和B相同的结构和节点值
     * https://leetcode.cn/problems/shu-de-zi-jie-gou-lcof/description/
     */

    public boolean isSubStructure(TreeNode A, TreeNode B) {

        if(A == null || B == null) {
            return false;
        }

        return recur(A, B) || isSubStructure(A.left, B) || isSubStructure(A.right, B);

    }

    boolean recur(TreeNode a, TreeNode b) {
        // 子树匹配完成
        if(b == null) {
            return true;
        }

        if(a == null || a.val != b.val) {
            return false;
        }

        return recur(a.left, b.left) && recur(a.right, b.right);
    }


}































































