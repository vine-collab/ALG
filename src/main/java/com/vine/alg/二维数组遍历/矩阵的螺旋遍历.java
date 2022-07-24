package com.vine.alg.二维数组遍历;

import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 阿季
 * @date 2022-07-24 2:58 PM
 */

public class 矩阵的螺旋遍历 {


    public static void main(String[] args) {
        矩阵的螺旋遍历 j = new 矩阵的螺旋遍历();
        List<Integer> integers = j.spiralOrder(new int[][]{{7},{9},{6}});
        System.out.println(JSON.toJSONString(integers));
    }


    List<Integer> spiralOrder(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int upper = 0;
        int lower = m - 1;
        int left = 0;
        int right = n - 1;
        List<Integer> res = new ArrayList<>();

        while (res.size() < m * n) {
            if (upper <= lower) {
                // 在顶部从左向右遍历
                for (int i = left; i <= right; i++) {
                    res.add(matrix[upper][i]);
                }
                // 上边界下移
                upper++;
            }
            if (left <= right) {
                // 在右侧从上向下遍历
                for (int i = upper; i <= lower; i++) {
                    res.add(matrix[i][right]);
                }
                // 右边界左移
                right--;
            }
            if (upper <= lower) {
                // 在底部从右向左遍历
                for (int i = right; i >= left; i--) {
                    res.add(matrix[lower][i]);
                }
                // 下边界上移
                lower--;
            }
            if (left <= right) {
                // 在左侧从下向上遍历
                for (int i = lower; i >= upper; i--) {
                    res.add(matrix[i][left]);
                }
                // 左边界右移
                left++;
            }

        }

        return res;
    }
}






























































