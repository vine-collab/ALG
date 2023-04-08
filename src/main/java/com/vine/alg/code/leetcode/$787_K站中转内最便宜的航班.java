package com.vine.alg.code.leetcode;

import java.util.*;

/**
 * @author 阿季
 * @date 2023-04-08 5:14 PM
 */

public class $787_K站中转内最便宜的航班 {


    /**
     * 有 n 个城市通过一些航班连接。给你一个数组flights ，其中flights[i] = [fromi, toi, pricei] ，表示该航班都从城市 fromi 开始，以价格 pricei 抵达 toi。
     * <p>
     * 现在给定所有的城市和航班，以及出发城市 src 和目的地 dst，你的任务是找到出一条最多经过 k站中转的路线，使得从 src 到 dst 的 价格最便宜 ，并返回该价格。 如果不存在这样的路线，则输出 -1。
     * <p>
     * 示例 1：
     * <p>
     * 输入:
     * n = 3, edges = [[0,1,100],[1,2,100],[0,2,500]]
     * src = 0, dst = 2, k = 1
     * 输出: 200
     * <p>
     * <p>
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public static void main(String[] args) {
        $787_K站中转内最便宜的航班 z = new $787_K站中转内最便宜的航班();
    }


    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        this.src = src;
        this.dst = dst;
        k++;
        for (int[] flight : flights) {
            int from = flight[0];
            int to = flight[1];
            int price = flight[2];
            indegree.putIfAbsent(to, new LinkedList<>());
            indegree.get(to).add(new int[]{from, price});
        }
        this.memo = new int[n][k + 1];
        for (int[] row : memo) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }
        return dp(dst, k);
    }

    int src, dst;
    Map<Integer, List<int[]>> indegree = new HashMap<>();

    int[][] memo;


    // 从src出发，k步之内到达s的最小路径权重为dp
    int dp(int s, int k) {

        if (s == src) {
            return 0;
        }
        if (k == 0) {
            return -1;
        }
        if (memo[s][k] != Integer.MAX_VALUE) {
            return memo[s][k];
        }
        int res = Integer.MAX_VALUE;
        if (!indegree.containsKey(s)) {
            return -1;
        }
        for (int[] w : indegree.get(s)) {
            int sub = dp(w[0], k - 1);
            if (sub < 0) {
                continue;
            }
            res = Math.min(res, sub + w[1]);
        }
        memo[s][k] = res == Integer.MAX_VALUE ? -1 : res;
        return memo[s][k];
    }

}































































