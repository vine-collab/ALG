package com.vine.alg.leetcode;

import java.util.Arrays;

/**
 * 区间问题
 *
 * @author 阿季
 * @date 2021-05-11 15:32
 */

public class Intervals {


    public int removeCoveredIntervals(int[][] intvs) {
        // 起点升序，终点降序
        Arrays.sort(intvs, (a, b) -> {
            if (a[0] == b[0]) {
                return b[1] - a[1];
            }
            return a[0] - b[0];
        });
        int left = intvs[0][0];
        int right = intvs[0][1];
        int res = 0;
        for (int i = 1; i < intvs.length; i++) {
            int[] intv = intvs[i];
            // 相交
            if (right >= intv[0] && right <= intv[1]) {
                right = intv[1];
            }
            // 覆盖
            if (left <= intv[0] && right >= intv[1]) {
                res++;
            }
            // 相离
            if (right < intv[0]) {
                left = intv[0];
                right = intv[1];
            }
        }
        return intvs.length - res;
    }


    public static void main(String[] args) {
        Intervals intervals = new Intervals();
        int[][] ints = {{1, 4}, {3, 6}, {2, 8}};
        int i = intervals.removeCoveredIntervals(ints);
        System.out.println(i);
    }

}
