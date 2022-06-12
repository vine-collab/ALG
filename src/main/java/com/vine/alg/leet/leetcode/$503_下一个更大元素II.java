package com.vine.alg.leet.leetcode;

import com.alibaba.fastjson.JSON;

import java.util.Stack;

/**
 * @author 阿季
 * @date 2022-06-12 9:44 PM
 */

public class $503_下一个更大元素II {

    public static void main(String[] args) {
        $503_下一个更大元素II x = new $503_下一个更大元素II();
        int[] ints = x.nextGreaterElements(new int[]{1, 2, 3, 4, 3});
        System.out.println(JSON.toJSONString(ints));
    }

    public int[] nextGreaterElements(int[] nums) {
        Stack<Integer> stack = new Stack<Integer>();
        int n = nums.length;
        int[] res = new int[n];

        for (int i = 2 * n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && nums[i % n] >= stack.peek()) {
                stack.pop();
            }
            res[i % n] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(nums[i % n]);
        }
        return res;


    }


}
