package com.vine.alg.leet.leetcode;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * @author 阿季
 * @date 2022-05-22 7:51 PM
 */


public class $1091_二进制矩阵中的最短路径 {
    public static void main(String[] args) {
        $1091_二进制矩阵中的最短路径 e = new $1091_二进制矩阵中的最短路径();
        int[][] ints = {{0, 0, 0}, {1, 1, 0}, {1, 1, 0}};
        int i = e.shortestPathBinaryMatrix(ints);
        System.out.println(i);
    }



    public int shortestPathBinaryMatrix(int[][] grid) {
        if (grid[0][0] == 1 || grid[grid.length - 1][grid.length - 1] == 1) {
            return -1;
        }

        Queue<String> q = new LinkedList<>();
        String target = grid.length - 1 + "_" + (grid.length - 1);
        q.offer("0_0");
        Set<String> visited = new HashSet<>();
        visited.add("0_0");
        int res = 1;
        while (!q.isEmpty()) {
            int size = q.size();
            for (int k = 0; k < size; k++) {
                String cur = q.poll();
                String[] s = cur.split("_");
                int i = Integer.parseInt(s[0]);
                int j = Integer.parseInt(s[1]);
                if (cur.equals(target)) {
                    return res;
                }
                if (grid[i][j] == 1) {
                    continue;
                }
                // 上
                if (i - 1 >= 0) {
                    String s1 = i - 1 + "_" + j;
                    if (!visited.contains(s1)) {
                        q.offer(s1);
                        visited.add(s1);
                    }
                }
                // 下
                if (i + 1 < grid.length) {
                    String s1 = i + 1 + "_" + j;
                    if (!visited.contains(s1)) {
                        q.offer(s1);
                        visited.add(s1);
                    }

                }
                // 左
                if (j - 1 >= 0) {
                    String s1 = i + "_" + (j - 1);
                    if (!visited.contains(s1)) {
                        q.offer(s1);
                        visited.add(s1);
                    }
                }
                // 右

                if (j + 1 < grid.length) {
                    String s1 = i + "_" + (j + 1);
                    if (!visited.contains(s1)) {
                        q.offer(s1);
                        visited.add(s1);
                    }
                }
                // 左上
                if (i - 1 >= 0 && j - 1 >= 0) {
                    String s1 = i - 1 + "_" + (j - 1);
                    if (!visited.contains(s1)) {
                        q.offer(s1);
                        visited.add(s1);
                    }
                }

                // 右上
                if (i - 1 >= 0 && j + 1 < grid.length) {
                    String s1 = i - 1 + "_" + (j + 1);
                    if (!visited.contains(s1)) {
                        q.offer(s1);
                        visited.add(s1);
                    }
                }

                // 左下
                if (i + 1 < grid.length && j - 1 >= 0) {
                    String s1 = i + 1 + "_" + (j - 1);
                    if (!visited.contains(s1)) {
                        q.offer(s1);
                        visited.add(s1);
                    }
                }

                // 右下
                if (i + 1 < grid.length && j + 1 < grid.length) {
                    String s1 = i + 1 + "_" + (j + 1);
                    if (!visited.contains(s1)) {
                        q.offer(s1);
                        visited.add(s1);
                    }
                }

            }
            res++;
        }

        return -1;
    }
}
