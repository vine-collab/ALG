package com.vine.alg.leet.leetcode;

import com.alibaba.fastjson.JSON;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * @author 阿季
 * @date 2022-06-12 6:43 PM
 */

public class $496_下一个更大元素I {


    /**
     * https://leetcode.cn/problems/next-greater-element-i/
     */


    public static void main(String[] args) {
        $496_下一个更大元素I x = new $496_下一个更大元素I();
        int[] ints = x.nextGreaterElement(new int[]{4, 1, 2}, new int[]{1, 3, 4, 2});
        System.out.println(JSON.toJSONString(ints));
    }


    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        // 计算第二个数组的下一个更大元素
        Map<Integer, Integer> map = new HashMap<>();
        int[] nge = nge(nums2);
        for (int i = 0; i < nums2.length; i++) {
            map.put(nums2[i], nge[i]);
        }
        int[] res = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++) {
            res[i] = map.get(nums1[i]);
        }


        return res;

    }

    /**
     * 计算数组元素对应的下一个更大元素
     *
     * @param nums
     * @return
     */
    int[] nge(int[] nums) {
        Stack<Integer> stack = new Stack<Integer>();
        int[] res = new int[nums.length];
        for (int i = nums.length - 1; i >= 0; i--) {
            // 保持栈是单调的
            while (!stack.isEmpty() && nums[i] >= stack.peek()) {
                stack.pop();
            }
            // 栈非空，栈顶元素 > 当前元素，找到当前元素的下一个更大元素
            res[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(nums[i]);
        }
        return res;
    }


}
