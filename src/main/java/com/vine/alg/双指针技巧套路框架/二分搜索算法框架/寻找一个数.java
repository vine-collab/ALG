package com.vine.alg.双指针技巧套路框架.二分搜索算法框架;

/**
 * @author 阿季
 * @date 2022-04-10 11:27 AM
 */

public class 寻找一个数 {

    public static void main(String[] args) {
        寻找一个数 x = new 寻找一个数();
        int[] nums = {2, 7, 0, 11, 15};
        int i = x.binarySearch(nums, 101);
        System.out.println(i);
    }

    int binarySearch(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else if (nums[mid] < target) {
                left = mid + 1;
            }

        }
        return -1;
    }


}
