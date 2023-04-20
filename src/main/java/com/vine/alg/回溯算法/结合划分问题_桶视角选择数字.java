package com.vine.alg.回溯算法;

import com.vine.alg.基本数据结构构造.Utils;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author 阿季
 * @date 2023-04-20 8:44 PM
 */

public class 结合划分问题_桶视角选择数字 {

    public static void main(String[] args) {
        结合划分问题_桶视角选择数字 z = new 结合划分问题_桶视角选择数字();
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
        return backtrack(k, 0, 0, 0);

    }

    int[] nums;

    int target;

    Map<Integer, Boolean> memo = new HashMap<>();


    boolean backtrack(int k, int ksum, int start, int used) {

        if (k == 0) {
            return true;
        }

        if (ksum == target) {
            boolean res = backtrack(k - 1, 0, 0, used);
            memo.put(used, res);
            return res;
        }

        if (memo.containsKey(used)) {
            // 避免冗余计算
            return memo.get(used);
        }


        for (int i = start; i < nums.length; i++) {
            if (((used >> i) & 1) == 1 || ksum + nums[i] > target) {
                continue;
            }

            used |= 1 << i; // 将第 i 位置为 1
            ksum += nums[i];
            if (backtrack(k, ksum, start + 1, used)) {
                return true;
            }
            ksum -= nums[i];
            used ^= 1 << i; // 使用异或运算将第 i 位恢复 0

        }
        return false;

    }


    /**
     * @param k     桶个数
     * @param ksum  每个桶当前的和
     * @param start 有效开始的num下标
     * @param used  该数字是否被用
     * @return
     */
    boolean backtrack(int k, int ksum, int start, boolean[] used) {

        if (k == 0) {
            return true;
        }

        if (ksum == target) {
            return backtrack(k - 1, 0, 0, used);
        }

        for (int i = start; i < nums.length; i++) {
            if (used[i] || ksum + nums[i] > target) {
                continue;
            }

            used[i] = true;
            ksum += nums[i];
            if (backtrack(k, ksum, start + 1, used)) {
                return true;
            }
            ksum -= nums[i];
            used[i] = false;

        }
        return false;

    }

}































































