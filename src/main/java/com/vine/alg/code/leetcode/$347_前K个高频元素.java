package com.vine.alg.code.leetcode;

import com.vine.alg.基本数据结构构造.Utils;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * @author 阿季
 * @date 2023-09-06 9:00 PM
 */

public class $347_前K个高频元素 {

    public static void main(String[] args) {
        $347_前K个高频元素 z = new $347_前K个高频元素();
        int[] ints = z.topKFrequent(Utils.splitToIntArr1("1,1,1,2,2,3"), 2);
        System.out.println(ints);
    }

    /**
     * https://leetcode.cn/problems/top-k-frequent-elements/
     */
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> freq = new HashMap<>();

        for (int num : nums) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }

        PriorityQueue<int[]> queue = new PriorityQueue<>((a, b) -> b[1] - a[1]);


        freq.forEach((key, v) -> {
            queue.offer(new int[]{key, v});
        });

        int[] res = new int[k];

        for (int i = 0; i < k; i++) {
            res[i] = queue.poll()[0];
        }
        return res;

    }


}
