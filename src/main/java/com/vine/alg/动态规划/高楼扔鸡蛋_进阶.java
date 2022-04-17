package com.vine.alg.动态规划;

/**
 * @author 阿季
 * @date 2022-04-17 11:06 AM
 */

public class 高楼扔鸡蛋_进阶 {
    public static void main(String[] args) {
        try {
            高楼扔鸡蛋_进阶 b = new 高楼扔鸡蛋_进阶();
            int i = b.superEggDrop(5, 10);
            System.out.println(i);
            int i2 = b.superEggDrop2(5, 10);
            System.out.println(i2);
            int i3 = b.superEggDrop3(5, 10);
            System.out.println(i3);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }


    /*
        k个鸡蛋，n层楼，最坏情况下，最少扔几次鸡蛋确定F楼层，0=<F<=n， 高于f的都会碎，低于f的不碎
        状态：鸡蛋碎不碎
        选择：去哪层楼扔鸡蛋
        出口：n = 0，不用扔；k == 1，挨个楼层去扔

     */
    int superEggDrop(int k, int n) {
        if (n == 0) {
            return 0;
        }
        if (k == 1) {
            return n;
        }
        // 从第一层开始
        int res = Integer.MAX_VALUE;
        for (int i = 1; i <= n; i++) {

            // 最坏情况下，取两者最大 // 在第i楼扔了一次
            int maxi = Integer.max(superEggDrop(k - 1, i - 1), // 碎 从i下面楼层开始扔
                    superEggDrop(k, n - i) // 没碎 从i上面楼层开始扔
            ) + 1;

            // 最少扔鸡蛋次数
            res = Integer.min(res, maxi);
        }


        return res;
    }


    /*
        用二分法降低搜索复杂度
     */

    int superEggDrop2(int K, int N) {
        if (N == 0) {
            return 0;
        }

        if (K == 1) {
            return N;
        }

        int res = Integer.MAX_VALUE;
        int lo = 1, hi = N;
        while (lo <= hi) { // 种植条件是<=
            int mid = (lo + hi) / 2;
            // 碎了
            int broken = superEggDrop2(K - 1, mid - 1);
            // 没有碎
            int nonBroken = superEggDrop2(K, N - mid);
            if (broken > nonBroken) {
                hi = mid - 1;
                res = Integer.min(res, broken + 1);
            } else {
                lo = mid + 1;
                res = Integer.min(res, nonBroken + 1);
            }
        }
        return res;
    }


    /*
        dp[K][m] = N
        表示K个鸡蛋扔m次能达到的层高N，结果取m的值
     */
    int superEggDrop3(int K, int N) {
        int[][] dp = new int[K + 1][N + 1];
        int m = 0;
        while (dp[K][m] < N) {
            m++;
            for (int k = 1; k <= K; k++) {
                dp[k][m] = dp[k][m - 1] + dp[k - 1][m - 1] + 1;

            }
        }
        return m;
    }


}













