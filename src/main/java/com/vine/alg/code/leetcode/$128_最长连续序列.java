package com.vine.alg.code.leetcode;

import com.vine.alg.基本数据结构构造.Utils;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author 阿季
 * @date 2022-08-18 9:44 PM
 */

public class $128_最长连续序列 {

    /**
     * 给定一个未排序的整数数组 nums ，找出数字连续的最长序列（不要求序列元素在原数组中连续）的长度。
     * <p>
     * 请你设计并实现时间复杂度为O(n) 的算法解决此问题。
     * <p>
     * <p>
     * <p>
     * 示例 1：
     * <p>
     * 输入：nums = [100,4,200,1,3,2]
     * 输出：4
     * 解释：最长数字连续序列是 [1, 2, 3, 4]。它的长度为 4。
     * 示例 2：
     * <p>
     * 输入：nums = [0,3,7,2,5,8,4,6,0,1]
     * 输出：9
     * <p>
     * 链接：https://leetcode.cn/problems/longest-consecutive-sequence
     */
    public static void main(String[] args) {
        $128_最长连续序列 z = new $128_最长连续序列();
        int i = z.longestConsecutive(Utils.toIntArr1("[0,3,7,2,5,8,4,6,0,1]"));
        System.out.println(i);
    }

    public int longestConsecutive(int[] nums) {

        int res = 0;
        Set<Integer> set = Arrays.stream(nums).boxed().collect(Collectors.toSet());


        for (Integer num : set) {
            // num不是最小的元素
            if (!set.contains(num - 1)) {
                int cnt = 0;
                while (set.contains(num)) {
                    cnt++;
                    num++;
                }

                res = Math.max(cnt, res);
            }
        }

        return res;


    }


    public int longestConsecutive1(int[] nums) {
        Set<Integer> set = Arrays.stream(nums).boxed().collect(Collectors.toSet());

        int res = 0;

        for(int n : set) {
            // n不是最小元素
            if(set.contains(n - 1)) {
                continue;
            }

            int cur = n;
            int len = 1;
            while(set.contains(cur + 1)) {
                cur++;
                len++;
            }
            res = Math.max(len, res);
        }
        return res;
    }

}































































