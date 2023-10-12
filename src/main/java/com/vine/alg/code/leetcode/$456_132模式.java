package com.vine.alg.code.leetcode;

import com.vine.alg.基本数据结构构造.Utils;

import java.util.Deque;
import java.util.Stack;

/**
 * @author 阿季
 * @date 2023-10-22 3:53 PM
 */

public class $456_132模式 {

    /**
     * 给你一个整数数组 nums ，数组中共有 n 个整数。132 模式的子序列 由三个整数 nums[i]、nums[j] 和 nums[k] 组成，并同时满足：i < j < k 和 nums[i] < nums[k] < nums[j] 。
     * <p>
     * 如果 nums 中存在 132 模式的子序列 ，返回 true ；否则，返回 false 。
     * <p>
     * 示例 1：
     * <p>
     * 输入：nums = [1,2,3,4]
     * 输出：false
     * 解释：序列中不存在 132 模式的子序列。
     * 示例 2：
     * <p>
     * 输入：nums = [3,1,4,2]
     * 输出：true
     * 解释：序列中有 1 个 132 模式的子序列： [1, 4, 2] 。
     * 示例 3：
     * <p>
     * 输入：nums = [-1,3,2,0]
     * 输出：true
     * 解释：序列中有 3 个 132 模式的的子序列：[-1, 3, 2]、[-1, 3, 0] 和 [-1, 2, 0] 。
     * <p>
     * https://leetcode.cn/problems/132-pattern/description/
     */
    public static void main(String[] args) {
        $456_132模式 z = new $456_132模式();
        System.out.println(z.find132pattern(Utils.splitToIntArr1("3,1,4,2")));

    }

    public boolean find132pattern(int[] nums) {
        if (nums == null || nums.length < 3) {
            return false;
        }

        int n = nums.length;

        Stack<Integer> stack = new Stack<>();
        int k = Integer.MIN_VALUE;
        for (int i = n - 1; i >= 0; i--) {
            if (nums[i] < k) {
                return true;
            }
            while(!stack.isEmpty() && stack.peek() < nums[i]) {
                k = Math.max(k, stack.pop());
            }
            stack.push(nums[i]);

        }
        return false;


    }

}


























