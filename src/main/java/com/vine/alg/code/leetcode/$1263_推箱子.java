package com.vine.alg.code.leetcode;

import org.checkerframework.checker.units.qual.A;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

/**
 * @author 阿季
 * @date 2023-08-27 11:39
 */

public class $1263_推箱子 {

    /**
     * https://leetcode.cn/problems/minimum-moves-to-move-a-box-to-their-target-location/
     */
    public static void main(String[] args) {
        $1263_推箱子 z = new $1263_推箱子();
    }

    int[][] dirs = new int[][]{{-1, 0}, {0, 1}, {0, -1}, {1, 0}};

    public int minPushBox(char[][] grid) {

        int m = grid.length;
        int n = grid[0].length;
        Set<Integer> visited = new HashSet<>();
        PriorityQueue<Integer[]> queue = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        Integer[] initialState = new Integer[5];
        initialState[0] = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 'S') {
                    initialState[1] = i;
                    initialState[2] = j;
                } else if (grid[i][j] == 'B') {
                    initialState[3] = i;
                    initialState[4] = j;
                }
            }
        }
        queue.add(initialState);
        while (queue.size() > 0) {
            Integer[] state = queue.poll();
            int px = state[1], py = state[2], bx = state[3], by = state[4];
            int hash = (px << 15) | (py << 10) | (bx << 5) | by;
            if (!visited.add(hash)) {
                continue;
            }
            int next_px, next_py, next_bx, next_by;
            for (int[] dir : dirs) {
                int d = state[0];
                next_px = dir[0] + px;
                next_py = dir[1] + py;

                if (next_px < 0 || next_px >= m || next_py < 0 || next_py >= n || grid[next_px][next_py] == '#') {
                    continue;
                }

                next_bx = bx;
                next_by = by;
                // 判断是否要移动箱子
                if (next_px == bx && next_py == by) {
                    next_bx = dir[0] + bx;
                    next_by = dir[1] + by;
                    if (next_bx < 0 || next_bx >= m || next_by < 0 || next_by >= n || grid[next_bx][next_by] == '#') {
                        continue;
                    }
                    //箱子移动+1
                    d++;
                }

                if (grid[next_bx][next_by] == 'T') {
                    return d;
                }
                queue.offer(new Integer[]{d, next_px, next_py, next_bx, next_by});
            }

        }
        return -1;
    }

}































































