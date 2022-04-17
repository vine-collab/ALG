package com.vine.alg.动态规划;

import java.util.Arrays;

/**
 * @author 阿季
 * @date 2022-04-17 5:56 PM
 */

public class 子集背包问题 {
    public static void main(String[] args) {
        try {
            子集背包问题 b = new 子集背包问题();
            boolean dp = b.dp(new int[]{1, 5, 11, 5});
            System.out.println(dp);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    /*
        正整数的数组nums，判断能否分成两个子集，使得两个子集元素和相等
        转换为背包问题：
            容量为sum/2的背包，和n个物品，每个物品的容积为nums[i]， 求背包能不能装满

        选择：对于第i个物品装，不装
        状态：背包的容量，和可选物品
        dp[i][j] 表示：对于前i个物品，背包的容量为j时，能否装满
        base case：
        dp[0][j] == false;
        dp[i][0] == true; 背包没有空间的时候就相当于装满了
        状态转义方程：对于第i个物品，装 || 不装
        由于nums 下标从0开始， nums[i - 1]，表示第i个物品的重量
        dp[i][j] = dp[i - 1][j - nums[i - 1]] || dp[i - 1][j]
        要求的结果位于 dp[nums.length][sum / 2]
     */

    boolean dp(int[] nums) {
        int sum = Arrays.stream(nums).sum();
        if (sum % 2 != 0) {
            return false;
        }
        int n = nums.length;
        sum = sum / 2;

        Boolean[][] dp = new Boolean[n + 1][sum + 1];
        for (Boolean[] booleans : dp) {
            Arrays.fill(booleans, false);
        }

        for (int i = 0; i < dp.length; i++) {
            dp[i][0] = true;
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= sum; j++) {
                if (j - nums[i - 1] < 0) {
                    // 背包装不下
                    dp[i][j] = dp[i - 1][j];
                } else {
                    // 装 || 不装
                    // 判断是否存在一种情况正好装满

                    dp[i][j] = dp[i - 1][j - nums[i - 1]] || dp[i - 1][j];
                }
            }
        }

        return dp[n][sum];

    }


}
