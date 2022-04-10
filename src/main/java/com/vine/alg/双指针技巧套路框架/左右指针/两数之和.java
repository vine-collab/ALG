package com.vine.alg.双指针技巧套路框架.左右指针;

import com.alibaba.fastjson.JSON;

/**
 * @author 阿季
 * @date 2022-04-10 10:24 AM
 */

public class 两数之和 {
    public static void main(String[] args) {
        两数之和 l = new 两数之和();
        int[] ints = l.twoSums(new int[]{2, 7, 11, 15}, 13);
        System.out.println(JSON.toJSONString(ints));
    }


    /*
        一个升序排了的数组，找出nums[i] + nums[j] = target, 返回i，j
     */
    int[] twoSums(int[] nums, int target) {

        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int sum = nums[left] + nums[right];
            if (target == sum) {
                return new int[]{left, right};
            } else if (target > sum) {
                left++;
            } else {
                right--;
            }
        }


        return new int[]{-1, -1};
    }


}
