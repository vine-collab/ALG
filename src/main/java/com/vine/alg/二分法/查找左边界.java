package com.vine.alg.二分法;

import com.vine.alg.基本数据结构构造.Utils;

/**
 * @author 阿季
 * @date 2022-11-05 3:42 PM
 */

public class 查找左边界 {


    public static void main(String[] args) {
        查找左边界 c = new 查找左边界();
        int i = c.left_bound(Utils.splitToIntArr1("1,2,3,3,4"), 4);
        System.out.println(i);
        int i1 = c.left_bound2(Utils.splitToIntArr1("1,2,3,3,4"), 5);
        System.out.println(i1);

    }

    int left_bound(int[] nums, int target) {
        int left = 0, right = nums.length;

        while (left < right) {
            int mid = left + (right - left) / 2;
            int m = nums[mid];
            if (target == m) {
                right = mid;
            } else if (target < m) {
                right = mid;
            } else if (target > m) {
                left = mid + 1;
            }

        }
//        return left;
        if (left == nums.length || nums[left] != target) {
            return -1;
        }
        return left;
    }

    int left_bound2(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int m = nums[mid];
            if (target == m) {
                right = mid - 1;
            } else if (target > m) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }

        }
//        return left;
        if (left == nums.length || nums[left] != target) {
            return -1;
        }
        return left;

    }


}































































