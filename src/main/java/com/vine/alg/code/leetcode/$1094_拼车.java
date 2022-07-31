package com.vine.alg.code.leetcode;

import com.vine.alg.差分数组.Difference;

/**
 * @author 阿季
 * @date 2022-07-04 8:37 PM
 */

public class $1094_拼车 {


    /**
     * 车上最初有capacity个空座位。车只能向一个方向行驶（也就是说，不允许掉头或改变方向）
     * <p>
     * 给定整数capacity和一个数组 trips , trip[i] = [numPassengersi, fromi, toi]表示第 i 次旅行有numPassengersi乘客，接他们和放他们的位置分别是fromi和toi。这些位置是从汽车的初始位置向东的公里数。
     * <p>
     * 当且仅当你可以在所有给定的行程中接送所有乘客时，返回true，否则请返回 false。
     * <p>
     * <p>
     * 示例 1：
     * <p>
     * 输入：trips = [[2,1,5],[3,3,7]], capacity = 4
     * 输出：false
     * 示例 2：
     * <p>
     * 输入：trips = [[2,1,5],[3,3,7]], capacity = 5
     * 输出：true
     * <p>
     * 链接：https://leetcode.cn/problems/car-pooling
     */
    public static void main(String[] args) {
        $1094_拼车 p = new $1094_拼车();
    }


    public boolean carPooling(int[][] trips, int capacity) {
        int[] nums = new int[1001];
        Difference diff = new Difference(nums);
        for (int[] trip : trips) {
            diff.increment(trip[1], trip[2] - 1, trip[0]);

        }
        int[] result = diff.result();

        for (int i : result) {
            if (capacity < i) {
                return false;
            }
        }
        return true;


    }

}














