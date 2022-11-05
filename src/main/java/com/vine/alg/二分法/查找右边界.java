package com.vine.alg.二分法;

import com.vine.alg.基本数据结构构造.Utils;

import java.time.chrono.MinguoChronology;

/**
 * @author 阿季
 * @date 2022-11-05 4:35 PM
 */

public class 查找右边界 {

    public static void main(String[] args) {
        查找右边界 c = new 查找右边界();
        int i = c.right_bound(Utils.splitToIntArr1("1,2,3,3,4"), 5);
        System.out.println(i);
        int i1 = c.right_bound2(Utils.splitToIntArr1("1,2,3,3,4"), 5);
        System.out.println(i1);
    }

    int right_bound(int[] nums, int target) {
        int left = 0, right = nums.length;
        while (left < right) {
            int mid = left + (right - left) / 2;
            int m = nums[mid];
            if (m == target) {
                left = mid + 1;
            } else if (m > target) {
                right = mid;
            } else {
                left = mid + 1;

            }
        }
//        return left - 1;

        if (left == 0) {
            return -1;
        }
        return nums[left - 1] == target ? left - 1 : -1;
    }


    int right_bound2(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int m = nums[mid];
            if (m == target) {
                left = mid + 1;
            } else if (m > target) {
                right = mid - 1;
            } else {
                left = mid + 1;

            }
        }
//        return left - 1;

        if (right < 0 || nums[right] != target) {
            return -1;
        }
        return right;

    }

}































































