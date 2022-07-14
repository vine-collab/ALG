package com.vine.alg.排序.归并排序;

/**
 * @author 阿季
 * @date 2022-07-13 9:06 PM
 */

public class 归并 {

    // 用于辅助合并有序数组
    int[] temp;

    void sort(int[] nums) {

        temp = new int[nums.length];

        // 排序整个数组，原地修改
        sort(nums, 0, nums.length - 1);
    }

    void sort(int[] nums, int lo, int hi) {

        if (lo == hi) {
            return;
        }
        int mid = lo + (hi - lo) / 2;
        // 排序左半部分
        this.sort(nums, lo, mid);
        // 排序右半部分
        this.sort(nums, mid + 1, hi);
        // 合并两个部分成一个有序数组
        this.merge(nums, lo, hi, mid);


    }

    // 合并成有序数组
    void merge(int[] nums, int lo, int hi, int mid) {
        // 先把lo-hi复制到temp中
        for (int i = lo; i <= hi; i++) {
            temp[i] = nums[i];
        }
        int i = lo, j = mid + 1;
        for (int p = lo; p <= hi; p++) {
            // 左边数组合并完毕
            if (i == mid + 1) {
                nums[p] = temp[j++];
            }
            // 右边数组合并完毕
            else if (j == hi + 1) {
                nums[p] = temp[i++];
            }
            else if(temp[i] > temp[j]) {
                nums[p] = temp[j++];
            }
            else {
                nums[p] = temp[i++];
            }
        }


    }


}













