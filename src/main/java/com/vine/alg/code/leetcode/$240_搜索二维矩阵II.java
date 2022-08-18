package com.vine.alg.code.leetcode;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.vine.alg.基本数据结构构造.Utils;

import javax.rmi.CORBA.Util;
import java.util.List;

/**
 * @author 阿季
 * @date 2022-08-16 9:22 PM
 */

public class $240_搜索二维矩阵II {


    public static void main(String[] args) {
        $240_搜索二维矩阵II z = new $240_搜索二维矩阵II();
        int[][] ints = {{1, 4, 7, 11, 15}, {2, 5, 8, 12, 19}, {3, 6, 9, 16, 22}, {10, 13, 14, 17, 24}, {18, 21, 23, 26, 30}};
        boolean i = z.searchMatrix(ints, 5);
        System.out.println(i);

        int[][] ints1 = Utils.toIntArr2("[[-5]]");
        boolean b = z.searchMatrix(ints1, -10);
        System.out.println(b);
    }

    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length, n = matrix[0].length;
        // 初始化在右上角
        int i = 0, j = n - 1;
        while (i < m && j >= 0) {
            if (matrix[i][j] == target) {
                return true;
            }
            if (matrix[i][j] < target) {
                // 需要大一点，往下移动
                i++;
            } else {
                // 需要小一点，往左移动
                j--;
            }
        }
        // while 循环中没有找到，则 target 不存在
        return false;
    }

}























































