package com.vine.alg.leet.leetcode;

/**
 * @author 阿季
 * @date 2022-06-29 8:49 PM
 */

public class $303_区域和检索数组不可变 {

    public static void main(String[] args) {
        $303_区域和检索数组不可变 q = new $303_区域和检索数组不可变();
        int[] ints = {-2, 0, 3, -5, 2, -1};
        q.arr = ints;
        q.preSum();
        int i = q.sumRange(1, 3);
        System.out.println(i);


    }

    private int[] arr;

    private int[] preSum;

    public int sumRange(int left, int right) {

        return preSum[right + 1] - preSum[left];
    }


    public void preSum() {
        int length = arr.length;
        int[] preSum = new int[length + 1];
        for (int i = 1; i < preSum.length; i++) {
            preSum[i] = preSum[i - 1] + arr[i - 1];
        }

        this.preSum = preSum;

    }


}








