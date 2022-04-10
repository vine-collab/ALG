package com.vine.alg.双指针技巧套路框架.二分搜索算法框架;

/**
 * @author 阿季
 * @date 2022-04-10 3:45 PM
 */

public class 寻找右侧边界 {
    public static void main(String[] args) {
        寻找右侧边界 x = new 寻找右侧边界();
        int[] nums = {1, 2, 2, 4, 11, 15};
        int i = x.searchRightBound(nums, 15);
        System.out.println(i);



        int i2 = x.searchRightBound2(nums, 15);
        System.out.println(i2);

    }

    /*
        返回结果可以理解为：代表数组中大于于 target 的数有多少个
     */
    int rightBound(int[] nums, int target) {

        int left = 0;
        int right = nums.length;
        while (left < right) { // 注意：搜索区间[left, right)
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                left = mid + 1; // [mid + 1, right) , 由于 mid + 1 所以可以搜索右边界
            } else if (nums[mid] < target) {
                left = mid + 1; // [mid + 1, right)
            } else if (nums[mid] > target) {
                right = mid; // [left, mid)
            }
        }
        return left - 1; // 注意：因为 left = mid + 1
    }


    int rightBound2(int[] nums, int target) {

        int left = 0;
        int right = nums.length - 1;
        while (left <= right) { // 注意：搜索区间[left, right]
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                left = mid + 1; // 收缩左边界 [mid + 1, right]
            } else if (nums[mid] < target) {
                left = mid + 1;  // 搜索区间[mid + 1, right]
            } else if (nums[mid] > target) {
                right = mid - 1; // 搜索区间[left, right - 1]
            }
        }
        return right;
    }

    int searchRightBound2(int[] nums, int target) {
        int rightBound = rightBound2(nums, target);
        if (rightBound < 0) {
            return -1;
        }

        return nums[rightBound] == target ? rightBound : -1;

    }


    int searchRightBound(int[] nums, int target) {
        int rightBound = rightBound(nums, target);
        if (rightBound < 0) {
            return -1;
        }

        return nums[rightBound] == target ? rightBound : -1;

    }


}
























