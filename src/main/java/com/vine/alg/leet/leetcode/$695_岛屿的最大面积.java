package com.vine.alg.leet.leetcode;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;

import java.util.List;

/**
 * @author 阿季
 * @date 2022-05-19 9:08 PM
 */

public class $695_岛屿的最大面积 {


    /**
     * https://leetcode.cn/problems/max-area-of-island/submissions/
     *
     * @param args
     */
    public static void main(String[] args) {
        $695_岛屿的最大面积 z = new $695_岛屿的最大面积();

        List<List<String>> lists = JSON.parseObject(s, new TypeReference<List<List<String>>>() {
        });
        char[][] grid = new char[lists.size()][lists.get(0).size()];
        for (int i = 0; i < lists.size(); i++) {
            for (int j = 0; j < lists.get(i).size(); j++) {
                grid[i][j] = lists.get(i).get(j).charAt(0);
            }
        }

        int i = z.maxAreaOfIsland(null);
        System.out.println(i);
    }


    public int maxAreaOfIsland(int[][] grid) {
        int res = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1) {
                    int dfs = dfs(grid, i, j);
                    res = Integer.max(res, dfs);
                }
            }
        }
        return res;
    }

    int dfs(int[][] grid, int i, int j) {
        int m = grid.length;
        int n = grid[0].length;
        if (i < 0 || j < 0 || i >= n || j >= m) {
            return 0;
        }

        if (grid[i][j] == 0) {
            return 0;
        }

        grid[i][j] = 0;

        return dfs(grid, i - 1, j) + dfs(grid, i + 1, j) + dfs(grid, i, j - 1) + dfs(grid, i, j + 1) + 1;


    }



    static String s = "[[0,0,1,0,0,0,0,1,0,0,0,0,0],[0,0,0,0,0,0,0,1,1,1,0,0,0],[0,1,1,0,1,0,0,0,0,0,0,0,0],[0,1,0,0,1,1,0,0,1,0,1,0,0],[0,1,0,0,1,1,0,0,1,1,1,0,0],[0,0,0,0,0,0,0,0,0,0,1,0,0],[0,0,0,0,0,0,0,1,1,1,0,0,0],[0,0,0,0,0,0,0,1,1,0,0,0,0]]";


}
