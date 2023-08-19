package com.vine.alg.code.leetcode;

import com.alibaba.fastjson.JSON;
import com.vine.alg.基本数据结构构造.Utils;
import jdk.nashorn.internal.runtime.JSONFunctions;

import javax.swing.*;
import javax.xml.stream.events.EndDocument;
import java.util.Arrays;

/**
 * @author 阿季
 * @date 2023-08-14 20:31
 */

public class $31_下一个排列 {

    public static void main(String[] args) {
        $31_下一个排列 z = new $31_下一个排列();
        z.nextPermutation(Utils.splitToIntArr1("1,3,2"));
    }


    /**
     * https://leetcode.cn/problems/next-permutation/description/
     * 整数数组的一个 排列  就是将其所有成员以序列或线性顺序排列。
     *
     * 例如，arr = [1,2,3] ，以下这些都可以视作 arr 的排列：[1,2,3]、[1,3,2]、[3,1,2]、[2,3,1] 。
     * 整数数组的 下一个排列 是指其整数的下一个字典序更大的排列。更正式地，如果数组的所有排列根据其字典顺序从小到大排列在一个容器中，那么数组的 下一个排列 就是在这个有序容器中排在它后面的那个排列。如果不存在下一个更大的排列，那么这个数组必须重排为字典序最小的排列（即，其元素按升序排列）。
     *
     * 例如，arr = [1,2,3] 的下一个排列是 [1,3,2] 。
     * 类似地，arr = [2,3,1] 的下一个排列是 [3,1,2] 。
     * 而 arr = [3,2,1] 的下一个排列是 [1,2,3] ，因为 [3,2,1] 不存在一个字典序更大的排列。
     * 给你一个整数数组 nums ，找出 nums 的下一个排列。
     *
     * 必须 原地 修改，只允许使用额外常数空间。
     *
     * 示例 1：
     *
     * 输入：nums = [1,2,3]
     * 输出：[1,3,2]
     * 示例 2：
     *
     * 输入：nums = [3,2,1]
     * 输出：[1,2,3]
     * 示例 3：
     *
     * 输入：nums = [1,1,5]
     * 输出：[1,5,1]
     */
    
    public void nextPermutation(int[] nums) {
        if(nums == null || nums.length == 1) {
            return;
        }

        int i = nums.length - 2, j = nums.length - 1, k = nums.length - 1;
        // 寻找nums[i] < nums[j] 的位置
        while(i >= 0 && nums[i] >= nums[j]) {
            i--;
            j--;
        }

        // 不是最后一个排列
        if(i >= 0) {
            // 寻找 ij中 第一个 i < k 的数值对 并交换
            while(nums[k] <= nums[i]) {
                k--;
            }
            swap(nums, i, k);
        }

        // 再将j,end 逆序
        int end = nums.length - 1;
        while(j <= end) {
            swap(nums, j, end);
            j++;
            end--;
        }
        System.out.println(JSON.toJSONString(nums));

    }

    public void swap(int[] nums, int i, int j) {
        if(i == j) {
            return;
        }
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}































































