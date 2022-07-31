package com.vine.alg.code.leetcode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author 阿季
 * @date 2022-06-07 8:41 PM
 */

public class $994_腐烂的橘子 {

    /**
     * https://leetcode.cn/problems/rotting-oranges/
     * 994. 腐烂的橘子
     * 在给定的 m x n 网格 grid 中，每个单元格可以有以下三个值之一：
     * <p>
     * 值 0 代表空单元格；
     * 值 1 代表新鲜橘子；
     * 值 2 代表腐烂的橘子。
     * 每分钟，腐烂的橘子 周围 4 个方向上相邻 的新鲜橘子都会腐烂。
     * <p>
     * 返回 直到单元格中没有新鲜橘子为止所必须经过的最小分钟数。如果不可能，返回 -1 。
     *
     * @param args
     */
    public static void main(String[] args) {
        $994_腐烂的橘子 l = new $994_腐烂的橘子();
        int i = l.orangesRotting(new int[][]{{2, 2}, {1, 1}, {0, 0}, {2, 0}});
        System.out.println(i);
    }

    public int orangesRotting(int[][] grid) {

        return bfs(grid);
    }


    int bfs(int[][] grid) {
        int minute = 0;
        int fresh = 0;
        Queue<String> queue = new LinkedList<>();
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 2) {
                    queue.offer(coordinate(i, j));
                    visited[i][j] = true;
                }
                if (grid[i][j] == 1) {
                    fresh++;
                }

            }
        }


        while (fresh > 0 && !queue.isEmpty()) {
            int size = queue.size();
            for (int k = 0; k < size; k++) {
                int[] xy = coordinate(queue.poll());
                int x = xy[0];
                int y = xy[1];
                if (grid[x][y] == 1) {
                    grid[x][y] = 2;
                }

                if (x - 1 >= 0 && grid[x - 1][y] == 1) {
                    if (!visited[x - 1][y]) {
                        visited[x - 1][y] = true;
                        queue.offer(coordinate(x - 1, y));
                        fresh--;
                    }
                }
                if (y - 1 >= 0 && grid[x][y - 1] == 1) {
                    if (!visited[x][y - 1]) {
                        visited[x][y - 1] = true;
                        queue.offer(coordinate(x, y - 1));
                        fresh--;
                    }
                }
                if (x + 1 < grid.length && grid[x + 1][y] == 1) {
                    if (!visited[x + 1][y]) {
                        visited[x + 1][y] = true;
                        queue.offer(coordinate(x + 1, y));
                        fresh--;
                    }
                }
                if (y + 1 < grid[0].length && grid[x][y + 1] == 1) {
                    if (!visited[x][y + 1]) {
                        visited[x][y + 1] = true;
                        queue.offer(coordinate(x, y + 1));
                        fresh--;
                    }
                }
            }
            minute++;
        }
        if (fresh > 0) {
            return -1;
        } else {
            return minute;
        }

    }

    String coordinate(int i, int j) {
        return i + "_" + j;
    }

    int[] coordinate(String s) {
        String[] s1 = s.split("_");
        return new int[]{Integer.parseInt(s1[0]), Integer.parseInt(s1[1])};
    }

}
