package com.vine.alg.单调栈;

import com.alibaba.fastjson.JSON;

import java.util.Stack;

/**
 * @author 阿季
 * @date 2022-05-12 9:32 PM
 */

public class $503_下一个更大元素II {


    /**
     * 503. 下一个更大元素 II https://leetcode.cn/problems/next-greater-element-ii/
     * 给定一个循环数组 nums （ nums[nums.length - 1] 的下一个元素是 nums[0] ），返回 nums 中每个元素的 下一个更大元素 。
     * <p>
     * 数字 x 的 下一个更大的元素 是按数组遍历顺序，这个数字之后的第一个比它更大的数，这意味着你应该循环地搜索它的下一个更大的数。如果不存在，则输出 -1 。
     * <p>
     * 示例 1:
     * <p>
     * 输入: nums = [1,2,1]
     * 输出: [2,-1,2]
     * 解释: 第一个 1 的下一个更大的数是 2；
     * 数字 2 找不到下一个更大的数；
     * 第二个 1 的下一个最大的数需要循环搜索，结果也是 2。
     * 示例 2:
     * <p>
     * 输入: nums = [1,2,3,4,3]
     * 输出: [2,3,4,-1,4]
     */
    public static void main(String[] args) {
        $503_下一个更大元素II x = new $503_下一个更大元素II();
        int[] ints = x.nextGreaterElements(new int[]{1, 2, 3, 4, 3});
        System.out.println(JSON.toJSONString(ints));
    }

    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        Stack<Integer> s = new Stack<>();
        for (int i = (n - 1) * 2; i >= 0; i--) {
            while (!s.isEmpty() && s.peek() <= nums[i % n]) {
                s.pop();
            }
            res[i % n] = s.isEmpty() ? -1 : s.peek();
            s.push(nums[i % n]);

        }
        return res;
    }


}
