package com.vine.alg.双指针技巧套路框架.左右指针;

import com.alibaba.fastjson.JSON;

/**
 * @author 阿季
 * @date 2022-04-10 10:32 AM
 */

public class 数组翻转 {


    public static void main(String[] args) {
        数组翻转 s = new 数组翻转();
        int[] nums = {2, 7, 0, 11, 15};
        s.reverse(nums);
        System.out.println(JSON.toJSONString(nums));

    }

    void reverse(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;
            left++;
            right--;
        }

    }

}
