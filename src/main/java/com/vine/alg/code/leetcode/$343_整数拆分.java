package com.vine.alg.code.leetcode;

/**
 * @author 阿季
 * @date 2022-06-26 8:52 PM
 */

public class $343_整数拆分 {


    /**
     * 给定一个正整数n，将其拆分为 k 个 正整数 的和（k >= 2），并使这些整数的乘积最大化。
     * <p>
     * 返回 你可以获得的最大乘积。
     * <p>
     * 示例 1:
     * <p>
     * 输入: n = 2
     * 输出: 1
     * 解释: 2 = 1 + 1, 1 × 1 = 1。
     * 示例2:
     * <p>
     * 输入: n = 10
     * 输出: 36
     * 解释: 10 = 3 + 3 + 4, 3 ×3 ×4 = 36。
     * <p>
     * <p>
     * 链接：https://leetcode.cn/problems/integer-break
     */
    public static void main(String[] args) {
        $343_整数拆分 z = new $343_整数拆分();
        int i = z.integerBreak(10);
        System.out.println(i);
    }


    // dp表示把i拆成至少两个数的最大乘积
    // dp[0] = dp[1] = 0
    public int integerBreak(int n) {
        int[] dp = new int[n + 1];
        for (int i = 2; i <= n; i++) {
            int curMax = 0;
            for (int j = 1; j < i; j++) {
                //              上一轮最大值，i拆掉j后不能再拆了，   拆掉j之后可以继续拆
                curMax = Math.max(curMax, Math.max(j * (i - j), j * dp[i - j]));
            }
            dp[i] = curMax;
        }
        return dp[n];

    }

}
