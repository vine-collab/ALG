package com.vine.alg.code.leetcode;

/**
 * @author 阿季
 * @date 2022-06-18 8:53 PM
 */

public class $64_最小路径和 {


    /**
     * 给定一个包含非负整数的 mxn网格grid ，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。
     * <p>
     * 说明：每次只能向下或者向右移动一步。
     * <p>
     * <p>
     * <p>
     * 示例 1：
     * <p>
     * <p>
     * 输入：grid = [[1,3,1],[1,5,1],[4,2,1]]
     * 输出：7
     * 解释：因为路径 1→3→1→1→1 的总和最小。
     * <p>
     * 链接：https://leetcode.cn/problems/minimum-path-sum
     */
    public static void main(String[] args) {
        $64_最小路径和 z = new $64_最小路径和();
        int[][] ints = {{1, 3, 1}, {1, 5, 1}, {4, 2, 1}};
        int i = z.minPathSum2(ints);
        System.out.println(i);

    }

    /**
     * dpij 表示 从00-> ij 位置的最小路径
     */
    public int minPathSum(int[][] grid) {

        int m = grid.length;
        int n = grid[0].length;
        int[][] dp = new int[m][n];
        dp[0][0] = grid[0][0];
        for (int i = 1; i < m; i++) {
            dp[i][0] = grid[i][0] + dp[i - 1][0];
        }
        for (int j = 1; j < n; j++) {
            dp[0][j] = grid[0][j] + dp[0][j - 1];
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = Integer.min(dp[i - 1][j], dp[i][j - 1]) + grid[i][j];
            }
        }

        return dp[m - 1][n - 1];


    }



    public int minPathSum2(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] dp = new int[m][n]; // dpij 表示从ij到m - 1, n-1 的最小路径和, 结果在dp00
        dp[m - 1][n - 1] = grid[m - 1][n - 1];

        for(int i = m - 2; i >= 0; i--) {
            dp[i][n - 1] = dp[i + 1][n - 1] + grid[i][n - 1];
        }

        for(int j = n - 2; j >= 0; j--) {
            dp[m - 1][j] = dp[m - 1][j + 1] + grid[m - 1][j];
        }


        for(int i = m - 2; i >= 0; i--) {
            for(int j = n - 2; j >= 0; j--) {
                    dp[i][j] = Integer.min(dp[i + 1][j], dp[i][j + 1]) + grid[i][j];
            }
        }

        return dp[0][0];







    }
}

















