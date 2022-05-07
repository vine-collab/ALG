package com.vine.naive.leetcode;

import com.alibaba.fastjson.JSON;

import java.lang.annotation.Target;
import java.lang.reflect.WildcardType;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author 阿季
 * @date 2022-05-06 9:53 PM
 */

public class $15_三数之和 {


    /*
    https://leetcode-cn.com/problems/3sum/
    15. 三数之和
    给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有和为 0 且不重复的三元组。
    注意：答案中不可以包含重复的三元组。
    示例 1：
    输入：nums = [-1,0,1,2,-1,-4]
    输出：[[-1,-1,2],[-1,0,1]]

    示例 2：
    输入：nums = []
    输出：[]

    示例 3：
    输入：nums = [0]
    输出：[]

    提示：

    */
    public static void main(String[] args) {
        $15_三数之和 s = new $15_三数之和();
        int[] ints = {-1, 0, 1, 2, -1, -4};
        Arrays.sort(ints);
        List<List<Integer>> lists = s.threeSum(ints);
        System.out.println(JSON.toJSONString(lists));
    }

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length < 3) {
            return new ArrayList<>();
        }
        for (int i = 0; i < nums.length; i++) {
            List<List<Integer>> list = twoSum(nums, i + 1, -nums[i]);
            for (List<Integer> integers : list) {
                List<Integer> copy = new ArrayList<>(integers);
                copy.add(nums[i]);
                res.add(copy);
            }
            while (i < nums.length - 1 && nums[i] == nums[i + 1]) {
                i++;
            }
        }
        return res;
    }


    List<List<Integer>> twoSum(int[] nums, int start, int target) {
        int left = start, right = nums.length - 1;
        List<List<Integer>> res = new ArrayList<>();
        while (left < right) {
            int l = nums[left], r = nums[right];
            int sum = l + r;
            if (target > sum) {
                while (left < right && nums[right] == r) {
                    right--;
                }
            } else if (target < sum) {
                while (left < right && nums[left] == l) {
                    left++;
                }
            } else {
                res.add(Arrays.asList(nums[left], nums[right]));
                while (left < right && nums[right] == r) {
                    right--;
                }
                while (left < right && nums[left] == l) {
                    left++;
                }
            }
        }
        return res;
    }


}
