package com.vine.alg.leetcode.动态规划;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author 阿季
 * @date 2021-05-23 16:05
 */

public class 戳气球问题 {

    public int maxCoins(int[] nums) {

        List<Integer> collect = Arrays.stream(nums).boxed().collect(Collectors.toList());

        backtrack(collect, 0);
        return 0;
    }

    int res = Integer.MIN_VALUE;

    void backtrack(List<Integer> nums, int score) {
        List<Integer> tempArr = new ArrayList<>(nums);
        if (tempArr.size() == 0) {
            res = Math.max(score, res);
            return;
        }

        for (int i = 0; i < tempArr.size(); i++) {
            int tempScore;
            if (i - 1 < 0 || i + 1 > tempArr.size()) {
                tempScore = tempArr.get(i);
            } else {
                tempScore = tempArr.get(i - 1) * tempArr.get(i) * tempArr.get(i + 1);
            }
            int temp = tempArr.get(i);
            List<Integer> integers = new ArrayList<>(tempArr);
            integers.remove(i);
            backtrack(integers, score + tempScore);
            integers.add(i, temp);
        }


    }


    int dp(int[] nums) {

        int[] ints = new int[nums.length + 2];
        ints[0] = 1;
        ints[nums.length + 1] = 1;
        System.arraycopy(nums, 0, ints, 1, nums.length);
        int[][] dp = new int[nums.length + 2][nums.length + 2];
        for (int i = nums.length; i >= 0; i--) {
            for (int j = i + 1; j < nums.length + 2; j++) {
                for (int k = i + 1; k < j; k++) {
                    dp[i][j] = Math.max(dp[i][j], dp[i][k] + dp[k][j] + ints[i] * ints[k] * ints[j]);
                }
            }

        }
        return dp[0][nums.length + 1];
    }


    public static void main(String[] args) {
        戳气球问题 c = new 戳气球问题();
        int i = c.dp(new int[]{3, 1, 5, 8});
        System.out.println(i);

    }

}
