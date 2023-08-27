package com.vine.alg.code.leetcode;

import com.vine.alg.基本数据结构构造.Utils;

import java.util.Arrays;

/**
 * @author 阿季
 * @date 2022-08-24 8:12 PM
 */

public class $152_乘积最大子数组 {


    /**
     * 给你一个整数数组 nums，请你找出数组中乘积最大的非空连续子数组（该子数组中至少包含一个数字），并返回该子数组所对应的乘积。
     * 测试用例的答案是一个32-位 整数。
     * 子数组 是数组的连续子序列。
     * <p>
     * 示例 1:
     * <p>
     * 输入: nums = [2,3,-2,4]
     * 输出: 6
     * 解释:子数组 [2,3] 有最大乘积 6。
     * 示例 2:
     * <p>
     * 输入: nums = [-2,0,-1]
     * 输出: 0
     * 解释:结果不能为 2, 因为 [-2,-1] 不是子数组。
     * <p>
     * <p>
     * 链接：https://leetcode.cn/problems/maximum-product-subarray
     */
    public static void main(String[] args) {
        $152_乘积最大子数组 c = new $152_乘积最大子数组();
        int i = c.maxProduct1(Utils.splitToIntArr1("2,3,-2,4"));
        System.out.println(i);

    }


    /**
     * nums[i] 结尾的 乘积最大子数组为dp[i]
     */
    public int maxProduct(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        dp[0] = nums[0];
        for (int i = 0; i < n; i++) {
            int max = nums[i];
            int r = nums[i];
            for (int j = i - 1; j >= 0; j--) {
                r = r * nums[j];
                max = Math.max(max, r);
            }
            dp[i] = max;
        }

        return Arrays.stream(dp).max().getAsInt();

    }


    public int maxProduct1(int[] nums) {
        int n = nums.length;
        int max = nums[0], min = nums[0], res = nums[0];
        for (int i = 1; i < n; i++) {
            int mx = max, mn = min;
            max = Math.max(mx * nums[i], Math.max(nums[i], mn * nums[i]));
            min = Math.min(mn * nums[i], Math.min(nums[i], mx * nums[i]));
            res = Math.max(max, res);

        }

        return res;
    }
}































































