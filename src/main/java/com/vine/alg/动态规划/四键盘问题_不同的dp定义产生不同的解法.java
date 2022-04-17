package com.vine.alg.动态规划;

/**
 * @author 阿季
 * @date 2022-04-16 6:21 PM
 */

public class 四键盘问题_不同的dp定义产生不同的解法 {
    public static void main(String[] args) {
        try {
            四键盘问题_不同的dp定义产生不同的解法 z = new 四键盘问题_不同的dp定义产生不同的解法();
            int i = z.maxA(5);
            System.out.println(i);
            int i1 = z.dp(5);
            System.out.println(i1);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    int maxA(int N) {
        return method1(N, 0, 0);
    }

    /*
        随着敲击次数的变化，下列状态发生变化
        n:表示剩余敲击次数
        aNum：表示屏幕上a的个数
        copy：表示剪贴板上a的个数
        出口：n<=0
     */
    int method1(int n, int aNum, int copy) {

        if (n <= 0) {
            return aNum;
        }

        int a = method1(n - 1, aNum + 1, copy);
        int cv = method1(n - 1, aNum + copy, copy);
//        int ca = method1(n - 1, aNum, copy);
        int cc = method1(n - 2, aNum, aNum); // ca、cc必然一起使用


        return Integer.max(Integer.max(Integer.max(a, cv), Integer.MIN_VALUE), cc);
    }


    int dp(int N) {
        int[] dp = new int[N + 1];
        dp[0] = 0;

        for (int i = 1; i <= N; i++) {
            dp[i] = dp[i - 1] + 1;
            for (int j = 2; j < i; j++) {
                dp[i] = Integer.max(dp[i], dp[j - 2] * (i - j + 1));
            }
        }
        return dp[N];
    }


}













