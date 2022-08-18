package com.vine.alg.code.leetcode;

import com.alibaba.fastjson.JSON;
import com.vine.alg.前缀树.TrieMap;
import jdk.nashorn.internal.runtime.JSONFunctions;

/**
 * @author 阿季
 * @date 2022-08-14 5:26 PM
 */

public class $48_旋转图像 {

    /**
     *
     */
    public static void main(String[] args) {
        $48_旋转图像 f = new $48_旋转图像();
        int[][] ints = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        f.rotate(ints);
    }

    public void rotate(int[][] matrix) {

        int m = matrix.length;
        int n = matrix[0].length;


        for (int i = 0; i < m; i++) {
            for (int j = i + 1; j < n; j++) {
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = tmp;
            }
        }

        System.out.println(JSON.toJSON(matrix));

        for (int i = 0; i < m; i++) {
            int left = 0, right = n - 1;
            while (left < right) {
                int temp = matrix[i][left];
                matrix[i][left] = matrix[i][right];
                matrix[i][right] = temp;
                left++;
                right--;
            }

        }
        System.out.println(JSON.toJSONString(matrix));
    }


}































































