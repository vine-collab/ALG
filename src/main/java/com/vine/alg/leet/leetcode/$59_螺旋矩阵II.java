package com.vine.alg.leet.leetcode;

import com.alibaba.fastjson.JSON;

/**
 * @author 阿季
 * @date 2022-07-24 3:35 PM
 */

public class $59_螺旋矩阵II {

    /**
     * https://leetcode.cn/problems/spiral-matrix-ii/
     * 给你一个正整数 n ，生成一个包含 1 到 n2 所有元素，且元素按顺时针顺序螺旋排列的 n x n 正方形矩阵 matrix 。
     */
    public static void main(String[] args) {
        $59_螺旋矩阵II l = new $59_螺旋矩阵II();
        int[][] ints = l.generateMatrix(3);
        System.out.println(JSON.toJSONString(ints));
    }

    public int[][] generateMatrix(int n) {

        int[][] res = new int[n][n];
        int upper = 0, left = 0, right = n - 1, lower = n - 1;

        int num = 1;

        while (num <= n * n) {
            // 在顶部从左向右遍历
            if (upper <= lower) {
                for (int i = left; i <= right; i++) {
                    res[upper][i] = num++;
                }
                // 上边界下移
                upper++;
            }

            // 在右侧从上向下遍历
            if (left <= right) {
                for (int i = upper; i <= lower; i++) {
                    res[i][right] = num++;
                }
                right--;
            }

            // 在底部从右向左遍历
            if (upper <= lower) {
                for (int i = right; i >= left; i--) {
                    res[lower][i] = num++;
                }
                lower--;
            }

            // 在左侧从下向上遍历
            if(left <= right) {
                for(int i = lower; i >= upper; i--) {
                    res[i][left] = num++;
                }
                left++;
            }
        }
        return res;

    }


}































































