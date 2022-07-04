package com.vine.alg.leet.leetcode;

import com.vine.alg.差分数组.Difference;

import static com.sun.tools.doclint.Entity.sum;

/**
 * @author 阿季
 * @date 2022-07-04 8:46 AM
 */

public class $370_区间加法 {

    public static void main(String[] args) {
        $370_区间加法 q = new $370_区间加法();

    }

    int[] getModifiedArray(int length, int[][] updates) {
        // nums 初始化为全 0
        int[] nums = new int[length];

        Difference diff = new Difference(nums);

        for (int[] update : updates) {
            int start = update[0];
            int end = update[1];
            int val = update[2];
            diff.increment(start, end, val);
        }
        return diff.result();
    }

}
