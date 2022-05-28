package com.vine.alg.leet.leetcode;

/**
 * @author 阿季
 * @date 2022-05-05 8:47 PM
 */

public class $74_搜索二维矩阵 {


    /*
        编写一个高效的算法来判断m x n矩阵中，是否存在一个目标值。该矩阵具有如下特性：

        每行中的整数从左到右按升序排列。
        每行的第一个整数大于前一行的最后一个整数。
        
        
        示例 1：
        
        输入：matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 3
        输出：true
        
        链接：https://leetcode-cn.com/problems/search-a-2d-matrix
     */

    public static void main(String[] args) {
        $74_搜索二维矩阵 s = new $74_搜索二维矩阵();
        int[][] ints = {{1,2}
        }
                ;
        boolean b = s.searchMatrix2(ints, 2);
        System.out.println(b);

    }


    public boolean searchMatrix(int[][] matrix, int target) {
        for (int[] ints : matrix) {
            if (target == ints[0] || target == ints[ints.length - 1]) {
                return true;
            }
            if (target > ints[0] || target < ints[ints.length - 1]) {
                return search(ints, target);
            }
        }
        return false;
    }

    public boolean search(int[] matrix, int target) {
        int left = 0, right = matrix.length - 1;
        while (left <= right) {
            int middle = left + (right - left) / 2;
            int m = matrix[middle];
            if (m == target) {
                return true;
            } else if (m < target) {
                left = m + 1;
            } else {
                right = m - 1;
            }
        }
        return false;
    }


    public boolean searchMatrix2(int[][] matrix, int target) {
        int M = matrix.length;
        int N = matrix[0].length;


        int left = 0, right = M * N - 1;
        while (left <= right) {
            int middle = left + (right - left) / 2;
            int m = middle / N == 0 ? 0 : middle / N;
            int n = middle % N == 0 ? 0 : middle % N;
            int v = matrix[m][n];
            if (v == target) {
                return true;
            } else if (v > target) {
                right = middle - 1;
            } else {
                left = middle + 1;
            }
        }
        return false;
    }

}














