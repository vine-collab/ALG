package com.hoteach.naive.动态规划;

/**
 * @author 阿季
 * @date 2021-05-23 18:26
 */

public class 四键键盘 {


    int maxA(int n) {
        return dp(n, 0, 0);
    }

    /**
     * 状态3中:按了a,按了ctrl+v,按了 ctrl+a ctrl+c
     * 选择：a, ctrl+a, ctrl+c, ctrl+v
     *
     * @param n
     * @param a
     * @param copy
     * @return
     */
    int dp(int n, int a, int copy) {
        if (n <= 0) {
            return a;
        }

        // 按了a
        int dp = dp(n - 1, a + 1, copy);
        // 按了ctrl+v
        int dp1 = dp(n - 1, a + copy, copy);

        // 按了 ctrl+a ctrl+c
        int dp2 = dp(n - 2, a, a);
        return Math.max(Math.max(dp, dp1), dp2);

    }


    public int maxA2(int n) {
        int[] dp = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            dp[i] = dp[i - 1] + 1;
            for (int j = 2; j < i; j++) {
                dp[i] = Math.max(dp[i], dp[j - 2] * (i - j + 1));
            }
        }
        return dp[n];
    }


    public static void main(String[] args) {
        四键键盘 c = new 四键键盘();
        int i = c.maxA(7);
        System.out.println(i);
        int i1 = c.maxA2(7);
        System.out.println(i1);
    }
}
