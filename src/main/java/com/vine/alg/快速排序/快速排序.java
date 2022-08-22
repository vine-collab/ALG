package com.vine.alg.快速排序;

import java.util.Arrays;
import java.util.Random;

import static org.apache.commons.lang3.ArrayUtils.swap;

/**
 * @author 阿季
 * @date 2022-08-22 9:42 PM
 */

public class 快速排序 {

    public static void main(String[] args) {
        快速排序 k = new 快速排序();

    }


    void sort(int[] nums) {
        // 打乱数组
        this.shuffle(nums);

    }

    void sort(int[] nums, int l, int h) {
        if (l >= h) {
            return;
        }

        // 对[l, h] 进行切分
        // 使得 nums[lo..p-1] <= nums[p] < nums[p+1..hi]
        int p = this.partition(nums, l, h);
        this.sort(nums, l, p - 1);
        this.sort(nums, p + 1, h);

    }

    // 对 nums[lo..hi] 进行切分
    int partition(int[] nums, int lo, int hi) {
        int pivot = nums[lo];
        // 关于区间的边界控制需格外小心，稍有不慎就会出错
        // 我这里把 i, j 定义为开区间，同时定义：
        // [lo, i) <= pivot；(j, hi] > pivot
        // 之后都要正确维护这个边界区间的定义
        int i = lo + 1, j = hi;
        // 当 i > j 时结束循环，以保证区间 [lo, hi] 都被覆盖
        while (i <= j) {
            while (i < hi && nums[i] <= pivot) {
                i++;
                // 此 while 结束时恰好 nums[i] > pivot
            }
            while (j > lo && nums[j] > pivot) {
                j--;
                // 此 while 结束时恰好 nums[j] <= pivot
            }

            // 此时 [lo, i) <= pivot && (j, hi] > pivot

            if (i >= j) {
                break;
            }
            swap(nums, i, j);

        }
        // 将 pivot 放到合适的位置，即 pivot 左边元素较小，右边元素较大
        swap(nums, lo, j);
        return j;


    }


    // 洗牌算法，将输入的数组随机打乱
    private void shuffle(int[] nums) {
        Random rand = new Random();
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            // 生成 [i, n - 1] 的随机数
            int r = i + rand.nextInt(n - i);
            swap(nums, i, r);
        }
    }


}











































































