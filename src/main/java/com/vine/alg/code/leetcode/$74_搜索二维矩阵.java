package com.vine.alg.code.leetcode;

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
        int[][] ints = {{1, 2}};
        boolean b = s.searchMatrix(ints, 2);
        System.out.println(b);

    }


    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        int left = 0, right = m * n - 1;
        while(left <= right) {
            int centre = left + (right - left) / 2;
            int mid = matrix[centre / n][centre % n];
            if(mid == target) {
                return true;
            } else if(mid < target){
                left = centre + 1;
            } else {
                right = centre - 1;
            }
        }
        return false;
    }

}














