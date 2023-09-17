package com.vine.alg.code.leetcode;

import com.vine.alg.基本数据结构构造.Utils;

import java.util.HashSet;
import java.util.Set;

/**
 * @author 阿季
 * @date 2023-09-06 8:39 PM
 */

public class $41_缺失的第一个正数 {

    public static void main(String[] args) {
        $41_缺失的第一个正数 z = new $41_缺失的第一个正数();
        int i = z.firstMissingPositive1(Utils.splitToIntArr1("0"));
        Utils.printf(i);
    }

    /**
     * https://leetcode.cn/problems/first-missing-positive/
     * <p>
     * 缺失的第一个正数一定在 1-n+1 之间
     */
    public int firstMissingPositive(int[] nums) {
        int length = nums.length;
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }

        for (int i = 1; i <= length; i++) {
            if (!set.contains(i)) {
                return i;
            }
        }
        return length + 1;
    }

    public int firstMissingPositive1(int[] nums) {
        int x = Integer.MAX_VALUE;
        for (int num : nums) {
            if (num == 1) {
                x = 1;
                break;
            }
        }

        if (x != 1) {
            return 1;
        }

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] <= 0 || nums[i] > nums.length) {
                nums[i] = 1;
            }
        }

        for (int i = 0; i < nums.length; i++) {
            int num = Math.abs(nums[i]) - 1;
            nums[num] = -Math.abs(nums[num]);
        }

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                return i + 1;
            }
        }
        return nums.length + 1;

    }


}
