package com.vine.alg.二维数组遍历;

/**
 * @author 阿季
 * @date 2022-07-24 2:42 PM
 */

public class 旋转数组 {


    // 将二维矩阵原地顺时针旋转 90 度
    public void rotate(int[][] matrix) {

        int n = matrix.length;
        // 先沿对角线镜像对称二维矩阵
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        // 反转每一行
        for (int[] row : matrix) {
            this.reverse(row);
        }
    }

    private void reverse(int[] row) {
        int i = 0, j = row.length - 1;
        while (i < j) {
            int temp = row[i];
            row[i] = row[j];
            row[j] = temp;
            i++;
            j--;
        }

    }


    // 将二维矩阵原地逆时针旋转 90 度
    void rotate2(int[][] matrix) {
        // 沿左下到右上的对角线镜像对称二维矩阵
        int n = matrix.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n - i; j++) {
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[n - j - 1][n - i - 1];
                matrix[n - j - 1][n - i - 1] = tmp;
            }
        }

        // 反转每一行
        for (int[] row : matrix) {
            this.reverse(row);
        }

    }


}































































