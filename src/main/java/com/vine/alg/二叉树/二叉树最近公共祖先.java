package com.vine.alg.二叉树;

import com.sun.org.apache.xerces.internal.impl.xpath.regex.REUtil;
import com.vine.alg.基本数据结构构造.TreeNode;

/**
 * @author 阿季
 * @date 2022-05-09 9:17 PM
 */

public class 二叉树最近公共祖先 {


    public static void main(String[] args) {
        二叉树最近公共祖先 e = new 二叉树最近公共祖先();
    }

    /*
     情况1：如果pq都在root为根的树中，则返回的结果就是最近公共祖先节点
     情况2：如果pq都不在root为根的树中，则返回null
     情况3：如果pq有一个在root为根的树中，返回该节点；
     */
    TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // base case
        if (root == null) return null;
        if (root == p || root == q) return root;

        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        // p,q
        if(left != null && right != null) {
            return root;
        }

        if(left == null && right == null) {
            return null;
        }

        if(left == null) {
            return right;
        } else {
            return left;
        }

    }


}
