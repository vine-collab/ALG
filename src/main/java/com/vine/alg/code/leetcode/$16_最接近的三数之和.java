package com.vine.alg.code.leetcode;

import com.vine.alg.基本数据结构构造.Utils;

import java.util.Arrays;

/**
 * @author 阿季
 * @date 2023-09-19 7:56 AM
 */

public class $16_最接近的三数之和 {


    /**
     * https://leetcode.cn/problems/3sum-closest/
     * 给你一个长度为 n 的整数数组 nums 和 一个目标值 target。请你从 nums 中选出三个整数，使它们的和与 target 最接近。
     * 返回这三个数的和。
     * 假定每组输入只存在恰好一个解。
     * <p>
     * 示例 1：
     * <p>
     * 输入：nums = [-1,2,1,-4], target = 1
     * 输出：2
     * 解释：与 target 最接近的和是 2 (-1 + 2 + 1 = 2) 。
     * 示例 2：
     * <p>
     * 输入：nums = [0,0,0], target = 1
     * 输出：0
     */
    public static void main(String[] args) {
        $16_最接近的三数之和 z = new $16_最接近的三数之和();
        int i = z.threeSumClosest(Utils.splitToIntArr1("-1,2,1,-4"), 1);
        System.out.println(i);

    }


    public int threeSumClosest(int[] nums, int target) {
        if (nums.length < 3) {
            return 0;
        }
        Arrays.sort(nums);
        this.nums = nums;

        int delta = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            int tmp = nums[i] + twoSum(i + 1, target - nums[i]);
            if (Math.abs(delta) > Math.abs(target - tmp)) {
                delta = target - tmp;
            }
        }
        return target - delta;

    }

    int[] nums;

    /**
     * 在 nums[start..] 搜索最接近 target 的两数之和
     */
    int twoSum(int start, int target) {
        int left = start, right = nums.length - 1;
        // 记录两数之和与目标值的偏差
        int delta = Integer.MAX_VALUE;
        while (left < right) {
            int sum = nums[left] + nums[right];
            if (Math.abs(delta) > Math.abs(target - sum)) {
                delta = target - sum;
            }
            if (sum < target) {
                left++;
            } else {
                right--;
            }

        }

        return target - delta;


    }


}