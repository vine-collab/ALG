package com.hoteach.naive;

import com.alibaba.fastjson.JSON;
import com.google.common.collect.Lists;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * nsum问题
 *
 * @author 阿季
 * @date 2021-05-12 15:37
 */

public class NSum {


    public int[] twoSum(int[] nums, Integer target) {

        Arrays.sort(nums);

        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int sum = nums[left] + nums[right];
            if (sum == target) {
                return new int[]{nums[left], nums[right]};
            }
            if (sum > target) {
                right--;
            }

            if (sum < target) {
                left++;
            }
        }
        return new int[]{};
    }

    public List<List<Integer>> twoSums(int[] nums, Integer target) {

        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        int pointLeft = 0;
        int pointRight = nums.length - 1;

        while (pointLeft < pointRight) {
            int left = nums[pointLeft];
            int right = nums[pointRight];
            int sum = nums[pointLeft] + nums[pointRight];
            if (sum == target) {
                result.add(Lists.newArrayList(nums[pointLeft], nums[pointRight]));
                while (pointLeft < pointRight && nums[pointLeft] == left) {
                    pointLeft++;
                }
                while (pointLeft < pointRight && nums[pointRight] == right) {
                    pointRight--;
                }
            }
            if (sum > target) {
                pointRight--;
            }

            if (sum < target) {
                pointLeft++;
            }
        }
        return result;
    }


    public static void main(String[] args) {
        NSum nSum = new NSum();
        int[] nums = {5, 3, 1, 6};
        int target = 9;
        int[] ints = nSum.twoSum(nums, target);
        System.out.println(Arrays.toString(ints));
        System.out.println("-------------------");
        nums = new int[]{9, 8, 8, 8, 0};
        target = 16;
        List<List<Integer>> pairs = nSum.twoSums(nums, target);
        System.out.println(JSON.toJSONString(pairs));


    }

}
