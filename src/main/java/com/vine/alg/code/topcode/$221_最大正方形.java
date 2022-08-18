package com.vine.alg.code.topcode;

import java.util.Arrays;

/**
 * @author 阿季
 * @date 2022-08-14 6:10 PM
 */

public class $221_最大正方形 {


    public static void main(String[] args) {
        $221_最大正方形 z = new $221_最大正方形();


    }


    public int maximalSquare(char[][] matrix) {

        int m = matrix.length;
        int n = matrix[0].length;

        int[][] dp = new int[m][n]; // 以 ij 位置为右下方的最大边长为 dp[i][j]

        for (int i = 0; i < m; i++) {
            dp[i][0] = matrix[i][0] - '0';
        }

        for (int j = 0; j < n; j++) {
            dp[0][j] = matrix[0][j] - '0';
        }


        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if(matrix[i][j] == '0') {
                    dp[i][j] = 0;
                } else {
                    dp[i][j] = Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1]) + 1;
                }
            }
        }

        int len = 0;
        for (int i = 0; i < m; i++) {
            len = Math.max(len, Arrays.stream(dp[i]).max().getAsInt());
        }

        return len * len;
    }
}































































