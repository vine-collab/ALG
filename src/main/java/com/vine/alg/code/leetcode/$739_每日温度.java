package com.vine.alg.code.leetcode;

import com.alibaba.fastjson.JSON;

import java.util.Stack;

/**
 * @author 阿季
 * @date 2022-06-12 10:18 PM
 */

public class $739_每日温度 {


    /**
     * https://leetcode.cn/problems/daily-temperatures/
     * 739. 每日温度
     * 给定一个整数数组 temperatures ，表示每天的温度，返回一个数组 answer ，其中 answer[i] 是指在第 i 天之后，才会有更高的温度。如果气温在这之后都不会升高，请在该位置用 0 来代替。
     *
     * 示例 1:
     * 输入: temperatures = [73,74,75,71,69,72,76,73]
     * 输出: [1,1,4,2,1,1,0,0]
     *
     *  示例 2:
     * 输入: temperatures = [30,40,50,60]
     * 输出: [1,1,1,0]
     * 示例 3:
     *
     * 输入: temperatures = [30,60,90]
     * 输出: [1,1,0]
     */

    public static void main(String[] args) {
        $739_每日温度 m = new $739_每日温度();
        int[] ints = m.dailyTemperatures(new int[]{73, 74, 75, 71, 69, 72, 76, 73});
        System.out.println(JSON.toJSONString(ints));
    }


    public int[] dailyTemperatures(int[] temperatures) {

        int[] result = new int[temperatures.length];
        Stack<Integer> s = new Stack<>();


        for (int i = temperatures.length - 1; i >= 0; i--) {
            while(!s.isEmpty() && temperatures[i] >= temperatures[s.peek()]) {
                s.pop();
            }

            result[i] = s.isEmpty() ? 0 : (s.peek() - i);
            s.push(i);
        }
        return result;




    }

}














