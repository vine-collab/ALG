package com.vine.alg.DFS框架;

import com.vine.alg.基本数据结构构造.TreeNode;

/**
 * @author 阿季
 * @date 2022-05-18 9:17 PM
 */

public class 遍历框架 {

    void traverse(TreeNode root) {
        traverse(root.left);
        traverse(root.right);
    }


    // 二维矩阵遍历框架
    void dfs(int[][] grid, int i, int j, boolean[][] visited) {
        int m = grid.length, n = grid[0].length;
        if (i < 0 || j < 0 || i >= m || j >= n) {
            // 超出索引边界
            return;
        }
        if (visited[i][j]) {
            // 已遍历过 (i, j)
            return;
        }
        // 进入节点 (i, j)
        visited[i][j] = true;
        dfs(grid, i - 1, j, visited); // 上
        dfs(grid, i + 1, j, visited); // 下
        dfs(grid, i, j - 1, visited); // 左
        dfs(grid, i, j + 1, visited); // 右
    }

}
