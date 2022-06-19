package com.vine.alg.动态规划;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * @author 阿季
 * @date 2022-06-19 5:55 PM
 */

public class 加权最短路径 {
    /**
     * 有 n 个城市通过一些航班连接。给你一个数组flights ，其中flights[i] = [fromi, toi, pricei] ，表示该航班都从城市 fromi 开始，以价格 pricei 抵达 toi。
     * <p>
     * 现在给定所有的城市和航班，以及出发城市 src 和目的地 dst，你的任务是找到出一条最多经过 k站中转的路线，使得从 src 到 dst 的 价格最便宜 ，并返回该价格。 如果不存在这样的路线，则输出 -1。
     * <p>
     * <p>
     * <p>
     * 示例 1：
     * <p>
     * 输入:
     * n = 3, edges = [[0,1,100],[1,2,100],[0,2,500]]
     * src = 0, dst = 2, k = 1
     * 输出: 200
     * 解释:
     * 城市航班图如下
     * <p>
     * <p>
     * 从城市 0 到城市 2 在 1 站中转以内的最便宜价格是 200，如图中红色所示。
     * <p>
     * 链接：https://leetcode.cn/problems/cheapest-flights-within-k-stops
     */
    public static void main(String[] args) {
        加权最短路径 k = new 加权最短路径();
        int cheapestPrice = k.findCheapestPrice(3, new int[][]{{0, 1, 100}, {1, 2, 100}, {0, 2, 500}}, 0, 2, 1);
        System.out.println(cheapestPrice);
    }


    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        this.src = src;
        this.dst = dst;
        k++; // 转换为边数
        for (int[] flight : flights) {
            int from = flight[0];
            int to = flight[1];
            int price = flight[2];
            indegree.putIfAbsent(to, new LinkedList<>());
            // 记录来源节点，入度
            indegree.get(to).add(new int[]{from, price});
        }

        return dp(dst, k);

    }

    Map<Integer, List<int[]>> indegree = new HashMap<>();

    Map<String, Integer> memo = new HashMap<>();

    int dst, src;


    /**
     * dp：从src出发，k步之内到达s的最小成本
     */

    int dp(int s, int k) {

        if (s == src) {
            return 0;
        }

        if (k == 0) {
            return -1;
        }

        if (!indegree.containsKey(s)) {
            return -1;
        }

        String key = key(s, k);
        if(memo.containsKey(key)) {
            return memo.get(key);
        }

        int res = Integer.MAX_VALUE;
        for (int[] v : indegree.get(s)) {
            int from = v[0];
            int price = v[1];
            int subProblem = dp(from, k - 1);
            if (subProblem != -1) {
                res = Integer.min(res, subProblem + price);
            }
        }
        res = res == Integer.MIN_VALUE ? -1 : res;
        memo.put(key, res);
        return res;


    }

    String key(int s, int k) {
        return s + "_" + k;
    }

}
