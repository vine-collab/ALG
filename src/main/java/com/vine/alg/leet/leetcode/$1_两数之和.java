package com.vine.alg.leet.leetcode;

import com.alibaba.fastjson.JSON;

import java.util.Arrays;
import java.util.HashMap;

/**
 * @author 阿季
 * @date 2022-07-23 9:40 PM
 */

public class $1_两数之和 {

    /**
     * 给定一个整数数组 nums和一个整数目标值 target，请你在该数组中找出 和为目标值 target 的那两个整数，并返回它们的数组下标。
     * <p>
     * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现。
     * <p>
     * 你可以按任意顺序返回答案。
     * <p>
     * 示例 1：
     * <p>
     * 输入：nums = [2,7,11,15], target = 9
     * 输出：[0,1]
     * 解释：因为 nums[0] + nums[1] == 9 ，返回 [0, 1] 。
     * 示例 2：
     * <p>
     * 输入：nums = [3,2,4], target = 6
     * 输出：[1,2]
     * 示例 3：
     * <p>
     * 输入：nums = [3,3], target = 6
     * 输出：[0,1]
     * <p>
     * 链接：https://leetcode.cn/problems/two-sum
     */
    public static void main(String[] args) {
        $1_两数之和 l = new $1_两数之和();
        int[] ints = {2, 7, 11, 15};

        int[] ints1 = l.twoSum(ints, 9);
        System.out.println(JSON.toJSONString(ints1));
    }


    public int[] twoSum(int[] nums, int target) {
        // 维护 val -> index 的映射
        HashMap<Integer, Integer> valToIndex = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            // 查表，看看是否有能和 nums[i] 凑出 target 的元素
            int need = target - nums[i];
            if (valToIndex.containsKey(need)) {
                return new int[]{valToIndex.get(need), i};
            }
            // 存入 val -> index 的映射
            valToIndex.put(nums[i], i);
        }
        return null;

    }


}































































