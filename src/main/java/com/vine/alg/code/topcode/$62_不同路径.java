package com.vine.alg.code.topcode;

public class $62_不同路径 {


    public static void main(String[] args) {
        $62_不同路径 b = new $62_不同路径();

        int i = b.uniquePaths(3, 7);
        System.out.println(i);
    }


    public int uniquePaths(int m, int n) {

        int[][] dp = new int[m][n]; // 表示从ij到终点的路径数量，结果在dp00
        for (int i = 0; i < m; i++) {
            dp[i][n - 1] = 1;
        }

        for (int j = 0; j < n; j++) {
            dp[m - 1][j] = 1;
        }


        for (int i = m - 2; i >= 0; i--) {
            for (int j = n - 2; j >= 0; j--) {
                dp[i][j] = dp[i + 1][j] + dp[i][j + 1];
            }
        }

        return dp[0][0];


    }


}