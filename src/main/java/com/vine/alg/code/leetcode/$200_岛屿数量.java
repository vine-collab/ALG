package com.vine.alg.code.leetcode;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;

import java.util.List;

/**
 * @author 阿季
 * @date 2022-05-18 9:35 PM
 */

public class $200_岛屿数量 {
    public static void main(String[] args) {
        $200_岛屿数量 d = new $200_岛屿数量();
        String s = "[\n" +
                "    [\n" +
                "        \"1\",\n" +
                "        \"1\",\n" +
                "        \"0\",\n" +
                "        \"0\",\n" +
                "        \"0\"\n" +
                "    ],\n" +
                "    [\n" +
                "        \"1\",\n" +
                "        \"1\",\n" +
                "        \"0\",\n" +
                "        \"0\",\n" +
                "        \"0\"\n" +
                "    ],\n" +
                "    [\n" +
                "        \"0\",\n" +
                "        \"0\",\n" +
                "        \"1\",\n" +
                "        \"0\",\n" +
                "        \"0\"\n" +
                "    ],\n" +
                "    [\n" +
                "        \"0\",\n" +
                "        \"0\",\n" +
                "        \"0\",\n" +
                "        \"1\",\n" +
                "        \"1\"\n" +
                "    ]\n" +
                "]";
        List<List<String>> lists = JSON.parseObject(s, new TypeReference<List<List<String>>>() {
        });
        char[][] grid = new char[lists.size()][lists.get(0).size()];
        for (int i = 0; i < lists.size(); i++) {
            for (int j = 0; j < lists.get(i).size(); j++) {
                grid[i][j] = lists.get(i).get(j).charAt(0);
            }
        }
        int i = d.numIslands(grid);
        System.out.println(i);
    }


    public int numIslands(char[][] grid) {
        int res = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == '1') {
                    res++;
                    dfs(grid, i, j);
                }
            }
        }
        return res;
    }

    /**
     * 从 (i, j) 开始，将与之相邻的陆地都变成海水
     *
     * @param grid
     * @param i
     * @param j
     */
    void dfs(char[][] grid, int i, int j) {
        int n = grid.length;
        int m = grid[0].length;
        if (i >= n || j >= m || i < 0 || j < 0) {
            // 超出索引边界
            return;
        }

        if (grid[i][j] == '0') {
            // 已经是海水
            return;
        }

        // 将i，j变成海水
        grid[i][j] = '0';
        // 淹没上下左右
        dfs(grid, i - 1, j);
        dfs(grid, i + 1, j);
        dfs(grid, i, j - 1);
        dfs(grid, i, j + 1);


    }


}























