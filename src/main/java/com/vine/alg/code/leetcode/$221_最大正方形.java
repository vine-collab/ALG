package com.vine.alg.code.leetcode;

/**
 * @author 阿季
 * @date 2022-07-30 8:57 PM
 */

public class $221_最大正方形 {


    /**
     * https://leetcode.cn/problems/maximal-square/
     */
    public static void main(String[] args) {
        $221_最大正方形 z = new $221_最大正方形();

    }

    public int maximalSquare(char[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        // 定义：以 matrix[i][j] 为右下角元素的全为 1 正方形矩阵的最大边长为 dp[i][j]。
        int[][] dp = new int[m][n];
        for (int i = 0; i < n; i++) { // 第一行
            dp[0][i] = matrix[0][i] - '0';
        }

        for (int i = 0; i < m; i++) {// 第一列
            dp[i][0] = matrix[i][0] - '0';
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][j] == '0') {
                    dp[i][j] = 0;
                } else {
                    dp[i][j] = Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1])) + 1;
                }
            }
        }
        int len = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                len = Math.max(len, dp[i][j]);
            }
        }

        return len * len;


    }


}































































