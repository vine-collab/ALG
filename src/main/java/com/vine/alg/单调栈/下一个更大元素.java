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
        int[] res = new int[nums.size()];
        Stack<Integer> s = new Stack<>();
        for (int i = nums.size() - 1; i >= 0; i--) {
            while (!s.isEmpty() && s.peek() <= nums.get(i)) {
                s.pop();
            }
            res[i] = s.isEmpty() ? -1 : s.pop();
            s.push(nums.get(i));
        }
        return res;
    }

}
