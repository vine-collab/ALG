package com.hoteach.naive.leetcode;

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


    public int findNumberOfLIS1(int[] nums) {
        // 以nums[i]结尾的最长递增子序列长度为dp[i]
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);
        // 以nums[i]结尾的最长递增子序列的个数为dp[i]
        int[] count = new int[nums.length];
        Arrays.fill(count, 1);

        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                    int dpi = dp[i];
                    int dpj = dp[j];

                    if (dpj + 1 > dpi) {
                        count[i] = count[i]++;
                    }
                }
            }
        }


        return count[1];
    }


    public static void main(String[] args) {
        最长递增子序列的个数 c = new 最长递增子序列的个数();
        int numberOfLIS = c.findNumberOfLIS(new int[]{2, 2, 2, 2, 2});
        System.out.println(numberOfLIS);
        int a = c.findNumberOfLIS1(new int[]{1, 3, 5, 4, 7});
        System.out.println(a);

    }


}

















