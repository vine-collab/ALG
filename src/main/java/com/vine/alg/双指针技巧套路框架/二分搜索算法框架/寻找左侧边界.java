package com.vine.alg.双指针技巧套路框架.二分搜索算法框架;

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

        int i1 = x.leftBound(nums, 2);
        System.out.println(i1);

        int i2 = x.searchLeftBound2(nums, 2);
        System.out.println(i2);

    }

    /*
        返回结果可以理解为：代表数组中小于 target 的数有多少个
     */
    int leftBound(int[] nums, int target) {

        int left = 0;
        int right = nums.length;
        while (left < right) { // 注意：搜索区间[left, right)
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                right = mid; // 可以搜索左侧边界
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid; // 注意
            }
        }
        return left;
    }


    int leftBound2(int[] nums, int target) {

        int left = 0;
        int right = nums.length - 1;
        while (left <= right) { // 注意：搜索区间[left, right]
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                right = mid - 1; // 收缩右边界
            } else if (nums[mid] < target) {
                left = mid + 1;  // 搜索区间[mid + 1, right]
            } else if (nums[mid] > target) {
                right = mid - 1; // 搜索区间[left, right - 1]
            }
        }
        return left;
    }

    int searchLeftBound2(int[] nums, int target) {
        int i = leftBound2(nums, target);
        if (i >= nums.length) {
            return -1;
        }

        return nums[i] == target ? i : -1;

    }


    int searchLeftBound(int[] nums, int target) {
        int i = leftBound(nums, target);
        if (i == nums.length) {
            return -1;
        }

        return nums[i] == target ? i : -1;

    }


}
























