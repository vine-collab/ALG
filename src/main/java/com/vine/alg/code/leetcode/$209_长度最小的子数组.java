package com.vine.alg.code.leetcode;

/**
 * @author 阿季
 * @date 2022-05-21 12:13 PM
 */

public class $209_长度最小的子数组 {


    /**
     * 给定一个含有n个正整数的数组和一个正整数 target 。
     * <p>
     * 找出该数组中满足其和 ≥ target 的长度最小的 连续子数组[numsl, numsl+1, ..., numsr-1, numsr]
     * ，并返回其长度。如果不存在符合条件的子数组，返回 0 。
     * <p>
     * 示例 1：
     * 输入：target = 7, nums = [2,3,1,2,4,3]
     * <p>
     * 输出：2
     * 解释：子数组[4,3]是该条件下的长度最小的子数组。
     * <p>
     * 示例 2：
     * 输入：target = 4, nums = [1,4,4]
     * 输出：1
     * <p>
     * 示例 3：
     * 输入：target = 11, nums = [1,1,1,1,1,1,1,1]
     * 输出：0
     * <p>
     * 链接：https://leetcode.cn/problems/minimum-size-subarray-sum
     */
    public static void main(String[] args) {
        $209_长度最小的子数组 z = new $209_长度最小的子数组();
        int i = z.minSubArrayLen(15, new int[]{1,2,3,4,5});
        System.out.println(i);
    }

    public int minSubArrayLen(int target, int[] nums) {
        int left = 0, right = 0, sum = 0, res = Integer.MAX_VALUE;

        while (right < nums.length) {
            sum += nums[right];
            right++;

            while (sum >= target) {
                res = Integer.min(res, right - left);
                sum -= nums[left];
                left++;
            }

        }


        return res == Integer.MAX_VALUE ? 0 : res;


    }


}
