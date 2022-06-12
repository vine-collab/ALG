package com.vine.alg.单调栈;

import com.alibaba.fastjson.JSON;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * @author 阿季
 * @date 2022-05-10 9:11 PM
 */

public class 下一个更大元素 {

    public static void main(String[] args) {
        下一个更大元素 x = new 下一个更大元素();
        int[] integers = x.nextGreaterElement(Arrays.asList(2, 1, 2, 4, 3));
        System.out.println(JSON.toJSONString(integers));
    }

    int[] nextGreaterElement(List<Integer> nums) {
        Stack<Integer> stack = new Stack<Integer>();

        int[] res = new int[nums.size()];
        for (int i = nums.size() - 1; i >= 0; i--) {

            while (!stack.isEmpty() && nums.get(i) >= stack.peek()) {
                stack.pop();
            }
            int num = stack.isEmpty() ? -1 : stack.peek();
            res[i] = num;
            stack.push(nums.get(i));
        }
        return res;

    }

}
