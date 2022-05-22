package com.vine.alg.leetcode.leetcode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author 阿季
 * @date 2022-05-21 11:22 PM
 */

public class $547_省份数量 {


    /**
     * 547. 省份数量
     * 有 n 个城市，其中一些彼此相连，另一些没有相连。如果城市 a 与城市 b 直接相连，
     * 且城市 b 与城市 c 直接相连，那么城市 a 与城市 c 间接相连。
     * <p>
     * 省份 是一组直接或间接相连的城市，组内不含其他没有相连的城市。
     * <p>
     * 给你一个 n x n 的矩阵 isConnected ，
     * 其中 isConnected[i][j] = 1 表示第 i 个城市和第 j 个城市直接相连，而 isConnected[i][j] = 0 表示二者不直接相连。
     * <p>
     * 返回矩阵中 省份 的数量。
     * <p>
     * 示例 1：
     * 输入：isConnected = [[1,1,0],[1,1,0],[0,0,1]]
     * 输出：2
     * <p>
     * 示例 2：
     * 输入：isConnected = [[1,0,0],[0,1,0],[0,0,1]]
     * 输出：3
     */
    public static void main(String[] args) {
        $547_省份数量 s = new $547_省份数量();

    }


    public int findCircleNum(int[][] isConnected) {
        int province = 0;
        boolean[] visited = new boolean[isConnected.length];
        for (int i = 0; i < isConnected[0].length; i++) {
            if (!visited[i]) {
                province++;
                dfs(isConnected, i, visited);

            }
        }
        return province;

    }

    void dfs(int[][] isConnected, int i, boolean[] visited) {
        visited[i] = true;
        // 遍历与i相邻的节点
        for (int j = 0; j < isConnected.length; j++) {
            if (isConnected[i][j] == 1 && !visited[j]) {
                dfs(isConnected, j, visited);
            }
        }
    }

    public int findCircleNum2(int[][] isConnected) {
        int province = 0;
        boolean[] visited = new boolean[isConnected.length];

        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < isConnected.length; i++) {
            if (visited[i]) {
                continue;
            }
            province++;
            q.offer(i);
            visited[i] = true;

            while (!q.isEmpty()) {
                Integer j = q.poll();
                // 遍历与j相邻的节点
                for (int k = 0; k < isConnected.length; k++) {
                    if (isConnected[j][k] == 1 && !visited[k]) {
                        visited[k] = true;
                        q.offer(k);
                    }

                }
            }
        }


        return province;
    }


}


















