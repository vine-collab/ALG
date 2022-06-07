package com.vine.alg.leet.leetcode;

import com.alibaba.fastjson.JSON;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * @author 阿季
 * @date 2022-06-03 6:10 PM
 */

public class $542_01矩阵 {


    /**
     * 给定一个由 0 和 1 组成的矩阵 mat ，请输出一个大小相同的矩阵，其中每一个格子是 mat 中对应位置元素到最近的 0 的距离。
     * <p>
     * 两个相邻元素间的距离为 1 。
     * <p>
     * <p>
     * <p>
     * 链接：https://leetcode.cn/problems/01-matrix
     */
    public static void main(String[] args) {
        $542_01矩阵 j = new $542_01矩阵();
        int[][] ints = j.updateMatrix(new int[][]{{0, 0, 0}, {0, 1, 0}, {1, 1, 1}});
        System.out.println(JSON.toJSONString(ints));
    }

    public int[][] updateMatrix(int[][] mat) {

        int[][] res = new int[mat.length][mat[0].length];

        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[i].length; j++) {
                if (mat[i][j] == 0) {
                    res[i][j] = 0;
                    continue;
                }

                res[i][j] = bfs(mat, i, j);

            }
        }
        return res;
    }


    int bfs(int[][] mat, int i, int j) {
        Queue<String> q = new LinkedList<>();
        String s = i + "_" + j;
        q.offer(s);

        Set<String> visited = new HashSet<>();
        visited.add(s);
        int distance = 0;

        while (!q.isEmpty()) {
            int size = q.size();
            for (int k = 0; k < size; k++) {
                String[] split = q.poll().split("_");
                Integer x = Integer.valueOf(split[0]);
                Integer y = Integer.valueOf(split[1]);

                int cur = mat[x][y];
                if (cur == 0) {
                    return distance;
                }
                if (x - 1 >= 0) {
                    String coordinate = coordinate(x - 1, y);
                    if (visited.add(coordinate)) {
                        q.offer(coordinate);
                    }
                }
                if (x + 1 < mat.length) {
                    String coordinate1 = coordinate(x + 1, y);
                    if (visited.add(coordinate1)) {
                        q.offer(coordinate1);
                    }
                }
                if (y - 1 >= 0) {
                    String coordinate2 = coordinate(x, y - 1);
                    if (visited.add(coordinate2)) {
                        q.offer(coordinate2);
                    }
                }
                if (y + 1 < mat[0].length) {
                    String coordinate3 = coordinate(x, y + 1);
                    if (visited.add(coordinate3)) {
                        q.offer(coordinate3);
                    }
                }
            }
            distance++;
        }
        return distance;

    }

    String coordinate(int x, int y) {
        return x + "_" + y;
    }
}



















