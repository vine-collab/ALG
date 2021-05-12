package com.hoteach.naive;

import java.util.Arrays;

/**
 * nsum问题
 *
 * @author 阿季
 * @date 2021-05-12 15:37
 */

public class NSum {


    public int[] twoSum(int[] nums, Integer target) {

        Arrays.sort(nums);

        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int sum = nums[left] + nums[right];
            if (sum == target) {
                return new int[]{nums[left], nums[right]};
            }
            if (sum > target) {
                right--;
            }

            if (sum < target) {
                left++;
            }

        }

        return new int[]{};
    }


    public static void main(String[] args) {
        NSum nSum = new NSum();
        int[] nums = {5, 3, 1, 6};
        int target = 9;
        int[] ints = nSum.twoSum(nums, target);
        System.out.println(Arrays.toString(ints));
    }

}
