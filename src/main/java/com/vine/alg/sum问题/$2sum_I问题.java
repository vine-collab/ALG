package com.vine.alg.sum问题;

import com.alibaba.fastjson.JSON;

import java.util.HashMap;
import java.util.Map;

/**
 * @author 阿季
 * @date 2022-05-03 4:37 PM
 */

public class $2sum_I问题 {





    /*
        1. 两数之和
        给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 target  的那 两个 整数，并返回它们的数组下标。

        你可以假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现。

        你可以按任意顺序返回答案。

        示例 1：

        输入：nums = [2,7,11,15], target = 9
        输出：[0,1]
        解释：因为 nums[0] + nums[1] == 9 ，返回 [0, 1] 。
        示例 2：

        输入：nums = [3,2,4], target = 6
        输出：[1,2]
        示例 3：

        输入：nums = [3,3], target = 6
        输出：[0,1]
     */

    public static void main(String[] args) {
        $2sum_I问题 sum问题 = new $2sum_I问题();
        int[] ints = sum问题.twoSum2(new int[]{3, 3}, 6);
        System.out.println(JSON.toJSONString(ints));
    }


    public int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        return new int[]{-1, -1};
    }

    public int[] twoSum2(int[] nums, int target) {
        Map<Integer, Integer> memo = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            memo.put(nums[i], i);
        }

        for (int i = 0; i < nums.length; i++) {
            int another = target - nums[i];
            if(memo.containsKey(another) && memo.get(another) != i) {
                return new int[]{i, memo.get(another)};
            }
        }
        return new int[]{-1, -1};
    }


}
