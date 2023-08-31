package com.vine.alg.code.leetcode;

import com.vine.alg.基本数据结构构造.Utils;

import java.util.Arrays;
import java.util.LinkedList;

public class $57_插入区间 {

    public static void main(String[] args) {
        $57_插入区间 z = new $57_插入区间();
        int[][] insert = z.insert(Utils.toIntArr2("[[1,5]]"), Utils.toIntArr1("[2,7]"));
        Utils.printf(insert);
    }

    /**
     * https://leetcode.cn/problems/insert-interval/description/
     */
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int[][] ints = new int[intervals.length + 1][2];
        for (int i = 0; i < intervals.length; i++) {
            ints[i] = intervals[i];
        }
        ints[intervals.length] = newInterval;

        Arrays.sort(ints, (a, b) -> a[0] - b[0]);

        LinkedList<int[]> list = new LinkedList<>();
        list.addLast(ints[0]);
        for(int i = 1; i < ints.length; i++) {
            int[] last = list.getLast();
            int[] cur = ints[i];
            if(last[1] >= cur[0]) {
                last[1] = Math.max(cur[1], last[1]);
            } else {
                list.addLast(cur);
            }
        }
        return list.toArray(new int[0][0]);
    }
}
