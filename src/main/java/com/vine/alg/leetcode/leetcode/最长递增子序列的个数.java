package com.vine.alg.leetcode.leetcode;

import com.alibaba.fastjson.JSON;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author 673.最长递增子序列的个数
 * @date 2021-06-10 17:19
 */

public class 最长递增子序列的个数 {


    public int findNumberOfLIS(int[] nums) {

        backTrack(nums, new LinkedList<>(), 0);

        return result[1];
    }


    private int[] result = new int[2];


    public void backTrack(int[] nums, List<Integer> track, int start) {

        if (start == nums.length || !track.isEmpty()) {
            int length = result[0];
            int size = track.size();
            if (length == size) {
                result[1] = result[1] + 1;
            }
            if (length < size) {
                result[0] = size;
                result[1] = 1;
            }

        }

        for (int i = start; i < nums.length; i++) {
            if (!track.isEmpty() && nums[i] <= track.get(track.size() - 1)) {
                continue;
            }
            track.add(nums[i]);
            backTrack(nums, track, i + 1);
            track.remove(track.size() - 1);
        }

    }


    public int findNumberOfLISDp(int[] nums) {
        // 以nums[i]结尾的最长递增子序列长度为dp[i]
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);
        // nums[0...i]中的最长递增子序列的个数为count[i]
        int[] count = new int[nums.length];
        Arrays.fill(count, 1);


        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    if (dp[j] + 1 > dp[i]) {
                        dp[i] = dp[j] + 1;
                        count[i] = count[j];
                    } else if (dp[j] + 1 == dp[i]) {
                        count[i] += count[j];
                    }
                }
            }
        }


        System.out.println(JSON.toJSONString(dp));
        System.out.println(JSON.toJSONString(count));

        int dpMax = Arrays.stream(dp).max().getAsInt();
        int sum = 0;
        for (int i = 0; i < dp.length; i++) {
            if (dp[i] == dpMax) {
                sum += count[i];
            }
        }
        return sum;
    }


    public int test(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }

        int[] dp = new int[nums.length];
        int[] combination = new int[nums.length];

        Arrays.fill(dp, 1);
        Arrays.fill(combination, 1);

        int max = 1, res = 0;

        for (int i = 1; i < dp.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    if (dp[j] + 1 > dp[i]) { //如果+1长于当前LIS 则组合数不变
                        dp[i] = dp[j] + 1;
                        combination[i] = combination[j];
                    } else if (dp[j] + 1 == dp[i]) { //如果+1等于当前LIS 则说明找到了新组合
                        combination[i] += combination[j];
                    }
                }
            }
            max = Math.max(max, dp[i]);
        }

        for (int i = 0; i < nums.length; i++)
            if (dp[i] == max) res += combination[i];

        return res;
    }


    public static void main(String[] args) {
        最长递增子序列的个数 c = new 最长递增子序列的个数();
        // int numberOfLIS = c.findNumberOfLIS(new int[]{2, 2, 2, 2, 2});
        // System.out.println(numberOfLIS);
        int a = c.findNumberOfLISDp(new int[]{1, 2, 4, 3, 5, 4, 7, 2});
        System.out.println(a);

        int t = c.test(new int[]{1, 2, 4, 3, 5, 4, 7, 2});
        System.out.println(t);

    }


}

















