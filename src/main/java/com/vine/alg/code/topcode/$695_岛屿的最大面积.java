package com.vine.alg.code.topcode;

/**
 * @author 阿季
 * @date 2022-08-18 8:22 PM
 */

public class $695_岛屿的最大面积 {

    public static void main(String[] args) {
        $695_岛屿的最大面积 d = new $695_岛屿的最大面积();

    }

    public int maxAreaOfIsland(int[][] grid) {
        this.grid = grid;
        int res = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1) {
                    int dfs = dfs(i, j);
                    res = Integer.max(res, dfs);
                }
            }
        }
        return res;
    }

    int[][] grid = null;

    // 返回以 i j 为起点的面积
    int dfs(int i, int j) {

        if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length) {
            return 0;
        }

        if (grid[i][j] == 0) {
            return 0;
        }
        grid[i][j] = 0;

        return 1
                + dfs(i - 1, j)
                + dfs(i + 1, j)
                + dfs(i, j - 1)
                + dfs(i, j + 1);
    }


}































































