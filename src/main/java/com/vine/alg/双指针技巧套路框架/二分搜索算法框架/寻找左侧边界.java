package com.vine.alg.双指针技巧套路框架.二分搜索算法框架;

import java.lang.annotation.Target;

/**
 * @author 阿季
 * @date 2022-04-10 3:45 PM
 */

public class 寻找左侧边界 {
    public static void main(String[] args) {
        寻找左侧边界 x = new 寻找左侧边界();
        int[] nums = {1, 2, 2, 4, 11, 15};
        int i = x.searchLeftBound(nums, 5);


        System.out.println(i);
    }

    /*
        返回结果可以理解为：代表数组中小于 target 的数有多少个
     */
    int leftBound(int[] nums, int target) {

        int left = 0;
        int right = nums.length;
        while (left < right) { // 注意
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                right = mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid; // 注意
            }
        }
        return left;
    }


    int searchLeftBound(int[] nums, int target) {
        int i = leftBound(nums, target);
        if (i == nums.length) {
            return -1;
        }

        return nums[i] == target ? i : -1;

    }


}
























