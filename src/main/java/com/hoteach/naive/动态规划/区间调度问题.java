package com.hoteach.naive.动态规划;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author 阿季
 * @date 2021-05-21 17:44
 */

public class 区间调度问题 {

    /**
     * 给你很多形如[start,end]的闭区间，请你设计一个算法，算出这些区间中最多有几个互不相交的区间。
     * @param intvs
     * @return
     */
    public int intervalSchedule(int[][] intvs) {
        if (intvs.length == 0) {
            return 0;
        }
        Arrays.sort(intvs, Comparator.comparingInt(o -> o[1]));

        int count = 1;
        int end = intvs[0][1];
        for (int[] intv : intvs) {
            int start = intv[0];
            if (start >= end) {
                count++;
                end = intv[1];
            }

        }


        return count;
    }


    public static void main(String[] args) {
        区间调度问题 c = new 区间调度问题();
        int[][] ints = {{1, 3}, {2, 4}, {3, 6}};
        int i = c.intervalSchedule(ints);
        System.out.println(i);
    }
}
