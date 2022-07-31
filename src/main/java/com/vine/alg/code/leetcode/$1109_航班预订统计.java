package com.vine.alg.code.leetcode;

import com.vine.alg.差分数组.Difference;

/**
 * @author 阿季
 * @date 2022-07-04 7:58 PM
 */

public class $1109_航班预订统计 {

    /**
     * https://leetcode.cn/problems/corporate-flight-bookings/
     * 这里有n个航班，它们分别从 1 到 n 进行编号。
     * <p>
     * 有一份航班预订表bookings ，表中第i条预订记录bookings[i] = [firsti, lasti, seatsi]意味着在从 firsti到 lasti （包含 firsti 和 lasti ）的 每个航班 上预订了 seatsi个座位。
     * <p>
     * 请你返回一个长度为 n 的数组answer，里面的元素是每个航班预定的座位总数。
     * <p>
     * <p>
     * <p>
     * 示例 1：
     * <p>
     * 输入：bookings = [[1,2,10],[2,3,20],[2,5,25]], n = 5
     * 输出：[10,55,45,25,25]
     * 解释：
     * 航班编号        1   2   3   4   5
     * 预订记录 1 ：   10  10
     * 预订记录 2 ：       20  20
     * 预订记录 3 ：       25  25  25  25
     * 总座位数：      10  55  45  25  25
     * 因此，answer = [10,55,45,25,25]
     * 示例 2：
     * <p>
     * 输入：bookings = [[1,2,10],[2,2,15]], n = 2
     * 输出：[10,25]
     * 解释：
     * 航班编号        1   2
     * 预订记录 1 ：   10  10
     * 预订记录 2 ：       15
     * 总座位数：      10  25
     * 因此，answer = [10,25]
     */
    public static void main(String[] args) {
        $1109_航班预订统计 h = new $1109_航班预订统计();
    }

    public int[] corpFlightBookings(int[][] bookings, int n) {

        int[] ints = new int[n];
        Difference diff = new Difference(ints);
        for (int[] booking : bookings) {
            // 航班从1开始计算，换算成数组下标需要-1
            int start = booking[0] - 1;
            int end = booking[1] - 1;
            int val = booking[2];
            diff.increment(start, end, val);
        }

        return diff.result();
    }


}



















