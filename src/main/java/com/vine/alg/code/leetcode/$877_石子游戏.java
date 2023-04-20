package com.vine.alg.code.leetcode;

import com.vine.alg.基本数据结构构造.Utils;

/**
 * @author 阿季
 * @date 2023-04-12 8:56 PM
 */

public class $877_石子游戏 {


    /**
     * Alice 和 Bob 用几堆石子在做游戏。一共有偶数堆石子，排成一行；每堆都有 正 整数颗石子，数目为 piles[i]。
     * <p>
     * 游戏以谁手中的石子最多来决出胜负。石子的 总数 是 奇数 ，所以没有平局。
     * <p>
     * Alice 和 Bob 轮流进行，Alice 先开始 。 每回合，玩家从行的 开始 或 结束 处取走整堆石头。 这种情况一直持续到没有更多的石子堆为止，此时手中 石子最多 的玩家 获胜 。
     * <p>
     * 假设 Alice 和 Bob 都发挥出最佳水平，当 Alice 赢得比赛时返回true，当 Bob 赢得比赛时返回false。
     * <p>
     * 示例 1：
     * <p>
     * 输入：piles = [5,3,4,5]
     * 输出：true
     * 解释：
     * Alice 先开始，只能拿前 5 颗或后 5 颗石子 。
     * 假设他取了前 5 颗，这一行就变成了 [3,4,5] 。
     * 如果 Bob 拿走前 3 颗，那么剩下的是 [4,5]，Alice 拿走后 5 颗赢得 10 分。
     * 如果 Bob 拿走后 5 颗，那么剩下的是 [3,4]，Alice 拿走后 4 颗赢得 9 分。
     * 这表明，取前 5 颗石子对 Alice 来说是一个胜利的举动，所以返回 true 。
     * <p>
     * 链接：https://leetcode.cn/problems/stone-game
     */
    public static void main(String[] args) {
        $877_石子游戏 z = new $877_石子游戏();
        boolean b = z.stoneGame(Utils.splitToIntArr1("3,7,2,3"));
        System.out.println(b);
    }


    public boolean stoneGame(int[] piles) {
        int l = piles.length;

        // dp[i][j].fir=x 表示石头堆从[i...j] 先手能获得最大分数
        // dp[i][j].sec=y 表示石头堆从[i...j] 后手能获得最大分数
        Pair[][] dp = new Pair[l][l];
        for (int i = 0; i < l; i++)
            for (int j = i; j < l; j++)
                dp[i][j] = new Pair(0, 0);


        // base case 只有一个石头的时候 i==j 先手为piles[i], 后手为0
        for (int i = 0; i < l; i++) {
            dp[i][i].fir = piles[i];
            dp[i][i].sec = 0;
        }

        // 转移方程
        // dp[i][j].fir = Math.max(piles[i] + dp[i + 1][j].sec, piles[j - 1] + dp[i][j - 1].fir);

        for(int i = l - 1; i >=0; i--) {
            for(int j = i + 1; j < l; j++) {
                // 先手选择最左边或最右边的分数
                int left = piles[i] + dp[i+1][j].sec;
                int right = piles[j] + dp[i][j-1].sec;
                if(left > right) {
                    dp[i][j].fir = left;
                    dp[i][j].sec = dp[i + 1][j].fir;
                } else {
                    dp[i][j].fir = right;
                    dp[i][j].sec = dp[i][j - 1].fir;
                }
            }
        }


        // 结果
        return dp[0][l - 1].fir - dp[0][l - 1].sec >= 0;


    }


    class Pair {

        int fir, sec;

        Pair(int fir, int sec) {
            this.fir = fir;
            this.sec = sec;
        }
    }

}































































