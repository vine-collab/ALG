package com.vine.alg.leet.leetcode;

/**
 * @author 阿季
 * @date 2022-05-19 9:48 PM
 */

public class $1905_统计子岛屿 {
    public static void main(String[] args) {
        $1905_统计子岛屿 t = new $1905_统计子岛屿();

    }

    /**
     * https://leetcode.cn/problems/count-sub-islands/
     */
    // 2中陆地位置，对于1中是水的位置，肯定不是岛屿，先全部淹没掉
    public int countSubIslands(int[][] grid1, int[][] grid2) {
        int res = 0;
        for (int i = 0; i < grid1.length; i++) {
            for (int j = 0; j < grid1[i].length; j++) {
                if (grid1[i][j] == 0 && grid2[i][j] == 1) {
                    dfs(grid1, i, j);
                }
            }
        }

        for (int i = 0; i < grid1.length; i++) {
            for (int j = 0; j < grid1[i].length; j++) {
                if (grid2[i][j] == 1) {
                    res++;
                    dfs(grid1, i, j);
                }
            }
        }
        return res;
    }


    void dfs(int[][] grid, int i, int j) {
        int m = grid.length;
        int n = grid[0].length;
        if (i < 0 || j < 0 || i >= m || j >= n) {
            return;
        }
        if (grid[i][j] == 0) {
            return;
        }

        grid[i][j] = 0;

        dfs(grid, i - 1, j);
        dfs(grid, i + 1, j);
        dfs(grid, i, j - 1);
        dfs(grid, i, j + 1);

    }

}
