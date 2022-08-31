package com.vine.alg.code.leetcode;

import com.vine.alg.基本数据结构构造.Utils;

import java.util.PriorityQueue;

/**
 * @author 阿季
 * @date 2022-08-30 8:28 PM
 */

public class $179_最大数 {


    /**
     * 给定一组非负整数 nums，重新排列每个数的顺序（每个数不可拆分）使之组成一个最大的整数。
     * 注意：输出结果可能非常大，所以你需要返回一个字符串而不是整数。
     * 示例 1：
     * <p>
     * 输入：nums = [10,2]
     * 输出："210"
     * 示例2：
     * <p>
     * 输入：nums = [3,30,34,5,9]
     * 输出："9534330"
     * <p>
     * 链接：https://leetcode.cn/problems/largest-number
     */
    public static void main(String[] args) {

        $179_最大数 z = new $179_最大数();
        String s = z.largestNumber(Utils.splitToIntArr1("3,30,34,5,9"));
        System.out.println(s);

    }

    public String largestNumber(int[] nums) {
        PriorityQueue<String> queue = new PriorityQueue<>((x, y) -> (y + x).compareTo(x + y));
        for (int num : nums) {
            queue.offer(String.valueOf(num));
        }

        StringBuilder res = new StringBuilder();
        while (queue.size() > 0) {
            res.append(queue.poll());
        }
        if (res.charAt(0) == '0') {
            return "0";
        }
        return res.toString();

    }
}































































