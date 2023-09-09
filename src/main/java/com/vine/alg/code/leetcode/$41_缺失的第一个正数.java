package com.vine.alg.code.leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * @author 阿季
 * @date 2023-09-06 8:39 PM
 */

public class $41_缺失的第一个正数 {

    public static void main(String[] args) {
        $41_缺失的第一个正数 z = new $41_缺失的第一个正数();

    }

    /**
     * https://leetcode.cn/problems/first-missing-positive/
     */
    public int firstMissingPositive(int[] nums) {
        int length = nums.length;
        Set<Integer> set = new HashSet<>();
        for(int num : nums) {
            set.add(num);
        }

        for(int i = 1; i <= length; i++) {
            if(!set.contains(i)) {
                return i;
            }
        }
        return length + 1;
    }


}
