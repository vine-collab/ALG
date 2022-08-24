package com.vine.alg.code.topcode;

import com.vine.alg.基本数据结构构造.Utils;

/**
 * @author 阿季
 * @date 2022-08-23 9:50 PM
 */

public class $153_寻找旋转排序数组中的最小值 {

    public static void main(String[] args) {
        $153_寻找旋转排序数组中的最小值 x = new $153_寻找旋转排序数组中的最小值();
        int min = x.findMin(Utils.splitToIntArr1("4,5,6,7,0,1,2"));
        System.out.println(min);
    }

    public int findMin(int[] nums) {
        int left = 0, right = nums.length - 1;

        int min = Integer.MAX_VALUE;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            int mv = nums[mid];

            min = Math.min(min, mv);

            // 左边有序
            if (nums[left] <= mv) {
                min = Math.min(nums[left], min);
                left = mid + 1;
            }
            // 右边有序
            else {
                min = Math.min(nums[mid + 1], min);
                right = mid - 1;
            }

        }

        return min;

    }


}































































