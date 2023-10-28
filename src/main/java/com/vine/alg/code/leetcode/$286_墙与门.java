package com.vine.alg.code.leetcode;

import com.vine.alg.基本数据结构构造.Utils;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author 阿季
 * @date 2023-10-28 8:16 PM
 */

public class $286_墙与门 {

    /**
     * 您提供的代码是一个解决“墙壁和门”问题的算法。在这个问题中，您有一个二维网格，其中墙壁是1，门是0。您的任务是通过从具有0值的单元格（门）开始，遍历所有可达的单元格，更新其值，使得从任何可达的单元格到最近的门（0值单元格）的距离不超过其值。
     * <p>
     * 看起来您的代码是正确的，它使用了广度优先搜索（BFS）的方法来遍历所有可达的单元格。它首先找到所有的0值单元格（门），然后从这些门开始，通过上、下、左、右四个方向进行搜索，更新所有可达的单元格的值。
     * <p>
     * 具体来说，这个算法的思想是：如果一个单元格的值大于其周围所有可达的单元格的值，那么这个单元格就是一堵墙，不能通过。如果一个单元格的值小于其周围所有可达的单元格的值，那么这个单元格就是一扇门，可以通过。通过更新所有可达的单元格的值，最终可以得到从任何可达的单元格到最近的门的距离。
     * <p>
     * 请注意，这个算法假设所有的墙壁都有值1，而所有的门都有值0。如果您的输入不符合这个假设，那么您可能需要对代码进行一些调整。
     * <p>
     */
    public static void main(String[] args) {
        $286_墙与门 z = new $286_墙与门();
        int[][] arr2 = Utils.toIntArr2("[[2147483647,-1,0,2147483647],[2147483647,2147483647,2147483647,-1],[2147483647,-1,2147483647,-1],[0,-1,2147483647,2147483647]]");
        z.wallsAndGates(arr2);
        Utils.printf(arr2);
    }


    public void wallsAndGates(int[][] rooms) {

        // 创建一个队列用于存放门的位置
        Queue<int[]> queue = new LinkedList<>();
        int m = rooms.length;
        int n = rooms[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (rooms[i][j] == 0) {
                    queue.offer(new int[]{i, j});
                }
            }
        }

        // 定义四个方向（上、下、左、右）
        int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        // 使用BFS进行遍历
        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            int curX = poll[0];
            int curY = poll[1];
            int currValue = rooms[curX][curY];
            for (int[] dir : dirs) {
                int newX = curX + dir[0];
                int newY = curY + dir[1];

                // 检查新位置是否有效（在边界内且不是墙）
                if (newX >= 0 && newX < rooms.length && newY >= 0 && newY < rooms[0].length && rooms[newX][newY] > currValue) {
                    // 更新新位置的值，并将新位置加入队列
                    rooms[newX][newY] = currValue + 1;
                    queue.add(new int[]{newX, newY});
                }
            }
        }

    }
}













