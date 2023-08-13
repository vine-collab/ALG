package com.vine.alg.code.leetcode;

import java.util.Arrays;

/**
 * @author 阿季
 * @date 2023-08-13 17:43
 */

public class $1288_删除被覆盖区间 {

    public static void main(String[] args) {
        $1288_删除被覆盖区间 z = new $1288_删除被覆盖区间();
    }


    /**
     * 给你一个区间列表，请你删除列表中被其他区间所覆盖的区间。
     *
     * 只有当 c <= a 且 b <= d 时，我们才认为区间 [a,b) 被区间 [c,d) 覆盖。
     *
     * 在完成所有删除操作后，请你返回列表中剩余区间的数目。
     *
     *
     *
     * 示例：
     *
     * 输入：intervals = [[1,4],[3,6],[2,8]]
     * 输出：2
     * 解释：区间 [3,6] 被区间 [2,8] 覆盖，所以它被删除了。
     */

    public int removeCoveredIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> {
            if(a[0] == b[0]) {
                return b[1] - a[1];
            }
            return a[0] - b[0];
        });
        int left = intervals[0][0];
        int right = intervals[0][1];
        int res = 0;
        for(int i = 1; i < intervals.length; i++) {
            int[] interval = intervals[i];
            // 覆盖
            if(left <= interval[0] && right >= interval[1]) {
                res++;
            }
            //相交合并
            if(right >= interval[0] && right <= interval[1]) {
                right = interval[1];
            }
            // 相离
            if(right < interval[0]) {
                left = interval[0];
                right = interval[1];
            }

        }

        return intervals.length - res;

    }

}































































