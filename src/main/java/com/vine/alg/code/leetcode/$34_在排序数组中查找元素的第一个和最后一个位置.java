package com.vine.alg.code.leetcode;

import com.alibaba.fastjson.JSON;

/**
 * @author 阿季
 * @date 2022-05-04 3:34 PM
 */

public class $34_在排序数组中查找元素的第一个和最后一个位置 {

    /*
    34. 在排序数组中查找元素的第一个和最后一个位置
    给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。

    如果数组中不存在目标值 target，返回 [-1, -1]。

    进阶：
    你可以设计并实现时间复杂度为 O(log n) 的算法解决此问题吗？

    示例 1：

    输入：nums = [5,7,7,8,8,10], target = 8
    输出：[3,4]
    示例 2：

    输入：nums = [5,7,7,8,8,10], target = 6
    输出：[-1,-1]
    示例 3：

    输入：nums = [], target = 0
    输出：[-1,-1]
     */
    public static void main(String[] args) {
        $34_在排序数组中查找元素的第一个和最后一个位置 z = new $34_在排序数组中查找元素的第一个和最后一个位置();
        int[] ints = z.searchRange1(new int[]{5}, 5);
        System.out.println(JSON.toJSONString(ints));
    }

    public int[] searchRange(int[] nums, int target) {

        if (nums.length == 1 && nums[0] == target) {
            return new int[]{0, 0};
        }


        int left = 0, right = nums.length - 1;

        while (left <= right) {
            int middle = left + (right - left) / 2;
            int m = nums[middle];
            if (m > target) {
                right = middle - 1;
            } else if (m < target) {
                left = middle + 1;
            } else {
                right = middle - 1;
            }
        }
        if (left >= nums.length || nums[left] != target) {
            left = -1;
        }
        if (left != -1) {
            int second = left;
            for (int i = left + 1; i < nums.length; i++) {
                if (nums[left] == nums[i]) {
                    second = Integer.max(second, i);
                }
            }
            return new int[]{left, second};
        } else {
            return new int[]{-1, -1};
        }
    }


    public int[] searchRange1(int[] nums, int target) {

        if (nums.length == 1 && nums[0] == target) {
            return new int[]{0, 0};
        }

        int left = 0, right = nums.length;

        while (left < right) {
            int m = left + (right - left) / 2;
            int mid = nums[m];
            if (mid == target) {
                right = m;
            } else if (mid > target) {
                right = m;
            } else {
                left = m + 1;
            }
        }
        if (left >= nums.length || nums[left] != target) {
            return new int[]{-1, -1};
        }
        int r = left;
        for (int i = left; i < nums.length; i++) {
            if (nums[i] == nums[left]) {
                r = Integer.max(i, r);
            }
        }
        return new int[]{left, r};

    }


}















