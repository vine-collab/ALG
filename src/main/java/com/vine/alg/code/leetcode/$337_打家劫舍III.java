package com.vine.alg.code.leetcode;

import com.sun.rowset.providers.RIOptimisticProvider;
import com.vine.alg.基本数据结构构造.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author 阿季
 * @date 2023-04-13 8:21 PM
 */

public class $337_打家劫舍III {


    /**
     * 小偷又发现了一个新的可行窃的地区。这个地区只有一个入口，我们称之为 root 。
     * <p>
     * 除了 root 之外，每栋房子有且只有一个“父“房子与之相连。一番侦察之后，聪明的小偷意识到“这个地方的所有房屋的排列类似于一棵二叉树”。 如果 两个直接相连的房子在同一天晚上被打劫 ，房屋将自动报警。
     * <p>
     * 给定二叉树的 root 。返回 在不触动警报的情况下 ，小偷能够盗取的最高金额 。
     * <p>
     * https://leetcode.cn/problems/house-robber-iii/
     */
    public static void main(String[] args) {
        $337_打家劫舍III z = new $337_打家劫舍III();
    }


    public int rob(TreeNode root) {

        return dp(root);
    }


    Map<TreeNode, Integer> memo = new HashMap<>();

    int dp(TreeNode root) {
        if (root == null) {
            return 0;
        }

        if (memo.containsKey(root)) {
            return memo.get(root);
        }

        // 根节点偷
        int r = root.val;
        // 偷左子树的子树
        int ll = root.left == null ? 0 : dp(root.left.left);
        // 偷右子树的子树
        int lr = root.left == null ? 0 : dp(root.left.right);
        // 偷右子树的左子树
        int rl = root.right == null ? 0 : dp(root.right.left);
        // 偷右子树的右子树
        int rr = root.right == null ? 0 : dp(root.right.right);


        // 不偷根节点，偷子节点
        int nr = dp(root.left) + dp(root.right);

        int res = Math.max(r + ll + lr + rl + rr, nr);

        memo.put(root, res);

        return res;


    }

}































































