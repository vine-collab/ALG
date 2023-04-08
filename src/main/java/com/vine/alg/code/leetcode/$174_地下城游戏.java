package com.vine.alg.code.leetcode;

/**
 * @author 阿季
 * @date 2022-06-19 11:57 AM
 */

public class $174_地下城游戏 {


    /**
     * https://leetcode.cn/problems/dungeon-game/
     * 一些恶魔抓住了公主（P）并将她关在了地下城的右下角。地下城是由 M x N 个房间组成的二维网格。我们英勇的骑士（K）最初被安置在左上角的房间里，他必须穿过地下城并通过对抗恶魔来拯救公主。
     * <p>
     * 骑士的初始健康点数为一个正整数。如果他的健康点数在某一时刻降至 0 或以下，他会立即死亡。
     * <p>
     * 有些房间由恶魔守卫，因此骑士在进入这些房间时会失去健康点数（若房间里的值为负整数，则表示骑士将损失健康点数）；其他房间要么是空的（房间里的值为 0），要么包含增加骑士健康点数的魔法球（若房间里的值为正整数，则表示骑士将增加健康点数）。
     * <p>
     * 为了尽快到达公主，骑士决定每次只向右或向下移动一步。
     * <p>
     * <p>
     * <p>
     * 编写一个函数来计算确保骑士能够拯救到公主所需的最低初始健康点数。
     * <p>
     * 例如，考虑到如下布局的地下城，如果骑士遵循最佳路径 右 -> 右 -> 下 -> 下，则骑士的初始健康点数至少为 7。
     * <p>
     * -2 (K)	-3	3
     * -5	-10	1
     * 10	30	-5 (P)
     */
    public static void main(String[] args) {
        $174_地下城游戏 d = new $174_地下城游戏();
        int i = d.calculateMinimumH1P(new int[][]{{-2, -3, 3}, {-5, -10, 1}, {10, 30, -5}});
        System.out.println(i);
    }


    /**
     * dp 表示从ij到mn点的所需要的最小生命值
     */
    public int calculateMinimumHP(int[][] dungeon) {
        int m = dungeon.length;
        int n = dungeon[0].length;
        int[][] dp = new int[m + 1][n + 1];
        dp[m - 1][n - 1] = dungeon[m - 1][n - 1] >= 0 ? 1 : -dungeon[m - 1][n - 1] + 1;

        for (int i = m; i >= 0; i--) {
            for (int j = n; j >= 0; j--) {
                if (i == m || j == n) {
                    dp[i][j] = Integer.MAX_VALUE;
                    continue;
                }
                if (i == m - 1 && j == n - 1) {
                    continue;
                }
                int res = Math.min(dp[i + 1][j], dp[i][j + 1]) - dungeon[i][j];
                dp[i][j] = res <= 0 ? 1 : res;


            }
        }

        return dp[0][0];

    }

    public int dp(int[][] dungeon, int i, int j) {
        int m = dungeon.length;
        int n = dungeon[0].length;

        if (i == m - 1 && j == n - 1) {
            return dungeon[i][j] > 0 ? 1 : -dungeon[i][j] + 1;
        }

        int res = Integer.min(dp(dungeon, i + 1, j), dp(dungeon, i, j + 1)) - dungeon[i][j];
        return res <= 0 ? 1 : res;

    }




    public int calculateMinimumH1P(int[][] dungeon) {
        int m = dungeon.length;
        int n = dungeon[0].length;
        // dp(i, j) 表示从i，j到达 右下角的最小生命值为dp
        int[][] dp = new int[m][n];
        dp[m - 1][n - 1] = dungeon[m - 1][n - 1] >= 0 ? 1 : -dungeon[m - 1][n - 1] + 1;
        for(int i = m - 2; i >= 0; i--) {
            int d = dp[i + 1][n - 1] - dungeon[i][n - 1];
            dp[i][n - 1] = d <= 0 ? 1 : d;
        }

        for(int j = n - 2; j >= 0; j--) {
            int d = dp[m - 1][j + 1] - dungeon[m - 1][j];
            dp[m - 1][j] = d <= 0 ? 1 : d;
        }

        for(int i = m - 2; i >= 0; i--) {
            for(int j = n - 2; j >= 0; j--) {
                int d = Math.min(dp[i + 1][j], dp[i][j + 1]) - dungeon[i][j];
                dp[i][j] = d <= 0 ? 1 : d;
            }
        }

        return dp[0][0];
    }

}







