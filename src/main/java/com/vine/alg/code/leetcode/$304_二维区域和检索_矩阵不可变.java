package com.vine.alg.code.leetcode;

public class $304_二维区域和检索_矩阵不可变 {

    /**
     * https://leetcode.cn/problems/range-sum-query-2d-immutable/description/
     */
    public static void main(String[] args) {
        $304_二维区域和检索_矩阵不可变 z = new $304_二维区域和检索_矩阵不可变();

    }

    int[][] preSum;

    public void NumMatrix(int[][] matrix) {
        preSum = new int[matrix.length + 1][matrix[0].length + 1];
        for(int i = 1; i < matrix.length; i++) {
            for(int j = 1; j < matrix[0].length; j++) {
                preSum[i][j] = preSum[i - 1][j] + preSum[i][j - 1] + matrix[i - 1][j - 1] - preSum[i - 1][j - 1];
            }
        }

    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        return preSum[row2 + 1][col2 + 1] - preSum[row1][col2 + 1] - preSum[row2 + 1][col1] + preSum[row1][col1];
    }
}
