package com.vine.alg.leet.leetcode;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @author 阿季
 * @date 2022-07-18 9:41 PM
 */

public class $215_数组中的第K个最大元素 {

    public static void main(String[] args) {
        $215_数组中的第K个最大元素 s = new $215_数组中的第K个最大元素();

        int kthLargest = s.findKthLargest(new int[]{3, 2, 1, 5, 6, 4}, 2);
        System.out.println(kthLargest);
    }


    public int findKthLargest(int[] nums, int k) {

        Queue<Integer> q = new PriorityQueue<>();
        for (int i = 0; i < nums.length; i++) {
            q.offer(nums[i]);

            if (q.size() > k) {
                q.poll();
            }

        }
        return q.peek();


    }

}






























































