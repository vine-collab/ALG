package com.vine.alg.code.leetcode;

import com.vine.alg.基本数据结构构造.Utils;
import sun.util.resources.es.CurrencyNames_es_UY;

/**
 * @author 阿季
 * @date 2022-09-08 9:27 PM
 */

public class $560_和为K的子数组 {


    /**
     * 给你一个整数数组 nums 和一个整数k ，请你统计并返回 该数组中和为k的连续子数组的个数。
     * <p>
     * 示例 1：
     * <p>
     * 输入：nums = [1,1,1], k = 2
     * 输出：2
     * 示例 2：
     * <p>
     * 输入：nums = [1,2,3], k = 3
     * 输出：2
     * <p>
     * 链接：https://leetcode.cn/problems/subarray-sum-equals-k
     */
    public static void main(String[] args) {
        $560_和为K的子数组 h = new $560_和为K的子数组();
        int i = h.subarraySum(Utils.splitToIntArr1("1,1,1"), 2);
        System.out.println(i);

    }


    /**
     * 不能用滑动窗口，数组会有负数
     */
    public int subarraySum(int[] nums, int k) {
        int[] preSum = new int[nums.length + 1];
        for (int i = 0; i < nums.length; i++) {
            preSum[i + 1] = nums[i] + preSum[i];
        }
        int count = 0;

        for (int i = 0; i < nums.length; i++) {
            for (int j = i; j < nums.length; j++) {
                if (preSum[j + 1] - preSum[i] == k) {
                    count++;
                }

            }

        }
        return count;

    }

}































































