package com.vine.alg.差分数组;

/**
 * @author 阿季
 * @date 2022-07-03 8:50 PM
 */

public class Difference {


    /**
     * 差分数组的主要适用场景是频繁对原始数组的某个区间的元素进行增减。
     */
    public Difference(int[] nums) {
        diff = new int[nums.length];
        diff[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            diff[i] = nums[i] - nums[i - 1];
        }

    }

    private int[] diff;

    public void increment(int i, int j, int val) {
        diff[i] += val;
        if (j + 1 < diff.length) {
            diff[j] -= val;
        }
    }

    public int[] result() {
        int[] result = new int[diff.length];

        result[0] = diff[0];
        for (int i = 1; i < diff.length; i++) {
            result[i] = result[i - 1] + diff[i];
        }
        
        return result;

    }


}