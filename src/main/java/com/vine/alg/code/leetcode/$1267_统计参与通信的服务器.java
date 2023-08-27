package com.vine.alg.code.leetcode;

import com.vine.alg.基本数据结构构造.Utils;

/**
 * @author 阿季
 * @date 2023-08-26 23:43
 */

public class $1267_统计参与通信的服务器 {


    /**
     * 这里有一幅服务器分布图，服务器的位置标识在 m * n 的整数矩阵网格 grid 中，1 表示单元格上有服务器，0 表示没有。
     * <p>
     * 如果两台服务器位于同一行或者同一列，我们就认为它们之间可以进行通信。
     * <p>
     * 请你统计并返回能够与至少一台其他服务器进行通信的服务器的数量。
     * <p>
     * https://leetcode.cn/problems/count-servers-that-communicate/
     */
    public static void main(String[] args) {
        $1267_统计参与通信的服务器 z = new $1267_统计参与通信的服务器();
        int[][] ints = Utils.toIntArr2("[[1,0,0,1,0],[0,0,0,0,0],[0,0,0,1,0]]");
        System.out.println(z.countServers(ints));
    }


    public int countServers(int[][] grid) {

        int m = grid.length;
        int n = grid[0].length;
        int[] row = new int[m];
        int[] col = new int[n];
        int res = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    row[i] += 1;
                    col[j] += 1;
                }
            }
        }


        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1 && (row[i] > 1 || col[j] > 1)) {
                    res++;
                }
            }
        }


        return res;

    }


}































































