package com.hoteach.naive.动态规划;

/**
 * @author 阿季
 * @date 2021-05-23 14:59
 */

public class 高楼扔鸡蛋 {



    int superEggDrop(int k, int n) {


        return 0;
    }

    int dp(int k, int n) {
        if (n == 0) {
            return 0;
        }
        if (k == 1) {
            return n;
        }
        int res = Integer.MAX_VALUE;
        for (int i = 1; i <= n; i++) {
            // 碎了
            int dp1 = dp(k - 1, i - 1);
            // 没碎
            int dp2 = dp(k, n - i);
            // 在第i楼扔了一次
            int i1 = Math.max(dp1, dp2) + 1;



            res = Math.min(res, i1);

        }
        return res;
    }


    public static void main(String[] args) {
        高楼扔鸡蛋 c = new 高楼扔鸡蛋();
        int dp = c.dp(5, 10);
        System.out.println(dp);
    }

}
