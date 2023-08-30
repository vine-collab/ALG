package com.vine.alg.code;

import com.vine.alg.基本数据结构构造.Utils;

import java.util.*;

public class $491_递增子序列 {

    /**
     * 给你一个整数数组 nums ，找出并返回所有该数组中不同的递增子序列，递增子序列中 至少有两个元素 。你可以按 任意顺序 返回答案。
     * <p>
     * 数组中可能含有重复元素，如出现两个整数相等，也可以视作递增序列的一种特殊情况。
     * 示例 1：
     * 输入：nums = [4,6,7,7]
     * 输出：[[4,6],[4,6,7],[4,6,7,7],[4,7],[4,7,7],[6,7],[6,7,7],[7,7]]
     * <p>
     * 示例 2：
     * 输入：nums = [4,4,3,2,1]
     * 输出：[[4,4]]
     * https://leetcode.cn/problems/non-decreasing-subsequences/description/
     */
    public static void main(String[] args) {
        $491_递增子序列 z = new $491_递增子序列();
        List<List<Integer>> subsequences = z.findSubsequences(Utils.splitToIntArr1("4,6,7,7"));
        Utils.printf(subsequences);
    }

    public List<List<Integer>> findSubsequences(int[] nums) {
        if (nums.length == 0) {
            return res;
        }
        backtrack(nums, 0);
        return res;
    }

    List<List<Integer>> res = new LinkedList<>();
    // 记录回溯的路径
    LinkedList<Integer> track = new LinkedList<>();

    // 回溯算法主函数
    void backtrack(int[] nums, int start) {
        if (track.size() >= 2) {
            // 找到一个合法答案
            res.add(new LinkedList<>(track));
        }
        // 用哈希集合防止重复选择相同元素
        HashSet<Integer> used = new HashSet<>();
        // 回溯算法标准框架
        for (int i = start; i < nums.length; i++) {
            // 保证集合中元素都是递增顺序
            if (!track.isEmpty() && track.getLast() > nums[i]) {
                continue;
            }
            // 保证不要重复使用相同的元素
            if (used.contains(nums[i])) {
                continue;
            }
            // 选择 nums[i]
            used.add(nums[i]);
            track.add(nums[i]);
            // 递归遍历下一层回溯树
            backtrack(nums, i + 1);
            // 撤销选择 nums[i]
            track.removeLast();
        }
    }

}
















