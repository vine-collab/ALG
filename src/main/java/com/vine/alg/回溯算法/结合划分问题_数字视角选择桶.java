package com.vine.alg.回溯算法;

import com.vine.alg.基本数据结构构造.Utils;

import java.util.Arrays;

/**
 * @author 阿季
 * @date 2023-04-20 8:44 PM
 */

public class 结合划分问题_数字视角选择桶 {

    public static void main(String[] args) {
        结合划分问题_数字视角选择桶 z = new 结合划分问题_数字视角选择桶();
        boolean b = z.canPartitionKSubsets(Utils.splitToIntArr1("4, 3, 2, 3, 5, 2, 1"), 4);
        System.out.println(b);
    }


    // 以数字视角放到n个集合里面
    public boolean canPartitionKSubsets(int[] nums, int k) {

        if (k > nums.length) {
            return false;
        }

        int sum = Arrays.stream(nums).sum();
        if (sum % k != 0) {
            return false;
        }

        target = sum / k;
        this.nums = nums;
        return backtrack(0, new int[k]);

    }

    int[] nums;

    int target;


    boolean backtrack(int index, int[] bucket) {
        if (index == nums.length) {
            for (int b : bucket) {
                if (b != target) {
                    return false;
                }
            }
            return true;
        }

        for (int i = 0; i < bucket.length; i++) {
            if (bucket[i] + nums[index] > target) {
                continue;
            }

            bucket[i] += nums[index];
            if (backtrack(index + 1, bucket)) {
                return true;
            }
            bucket[i] -= nums[index];
        }


        return true;

    }

}































































