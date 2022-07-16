package com.vine.alg.leet.leetcode;

/**
 * @author 阿季
 * @date 2022-07-16 3:14 PM
 */

public class $96_不同的二叉搜索树 {


    /**
     * https://leetcode.cn/problems/unique-binary-search-trees/
     * 给你一个整数 n ，求恰由 n 个节点组成且节点值从 1 到 n 互不相同的 二叉搜索树 有多少种？返回满足题意的二叉搜索树的种数。
     */
    public static void main(String[] args) {
        $96_不同的二叉搜索树 b = new $96_不同的二叉搜索树();
        System.out.println(b.numTrees(3));

    }


    public int numTrees(int n) {
        return count(1, n);
    }


    // 闭区间lo-hi 的数字能组成count中bst
    int count(int lo, int hi) {
        //注意 base case，显然当lo > hi闭区间[lo, hi]肯定是个空区间，也就对应着空节点 null，
        // 虽然是空节点，但是也是一种情况，所以要返回 1 而不能返回 0。
        if (lo > hi) {
            return 1;
        }
        int res = 0;
        for (int i = lo; i <= hi; i++) {
            // i 的值作为根节点
            int left = count(lo, i - 1);
            int right = count(i + 1, hi);
            // 左右子树的组合数乘积是bst总数
            res += left * right;
        }

        return res;
    }

}
